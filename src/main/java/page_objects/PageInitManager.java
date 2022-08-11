package page_objects;

import org.openqa.selenium.WebDriver;
import page_objects.for_sale.ForSalePage;
import page_objects.home.HomePage;
import page_objects.profile.EditProfilePage;
import page_objects.sell_car.*;

public class PageInitManager {

    private static PageInitManager pageInitManager;

    public static PageInitManager getPageInitManager() {
        if (pageInitManager == null) {
            return new PageInitManager();
        }
        return pageInitManager;
    }

    public HomePage getHomePage(WebDriver driver) {
        return new HomePage(driver);
    }

    public EditProfilePage getEditProfilePage(WebDriver driver) {
        return new EditProfilePage(driver);
    }

    public SellMyCarPage getSellMyCarPage(WebDriver driver) {
        return new SellMyCarPage(driver);
    }

    public SelectACarPage getSelectACarPage(WebDriver driver) {
        return new SelectACarPage(driver);
    }

    public SellDetailsPage getSellDetailsPage(WebDriver driver) {
        return new SellDetailsPage(driver);
    }

    public SellFeaturesPage getSellFeaturesPage(WebDriver driver) {
        return new SellFeaturesPage(driver);
    }

    public SellPhotosPage getSellPhotosPage(WebDriver driver) {
        return new SellPhotosPage(driver);
    }

    public SellDescriptionPage getSellDescriptionPage(WebDriver driver) {
        return new SellDescriptionPage(driver);
    }

    public SellReviewPage getSellReviewPage(WebDriver driver) {
        return new SellReviewPage(driver);
    }

    public ForSalePage getForSalePage(WebDriver driver) {
        return new ForSalePage(driver);
    }
}
