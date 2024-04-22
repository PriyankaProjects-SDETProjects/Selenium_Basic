package webElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class FramesDemo {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        //driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        Actions a = new Actions(driver);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement trgt = driver.findElement(By.id("droppable"));
        a.dragAndDrop(src,trgt).build().perform();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[normalize-space()='Accept']")).click();
    }
}
