package ru.yandex.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Создали page object — класс страницы Про аренду
public class RentPage {
    private final WebDriver driver;
    //Локатор поля Дата
    private final By datePicker = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    //Локатор открывающегося поля с месяцем даты
    private final By monthDatePicker = By.xpath(".//button[@aria-label='Next Month']");
    //Локатор выбора даты
    private final By myDatePicker = By.xpath(".//div[contains(@aria-label,'Choose')]");
    //Локатор поля с выбором дней аренды
    private final By fieldDate = By.className("Dropdown-placeholder");
    //Локатор выбора срока аренды - двое суток
    private final By rentMenu = By.xpath(".//div[contains(text(), 'двое суток')]");
    //Локатор чек-бокса Серый
    private final By checkBoxGrey = By.xpath("//*[@id='grey']");
    //Локатор чек-бокса Черный
    private final By checkBoxBlack = By.xpath("//*[@id='black']");
    //Локатор поля Комментарий курьеру
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Локатор кнопки Заказать
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор кнопки Да
    private final By yesOrderButton = By.xpath(".//button[contains(text(),'Да')]");
    //Локатор окна Заказ оформлен
    private final By orderMadeWindow = By.xpath(".//div[contains(text(),'Заказ оформлен')]");

    //конструктор класса page object
    public RentPage(WebDriver driver) {
        this.driver = driver;
    }
    //Метод выбора даты аренды
    public void checkDate() {
        driver.findElement(datePicker).click();
        driver.findElement(monthDatePicker).isDisplayed();
        driver.findElement(myDatePicker).click();
    }
    //Метод выбора срока аренды
    public void checkRentDate() {
        driver.findElement(fieldDate).click();
        driver.findElement(rentMenu).click();
    }
    //Метод выбора цвета Серый
    public void clickCheckBoxGrey() {
        driver.findElement(checkBoxGrey).click();
    }
    //Метод выбора цвета Черный
    public void clickCheckBoxBlack() {
        driver.findElement(checkBoxBlack).click();
        //Метод заполнения поля Комментарий
    }
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    //Метод нажатия на кнопку Заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    //метод нажатия кнопки ДА
    public void clickYesOrderButton() {
            driver.findElement(yesOrderButton).click();
        }
        //метод проверяет, что окно Заказ оформлен открылось
    public void isOrderIsMadeWindowDisplayed() {
            driver.findElement(orderMadeWindow).isDisplayed();
        }
    }



