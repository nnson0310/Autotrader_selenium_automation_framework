package listeners;

import com.google.auto.service.AutoService;
import commons.GlobalConstants;
import helpers.FunctionHelper;
import helpers.LoggerHelper;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

@AutoService(TestExecutionListener.class)
public class StateExecutionListener implements TestExecutionListener {

    private Logger log;

    public StateExecutionListener() {
        log = LoggerHelper.getLogger(StateExecutionListener.class);
    }

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        FunctionHelper.clearFileContent(GlobalConstants.getGlobalConstants().getPathLogFile());
        log.info("---Before test execution---");
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        log.info("---After test execution---");

        //create environment.properties for Allure Reports
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
