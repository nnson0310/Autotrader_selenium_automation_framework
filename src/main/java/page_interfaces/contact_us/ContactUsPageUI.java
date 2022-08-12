package page_interfaces.contact_us;

public interface ContactUsPageUI {
    String ENQUIRY_TYPE_DROPDOWN = "css=select#field-messageType";
    String MESSAGE_TEXTAREA = "css=textarea#field--message";
    String SUBMIT_QUESTION_BUTTON = "css=div.field--submit button";
    String ENQUIRY_SUBMIT_SUCCESS_NOTIFICATION = "xpath=//div[contains(@class, 'success')]//p[contains(text(), '%s')]";
}
