import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.pageObject.HomePage;
import ru.yandex.pageObject.OrderPage;
import ru.yandex.pageObject.RentPage;

import java.time.Duration;

// Класс с автотестом
@RunWith(Parameterized.class)
public class CheckOrderTest {
    private final String name;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String comment;
    private final String metro;
    private static String orderButton;

    //конструктор
    public CheckOrderTest (String name, String lastname, String address, String phoneNumber, String comment, String metro, String orderButton) {
        this.name = name;
        this.lastName = lastname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.metro = metro;
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters
    public static String[][] orderInfo() {
        return new String[][] {
                {"Наталья", "Ямова", "Галерная", "99999999999", "Привезите цветы", "Преображенская площадь", HomePage.headerOrderButton},
                {"Имя", "Фамилия", "Адрес", "99999999998", "Комментарий", "Библиотека имени Ленина", HomePage.homeFinishOrderButton}
        };
    }

    // Выбор браузера
    WebDriver driver = new ChromeDriver();
    // WebDriver driver = new FirefoxDriver();

    // Объект класса страницы HomePage
    HomePage objHomePage = new HomePage(driver);
    // Объект класса страницы формы заказа
    OrderPage objOrderPage = new OrderPage(driver);
    //Объект класса страницы с деталями заказа самоката
    RentPage objRentPage = new RentPage(driver);




    @Before
    public void beforeTestingSite() {
        //WebDriverManager.chromedriver().setup();
        // переход на страницу тестового приложения
        objHomePage.setTestingSite();
        //ожидание прогрузки страницы
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //метод для нажатия на кнопку Принять куки
        objHomePage.clickCookiesButton();
    }

    //тест для проверки заказа через кнопку Заказать в хедере стартовой страницы
    @Test
    public void scooterTest() {
        //метод для нажатия на кнопку Заказать в хедере стартовой страницы
        objHomePage.clickHeaderOrderButton(orderButton);
        //ожидание прогрузки страницы
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //метод проверяет отображение страницы формы заказа
        objOrderPage.isOrderPageDisplayed();
        //методы заполнения деталей заказа самоката
        objOrderPage.setName(name);
        objOrderPage.setLastName(lastName);
        objOrderPage.setAddress(address);
        objOrderPage.checkMetro(metro);
        objOrderPage.setPhoneNumber(phoneNumber);
        objOrderPage.clickNextButton();
        //методы заполнения деталей аренды самоката
        objRentPage.checkDate();
        objRentPage.checkRentDate();
        objRentPage.clickCheckBoxGrey();
        objRentPage.setComment(comment);
        objRentPage.clickOrderButton();
        //ожидание прогрузки страницы
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //метод кликает по кнопке ДА
        objRentPage.clickYesOrderButton();
        //метод ожидания прогрузки окна Заказ оформлен
        objRentPage.isOrderIsMadeWindowDisplayed();
    }


    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}