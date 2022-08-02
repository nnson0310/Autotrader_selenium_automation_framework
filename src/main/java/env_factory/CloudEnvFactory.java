package env_factory;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class CloudEnvFactory implements EnvFactory {

    WebDriver driver;

    private final String browserName;
    private final String browserVersion;
    private final String os;
    private final String osVersion;

    public CloudEnvFactory(String browserName, String browserVersion, String os, String osVersion) {
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.os = os;
        this.osVersion = osVersion;
    }

    public WebDriver initBrowserDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("os", os);
        browserstackOptions.put("osVersion", osVersion);
        browserstackOptions.put("projectName", GlobalConstants.getGlobalConstants().getProjectName());
        browserstackOptions.put("buildName", GlobalConstants.getGlobalConstants().getProjectVersion());
        browserstackOptions.put("browserstack", browserstackOptions);

        capabilities.setCapability("bstack:options", browserstackOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalConstants().getBrowserStackUrl()), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
