package env_factory;

import browser_factory.local.*;
import enums.Browser;
import org.openqa.selenium.WebDriver;

/**
 * Due to W3C Standard, Opera does not meet requirements
 * so Opera is not supported in Selenium 4.
 * Although we can still use it by setting W3C through ChromeOptions (work-around method)
 */
public class LocalEnvFactory implements EnvFactory {

    WebDriver driver;

    private final String browserName;

    public LocalEnvFactory(String browserName) {
        this.browserName = browserName;
    }

    public WebDriver initBrowserDriver() {
        Browser browser = Browser.valueOf(browserName.toUpperCase());

        if (browser == Browser.CHROME) {
            driver = new ChromeDriverFactory().getBrowserDriver();
        } else if (browser == Browser.FIREFOX) {
            driver = new FirefoxDriverFactory().getBrowserDriver();
        } else if (browser == Browser.EDGE) {
            driver = new EdgeDriverFactory().getBrowserDriver();
        } else if (browser == Browser.H_CHROME) {
            driver = new HChromeDriverFactory().getBrowserDriver();
        } else if (browser == Browser.H_FIREFOX) {
            driver = new HFirefoxDriverFactory().getBrowserDriver();
        } else if (browser == Browser.OPERA) {
            driver = new OperaDriverFactory().getBrowserDriver();
        } else {
            driver = new SafariDriverFactory().getBrowserDriver();
        }

        return driver;
    }
}
