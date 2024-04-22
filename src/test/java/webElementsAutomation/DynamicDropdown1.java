package webElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DynamicDropdown1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.cleartrip.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Where from?']")).click();
        driver.findElement(By.xpath("(//p[normalize-space()='Mumbai, IN - Chatrapati Shivaji Airport (BOM)'])[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Where to?']")).click();
        driver.findElement(By.xpath("//p[normalize-space()='New Delhi, IN - Indira Gandhi Airport (DEL)']")).click();



    }

}
