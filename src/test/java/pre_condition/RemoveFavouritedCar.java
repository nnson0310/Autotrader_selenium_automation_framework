package pre_condition;

import helpers.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.PageInitManager;
import page_objects.home.HomePage;
import page_objects.member_centre.EditProfilePage;
import page_objects.member_centre.FavouritedCarPage;

public class RemoveFavouritedCar {

    HomePage homePage;
    EditProfilePage editProfilePage;
    FavouritedCarPage favouritedCarPage;

    Logger log;
    WebDriver driver;

    public RemoveFavouritedCar(WebDriver driver) {
        this.driver = driver;
        homePage = PageInitManager.getPageInitManager().getHomePage(driver);
        log = LoggerHelper.getLogger(RemoveFavouritedCar.class);
    }

    public HomePage removeAllCars(String username) {
        log.info("Pre-condition - Remove all favourited cars - Step 01: Click to heart icon to show favourite shortlist");
        homePage.clickToHeartIconOnHeader(driver);

        log.info("Pre-condition - Remove all favourited cars - Step 02: Click to 'Show More' link to go to Favourited_Cars page");
        favouritedCarPage = homePage.clickToShowMoreShortlistLink(driver);

        log.info("Pre-condition - Remove all favourited cars - Step 03: Click to star icon to remove all added car");
        favouritedCarPage.clickToStarIconToRemoveAllCars(driver);

        log.info("Pre-condition - Remove all favourited cars - Step 04: Click to 'AutoTrader' logo to return to homepage");
        homePage = favouritedCarPage.clickToAutotraderLogo(driver);

        return homePage;
    }
}
