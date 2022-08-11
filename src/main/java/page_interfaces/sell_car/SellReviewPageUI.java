package page_interfaces.sell_car;

public interface SellReviewPageUI {
    String REVIEW_VEHICLE_TITLE_LABEL_H1 = "xpath=//h1[@class='review--vehicleTitle' and contains(text(), '%s')]";
    String UPLOADED_PHOTOS_STEP_INDICATOR_LABEL_P = "css=p.editSection--extraText";
    String VIEW_MORE_DESCRIPTION_BUTTON = "xpath=//p[contains(text(), 'View More')]//parent::div[@class='review--descriptionButton']";
    String REVIEW_DESCRIPTION_LABEL_P = "css=div.review--description>p";
    String OPTIONAL_EXTRAS_COLLAPSE = "xpath=//h3[contains(text(), 'Optional Extras')]//ancestor::div[contains(@class, 'v-collapse-toggler')]";
    String OPTIONAL_EXTRAS_COLLAPSE_LIST_ITEMS = "xpath=//h3[contains(text(), 'Optional Extras')]//parent::div//following-sibling::div//div[@class='tick']//p[text()='%s']";
    String CUSTOM_MODIFICATIONS_COLLAPSE = "xpath=//h3[contains(text(), 'Custom Modifications')]//ancestor::div[contains(@class, 'v-collapse-toggler')]";
    String CUSTOM_MODIFICATIONS_COLLAPSE_LIST_ITEMS = "xpath=//div[contains(@class, 'modificationCollapse--wrapper')]//li[@class='listFade-item' and contains(text(), '%s')]";
}
