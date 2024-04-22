package webElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Chkboxes {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_chk_friendsandfamily'])[1]")).click();
        System.out.println(driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_chk_friendsandfamily'])[1]")).isSelected());

        ////input[@type='checkbox']
    }

}