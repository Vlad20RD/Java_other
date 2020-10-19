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
    //определение пути до драйвера и его настройка
    System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

    driver = new ChromeDriver();
    loginPage = new LoginPage(driver);
    profilePage = new ProfilePage(driver);

    //окно разворачивается на полный экран
    driver.manage().window().maximize();
    //задержка на выполнение теста = 10 сек.
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //получение ссылки на страницу входа из файла настроек
    driver.get(ConfProperties.getProperty("loginpage"));
  }


  @Test
  public void loginTest() {
    //получение доступа к методам класса LoginPage для взаимодействия с элементами страницы
    //значение login/password берутся из файла настроек по аналогии с chromedriver
    //и loginpage
    //вводим логин
    loginPage.inputLogin(ConfProperties.getProperty("login"))
    //нажимаем кнопку входа
    .clickLoginBtn()
    //вводим пароль
    .inputPasswd(ConfProperties.getProperty("password"))
    //нажимаем кнопку входа
    .clickLoginBtn();
    //получаем отображаемый логин
    String user = profilePage.getUserName();
    //и сравниваем его с логином из файла настроек
    Assertions.assertEquals(ConfProperties.getProperty("name"), user);
  }


  @AfterAll
  public static void tearDown() {
    profilePage.entryMenu()
    .userLogout();
    driver.quit();
  }
}