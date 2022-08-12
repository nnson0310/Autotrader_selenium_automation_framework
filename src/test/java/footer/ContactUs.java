package footer;

import commons.BaseTest;
import data_resolver.Environment;
import dynamic_field_name.ContactUsFieldName;
import dynamic_field_name.FooterLinkFieldName;
import helpers.LoggerHelper;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.openqa.selenium.WebDriver;
import page_objects.PageInitManager;
import page_objects.contact_us.ContactUsPage;
import page_objects.home.HomePage;
import parameter_resolver.EnvironmentParameterResolver;

@Tag("contact_us")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class ContactUs extends BaseTest {
    WebDriver driver;
    Logger log;

    HomePage homePage;
    ContactUsPage contactUsPage;

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
        log = LoggerHelper.getLogger(ContactUs.class);
        homePage = PageInitManager.getPageInitManager().getHomePage(driver);
    }

    @ParameterizedTest
    @ArgumentsSource(parameter_test_data.ContactUs.class)
    public void TC_01_Submit_Question_Success(String enquiryType, String name, String email, String message, String successNotify, TestInfo testInfo) {
        String testMethod = testInfo.getTestMethod().get().getName();

        log.info(testMethod + " - Step 01: Click to 'Contact Us' link in footer");
        homePage.clickToFooterLink(driver, FooterLinkFieldName.contactUs);
        contactUsPage = PageInitManager.getPageInitManager().getContactUsPage(driver);

        log.info(testMethod + " - Step 02: Select enquiry type = " + enquiryType);
        contactUsPage.selectToEnquiryTypeDropdown(driver, enquiryType);

        log.info(testMethod + " - Step 03: Enter to name textbox with name = " + name);
        contactUsPage.enterToDynamicTextboxByName(driver, name, ContactUsFieldName.nameFieldName);

        log.info(testMethod + " - Step 04: Enter to email address textbox with email = " + email);
        contactUsPage.enterToDynamicTextboxByName(driver, email, ContactUsFieldName.emailFieldName);

        log.info(testMethod + " - Step 05: Enter to message textarea with message = " + message);
        contactUsPage.enterToMessageTextarea(driver, message);

        log.info(testMethod + " - Step 06: Click to 'Submit Questions' button");
        contactUsPage.clickToSubmitQuestionButton(driver);

        log.info(testMethod + " - Step 07: Verify that success notification = '" + successNotify + "' is displayed");
        Assertions.assertTrue(contactUsPage.isEnquirySubmitSuccessNotificationDisplayed(driver, successNotify));

    }

    @AfterAll
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
