package footer;

import commons.BaseTest;
import data_resolver.Environment;
import dynamic_field_name.FooterLinkFieldName;
import helpers.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import page_objects.PageInitManager;
import page_objects.home.HomePage;
import parameter_resolver.EnvironmentParameterResolver;

@Tag("footer_link")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class FooterLink extends BaseTest {
    WebDriver driver;
    Logger log;

    HomePage homePage;

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
        log = LoggerHelper.getLogger(FooterLink.class);
        homePage = PageInitManager.getPageInitManager().getHomePage(driver);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Autotrader Group"})
    public void TC_01_Navigate_To_Dealers_Page(String tabTitle, TestInfo testInfo) {
        String testMethod = testInfo.getTestMethod().get().getName();

        log.info(testMethod + " - Step 01: Click to 'Dealers' link in footer");
        homePage.clickToFooterLink(driver, FooterLinkFieldName.dealers);

        log.info(testMethod + " - Step 02: Switch to new tab and verify tab title = " + tabTitle);
        Assertions.assertEquals(tabTitle, homePage.getPageTitleOfNewTab(driver));
    }

    @ParameterizedTest
    @ValueSource(strings = {"CarsGuide: Car Reviews - New & Used Car Sales"})
    public void TC_02_Navigate_To_CarsGuide_Page(String tabTitle, TestInfo testInfo) {
        String testMethod = testInfo.getTestMethod().get().getName();

        log.info(testMethod + " - Step 01: Click to 'CarsGuide' link in footer");
        homePage.clickToFooterLink(driver, FooterLinkFieldName.carsGuide);

        log.info(testMethod + " - Step 02: Switch to new tab and verify tab title = " + tabTitle);
        Assertions.assertEquals(tabTitle, homePage.getPageTitleOfNewTab(driver));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Gumtree: Australia's Free Marketplace. Find a car, job, furniture & more"})
    public void TC_03_Navigate_To_Gumtree_Page(String tabTitle, TestInfo testInfo) {
        String testMethod = testInfo.getTestMethod().get().getName();

        log.info(testMethod + " - Step 01: Click to 'Gumtree' link in footer");
        homePage.clickToFooterLink(driver, FooterLinkFieldName.gumTree);

        log.info(testMethod + " - Step 02: Switch to new tab and verify tab title = " + tabTitle);
        Assertions.assertEquals(tabTitle, homePage.getPageTitleOfNewTab(driver));
    }

    @AfterAll
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
