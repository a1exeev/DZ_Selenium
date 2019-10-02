import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class InsuranceTest extends GoogleDriverSetUp {

    @Test
    public void InsuranceTest() {

        String site = "http://www.rgs.ru/";
        driver.get(site);

        findAndClick("/html/body/div[4]/div/div[4]/a");

        WebDriverWait wait0 = new WebDriverWait(driver, 7);
        wait0.until(ExpectedConditions.elementToBeClickable(By.linkText(
                "Добровольное медицинское страхование (ДМС)")));
        WebElement elementDMS = driver.findElementByXPath(
                "/html/body/div[5]/div/div[1]/div[1]/div/a[1]");
        JavascriptExecutor executor = driver;
        executor.executeScript("arguments[0].click();", elementDMS);

        String dmsTitle =
                "ДМС 2019 | Рассчитать стоимость добровольного медицинского страхования и оформить ДМС в Росгосстрах";
        Assert.assertEquals(dmsTitle,
                driver.getTitle());

        findAndClick("/html/body/div[8]/div/div/div/div/a[3]");

        WebDriverWait wait2 = new WebDriverWait(driver, 7);

        String surnameToPrint = "Фамилия";
        findAndFill("//*[@id=\"applicationForm\"]/div[2]/div[1]/input", surnameToPrint);

        WebDriverWait wait4 = new WebDriverWait(driver, 3);

        String nameToPrint = "Имя";
        findAndFill("//*[@id=\"applicationForm\"]/div[2]/div[2]/input", nameToPrint);

        WebDriverWait wait5 = new WebDriverWait(driver, 3);

        String patronymictoPrint = "Отчество";
        findAndFill("//*[@id=\"applicationForm\"]/div[2]/div[3]/input", patronymictoPrint);

        WebDriverWait wait6 = new WebDriverWait(driver, 3);

        String phoneNumberToPrint = "8005553535";
        findAndFill("//*[@id=\"applicationForm\"]/div[2]/div[5]/input", phoneNumberToPrint);

        WebDriverWait wait7 = new WebDriverWait(driver, 3);

        String eMailToPrint = "qwertyqwerty";
        findAndFill("/html/body/div[9]/div/div/div/div[2]/div[2]/form/div[2]/div[6]/input", eMailToPrint);

        WebDriverWait wait8 = new WebDriverWait(driver, 3);

        String commentsToPrint = "Комментарии";
        findAndFill("/html/body/div[9]/div/div/div/div[2]/div[2]/form/div[2]/div[8]/textarea", commentsToPrint);

        WebDriverWait wait9 = new WebDriverWait(driver, 3);

        findAndClick("/html/body/div[9]/div/div/div/div[2]/div[2]/form/div[2]/div[9]/label/input");

        WebDriverWait wait10 = new WebDriverWait(driver, 3);

        String dateToPrint = "12.12.2019";
        findAndFill("/html/body/div[9]/div/div/div/div[2]/div[2]/form/div[2]/div[7]/input", dateToPrint);

        WebDriverWait wait11 = new WebDriverWait(driver, 3);

        findAndClick("/html/body/div[9]/div/div/div/div[2]/div[2]/form/div[2]/div[10]/div/button");

        WebDriverWait wait12 = new WebDriverWait(driver, 3);

        Assert.assertEquals(surnameToPrint, driver.findElementByXPath("//*[@id=\"applicationForm\"]/div[2]/div[1]/input").getAttribute("inner text"));
        Assert.assertEquals(nameToPrint, driver.findElementByXPath("//*[@id=\"applicationForm\"]/div[2]/div[2]/input").getAttribute("inner text"));
        Assert.assertEquals(patronymictoPrint, driver.findElementByXPath("//*[@id=\"applicationForm\"]/div[2]/div[3]/input").getAttribute("inner text"));
        Assert.assertEquals(eMailToPrint, driver.findElementByXPath("/html/body/div[9]/div/div/div/div[2]/div[2]/form/div[2]/div[6]/input").getAttribute("inner text"));
        Assert.assertEquals(commentsToPrint, driver.findElementByXPath("/html/body/div[9]/div/div/div/div[2]/div[2]/form/div[2]/div[8]/textarea").getAttribute("inner text"));

        String error = "//*[@id=\"applicationForm\"]/div[2]/div[6]/div/label/span";
        Assert.assertEquals("Введите адрес электронной почты",
                driver.findElementByXPath(error).getAttribute("inner text"));
    }

    public WebElement findAndClick(String xpath){
        WebElement element = driver.findElementByXPath(xpath);
        element.click();
        return element;
    }

    public WebElement findAndFill(String xpath, String content){
        WebElement element = driver.findElementByXPath(xpath);
        element.sendKeys(content);
        return element;
    }
}