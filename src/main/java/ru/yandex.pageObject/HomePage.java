package ru.yandex.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ru.yandex.pageObject.Constans.*;
import static ru.yandex.pageObject.Constans.ANSWER7;

public class HomePage {
    private WebDriver driver;
    private final String testingSite = "https://qa-scooter.praktikum-services.ru/";

    public static String actualQuestion0 = "accordion__heading-0";
    public static String actualQuestion1 = "accordion__heading-1";
    public static String actualQuestion2 = "accordion__heading-2";
    public static String actualQuestion3 = "accordion__heading-3";
    public static String actualQuestion4 = "accordion__heading-4";
    public static String actualQuestion5 = "accordion__heading-5";
    public static String actualQuestion6 = "accordion__heading-6";
    public static String actualQuestion7 = "accordion__heading-7";
    public static String actualAnswer0 = "accordion__panel-0";
    public static String actualAnswer1 = "accordion__panel-1";
    public static String actualAnswer2 = "accordion__panel-2";
    public static String actualAnswer3 = "accordion__panel-3";
    public static String actualAnswer4 = "accordion__panel-4";
    public static String actualAnswer5 = "accordion__panel-5";
    public static String actualAnswer6 = "accordion__panel-6";
    public static String actualAnswer7 = "accordion__panel-7";

    //Локатор кнопки Заказать в хедере стартовой страницы
    public static String headerOrderButton = "//*[@id='root']/div/div/div[1]/div[2]/button[1]";

    //Локатор кнопки Заказать внизу стартовой страницы
    public static String homeFinishOrderButton = "//*[@id='root']/div/div/div[4]/div[2]/div[5]/button";

    //Локатор кнопки Принять куки
    private final By cookiesButton = By.id("rcc-confirm-button");

    //локаторы раздела страницы "Вопросы о важном"
    private final By importantQuestions = By.className("accordion");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //метод для перехода на тестируемый сайт
    public void setTestingSite() {
        driver.get(testingSite);
    }

    //метод для нажатия на кнопку Принять куки
    public void clickCookiesButton() {
        driver.findElement(cookiesButton).click();
    }

    //метод для нажатия на кнопку Заказать в хедере стартовой страницы
    public void clickHeaderOrderButton(String orderLocator) {
        By orderButton = By.xpath(orderLocator);
        driver.findElement(orderButton).click();
    }

    //метод скролла страницы до раздела "Вопросы о важном"
    public void scrollImportantQuestions() {
        WebElement accordion = driver.findElement(importantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", accordion);
    }
}

