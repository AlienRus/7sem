package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HabrTest {
    @Test
    public void test() {
        String chromeDriverPath = "D:\\Programming\\7sem\\TestProject\\drivers\\chromedriver.exe";
        String chromeBinaryPath = "D:\\Programming\\7sem\\TestProject\\chrome-win64\\chrome.exe";

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(chromeBinaryPath);
        chromeOptions.addArguments("--start-maximized");

        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);

        JavascriptExecutor js = ((JavascriptExecutor) driver);

        driver.get("https://habr.com/ru/all");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@class='tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_search tm-header-user-menu__icon_dark']")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//input[@name='q']")), driver.switchTo().activeElement());
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium WebDriver");
        driver.findElement(By.xpath("//*[@class='tm-svg-img tm-svg-icon']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Что такое Selenium?")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assertions.assertEquals("28 сен 2012 в 16:14", driver.findElement(By.xpath("//*[@title='2012-09-28, 16:14']")).getText());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[@href='/ru/articles/' and @class='footer-menu__item-link router-link-active']")).click();

        driver.quit();
    }
}