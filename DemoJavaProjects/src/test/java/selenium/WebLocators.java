package selenium;

import org.asynchttpclient.webdav.WebDavResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebLocators {

    public static void main (String[]args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://developer.salesforce.com/signup");
        WebElement firstname = driver.findElement(By.name("first_name"));
        System.out.println("before passing value");
        firstname.sendKeys("kasthuri");
        System.out.println("After passing value");


    }
}
