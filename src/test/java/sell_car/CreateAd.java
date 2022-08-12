package sell_car;

import commons.BaseTest;
import commons.GlobalConstants;
import data_resolver.Environment;
import dynamic_field_name.CarDetailsFieldName;
import dynamic_field_name.SelectCarFieldName;
import helpers.LoggerHelper;
import helpers.ParseJsonHelper;
import json_data.SelectCar;
import json_data.SellDetails;
import json_data.SellFeatures;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import page_objects.PageInitManager;
import page_objects.home.HomePage;
import page_objects.sell_car.*;
import parameter_resolver.EnvironmentParameterResolver;
import pre_condition.LoginHelper;

import java.util.ArrayList;
import java.util.List;

@Tag("create_ad")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(EnvironmentParameterResolver.class)
public class CreateAd extends BaseTest {
    WebDriver driver;
    Logger log;

    HomePage homePage;
    SellMyCarPage sellMyCarPage;
    SelectACarPage selectACarPage;
    SellDetailsPage sellDetailsPage;
    SellPhotosPage sellPhotosPage;
    SellFeaturesPage sellFeaturesPage;
    SellDescriptionPage sellDescriptionPage;
    SellReviewPage sellReviewPage;

    ArrayList<SelectCar> selectCarList;
    SellDetails carDetails;
    SellFeatures sellFeatures;
    List<String> optionalExtras, customModifications;
    String uploadPhotos, carName, reviewVehicleTitle;
    String optionalExtrasText = "";
    String customModificationsText = "";
    int optionalExtrasSize, customModificationsSize, numberOfUploadedImages;

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

        // login as pre condition
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginWithValidCredentials();

        // test data
        selectCarList = ParseJsonHelper.getSelectCar();
        carDetails = ParseJsonHelper.getSellDetails();
        sellFeatures = ParseJsonHelper.getSellFeatures();
        optionalExtras = sellFeatures.getOptionalExtras();
        customModifications = sellFeatures.getCustomModifications();
        optionalExtrasSize = optionalExtras.size();
        customModificationsSize = customModifications.size();
        for (SelectCar car : selectCarList) {
            carName = car.getMake() + " " + car.getModel() + " " + car.getVariant() + " " + car.getSeries();
            reviewVehicleTitle = "Complete your FREE ad for a "
                    + car.getYear() + " "
                    + car.getMake() + " "
                    + car.getModel() + " "
                    + car.getBodyType() + " "
                    + car.getTransmission() + " "
                    + car.getVariant() + " "
                    + car.getSeries();
        }

        for (String optionalExtra : optionalExtras) {
            optionalExtrasText += optionalExtra + ", ";
        }

        for (String customModification : customModifications) {
            customModificationsText += customModification + ", ";
        }

