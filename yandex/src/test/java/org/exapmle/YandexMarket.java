package org.exapmle;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;


import java.util.*;


public class YandexMarket extends TestBase{

  @Test
  public void getInfo(){

    try {
      System.out.println("������ �����");

      app.driver.get("https://yandex.ru/");

      //�������� �� �������
      app.clickOnTheMarket();

      ArrayList<String> tabs = new ArrayList<String> (app.driver.getWindowHandles());
      app.driver.switchTo().window(tabs.get(1));

      //������ ���������
      app.fillSearchField("��������");

      String vl = app.driver.findElement(By.xpath("//input[@id='header-search']")).getAttribute("value");

      Assertions.assertEquals("��������", vl);

      //�����
      app.searchButton();

      //� ���� ���� ������ �������� 100000 � 200000
      app.fillPriceFiledBeforeAndAfter("���� ��","100000");
      app.fillPriceFiledBeforeAndAfter("���� ��","200000");

      //������� �������������� �Apple�, �ASUS�, �HP�, �Xiaomi�
      app.clickOnCheckBoxByName("ASUS");
      app.clickOnCheckBoxByName("Apple");
      app.clickOnCheckBoxByName("HP");
      app.clickOnCheckBoxByName("Xiaomi");

      app.check("ASUS");
      app.check("Apple");
      app.check("HP");
      app.check("Xiaomi");

      //������� ��������� �Core i7�
      app.clickOnCheckBoxByName("Intel Core i7");

      app.check("Intel Core i7");

      //�������� ���� ������
      app.clearSearchField();

      //������ �������� ������ � �����
      app.fillSearchField("������� ������");
      app.searchButton();

      //����� ������ � ��������� ������
      //driver.findElements(By.xpath("//article//a[contains(@title, '����')]")).forEach(x -> System.out.println(x.getAttribute("title")));
      app.searchForTextInTheTitleOfTheProduct("�������");

      System.out.println("���� �������");

    }
    catch (NoSuchElementException e) {
      System.out.println("�� ������ �������");
      e.printStackTrace();
    }
    catch (Exception e) {
      System.out.println("���, ���-�� ����� �� ���");
      e.printStackTrace();
    }


  }


}
