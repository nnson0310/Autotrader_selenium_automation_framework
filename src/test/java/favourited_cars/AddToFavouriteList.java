package favourited_cars;

import commons.BaseTest;
import data_resolver.Environment;
import dynamic_field_name.MemberCentreFieldName;
import helpers.LoggerHelper;
import helpers.ParseJsonHelper;
import json_data.AddToFavourite;
import json_data.LoginCredentials;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import page_objects.PageInitManager;
import page_objects.for_sale.ForSalePage;
import page_objects.home.HomePage;
import page_objects.member_centre.EditProfilePage;
import page_objects.member_centre.FavouritedCarPage;
import parameter_resolver.EnvironmentParameterResolver;
import pre_condition.Login;
import json_data.AddToFavourite.FavouriteCar;
import pre_condition.RemoveFavouritedCar;

@Tag("add_to_favourite")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class AddToFavouriteList extends BaseTest {
    WebDriver driver;
    Logger log;

    HomePage homePage;
    ForSalePage forSalePage;
    EditProfilePage editProfilePage;
    FavouritedCarPage favouritedCarPage;

    AddToFavourite addToFavourite;
    FavouriteCar favouriteCar;
    LoginCredentials loginCredentials;

    String username;

    @BeforeAll
    public void setUp(Environment environment) {
        driver = getBrowserDriver(
                environment.getUrl(),
                environment.getEnvironmentName(),
                environment.getBrowserName(),
                environment.getBrowserVersion(),
                environment.getIpAddress(),
                environment.getPort(),
                environment.getOs(),
                environment.getOsVersion()
        );
        log = LoggerHelper.getLogger(AddToFavouriteList.class);
        homePage = PageInitManager.getPageInitManager().getHomePage(driver);

        //test data
        addToFavourite = ParseJsonHelper.getAddToFavourite();
        favouriteCar = addToFavourite.getFavouriteCar();
        loginCredentials = ParseJsonHelper.getLoginCredentials();
        username = loginCredentials.getUsername();

        // pre-condition: login with valid credentials
        Login loginHelper = new Login(driver, homePage);
        loginHelper.loginWithValidCredentials();

        // pre-condition: remove all added favourite car
        RemoveFavouritedCar removeFavouritedCar = new RemoveFavouritedCar(driver);
        homePage = removeFavouritedCar.removeAllCars(username);
    }

    @Test
    public void TC_01_Add_To_Favourite(TestInfo testInfo) {
        String testMethod = testInfo.getTestMethod().get().getName();

        log.info(testMethod + " - Step 01: Click to Featured Searches = " + addToFavourite.getFeaturedSearches());
        forSalePage = homePage.clickToFeaturedSearches(driver, addToFavourite.getFeaturedSearches());

        log.info(testMethod + " - Step 02: Add car = '" + favouriteCar.getName() + "' to favourite list by clicking to heart icon");
        forSalePage.clickToShortListHeartIcon(driver, favouriteCar.getName());

        log.info(testMethod + " - Step 03: Verify that success notify = '" + addToFavourite.getExpectedNotify() + "' is displayed");
        Assertions.assertTrue(forSalePage.isNotifyDisplayed(driver, addToFavourite.getExpectedNotify()));

        log.info(testMethod + " - Step 04: Verify that number of favourite car counted on header = " + favouriteCar.getCount());
        Assertions.assertEquals(favouriteCar.getCount(), forSalePage.getAddedFavouriteCarCountOnHeader(driver, addToFavourite.getExpectedNotify()));

        log.info(testMethod + " - Step 05: Click to heart icon on header to show shortlist of added favourited cars");
        forSalePage.clickToHeartIconOnHeader(driver);

        String subTitle = favouriteCar.getPrice() + " • " + favouriteCar.getOdometerReading();
        log.info(testMethod + " - Step 06: Verify that car name = " + favouriteCar.getName() + " and subtitle = " + subTitle + " showing on shortlist");
        Assertions.assertTrue(forSalePage.isFavouritedCarsDisplayedInShortlist(driver, favouriteCar.getName(), subTitle));

        log.info(testMethod + " - Step 07: Click to 'Show More' link of shortlist");
        favouritedCarPage = forSalePage.clickToShowMoreShortlistLink(driver);

        log.info(testMethod + " - Step 08: Verify that car name = " + favouriteCar.getName() + " are displayed with correct information");
        Assertions.assertAll(
                "verify added favourite car",
                () -> Assertions.assertEquals(favouriteCar.getCount(), favouritedCarPage.getAddedCarCount(driver)),
                () -> Assertions.assertTrue(favouritedCarPage.isCarNameDisplayed(driver, favouriteCar.getName())),
                () -> Assertions.assertTrue(favouritedCarPage.isPriceDisplayed(driver, favouriteCar.getPrice())),
                () -> Assertions.assertTrue(favouritedCarPage.isOdometerReadingDisplayed(driver, favouriteCar.getOdometerReading()))
        );
    }

    @AfterAll
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
