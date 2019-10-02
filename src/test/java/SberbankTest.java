import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SberbankTest extends GoogleDriverSetUp {

    @Test
    public void SberbankTest() {

        //п.1
        String site = "http://www.sberbank.ru/ru/person";
        driver.get(site);

        //п.2
        WebDriverWait waitAfter1 = new WebDriverWait(driver, 7);
        waitAfter1.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//*[@id=\"main\"]/div[1]/div/div/div[4]/header/div/div/div/div[2]/div[3]/div/div/a/div/span")));

        WebDriverWait wait1 = new WebDriverWait(driver, 7);

        //выбор региона
        findAndClick("//*[@id=\"main\"]/div[1]/div/div/div[4]/header/div/div/div/div[2]/div[3]/div/div/a/div/span");
        findAndClick("/html/body/div[7]/div/div/div/div/div/div/div/div[3]/div[2]/a[17]");

        WebDriverWait wait2 = new WebDriverWait(driver, 7);

        //
        String regionToChoose = "Нижегородская область";
        WebElement regionToCompare = driver.findElementByXPath(
                "//*[@id=\"main\"]/div[1]/div/div/div[4]/header/div/div/div/div[2]/div[3]/div/div/a/div/span");
        Assert.assertEquals(regionToChoose, regionToCompare.getText());

        WebElement footer = driver.findElementByXPath("/html/body/div[1]/div[4]/div/div/div");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
        WebDriverWait wait3 = new WebDriverWait(driver, 7);

        WebElement socMediaIcons = driver.findElementByXPath(
                "/html/body/div[1]/div[4]/div/div/div/div[3]/footer/div/div[2]/div[3]/ul");
        if (!socMediaIcons.isDisplayed()) Assert.fail("Иконок соц. сетец не обнаружено!");


    }

    public WebElement findAndClick(String xpath){
        WebElement element = driver.findElementByXPath(xpath);
        element.click();
        return element;
    }
}
