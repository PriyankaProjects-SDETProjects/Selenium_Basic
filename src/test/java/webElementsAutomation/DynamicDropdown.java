package webElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //driver.findElement(By.xpath("(//input[@class='select_CTXT'])[1]")).click();
        driver.findElement(By.xpath("(//input[@class='select_CTXT valid'])[1]")).click();
        driver.findElement(By.xpath("a[value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='GOI'])[1]"));


    }
}
