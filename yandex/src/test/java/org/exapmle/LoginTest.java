package org.exapmle;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LoginTest {

  public static LoginPage loginPage;
  public static ProfilePage profilePage;
  public static WebDriver driver;

  @BeforeAll
  public static void setup() {
    //����������� ���� �� �������� � ��� ���������
    System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

    driver = new ChromeDriver();
    loginPage = new LoginPage(driver);
    profilePage = new ProfilePage(driver);

    //���� ��������������� �� ������ �����
    driver.manage().window().maximize();
    //�������� �� ���������� ����� = 10 ���.
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //��������� ������ �� �������� ����� �� ����� ��������
    driver.get(ConfProperties.getProperty("loginpage"));
  }


  @Test
  public void loginTest() {
    //��������� ������� � ������� ������ LoginPage ��� �������������� � ���������� ��������
    //�������� login/password ������� �� ����� �������� �� �������� � chromedriver
    //� loginpage
    //������ �����
    loginPage.inputLogin(ConfProperties.getProperty("login"))
    //�������� ������ �����
    .clickLoginBtn()
    //������ ������
    .inputPasswd(ConfProperties.getProperty("password"))
    //�������� ������ �����
    .clickLoginBtn();
    //�������� ������������ �����
    String user = profilePage.getUserName();
    //� ���������� ��� � ������� �� ����� ��������
    Assertions.assertEquals(ConfProperties.getProperty("name"), user);
  }


  @AfterAll
  public static void tearDown() {
    profilePage.entryMenu()
    .userLogout();
    driver.quit();
  }
}