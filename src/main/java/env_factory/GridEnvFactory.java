package env_factory;

import enums.Browser;
import browser_factory.grid.ChromeDriverFactory;
import browser_factory.grid.FirefoxDriverFactory;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class GridEnvFactory implements EnvFactory {

    WebDriver driver;

    private final String browserName;
    private final String ipAddress;
    private final String port;

    public GridEnvFactory(String browserName, String ipAddress, String port) {
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public WebDriver initBrowserDriver() {
        Browser browser = Browser.valueOf(browserName.toUpperCase());

        try {
            if (browser == Browser.CHROME) {
                driver = new ChromeDriverFactory().getBrowserDriver(browserName, ipAddress, port);
            }
            else {
                driver = new FirefoxDriverFactory().getBrowserDriver(browserName, ipAddress, port);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
