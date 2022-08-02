package browser_factory.grid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverFactory {

    public WebDriver getBrowserDriver(String ipAddress, String port) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);

        return new RemoteWebDriver(new URL(String.format("http:/%s:%s/wd/hub", ipAddress, port)), chromeOptions);
    }
}
