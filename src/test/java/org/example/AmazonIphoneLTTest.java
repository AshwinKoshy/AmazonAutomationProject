package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AmazonIphoneLTTest {
    public static final String USERNAME = "engineeringtestsigma";
    public static final String ACCESS_KEY = "XK6ARxr0FsuYM7Uur0FdNVMMRRTrG7VGMWiEwLE5ASBSN8gqOO";
    public static final String GRID_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub.lambdatest.com/wd/hub";

    @Test
    public void galaxySearchTest() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("build", "Amazon Galaxy Test Build");
        capabilities.setCapability("name", "Galaxy Product Cart Price Test");
        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("video", true);
        capabilities.setCapability("console", true);

        WebDriver driver = new RemoteWebDriver(new URL(GRID_URL), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.in");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone");
        driver.findElement(By.id("nav-search-submit-button")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]/descendant::button[.='Add to cart']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[normalize-space(text())='Cart'])[2]")).click();

        String price = driver.findElement(By.xpath("(//form[@id='activeCartViewForm']//span[contains(@class,'a-text-bold')])[3]")).getText();
        System.out.println("Product Price: " + price);

        driver.quit();
    }
}
