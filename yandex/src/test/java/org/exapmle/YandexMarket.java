package org.exapmle;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;


import java.util.*;


public class YandexMarket extends TestBase{

  @Test
  public void getInfo(){

    try {
      System.out.println("Запуск теста");

      app.driver.get("https://yandex.ru/");

      //Кликнуть на «Маркет»
      app.clickOnTheMarket();

      ArrayList<String> tabs = new ArrayList<String> (app.driver.getWindowHandles());
      app.driver.switchTo().window(tabs.get(1));

      //Ввести «ноутбуки»
      app.fillSearchField("ноутбуки");

      String vl = app.driver.findElement(By.xpath("//input[@id='header-search']")).getAttribute("value");

      Assertions.assertEquals("ноутбуки", vl);

      //Найти
      app.searchButton();

      //В поле Цена ввести значения 100000 – 200000
      app.fillPriceFiledBeforeAndAfter("Цена от","100000");
      app.fillPriceFiledBeforeAndAfter("Цена до","200000");

      //Выбрать производителей «Apple», «ASUS», «HP», «Xiaomi»
      app.clickOnCheckBoxByName("ASUS");
      app.clickOnCheckBoxByName("Apple");
      app.clickOnCheckBoxByName("HP");
      app.clickOnCheckBoxByName("Xiaomi");

      app.check("ASUS");
      app.check("Apple");
      app.check("HP");
      app.check("Xiaomi");

      //Выбрать процессор «Core i7»
      app.clickOnCheckBoxByName("Intel Core i7");

      app.check("Intel Core i7");

      //Очистить поле поиска
      app.clearSearchField();

      //Ввести «Зеленый слоник» и найти
      app.fillSearchField("Зеленый слоник");
      app.searchButton();

      //Поиск текста в заголовке товара
      //driver.findElements(By.xpath("//article//a[contains(@title, 'Худи')]")).forEach(x -> System.out.println(x.getAttribute("title")));
      app.searchForTextInTheTitleOfTheProduct("игрушка");

      System.out.println("Тест окончен");

    }
    catch (NoSuchElementException e) {
      System.out.println("Не найден элемент");
      e.printStackTrace();
    }
    catch (Exception e) {
      System.out.println("Упс, что-то пошло не так");
      e.printStackTrace();
    }


  }


}
