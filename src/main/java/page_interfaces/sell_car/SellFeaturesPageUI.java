package page_interfaces.sell_car;

public interface SellFeaturesPageUI {
    String OPTIONAL_EXTRAS_COLLAPSE = "xpath=//h3[contains(text(), 'Optional Extras')]//ancestor::div[@class='vc-collapse']";
    String CUSTOM_MODIFICATIONS_COLLAPSE = "xpath=//h3[contains(text(), 'Custom Modifications')]//ancestor::div[@class='vc-collapse']";
    String OPTIONAL_EXTRAS_RADIO_BUTTON = "xpath=//p[text()='%s']//preceding-sibling::div[@class='input--radioDisplay']";
    String CUSTOM_MODIFICATIONS_TEXTBOX = "css=div.modificationCollapse--input input";
    String ADD_CUSTOM_MODIFICATIONS_BUTTON = "css=div.modificationCollapse--inputButton";
    String SAVE_AND_CONTINUE_BUTTON = "css=div.sellACar--footerContainer button";
    String OPTIONAL_EXTRAS_STEP_INDICATOR_LABEL_P = "xpath=//h3[contains(text(), 'Optional Extras')]//following-sibling::p[@class='collapse--headerStepIndicator']";
    String CUSTOM_MODIFICATIONS_STEP_INDICATOR_LABEL_P = "xpath=//h3[contains(text(), 'Custom Modifications')]//following-sibling::p[@class='modificationCollapse--headerStepIndicator']";
}
