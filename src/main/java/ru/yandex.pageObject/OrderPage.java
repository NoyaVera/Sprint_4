package ru.yandex.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class OrderPage {
    //Добавили поле driver
    private WebDriver driver;
    //Локатор страницы формы заказа
    private final By orderPage = By.xpath("/html/body/div");
    //Локатор поля Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Локатор поля Фамилия
    private final By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор поля Адрес
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор поля Метро
    private final By metroValue = By.className("select-search__input");
    //локатор разворачивающегося списка станций метро
    private final By metroChoice = By.xpath(".//input[@placeholder='* Станция метро']");
    //Локатор поля Телефон
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор кнопки Далее
    private final By nextButton = By.xpath("//button[text()='Далее']");

    //конструктор класса page object страницы формы заказа
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        }
        //метод проверяет отображение страницы формы заказа
    public void isOrderPageDisplayed(){
        driver.findElement(orderPage).isDisplayed();
    }
    // метод заполняет поле Имя
    public void setName (String name){
            driver.findElement(nameField).sendKeys(name);
        }
        // метод заполняет поле Фамилия
        public void setLastName (String lastname){
            driver.findElement(lastNameField).sendKeys(lastname);
        }
        // метод заполняет поле Адрес
        public void setAddress (String address){
            driver.findElement(addressField).sendKeys(address);
        }
        // метод для выбора станции метро
        public void checkMetro(String metro) {
            assertTrue(driver.findElement(metroChoice).isEnabled());
            driver.findElement(metroChoice).clear();
            driver.findElement(metroChoice).sendKeys(metro, Keys.ARROW_DOWN, Keys.ENTER);
        }
        // метод заполняет поле Телефон
        public void setPhoneNumber (String phoneNumber){
            driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        }
        // метод кликает по кнопке Далее
        public void clickNextButton () {
            driver.findElement(nextButton).click();
        }

}




