package pre_condition;

import helpers.LoggerHelper;
import helpers.ParseJsonHelper;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import page_objects.home.HomePage;

public class Login {

    HomePage homePage;
    Logger log;
    WebDriver driver;

    private final String email = ParseJsonHelper.getLoginCredentials().getEmail();
    private final String password = ParseJsonHelper.getLoginCredentials().getPassword();
    private final String username = ParseJsonHelper.getLoginCredentials().getUsername();

    public Login(WebDriver driver, HomePage homePage) {
        this.driver = driver;
        this.homePage = homePage;
        log = LoggerHelper.getLogger(Login.class);
    }

    public void loginWithValidCredentials() {
        log.info("Pre-condition - Login with valid credentials - Step 01: Click to SignUp/Login button to open SignUp/Login popup");
        homePage.clickToHeaderLoginButton(driver);

        log.info("Pre-condition - Login with valid credentials - Step 02: Enter to email textbox with email = " + email);
        homePage.enterToEmailTextbox(driver, email);

        log.info("Pre-condition - Login with valid credentials - Step 03: Enter to password textbox with password = " + password);
        homePage.enterToPasswordTextbox(driver, password);

        log.info("Pre-condition - Login with valid credentials - Step 04: Click to Login button");
        homePage.clickToLoginButton(driver);

        log.info("Pre-condition - Login with valid credentials - Step 05: Verify that username = " + username + " is displayed on header");
        Assertions.assertTrue(homePage.isUserNameDisplayedOnHeader(driver, username));
    }
}
