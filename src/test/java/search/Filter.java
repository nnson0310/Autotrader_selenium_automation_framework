package search;

import commons.BaseTest;
import data_resolver.Environment;
import dynamic_field_name.FilterFieldName;
import dynamic_field_name.HeaderNavigationLink;
import favourited_cars.AddToFavouriteList;
import helpers.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import page_objects.PageInitManager;
import page_objects.for_sale.ForSalePage;
import page_objects.home.HomePage;
import parameter_resolver.EnvironmentParameterResolver;

@Tag("filter")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class Filter extends BaseTest {
    WebDriver driver;
    Logger log;

    HomePage homePage;
    ForSalePage forSalePage;

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
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/test_data/csv/filter_conditions.csv",
            numLinesToSkip = 1,
            ignoreLeadingAndTrailingWhitespace = true
    )
    @Tag("make_price_year")
    public void TC_01_Add_To_Favourite(String filterMake, String filterPrice, String filterYear, String expectedPrice, int expectedResults, TestInfo testInfo) {
        String testMethod = testInfo.getTestMethod().get().getName();

        log.info(testMethod + " - Step 01: Hover to 'Buy' header link and click to 'All Cars' navigation link");
        homePage.clickToBuyHeaderNavItemLink(driver, HeaderNavigationLink.allCarsFieldName);
        forSalePage = PageInitManager.getPageInitManager().getForSalePage(driver);

        log.info(testMethod + " - Step 02: Click to Make filter = " + filterMake);
        forSalePage.clickToFilterLink(driver, FilterFieldName.MAKE_MAIN_FILTER_LINK, filterMake);

        log.info(testMethod + " - Step 03: Click to 'Cheap Cars' of Price Filter");
        forSalePage.clickToFilterLink(driver, FilterFieldName.PRICE_MAIN_FILTER_LINK, FilterFieldName.PRICE_CHEAP_FILTER_LINK);

        log.info(testMethod + " - Step 04: Click to " + filterPrice + " of Price Filter");
        forSalePage.clickToFilterLink(driver, FilterFieldName.PRICE_MAIN_FILTER_LINK, filterPrice);

        log.info(testMethod + " - Step 05: Click to 'Old Cars' link of Year Filter");
        forSalePage.clickToFilterLink(driver, FilterFieldName.YEAR_MAIN_FILTER_LINK, FilterFieldName.YEAR_OLDER_CAR_FILTER_LINK);

        log.info(testMethod + " - Step 06: Click to year = " + filterYear + " link of Year Filter");
        forSalePage.clickToFilterLink(driver, FilterFieldName.YEAR_MAIN_FILTER_LINK, filterYear);

        String carName = filterYear + " " + filterMake;
        log.info(testMethod + " - Step 07: Verify that all filtered cars have following information: \n" +
                "+ Car name contains '" + carName + "'.\n" +
                "+ There are '" + expectedResults + "' cars displayed as filtered results.\n" +
                "+ Price is '" + expectedPrice + "'.\n"
        );
        Assertions.assertAll(
                "filtered_cars",
                () -> Assertions.assertTrue(forSalePage.isCarNameDisplayed(driver, carName)),
                () -> Assertions.assertEquals(expectedResults, forSalePage.getNumberOfCars(driver)),
                () -> Assertions.assertTrue(forSalePage.isCarPriceDisplayed(driver, expectedPrice))
        );
    }

    @AfterAll
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
