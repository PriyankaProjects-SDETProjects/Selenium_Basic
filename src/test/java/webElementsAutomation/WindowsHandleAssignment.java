package webElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowsHandleAssignment {

    //https://the-internet.herokuapp.com
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='Multiple Windows']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
        ////h3[normalize-space()='Opening a new window']
        Set<String> windows = driver.getWindowHandles();
            Iterator <String> itr = windows.iterator();
            String parentId = itr.next();
            String childId = itr.next();
            driver.switchTo().window(childId);
        String childWindowText = driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText();
        System.out.println(childWindowText);
        driver.switchTo().window(parentId);
        String parentWindowText = driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText();
        System.out.println(parentWindowText);
    }


}
