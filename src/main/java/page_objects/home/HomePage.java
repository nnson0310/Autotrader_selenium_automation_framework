package page_objects.home;

import org.openqa.selenium.WebDriver;
import page_objects.CommonPage;

public class HomePage extends CommonPage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
