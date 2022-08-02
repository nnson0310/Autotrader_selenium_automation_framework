package commons;

import env_factory.CloudEnvFactory;
import env_factory.GridEnvFactory;
import env_factory.LocalEnvFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    protected final Log log;

    public BaseTest() {
        log = LogFactory.getLog(getClass());
    }

    protected WebDriver getBrowserDriver(
            String url,
            String environmentName,
            String browserName,
            String browserVersion,
            String ipAddress,
            String port,
            String os,
            String osVersion
    ) {
        if (browserName == null) {
            browserName = "firefox";
        }

        System.out.println(environmentName);
        System.out.println(url);

        switch(environmentName.toLowerCase()) {
            case "local":
                driver = new LocalEnvFactory(browserName).initBrowserDriver();
                System.out.println(driver);
                break;
            case "grid":
                driver = new GridEnvFactory(browserName, ipAddress, port).initBrowserDriver();
                break;
            default:
                driver = new CloudEnvFactory(browserName, browserVersion, os, osVersion).initBrowserDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.getGlobalConstants().getLongTimeout()));
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

    /**
     * Close browser and kill all running process of browser driver
     * @author Son
     */
    protected void closeBrowserAndKillProcess() {
        String cmd = "";
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            if (driverInstanceName.contains("chrome")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }
            } else if (driverInstanceName.contains("internetexplorer")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driverInstanceName.contains("firefox")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }
            } else if (driverInstanceName.contains("edge")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            } else if (driverInstanceName.contains("opera")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                } else {
                    cmd = "pkill operadriver";
                }
            } else if (driverInstanceName.contains("safari")) {
                if (osName.contains("mac")) {
                    cmd = "pkill safaridriver";
                }
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
