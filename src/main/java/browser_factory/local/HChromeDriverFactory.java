package browser_factory.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HChromeDriverFactory implements BrowserDriverFactory {

    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setHeadless(true);

        return new ChromeDriver(chromeOptions);
    }
}
