package org.naic.pages;

import org.naic.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

    @FindBy(id="cui-login")
    public WebElement loginBttn1;

    @FindBy(xpath = "//input[@id='INT_USERNAME']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='INT_PASSWORD']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='INT_LOGIN_BTN']")
    public WebElement loginBtn2;

    @FindBy(xpath = "//span[contains(.,'Login failed')]")
    public WebElement errorMessage;

}
