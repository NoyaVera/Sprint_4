import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.pageObject.HomePage;

import java.time.Duration;

import static ru.yandex.pageObject.Constans.*;

// Класс с автотестом
@RunWith(Parameterized.class)
public class DropdownTest {
    //Переменная для локатора вопросов
    private static String actualQuestion;
    //Переменная для локатора ответов
    private static String actualAnswer;
    //Переменная для ожидаемого текста
    private final String expectedText;

    //Конструктор класса
    public DropdownTest(String actualQuestion, String actualAnswer, String expectedText) {
        this.actualQuestion = actualQuestion;
        this.actualAnswer = actualAnswer;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getResult() {
        return new Object[][] {
                {HomePage.actualQuestion0, HomePage.actualAnswer0, ANSWER0},
                {HomePage.actualQuestion1, HomePage.actualAnswer1, ANSWER1},
                {HomePage.actualQuestion2, HomePage.actualAnswer2, ANSWER2},
                {HomePage.actualQuestion3, HomePage.actualAnswer3, ANSWER3},
                {HomePage.actualQuestion4, HomePage.actualAnswer4, ANSWER4},
                {HomePage.actualQuestion5, HomePage.actualAnswer5, ANSWER5},
                {HomePage.actualQuestion6, HomePage.actualAnswer6, ANSWER6},
                {HomePage.actualQuestion7, HomePage.actualAnswer7, ANSWER7},
        };
    }

    // выбор браузера
    WebDriver driver = new ChromeDriver();
    //WebDriver driver = new FirefoxDriver();

    // Объект класса страницы HomePage
    HomePage objHomePage = new HomePage(driver);

    @Before
    public void beforeTestingSite() {
        // переход на страницу тестового приложения
        objHomePage.setTestingSite();
        //ожидание прогрузки страницы
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //метод для нажатия на кнопку Принять куки
        objHomePage.clickCookiesButton();
        //проскроллить до конца страницы
        objHomePage.scrollImportantQuestions();

    }

    @Test
    public void questionsTest(){
        driver.findElement(By.id(actualQuestion)).click();
        String actualAnswerText = driver.findElement(By.id(actualAnswer)).getText();
        Assert.assertEquals(expectedText, actualAnswerText);
    }
    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
