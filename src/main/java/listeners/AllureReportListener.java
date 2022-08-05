package listeners;

import com.google.auto.service.AutoService;
import commons.BaseTest;
import helpers.FunctionHelper;
import helpers.LoggerHelper;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@AutoService(TestExecutionListener.class)
public class AllureReportListener implements TestExecutionListener {

    Logger log;

    public AllureReportListener() {
        log = LoggerHelper.getLogger(AllureReportListener.class);
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        //attach screenshot to reports
        attachScreenshot(testExecutionResult);
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
    }

    @Override
    public void executionSkipped(TestIdentifier testIdentifier, String reason) {
        log.info("---Tests are skipped---");
    }

    private void attachScreenshot(TestExecutionResult testExecutionResult) {
        if (testExecutionResult.getStatus().equals(TestExecutionResult.Status.FAILED)) {
            WebDriver driver = BaseTest.getWebDriver();
            Date date = Calendar.getInstance().getTime();
            FileInputStream inputStream = null;
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try {
                inputStream = FileUtils.openInputStream(screenshot);
                Allure.addAttachment("Screenshot taken in " + FunctionHelper.getTodayByFormat(date, "yyyy-mm-dd hh:mm:ss"), inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
