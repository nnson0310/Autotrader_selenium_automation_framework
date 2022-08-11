package page_interfaces.sell_car;

public interface SelectACarPageUI {
    String DYNAMIC_INPUT_DROPDOWN = "xpath=//label[text()='%s']//following-sibling::input";
    String DYNAMIC_SELECT_ITEM = "xpath=//label[text()='%s']//parent::div//following-sibling::div[@class='select--dropdown']//li[normalize-space(text())='%s']";
    String CREATE_YOUR_FREE_AD_BUTTON = "css=div.desktopButtons button.selectCar--button";
}
