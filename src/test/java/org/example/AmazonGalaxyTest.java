package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AmazonGalaxyTest {
    @Test
    public void galaxySearchTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.85 Safari/537.36");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Galaxy");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]/descendant::button[.='Add to cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[normalize-space(text())='Cart'])[2]")).click();
        String Price = driver.findElement(By.xpath("(//form[@id='activeCartViewForm']//span[contains(@class,\"a-text-bold\")])[3]")).getText();
        System.out.println(Price);

        Thread.sleep(5000); // Let results load
        driver.quit();
        }
    }