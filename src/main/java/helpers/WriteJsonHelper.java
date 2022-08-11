package helpers;

import com.google.gson.Gson;
import commons.GlobalConstants;
import json_data.LoginCredentials;

import java.io.*;

public class WriteJsonHelper {

    public static void updateUsernameOfLoginCredentials(String username) {
        Gson gson = new Gson();

        String file = GlobalConstants.getGlobalConstants().getPathToJsonTestData() + "login_credentials.json";
        try {
            FileReader fileReader = new FileReader(file);
            LoginCredentials credentials = gson.fromJson(fileReader, LoginCredentials.class);
            credentials.setUsername(username);

            File jsonFile = new File(file);
            OutputStream outputStream = new FileOutputStream(jsonFile);
            outputStream.write(gson.toJson(credentials).getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
