package webElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowsHandles {

    public static void main(String[] args) {
        WebDriver driver=new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String>it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();
        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.xpath("//p[@class='im-para red']")).getText());
        //driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
        String emailId = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println(emailId);
        driver.switchTo().window(parentID);
        driver.findElement(By.id("username")).sendKeys(emailId);

    }
}
