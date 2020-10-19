package org.exapmle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

  //����������� ������, ������������ �������������� ����� ������
  public WebDriver driver;
  public ProfilePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }


  //����������� �������� ���� ������������
  @FindBy(xpath = "//a[contains(@class, 'user-account_has-accent-letter')]/span[@class='user-account__name']")
  private WebElement userMenu;

  //����������� �������� ������ ������ �� ��������
  @FindBy(xpath = "//span[.='�����']")
  private WebElement logoutBtn;



  //����� ��� ��������� ����� ������������ �� ���� ������������
  public String getUserName() {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'user-account_has-accent-letter')]/span[@class='user-account__name']")));
    String userName = userMenu.getText();
    return userName;
  }

  //����� ��� ������� ������ ���� ������������
  public ProfilePage entryMenu() {
    userMenu.click();
    return this;
  }

  //����� ��� ������� ������ ������ �� ��������
  public ProfilePage userLogout() {
    logoutBtn.click();
    return this;
  }


}
