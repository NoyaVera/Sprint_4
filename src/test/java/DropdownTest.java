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
    // выбор браузера
    WebDriver driver = new ChromeDriver();
    // WebDriver driver = new FirefoxDriver();

    // Объект класса страницы HomePage
    HomePage objHomePage = new HomePage(driver);
    //Переменная для локатора вопросов
    private final String actualQuestion;
    //Переменная для локатора ответов
    private final String actualAnswer;
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
                {"accordion__heading-0", "accordion__panel-0", ANSWER0},
                {"accordion__heading-1", "accordion__panel-1", ANSWER1},
                {"accordion__heading-2", "accordion__panel-2", ANSWER2},
                {"accordion__heading-3", "accordion__panel-3", ANSWER3},
                {"accordion__heading-4", "accordion__panel-4", ANSWER4},
                {"accordion__heading-5", "accordion__panel-5", ANSWER5},
                {"accordion__heading-6", "accordion__panel-6", ANSWER6},
                {"accordion__heading-7", "accordion__panel-7", ANSWER7},
        };
    }

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
    public void QuestionsTest(){
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
