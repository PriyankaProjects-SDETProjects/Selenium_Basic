package webElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class NestedFramesDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='Nested Frames']")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElements(By.tagName("frame")).size());
        driver.switchTo().frame(0);
        System.out.println(driver.findElements(By.tagName("frame")).size());
        driver.switchTo().frame(1);
        String midFrameText = driver.findElement(By.xpath("//frame[name='frame-middle']")).getText();
        //System.out.println(driver.findElement(By.xpath("//frame[name='frame-middle']")).getText());
    }
}
