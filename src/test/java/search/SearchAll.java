package search;

import commons.BaseTest;
import data_resolver.Environment;
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
import sell_car.CreateAd;

import java.util.ArrayList;
import java.util.List;

@Tag("search_all")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class SearchAll extends BaseTest {
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
        log = LoggerHelper.getLogger(CreateAd.class);
        homePage = PageInitManager.getPageInitManager().getHomePage(driver);
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/test_data/csv/search_params.csv",
            numLinesToSkip = 1,
            ignoreLeadingAndTrailingWhitespace = true
    )
    public void TC_01_Search_With_Both_Make_And_Model(String make, String model, String expectedResults, TestInfo testInfo) {
        String testMethod = testInfo.getTestMethod().get().getName();
        String carName = make + " " + model;
        List<String> selectedFilters = new ArrayList<>();
        selectedFilters.add(make);
        selectedFilters.add(model);

        log.info(testMethod + " - Start Test");

        log.info(testMethod + " - Step 01: Select Make = '" + make + "' in dropdown list");
        homePage.selectMakeInDropdown(driver, make);

        log.info(testMethod + " - Step 02: Select Model = '" + model + "' in dropdown list");
        homePage.selectModelInDropdown(driver, model);
        forSalePage = PageInitManager.getPageInitManager().getForSalePage(driver);

        log.info(testMethod + " - Step 03: Verify that search title contains '" + carName + "'");
        Assertions.assertTrue(forSalePage.isSearchTitleDisplayed(driver, carName));

        log.info(testMethod + " - Step 04: Verify that selected filters are make = " + make + " and model = " + model);
        Assertions.assertTrue(forSalePage.areSelectedFiltersDisplayed(driver, selectedFilters));

        log.info(testMethod + " - Step 05: Verify that there are " + expectedResults + " results are displayed and all car title contains " + carName);
        Assertions.assertEquals(expectedResults, forSalePage.getNumberOfCarListingTitle(driver, carName));

        log.info(testMethod + " - Step 06: Click to 'Autotrader' logo to return to homepage");
        forSalePage.clickToAutotraderLogo(driver);

        log.info(testMethod + " - End Test");
    }

    @AfterAll
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
