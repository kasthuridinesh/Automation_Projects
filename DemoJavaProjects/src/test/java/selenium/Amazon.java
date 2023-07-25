package selenium;
/// importing libraries

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon {
    @Test
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");
        driver.findElement(By.id("nav-search-submit-button")).click();
        // printing all text data in the toolbar of the application
        WebElement textdata = driver.findElement(By.id("nav-main"));
        System.out.println(textdata.getText());


    }
}
