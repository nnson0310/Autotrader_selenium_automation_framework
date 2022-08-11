package profile;

import commons.BaseTest;
import data_resolver.Environment;
import helpers.*;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import page_objects.profile.EditProfilePage;
import page_objects.home.HomePage;
import page_objects.PageInitManager;
import parameter_resolver.EnvironmentParameterResolver;
import pre_condition.LoginHelper;

@Tag("edit_profile")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class EditProfile extends BaseTest {
    WebDriver driver;
    Logger log;

    HomePage homePage;
    EditProfilePage editProfilePage;

    String userName, firstName, lastName, successNotify;

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
        log = LoggerHelper.getLogger(EditProfile.class);
        homePage = PageInitManager.getPageInitManager().getHomePage(driver);

        // login credentials
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginWithValidCredentials();

        // test data
        userName = ParseJsonHelper.getLoginCredentials().getUsername();
        firstName = DataFaker.getDataFaker().generateFirstName();
        lastName = DataFaker.getDataFaker().generateLastName();
        successNotify = "Changes successful";

    }

    @Test
    public void TC_01_Update_First_Name_And_Last_Name() {
        log.info("TC_01_Update_First_Name_And_Last_Name - Step 01: Hover to user_name header");
        homePage.hoverToUserNameHeader(driver, userName);

        log.info("TC_01_Update_First_Name_And_Last_Name - Step 02: Click to Edit Profile link in dropdown");
        editProfilePage = homePage.clickToEditProfileHeaderLink(driver);

        log.info("TC_01_Update_First_Name_And_Last_Name - Step 03: Enter to first_name textbox with first_name = " + firstName);
        editProfilePage.enterToFirstNameTextbox(driver, firstName);

        log.info("TC_01_Update_First_Name_And_Last_Name - Step 04: Enter to last_name textbox with last_name = " + lastName);
        editProfilePage.enterToLastNameTextbox(driver, lastName);

        log.info("TC_01_Update_First_Name_And_Last_Name - Step 05: Click to Save button");
        editProfilePage.clickToSaveButton(driver);

        log.info("TC_01_Update_First_Name_And_Last_Name - Step 06: Click to Save_changes button of modal");
        editProfilePage.clickToSaveChangesModalButton(driver);
        WriteJsonHelper.updateUsernameOfLoginCredentials(firstName);

        log.info("TC_01_Update_First_Name_And_Last_Name - Step 07: Verify that notification = " + successNotify + " is displayed");
        Assertions.assertTrue(editProfilePage.isChangeSuccessNotifyDisplayed(driver, successNotify));
    }

    @AfterAll
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
