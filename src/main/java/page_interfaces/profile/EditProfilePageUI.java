package page_interfaces.profile;

public interface EditProfilePageUI {
    String FIRST_NAME_TEXTBOX = "css=div.form--sectionOne input[name='first_name']";
    String LAST_NAME_TEXTBOX = "css=div.form--sectionOne input[name='last_name']";
    String SAVE_BUTTON = "css=button.save--button";
    String SAVE_CHANGES_MODAL_BUTTON = "xpath=//div[@class='modal']//div[contains(text(), 'Save changes')]";
    String CHANGE_SUCCESS_NOTIFICATION_LABEL_DIV = "xpath=//div[contains(@class, 'success')]//p[contains(., '%s')]";
}
