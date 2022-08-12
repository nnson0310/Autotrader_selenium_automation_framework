package research;

import commons.BaseTest;
import data_resolver.Environment;
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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class TowingCapacity extends BaseTest {
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
        log = LoggerHelper.getLogger(TowingCapacity.class);
        homePage = PageInitManager.getPageInitManager().getHomePage(driver);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car"})
    public void TC_01_Submit_Question_Success(String input, TestInfo testInfo) {
        String testMethod = testInfo.getTestMethod().get().getName();

        log.info(testMethod + " - Step 01: Click to 'Contact Us' link in footer");

    }

    @AfterAll
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}

