package api.browser_stack;

import com.google.gson.Gson;
import commons.GlobalConstants;
import custom_exceptions.InvalidBuildException;
import helpers.FunctionHelper;
import org.apache.commons.codec.binary.Base64;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrowserStack {

    private static final String credentials = GlobalConstants.getGlobalConstants().getCloudUsername()
            + ":"
            + GlobalConstants.getGlobalConstants().getCloudAutomateKey();
    private static final String basicAuth = "Basic " + new String(new Base64().encode(credentials.getBytes()));

    private BrowserStack() {

    }

    /**
     * Fetch build_id from Browser Stack api
     *
     * @return latest build id fetching from Browser Stack api
     */
    private static String getLatestBuildId() {
        HttpGet request = new HttpGet("https://api.browserstack.com/automate/builds.json?limit=1");
        request.addHeader("Authorization", basicAuth);

        String buildId = null;

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            Gson gson = new Gson();
            Build[] builds = gson.fromJson(result, Build[].class);
            for (Build build : builds) {
                buildId = build.buildInfo.hashedId;
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return buildId;
    }

    /**
     * Fetch video_url and created_at from Browser Stack Session Api
     *
     * @return a List of Map collection which contain all (video_url and created_at)
     * of latest build
     */
    private static List<HashMap<String, String>> getAllSessions() {
        String latestBuildId = getLatestBuildId();
        if (latestBuildId == null) {
            throw new InvalidBuildException("Fail to get latest build id from BrowserStack");
        }

        HttpGet request = new HttpGet("https://api.browserstack.com/automate/builds/" + latestBuildId + "/sessions.json");
        request.addHeader("Authorization", basicAuth);

        List<HashMap<String, String>> sessionInfo = new ArrayList<>();

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            Gson gson = new Gson();
            Session[] sessions = gson.fromJson(result, Session[].class);
            for (Session session : sessions) {
                HashMap<String, String> sessionDetails = new HashMap<>();
                sessionDetails.put("created_at", session.sessionInfo.createdAt.replaceAll(":", "-"));
                sessionDetails.put("video_url", session.sessionInfo.videoUrl);
                sessionInfo.add(sessionDetails);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return sessionInfo;
    }

    /**
     * Fetch video_url and created_at from Browser Stack Session Api
     *
     * @return a HashMap collection contains only latest (video_url and created_at)
     * of latest build
     */
    private static HashMap<String, String> getLatestSession() {
        String latestBuildId = getLatestBuildId();
        if (latestBuildId == null) {
            throw new InvalidBuildException("Unable to get latest build_id from BrowserStack");
        }

        HttpGet request = new HttpGet("https://api.browserstack.com/automate/builds/" + latestBuildId + "/sessions.json");
        request.addHeader("Authorization", basicAuth);

        HashMap<String, String> latestSession = new HashMap<>();

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            Gson gson = new Gson();
            Session[] sessions = gson.fromJson(result, Session[].class);

            latestSession.put("created_at", sessions[0].sessionInfo.createdAt.replaceAll(":", "-"));
            latestSession.put("video_url", sessions[0].sessionInfo.videoUrl);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return latestSession;
    }

    /**
     * Save only latest record video of latest build in Browser Stack
     * Remember to put current thread in sleep status for a moment because it takes time for
     * Browser Stack to create and save record video
     *
     * @throws IOException
     */
    public static void saveLatestRecordVideo() throws IOException {
        FunctionHelper.sleepInSeconds(GlobalConstants.getGlobalConstants().getShortTimeout());

        HashMap<String, String> latestSession = getLatestSession();
        System.out.println("---Start download video---");
        URL website = new URL(latestSession.get("video_url"));
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(
                GlobalConstants.getGlobalConstants().getPathToBrowserStackVideo()
                        + "video_"
                        + latestSession.get("created_at") + ".mp4"
        );
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        System.out.println("---End download video---");
    }

    /**
     * Save all record videos of latest build in Browser Stack
     * Remember to put current thread in sleep status for a moment because it takes time for
     * Browser Stack to create and save record video
     *
     * @throws IOException
     */
    public static void saveAllRecordVideo() throws IOException {
        FunctionHelper.sleepInSeconds(GlobalConstants.getGlobalConstants().getShortTimeout());

        List<HashMap<String, String>> sessionInfo = getAllSessions();
        int index = 1;
        for (HashMap<String, String> session : sessionInfo) {
            System.out.println("---Start download video " + index + "---");
            URL website = new URL(session.get("video_url"));
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(
                    GlobalConstants.getGlobalConstants().getPathToBrowserStackVideo()
                            + "video_"
                            + session.get("created_at") + ".mp4"
            );
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            System.out.println("---Finish download video " + index + "---");
            index++;
        }
    }
}
