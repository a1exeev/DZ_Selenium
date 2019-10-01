import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class InsuranceTest extends GoogleDriverSetUp {

    @Test
    public void InsuranceTest() {

        //п.1
        String site = "http://www.rgs.ru/";
        driver.get(site);

        //п.2-3
        WebElement elementHealth = driver.findElementByXPath(
                "/html/body/div[4]/div/div[4]/a");
        elementHealth.click();

        WebDriverWait waitAfter1 = new WebDriverWait(driver, 7);
        waitAfter1.until(ExpectedConditions.elementToBeClickable(By.linkText(
                "Добровольное медицинское страхование (ДМС)")));

        WebElement elementDMS = driver.findElementByXPath(
                "/html/body/div[5]/div/div[1]/div[1]/div/a[1]");
        JavascriptExecutor executor = driver;
        executor.executeScript("arguments[0].click();", elementDMS);

        WebDriverWait waitAfter2 = new WebDriverWait(driver, 7);

        //п.4
        Assert.assertEquals("ДМС — добровольное медицинское страхование",
                driver.getTitle());

        //п.5
        WebElement elementSendRequest = driver.findElementByXPath(
                "//*[@id=\"rgs-main-context-bar\"]/div/div/div/div/a[3]");
        elementSendRequest.click();

        WebDriverWait waitAfter3 = new WebDriverWait(driver, 7);

        //п.6
        WebElement elementFreeInsurance = driver.findElementByXPath(
                "/html/body/div[9]/div/div/div/div[1]/h4/b");
        Assert.assertEquals("Заявка на добровольное медицинское страхование",
                elementFreeInsurance.getText());

        //п.7
        String surname = "//*[@id=\"applicationForm\"]/div[2]/div[1]/input";
        WebElement surnameToEnter = driver.findElementByXPath(surname);
        surnameToEnter.sendKeys("Фамилия");

        String name = "//*[@id=\"applicationForm\"]/div[2]/div[2]/input";
        WebElement nameToEnter = driver.findElementByXPath(name);
        nameToEnter.sendKeys("Имя");

        String patronymic = "//*[@id=\"applicationForm\"]/div[2]/div[3]/input";
        WebElement patronymicToEnter = driver.findElementByXPath(patronymic);
        patronymicToEnter.sendKeys("Отчество");

        String region = "//*[@id=\"applicationForm\"]/div[2]/div[4]/select";
        Select regionToSelect = new Select(driver.findElementByXPath(region));
        regionToSelect.selectByVisibleText("Выберите...");

        String phoneNumber = "//*[@id=\"applicationForm\"]/div[2]/div[5]/input";
        WebElement phoneNumberToEnter = driver.findElementByXPath(phoneNumber);
        phoneNumberToEnter.click();
        phoneNumberToEnter.clear();
        phoneNumberToEnter.sendKeys("8005553535");

        String eMail = "//*[@id=\"applicationForm\"]/div[2]/div[6]/input";
        WebElement eMailToEnter = driver.findElementByXPath(eMail);
        eMailToEnter.sendKeys("qwertyqwerty");

        String date = "//*[@id=\"applicationForm\"]/div[2]/div[7]/input";
        WebElement dateToEnter = driver.findElementByXPath(date);
        dateToEnter.sendKeys("20042020");

        String comments = "//*[@id=\"applicationForm\"]/div[2]/div[8]/textarea";
        WebElement commentsToEnter = driver.findElementByXPath(comments);
        commentsToEnter.sendKeys("Комментарии");

        String checkBox = "//*[@id=\"applicationForm\"]/div[2]/div[9]/label/input";
        WebElement checkBoxToFill = driver.findElementByXPath(checkBox);
        checkBoxToFill.click();

        String sendButton = "//*[@id=\"button-m\"]";
        WebElement sendButtonToPress = driver.findElementByXPath(sendButton);
        sendButtonToPress.click();

        Assert.assertEquals(surname, surnameToEnter.getText());
        Assert.assertEquals(name, nameToEnter.getText());
        Assert.assertEquals(patronymic, patronymicToEnter.getText());
        Assert.assertEquals(eMail, eMailToEnter.getText());
        Assert.assertEquals(comments, commentsToEnter.getText());

        WebDriverWait waitAfter4 = new WebDriverWait(driver, 7);

        String errorEMail = "//*[@id=\"applicationForm\"]/div[2]/div[6]/div/label/span";
        Assert.assertEquals("Введите адрес электронной почты",
                driver.findElementByXPath(errorEMail).getText());
    }
}