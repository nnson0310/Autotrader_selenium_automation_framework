package page_objects;

import org.openqa.selenium.WebDriver;

public class PageInitManager {

    private static PageInitManager pageInitManager;

    public static PageInitManager getPageInitManager() {
        if (pageInitManager == null) {
            return new PageInitManager();
        }
        return pageInitManager;
    }

    public static HomePage getHomePage(WebDriver driver) {
        return new HomePage(driver);
    }

    public static LoginPage getLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }
}
