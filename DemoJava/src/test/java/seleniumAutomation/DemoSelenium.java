package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoSelenium {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("watches");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.className("a-icon a-icon-checkbox")).click();
    }
}
