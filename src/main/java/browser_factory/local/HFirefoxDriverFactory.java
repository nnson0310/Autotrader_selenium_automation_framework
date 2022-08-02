package browser_factory.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HFirefoxDriverFactory implements BrowserDriverFactory {

    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.setHeadless(true);

        return new FirefoxDriver(firefoxOptions);
    }
}
