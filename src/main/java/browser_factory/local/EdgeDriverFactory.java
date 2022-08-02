package browser_factory.local;

import custom_exceptions.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

public class EdgeDriverFactory implements BrowserDriverFactory {

    @Override
    public WebDriver getBrowserDriver() {

        if (!IS_OS_WINDOWS) {
            throw new BrowserNotSupportedException("Edge browser");
        }

        WebDriverManager.edgedriver().setup();

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setAcceptInsecureCerts(true);

        return new EdgeDriver(edgeOptions);
    }
}
