package research;

import commons.BaseTest;
import data_resolver.Environment;
import dynamic_field_name.HeaderNavigationLink;
import helpers.LoggerHelper;
import helpers.ParseJsonHelper;
import json_data.CarDimension;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import page_objects.PageInitManager;
import page_objects.home.HomePage;
import page_objects.research.CarDimensionPage;
import page_objects.research.ShowDimensionPage;
import parameter_resolver.EnvironmentParameterResolver;

import java.util.ArrayList;
import java.util.List;

@Tag("research_car_dimension")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class Dimension extends BaseTest {
    WebDriver driver;
    Logger log;

    HomePage homePage;
    CarDimensionPage carDimensionPage;
    ShowDimensionPage showDimensionPage;

    ArrayList<CarDimension> carDimensions;

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
        log = LoggerHelper.getLogger(Dimension.class);
        homePage = PageInitManager.getPageInitManager().getHomePage(driver);

        //test data
        carDimensions = ParseJsonHelper.getCarDimensionList();

    }

    @Test
    public void TC_01_All_Search_Params(TestInfo testInfo) {
        String testMethod = testInfo.getTestMethod().get().getName();

        for (CarDimension carDimension : carDimensions) {
            log.info(testMethod + " - Start Test");

            log.info(testMethod + " - Step 01: Hover to 'Research' header link and click to 'Car Dimensions' navigation link");
            homePage.clickToHeaderNavigationLink(driver, HeaderNavigationLink.researchFieldName, HeaderNavigationLink.carDimensionsFieldName);
            carDimensionPage = PageInitManager.getPageInitManager().getCarDimensionPage(driver);

            log.info(testMethod + " - Step 02: Select to Make dropdown with Make = " + carDimension.getMake());
            carDimensionPage.selectToMakeDropdown(driver, carDimension.getMake());

            log.info(testMethod + " - Step 03: Select to Model dropdown with Model = " + carDimension.getModel());
            carDimensionPage.selectToModelDropdown(driver, carDimension.getModel());

            log.info(testMethod + " - Step 04: Select to Year dropdown with Year = " + carDimension.getYear());
            carDimensionPage.selectToYearDropdown(driver, carDimension.getYear());

            log.info(testMethod + " - Step 05: Click to 'Show Dimensions' button");
            showDimensionPage = carDimensionPage.clickToShowDimensionsButton(driver);

            log.info(testMethod + " - Step 06: Verify that dimension title = " + carDimension.getDimensionTitle());
            Assertions.assertTrue(showDimensionPage.isDimensionTitleDisplayed(driver, carDimension.getDimensionTitle()));

            // get dimension results
            List<CarDimension.DimensionResults> dimensionResults = new ArrayList<>();
            dimensionResults = carDimension.getDimensionResults();

            List<CarDimension.DimensionResults> finalDimensionResults = dimensionResults;
            int resultCounter = dimensionResults.size();
            log.info(testMethod + " - Step 07: Verify that number of dimensions results = " + resultCounter + " and all dimensions info are correct");
            Assertions.assertAll(
                    "dimensions-info",
                    () -> Assertions.assertEquals(resultCounter, showDimensionPage.getNumberOfDimensionResults(driver)),
                    () -> Assertions.assertTrue(showDimensionPage.areDimensionResultsDisplayed(driver, finalDimensionResults))
            );

            log.info(testMethod + " - Step 08: Verify that for_sale button title = " + carDimension.getButtonTitle());
            Assertions.assertTrue(showDimensionPage.isForSaleButtonTitleDisplayed(driver, carDimension.getButtonTitle()));

            log.info(testMethod + " - Step 09: Click to Autotrader Logo to return to homepage");
            homePage = showDimensionPage.clickToAutotraderLogo(driver);

            log.info(testMethod + " - End Test");
        }
    }

    @AfterAll
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
