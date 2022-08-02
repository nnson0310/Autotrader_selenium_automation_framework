package browser_factory.local;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

/**
 * As mention in Selenium 4 doc, Opera Driver is deprecated
 * because it can not meet W3C standards. Below is just
 * work-around methods (not recommend)
 */
public class OperaDriverFactory implements BrowserDriverFactory {
    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.operadriver().setup();

        OperaOptions operaOptions = new OperaOptions();
        operaOptions.setExperimentalOption("w3c", true);

        return new OperaDriver(operaOptions);
    }
}
