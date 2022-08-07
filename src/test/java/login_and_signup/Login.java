package login_and_signup;

import commons.BaseTest;
import data_resolver.Environment;
import helpers.LoggerHelper;
import helpers.RecordVideoHelper;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import page_objects.HomePage;
import page_objects.PageInitManager;
import parameter_resolver.EnvironmentParameterResolver;

@Tag("login")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class Login extends BaseTest {

    HomePage homePage;

    WebDriver driver;
    Logger log;

    String password;

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

        log.info("Pre-condition: Click to SignUp/Login button to open SignUp/Login popup");
        homePage.clickToHeaderLoginButton(driver);

        //test data
        password = "123456";
    }

//    @ParameterizedTest
//    @MethodSource("parameter_test_data.Login#invalidEmail")
//    @DisplayName("TC_01_Login_With_Invalid_Email")
//    public void TC_01_Login_With_Invalid_Email(String email, String password, String message, TestInfo testInfo) {
//        String testMethod = testInfo.getTestMethod().get().getName();
//
//        log.info(testMethod + " - Start test");
//
//        log.info(testMethod + " - Step 01: Enter to email textbox with email = " + email);
//        homePage.enterToEmailTextbox(driver, email);
//
//        log.info(testMethod + " - Step 02: Enter to password textbox with password = " + password);
//        homePage.enterToPasswordTextbox(driver, password);
//
//        log.info(testMethod + " - Step 03: Click to Login Button");
//        homePage.clickToLoginButton(driver);
//
//        log.info(testMethod + " - Step 04: Verify that error message = " + message + " is displayed");
//        Assertions.assertTrue(homePage.isValidationErrorMessageDisplayed(driver, message));
//
//        log.info(testMethod + " - End test");
//    }

    @DisplayName("TC_02_Login_With_Invalid_Password")
    @ParameterizedTest
    @MethodSource("parameter_test_data.Login#invalidPassword")
    public void TC_02_Login_With_Invalid_Password(String email, String password, String message, TestInfo testInfo) {
        String testMethod = testInfo.getTestMethod().get().getName();

        log.info(testMethod + " - Start test");

        log.info(testMethod + " - Step 01: Enter to email textbox with email = " + email);
        homePage.enterToEmailTextbox(driver, email);

        log.info(testMethod + " - Step 02: Enter to password textbox with password = " + password);
        homePage.enterToPasswordTextbox(driver, password);

        log.info(testMethod + " - Step 03: Click to Login Button");
        homePage.clickToLoginButton(driver);

        log.info(testMethod + " - Step 04: Verify that error message = " + message + " is displayed");
        Assertions.assertTrue(homePage.isLoginErrorMessageDisplayed(driver, message));

        log.info(testMethod + " - End test");
    }

    @AfterAll
    public void afterAll() {
        closeBrowserAndKillProcess();
    }

}