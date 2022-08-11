package page_interfaces.sell_car;

public interface SellDetailsPageUI {
    String VEHICLE_CONTENT_LABEL_DIV = "xpath=//div[@class='vehicle--content']//p[text()='%s']";
    String CAR_TRANSMISSION_LABEL_SPAN = "css=div.cardGrid--lineItem.transmission span";
    String CAR_YEAR_LABEL_SPAN = "css=div.cardGrid--lineItem.year span";
    String CAR_BODY_TYPE_LABEL_SPAN = "css=div.cardGrid--lineItem.body span";
    String CAR_FUEL_TYPE_LABEL_SPAN = "css=div.cardGrid--lineItem.engine span";
    String PICKUP_LOCATION_TEXTBOX = "css=div[name='pickup_location'] input";
    String PICKUP_LOCATION_SELECT_ITEM = "xpath=//div[@name='pickup_location']//following-sibling::div[@class='select--dropdown']//li[normalize-space(text())='%s']";
    String REGISTRATION_EXPIRED_RADIO = "xpath=//div[@id='rego_exp']//div[contains(.,'%s')]//div[@class='input--radioDisplay']";
    String COME_WITH_LOGBOOK_RADIO = "xpath=//div[@id='logbook']//div[contains(.,'%s')]//div[@class='input--radioDisplay']";
    String SET_OF_KEYS_SELECT_DROPDOWN = "xpath=//div[@name='keys']";
    String SET_OF_KEYS_SELECT_ITEM = "xpath=//div[@name='keys']//following-sibling::div//li[normalize-space(text())='%s']";
    String EXPIRY_MONTH_SELECT_DROPDOWN = "xpath=//div[@name='rego_exp_month']";
    String EXPIRY_MONTH_SELECT_ITEM = "xpath=//div[@name='rego_exp_month']//following-sibling::div//li[contains(text(), '%s')]";
    String EXPIRY_YEAR_SELECT_DROPDOWN = "xpath=//div[@name='rego_exp_year']";
    String EXPIRY_YEAR_SELECT_ITEM = "xpath=//div[@name='rego_exp_year']//following-sibling::div//li[contains(text(), '%s')]";
    String SAVE_AND_CONTINUE_BUTTON = "css=div.sellACar--footerContainer button";
}
