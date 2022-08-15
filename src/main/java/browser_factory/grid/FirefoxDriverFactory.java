package browser_factory.grid;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Init gecko driver for grid environment (selenium grid or docker grid)
 * Although WebDriverManager will auto download appropriate version of gecko driver,
 * sometimes it will not run stably due to unknown errors. It is recommend to set gecko driver
 * version manually through System.setProperty()
 * Due to docker-selenium grid image (4.3.0) using in this project,
 * gecko driver and browser version is 103
 */
public class FirefoxDriverFactory {
    public WebDriver getBrowserDriver(String browser, String ipAddress, String port) throws MalformedURLException {
//        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", GlobalConstants.getGlobalConstants().getPathToBrowserDriver() + "geckodriver_103.exe");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        firefoxOptions.merge(capabilities);

        // disable browser logs
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        return new RemoteWebDriver(new URL(String.format("http://%s:%s", ipAddress, port)), firefoxOptions);
    }
}
