package browser_factory.local;

import custom_exceptions.BrowserNotSupportedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

public class SafariDriverFactory implements BrowserDriverFactory {
    @Override
    public WebDriver getBrowserDriver() {
        if (!IS_OS_MAC) {
            throw new BrowserNotSupportedException("Safari browser");
        }

        return new SafariDriver();
    }
}
