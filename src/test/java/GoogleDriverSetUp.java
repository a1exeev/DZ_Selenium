import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoogleDriverSetUp {
    public ChromeDriver driver;

    @Before
    public void driverSetUp() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String filePath = reader.readLine();
            System.setProperty("webdriver.chrome.driver", filePath);
            driver = new ChromeDriver();
        } catch (FileNotFoundException fnf) {
            System.out.println(
                    "Ошибка! Файл по указанному адресу не найден. Повторите запрос.");
        } catch (IOException ioe) {
            System.out.println("Ошибка: ");
            ioe.printStackTrace();
        }
    }

    @After
    public void driverClose() {
        driver.quit();
    }
}