package browser_factory.grid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverFactory {
    public WebDriver getBrowserDriver(String ipAddress, String port) throws MalformedURLException {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);

        return new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, port)), firefoxOptions);
    }
}
