package webElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DyDropdown2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.spicejet.com");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@data-testid='search-source-code']")).click();
        driver.findElement(By.xpath("//div[text()='MAA - Chennai, India']")).click();
       /* Thread.sleep(10000);
        driver.findElement(By.xpath("//div[@data-testid='search-destination-code']")).click();
        driver.findElement(By.xpath("(//div[text()='BOM - Mumbai, India'])[2]")).click();*/
    }

}