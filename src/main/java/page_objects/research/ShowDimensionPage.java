package page_objects.research;

import io.qameta.allure.Step;
import json_data.CarDimension;
import org.openqa.selenium.WebDriver;
import page_interfaces.research.ShowDimensionPageUI;
import page_objects.CommonPage;

import java.util.List;

public class ShowDimensionPage extends CommonPage {
    WebDriver driver;

    public ShowDimensionPage (WebDriver driver) {
        this.driver = driver;
    }

    @Step("Verify that dimension title = {1}")
    public boolean isDimensionTitleDisplayed(WebDriver driver, String dimensionTitle) {
        waitForElementVisible(driver, ShowDimensionPageUI.DIMENSION_TITLE_LABEL_H1, dimensionTitle);
        return isElementDisplayed(driver, ShowDimensionPageUI.DIMENSION_TITLE_LABEL_H1, dimensionTitle);
    }

    @Step("Verify that for_sale button title = {1}")
    public boolean isForSaleButtonTitleDisplayed(WebDriver driver, String buttonTitle) {
        waitForElementVisible(driver, ShowDimensionPageUI.FOR_SALE_BUTTON, buttonTitle);
        return isElementDisplayed(driver, ShowDimensionPageUI.FOR_SALE_BUTTON, buttonTitle);
    }

    @Step("Get number of dimension results")
    public int getNumberOfDimensionResults(WebDriver driver) {
        waitForAllElementVisible(driver, ShowDimensionPageUI.DIMENSION_RESULT_TABLE_ROW);
        return getElementSize(driver, ShowDimensionPageUI.DIMENSION_RESULT_TABLE_ROW);
    }

    @Step("Verify that all dimension results are displayed correctly")
    public boolean areDimensionResultsDisplayed(WebDriver driver, List<CarDimension.DimensionResults> dimensionResults) {
        boolean result = true;
        for(CarDimension.DimensionResults dimensionResult: dimensionResults) {
            result = isElementDisplayed(
                    driver,
                    ShowDimensionPageUI.DIMENSION_RESULT_TABLE_DATA,
                    dimensionResult.getVariant(),
                    dimensionResult.getHxwxl(),
                    dimensionResult.getKerbWeight()
            );
        }
        return result;
    }
}
