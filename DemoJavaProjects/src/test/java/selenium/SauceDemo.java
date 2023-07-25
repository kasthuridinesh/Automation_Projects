package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemo {

    @Test
    public void Login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(500);
        driver.findElement(By.id("login-button")).click();
        WebElement product_list = driver.findElement(By.id("react-burger-menu-btn"));
        product_list.getText();
        List<WebElement> all_product = driver.findElements(By.tagName("a"));
        all_product.get(1);
    }

}
