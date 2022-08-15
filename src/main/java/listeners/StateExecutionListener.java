package listeners;

import api.browser_stack.BrowserStack;
import com.google.auto.service.AutoService;
import commons.GlobalConstants;
import enums.Environment;
import helpers.FunctionHelper;
import helpers.LoggerHelper;
import helpers.RecordVideoHelper;
import lombok.SneakyThrows;
import org.apache.logging.log4j.Logger;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

@AutoService(TestExecutionListener.class)
public class StateExecutionListener implements TestExecutionListener {

    private final Logger log;
    private final String environment = FunctionHelper.getEnvironmentProperties().getProperty("environment_name");
    private boolean recordLocalVideo = true;

    public StateExecutionListener() {
        log = LoggerHelper.getLogger(StateExecutionListener.class);
    }

    @SneakyThrows
    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        FunctionHelper.clearFileContent(GlobalConstants.getGlobalConstants().getPathLogFile());
        log.info("---Before test execution---");

        Environment environmentName = Environment.valueOf(environment.toUpperCase());
        if (environmentName == Environment.LOCAL) {
            // Record video on local environment
            FunctionHelper.deleteAllFilesInFolder(new File(GlobalConstants.getGlobalConstants().getPathToRecordVideo()));
            RecordVideoHelper.startRecord("Start record video");
        } else {
            recordLocalVideo = false;
        }
    }

    @SneakyThrows
    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        log.info("---After test execution---");

        //stop record video
        Environment environmentName = Environment.valueOf(environment.toUpperCase());
        if (recordLocalVideo) {
            RecordVideoHelper.stopRecord();
        } else if (environmentName == Environment.CLOUD) {
            // delete all old videos in browser-stack-videos
            FunctionHelper.deleteAllFilesInFolder(new File(GlobalConstants.getGlobalConstants().getPathToBrowserStackVideo()));

            // Download new record video on Browser Stack
            // You can choose between download only latest video
            // or download all videos of latest build
            // (refer to Browser Stack Session Api for more details)

//             BrowserStack.saveAllRecordVideo();
            BrowserStack.saveLatestRecordVideo();
        }

        // create environment.properties to apply
        // environment information for Allure Reports
        String pathToTargetFolder = null;
        try {
            pathToTargetFolder = Paths.get(Objects.requireNonNull(StateExecutionListener.class.getResource("/")).toURI()).getParent().toString();
            String pathToCopied = pathToTargetFolder + File.separator + "allure-results" + File.separator + "environment.properties";
            String pathToOriginal = GlobalConstants.getGlobalConstants().getPathToEnvironmentPropertyFile();
            FunctionHelper.copyFileToAnotherDirectory(pathToOriginal, pathToCopied);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
