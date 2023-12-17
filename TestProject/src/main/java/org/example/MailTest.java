package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MailTest {
    @Test
    public void test() {
        String chromeDriverPath = "D:\\Programming\\7sem\\TestProject\\drivers\\chromedriver.exe";
        String chromeBinaryPath = "D:\\Programming\\7sem\\TestProject\\chrome-win64\\chrome.exe";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(chromeBinaryPath);
        chromeOptions.addArguments("--start-maximized");

        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://account.mail.ru/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assertions.assertEquals(driver.findElement(By.xpath("//input[@name='username']")), driver.switchTo().activeElement());
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("testich201");
        driver.findElement(By.xpath("//*[@class='inner-0-2-89 innerTextWrapper-0-2-90']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("toptester123");
        driver.findElement(By.xpath("//*[@class='inner-0-2-89 innerTextWrapper-0-2-90']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@class='ph-project ph-project__account svelte-1osmzf1']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assertions.assertEquals("Test Testich", driver.findElement(By.xpath("//*[@aria-label='Test Testich']")).getText());
        driver.findElement(By.xpath("//*[@data-click-counter='75068944']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_outlined-themed resplash-btn_mailbox-big ihfknge-de8k2m']")).isDisplayed();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        driver.quit();
    }
}