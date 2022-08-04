package page_interfaces;

public interface HomePageUI {
    String HEADER_LOGIN_BUTTON = "css=ul.header--navList-user div[data-cy='header-login-btn']";
    String AUTH_LOCK_SIGNUP_TAB = "xpath=//div[@class='auth0-lock-form']//a[text()='Sign Up']";
    String EMAIL_TEXTBOX = "css=input[name='email']";
    String PASSWORD_TEXTBOX = "css=input[name='password']";
    String FIRST_NAME_TEXTBOX = "css=input[name='first_name']";
    String LAST_NAME_TEXTBOX = "css=input[name='last_name']";
    String SIGNUP_BUTTON = "css=button[aria-label='Sign Up']";
    String USERNAME_HEADER_LABEL_DIV = "xpath=//ul[contains(@class, 'header--navList')]//div[@class='userName' and contains(text(), '%s')]";
}
