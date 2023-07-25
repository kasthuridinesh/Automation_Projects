import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Xpath {
    @Test
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/quiztest/quiztest.asp?qtest=JAVA");
        // find element using relative xpath
        driver.findElement(By.xpath("//a[@id='navbtn_exercises']")).click();
        // find elemet using Absolute xpath
        driver.findElement(By.xpath("/html/body/div[2]/a[3]")).click();

    }
}
