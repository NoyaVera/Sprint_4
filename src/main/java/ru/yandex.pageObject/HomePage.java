package ru.yandex.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final String testingSite = "https://qa-scooter.praktikum-services.ru/";
    //Добавили поле driver
    private WebDriver driver;
    //Локатор кнопки Заказать в хедере стартовой страницы
    private final By headerOrderButton = By.className("Button_Button__ra12g");
    //Локатор кнопки Заказать внизу стартовой страницы
    private final By homeFinishOrderButton = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");
    //Локатор кнопки Принять куки
    private final By cookiesButton = By.id("rcc-confirm-button");

    //локаторы раздела страницы "Вопросы о важном"
    private final By importantQuestions = By.className("accordion");


    //конструктор класса page object
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //метод для перехода на тестируемый сайт
    public void setTestingSite(){
        driver.get(testingSite);
    }

    //метод для нажатия на кнопку Принять куки
    public void clickCookiesButton () {
        driver.findElement(cookiesButton).click();
    }
    //метод для нажатия на кнопку Заказать в хедере стартовой страницы
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
    //метод для нажатия на кнопку Заказать внизу стартовой страницы
    public void clickHomeFinishOrderButton () {
        driver.findElement(homeFinishOrderButton).click();
    }
    //метод скролла страницы до раздела "Вопросы о важном"
    public void scrollImportantQuestions () {
        WebElement accordion = driver.findElement(importantQuestions);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", accordion);
        }
}

