package com.Amazontest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Amazon_testbrowser {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        String hubURL = "http://localhost:4444/wd/hub";
        String[] browsers = {"chrome", "firefox", "MicrosoftEdge"};

        for (String browser : browsers) {
            System.out.println("Running on: " + browser);
            
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.LINUX);

            WebDriver driver = new RemoteWebDriver(new URL(hubURL), capabilities);

            try {
                driver.get("https://www.amazon.com");
                System.out.println("Page Title: " + driver.getTitle());

                WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
                searchBox.sendKeys("Laptop");
                searchBox.submit();

                Thread.sleep(5000);

                System.out.println("Search completed on " + browser);
            } catch (Exception e) {
                System.out.println("Error on " + browser + ": " + e.getMessage());
            } finally {
                driver.quit();
            }
        }
    }
}

