package org.exapmle;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

  public WebDriver driver;
  public LoginPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }


  //определение локатора поля ввода логина
  @FindBy(xpath = "//input[@name='login']")
  private WebElement loginField;

  //определение локатора кнопки входа в аккаунт
  @FindBy(xpath = "//span[.='Войти']/ancestor::button")
  private WebElement loginBtn;

  //определение локатора поля ввода пароля
  @FindBy(xpath = "//input[@name='passwd']")
  private WebElement passwdField;



  public LoginPage inputLogin(String login) {
    loginField.sendKeys(login);
    return this;
  }

  public LoginPage inputPasswd(String passwd) {
    passwdField.sendKeys(passwd);
    return this;
  }

  public LoginPage clickLoginBtn() {
    loginBtn.click();
    return this;
  }
}