        String pathToImage = GlobalConstants.getGlobalConstants().getPathToUploadImages();
        uploadPhotos = pathToImage + "my_car_01.jpg" + "\n" + pathToImage + "my_car_02.jpg";
        numberOfUploadedImages = 2;
    }

    @Test
    public void TC_01_Create_Ad_With_No_Number_Plate(TestInfo testInfo) {
        String testMethod = testInfo.getTestMethod().get().getName();

        for (SelectCar car : selectCarList) {
            log.info(testMethod + " - Step 01: Click to 'Create my Free ad' button in header");
            sellMyCarPage = homePage.clickToCreateMyFreeAdButton(driver);

            log.info(testMethod + " - Step 02: Click to 'No Number Plate' link");
            selectACarPage = sellMyCarPage.clickToNoNumberPlateLink(driver);

            log.info(testMethod + " - Step 03: Select make = " + car.getMake());
            selectACarPage.selectToInputDropdown(driver, SelectCarFieldName.makeSelectName, car.getMake());

            log.info(testMethod + " - Step 04: Select model = " + car.getModel());
            selectACarPage.selectToInputDropdown(driver, SelectCarFieldName.modelSelectName, car.getModel());

            log.info(testMethod + " - Step 05: Select year = " + car.getYear());
            selectACarPage.selectToInputDropdown(driver, SelectCarFieldName.yearSelectName, car.getYear());

            log.info(testMethod + " - Step 06: Select body type = " + car.getBodyType());
            selectACarPage.selectToInputDropdown(driver, SelectCarFieldName.bodyTypeSelectName, car.getBodyType());

            log.info(testMethod + " - Step 07: Select transmission = " + car.getTransmission());
            selectACarPage.selectToInputDropdown(driver, SelectCarFieldName.transmissionSelectName, car.getTransmission());

            log.info(testMethod + " - Step 08: Select fuel type = " + car.getFuelType());
            selectACarPage.selectToInputDropdown(driver, SelectCarFieldName.fuelTypeSelectName, car.getFuelType());

            log.info(testMethod + " - Step 09: Select variant = " + car.getVariant());
            selectACarPage.selectToInputDropdown(driver, SelectCarFieldName.variantSelectName, car.getVariant());

            log.info(testMethod + " - Step 10: Select series = " + car.getSeries());
            selectACarPage.selectToInputDropdown(driver, SelectCarFieldName.seriesSelectName, car.getSeries());

            log.info(testMethod + " - Step 11: Click to 'Create your FREE ad' button");
            sellDetailsPage = selectACarPage.clickToCreateYourFreeAdButton(driver);

            log.info(testMethod + " - Step 12: Verify that car details is correct");
            Assertions.assertAll(
                    "car-details",
                    () -> Assertions.assertTrue(sellDetailsPage.isCarNameDisplayed(driver, carName)),
                    () -> Assertions.assertTrue(sellDetailsPage.isCarTransmissionDisplayed(driver, car.getTransmission())),
                    () -> Assertions.assertTrue(sellDetailsPage.isCarYearDisplayed(driver, car.getYear())),
                    () -> Assertions.assertTrue(sellDetailsPage.isCarBodyTypeDisplayed(driver, car.getBodyType())),
                    () -> Assertions.assertTrue(sellDetailsPage.isCarFuelTypeDisplayed(driver, car.getFuelType()))
            );

            log.info(testMethod + " - Step 13: Enter number plate = " + carDetails.getRegistrationVin().getNumberPlate());
            sellDetailsPage.enterToDynamicTextboxByName(driver, carDetails.getRegistrationVin().getNumberPlate(), CarDetailsFieldName.numberPlateFieldName);

            log.info(testMethod + " - Step 14: Enter VIN = " + carDetails.getRegistrationVin().getVin());
            sellDetailsPage.enterToDynamicTextboxByName(driver, carDetails.getRegistrationVin().getVin(), CarDetailsFieldName.vinFieldName);

            log.info(testMethod + " - Step 15: Check to checkbox 'Is Your Registration Expired' = " + carDetails.getExpired());
            sellDetailsPage.checkToRegistrationExpiredRadio(driver, carDetails.getExpired());

            log.info(testMethod + " - Step 16: Select expiry month = " + carDetails.getExpiryDate().getMonth());
            sellDetailsPage.selectToExpiryMonthDropdown(driver, carDetails.getExpiryDate().getMonth());

            log.info(testMethod + " - Step 17: Select expiry year = " + carDetails.getExpiryDate().getYear());
            sellDetailsPage.selectToExpiryYearDropdown(driver, carDetails.getExpiryDate().getYear());

            log.info(testMethod + " - Step 18: Enter asking price = " + carDetails.getCarSpecifics().getAskingPrice());
            sellDetailsPage.enterToDynamicTextboxByName(driver, carDetails.getCarSpecifics().getAskingPrice(), CarDetailsFieldName.askingPriceFieldName);

            log.info(testMethod + " - Step 19: Enter odometer reading = " + carDetails.getCarSpecifics().getOdometerReading());
            sellDetailsPage.enterToDynamicTextboxByName(driver, carDetails.getCarSpecifics().getOdometerReading(), CarDetailsFieldName.odometerReadingFieldName);

            log.info(testMethod + " - Step 20: Enter location of car pickup = " + carDetails.getCarSpecifics().getPickupLocationSelect());
            sellDetailsPage.selectToCarPickupLocationDropdown(driver, carDetails.getCarSpecifics().getPickupLocationInput(), carDetails.getCarSpecifics().getPickupLocationSelect());

            log.info(testMethod + " - Step 21: Enter exterior colour = " + carDetails.getCarSpecifics().getExteriorColour());
            sellDetailsPage.enterToDynamicTextboxByName(driver, carDetails.getCarSpecifics().getExteriorColour(), CarDetailsFieldName.exteriorColourFieldName);

            log.info(testMethod + " - Step 22: Enter interior colour = " + carDetails.getCarSpecifics().getInteriorColour());
            sellDetailsPage.enterToDynamicTextboxByName(driver, carDetails.getCarSpecifics().getInteriorColour(), CarDetailsFieldName.interiorColourFieldName);

            log.info(testMethod + " - Step 23: Check to 'Will your car come with a logbook?' checkbox = " + carDetails.getAdditional().getLogbook());
            sellDetailsPage.checkToLogbookRadio(driver, carDetails.getAdditional().getLogbook());

            log.info(testMethod + " - Step 24: Select sets of keys = " + carDetails.getAdditional().getSetKeys());
            sellDetailsPage.selectToSetOfKeysDropdown(driver, carDetails.getAdditional().getSetKeys());

            log.info(testMethod + " - Step 25: Click to 'Save and Continue' button");
            sellPhotosPage = sellDetailsPage.clickToSaveAndContinueButton(driver);

            log.info(testMethod + " - Step 26: Upload multi photos stored in upload folder");
            sellPhotosPage.uploadPhotos(driver, uploadPhotos);

            log.info(testMethod + " - Step 27: Verify that all photos are uploaded successfully");
            Assertions.assertTrue(sellPhotosPage.areAllPhotosUploaded(driver));

            log.info(testMethod + " - Step 28: Click to 'Save And Continue' button");
            sellFeaturesPage = sellPhotosPage.clickToSaveAndContinueButton(driver);

            log.info(testMethod + " - Step 29: Click to toggle 'Optional Extras'");
            sellFeaturesPage.clickToOptionalExtrasCollapse(driver);

            log.info(testMethod + " - Step 30: Click to radio button to choose optional extras = " + optionalExtrasText);
            sellFeaturesPage.clickToOptionalExtrasRadioButton(driver, optionalExtrasText, optionalExtras);

            log.info(testMethod + " - Step 31: Verify that number of clicked optional extras = " + String.valueOf(optionalExtrasSize));
            Assertions.assertEquals(sellFeaturesPage.getCheckedOptionalExtras(driver, optionalExtrasSize), optionalExtrasSize);

            log.info(testMethod + " - Step 32: Click to toggle 'Custom Modifications'");
            sellFeaturesPage.clickToCustomModificationsCollapse(driver);

            log.info(testMethod + " - Step 33: Enter to textbox and add custom modifications = " + customModificationsText);
            sellFeaturesPage.addCustomModifications(driver, customModificationsText, customModifications);

            log.info(testMethod + " - Step 34: Verify that number of added custom modifications = " + String.valueOf(customModificationsSize));
            Assertions.assertEquals(customModificationsSize, sellFeaturesPage.getAddedCustomModifications(driver, customModificationsSize));

            log.info(testMethod + " - Step 35: Click to 'Save and Continue' button");
            sellDescriptionPage = sellFeaturesPage.clickToSaveAndContinueButton(driver);

            log.info(testMethod + " - Step 36: Add description = " + sellFeatures.getDescription());
            sellDescriptionPage.enterToDescriptionTextarea(driver, sellFeatures.getDescription());

            log.info(testMethod + " - Step 37: Click to 'Save and Continue button");
            sellReviewPage = sellDescriptionPage.clickToSaveAndContinueButton(driver);

            log.info(testMethod + " - Step 38: Verify review vehicle title = " + reviewVehicleTitle);
            Assertions.assertTrue(sellReviewPage.isReviewVehicleTitleDisplayed(driver, reviewVehicleTitle));

            log.info(testMethod + " - Step 38: Verify number of uploaded images = " + String.valueOf(numberOfUploadedImages));
            Assertions.assertEquals(numberOfUploadedImages, sellReviewPage.getNumberOfUploadedImages(driver));

            log.info(testMethod + " - Step 39: Click to 'View More Description' button");
            sellReviewPage.clickToViewMoreDescription(driver);

            log.info(testMethod + " - Step 40: Verify that description = '" + sellFeatures.getDescription() + "'");
            Assertions.assertEquals(sellFeatures.getDescription(), sellReviewPage.getFullOfReviewDescription(driver));

            log.info(testMethod + " - Step 41: Click to toggle 'Optional Extras' collapse");
            sellReviewPage.clickToOptionalExtrasCollapse(driver);

            log.info(testMethod + " - Step 42: Verify that checked optional extras = " + optionalExtrasText);
            Assertions.assertTrue(sellReviewPage.areCheckedOptionalExtrasDisplayed(driver, optionalExtrasText, optionalExtras));

            log.info(testMethod + " - Step 43: Click to toggle 'Custom Modifications' collapse");
            sellReviewPage.clickToCustomModificationsCollapse(driver);

            log.info(testMethod + " - Step 44: Verify that added custom modifications = " + customModificationsText);
            Assertions.assertTrue(sellReviewPage.areAddedCustomModificationsDisplayed(driver, customModificationsText, customModifications));
        }
    }

    @AfterAll
    public void tearDown() {
        closeBrowserAndKillProcess();
    }
}
