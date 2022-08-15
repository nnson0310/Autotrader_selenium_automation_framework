package browser_factory.grid;

import commons.GlobalConstants;
import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Init browser driver for grid environment (selenium grid or docker grid)
 * Although WebDriverManager will auto download appropriate version of chrome driver,
 * it will not run stably due to unknown errors. It is recommend to set chrome driver
 * version manually through System.setProperty()
 * Due to docker-selenium grid image (4.3.0) using in this project,
 * chrome driver and browser version is 103
 */
public class ChromeDriverFactory {

    public WebDriver getBrowserDriver(String browser, String ipAddress, String port) throws MalformedURLException {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", GlobalConstants.getGlobalConstants().getPathToBrowserDriver() + "chromedriver_103.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setAcceptInsecureCerts(true);
        chromeOptions.merge(capabilities);

        return new RemoteWebDriver(new URL(String.format("http://%s:%s", ipAddress, port)), chromeOptions);
    }
}
