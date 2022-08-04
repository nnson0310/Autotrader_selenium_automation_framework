package login_and_signup;

import commons.BaseTest;
import data_resolver.Environment;
import helpers.DataFaker;
import helpers.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;
import org.openqa.selenium.WebDriver;
import page_objects.HomePage;
import page_objects.PageInitManager;
import parameter_resolver.EnvironmentParameterResolver;

@Tag("signup")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class Signup extends BaseTest {

    HomePage homePage;

    WebDriver driver;
    Logger log;

    String email, password, firstName, lastName;

    @BeforeAll
    public void beforeAll(Environment environment) {
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
        log = LoggerHelper.getLogger(Signup.class);
        homePage = PageInitManager.getHomePage(driver);

        //test data
        email = DataFaker.getDataFaker().generateEmail();
        password = "Pass123456";
        firstName = DataFaker.getDataFaker().generateFirstName();
        lastName = DataFaker.getDataFaker().generateLastName();

    }

    @RetryingTest(maxAttempts = 3)
    @DisplayName("TC_01_Signup_With_Valid_Credentials")
    public void TC_01_Signup_With_Valid_Credentials() {
        log.info("TC_01_Signup_With_Valid_Credentials - Step 01: Click to Signup/Login button");
        homePage.clickToHeaderLoginButton(driver);

        log.info("TC_01_Signup_With_Valid_Credentials - Step 02: Click to switch to Signup Tab");
        homePage.clickToSignupTab(driver);

        log.info("TC_01_Signup_With_Valid_Credentials - Step 03: Enter to email textbox with email = " + email);
        homePage.enterToEmailTextbox(driver, email);

        log.info("TC_01_Signup_With_Valid_Credentials - Step 04: Enter to password textbox with password = " + password);
        homePage.enterToPasswordTextbox(driver, password);

        log.info("TC_01_Signup_With_Valid_Credentials - Step 05: Enter to first_name textbox with first name = " + firstName);
        homePage.enterToFirstNameTextbox(driver, firstName);

        log.info("TC_01_Signup_With_Valid_Credentials - Step 06: Enter to last_name textbox with last name = " + lastName);
        homePage.enterToLastNameTextbox(driver, lastName);

        log.info("TC_01_Signup_With_Valid_Credentials - Step 07: Click to Signup button");
        homePage.clickToSignUpButton(driver);

        log.info("TC_01_Signup_With_Valid_Credentials - Step 08: Verify that username = " + firstName + " is displayed on header");
        Assertions.assertTrue(homePage.isUserNameDisplayedOnHeader(driver, firstName));
    }

    @AfterAll
    public void afterAll() {
        closeBrowserAndKillProcess();
    }

}