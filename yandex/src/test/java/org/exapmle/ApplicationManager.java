package org.exapmle;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class ApplicationManager {
  public WebDriver driver;

  protected void init() {
    System.setProperty("webdriver.chrome.driver", "D:/GitProject/Java_other/yandex/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  protected void stop() {
    driver.quit();
  }

  protected void clickOnCheckBoxByName(String name){
    driver.findElement(By.xpath("//span[.='"+ name +"']/ancestor::label")).click();
  }

  protected void fillPriceFiledBeforeAndAfter(String name, String price){
    driver.findElement(By.xpath("//input[@name='" + name + "']")).sendKeys(price);
  }

  protected void fillSearchField(String name){
    driver.findElement(By.xpath("//input[@id='header-search']")).sendKeys(name);
  }

  protected void searchForTextInTheTitleOfTheProduct(String text) {
    driver.findElement(By.xpath("//article//a[contains(@title, " + text + ")]")).click();
  }

  protected void searchButton() {
    driver.findElement(By.xpath("//button[@type='submit' and div[.='Найти']]")).click();
  }

  protected void clickOnTheMarket() {
    driver.findElement(By.xpath("//a[@data-id='market']")).click();
  }

  protected void clearSearchField() {
    driver.findElement(By.xpath("//input[@id='header-search']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
  }

  protected void check(String name) {
    boolean isSelected = driver.findElement(By.xpath("//span[.='"+ name +"']/ancestor::label/input")).isSelected();
    Assertions
        .assertThat(isSelected)
        .withFailMessage("Чекбокс с названием \"" + name + "\" не выбран!!!")
        .isTrue();
  }

}
