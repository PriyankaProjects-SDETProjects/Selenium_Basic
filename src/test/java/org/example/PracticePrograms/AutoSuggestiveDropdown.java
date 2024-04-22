package org.example.PracticePrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AutoSuggestiveDropdown {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Thread.sleep(2000);
      //Set <WebElement>options = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
      /*List<WebElement> opt = driver.findElements(By.xpath("//li/div[@class='ui-menu-item-wrapper']"));
       Iterator<WebElement> itr = opt.iterator();
       while (itr.hasNext()) {
           System.out.println(itr.next().getText());

       }*/
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
    }

        //    //div[@class='ui-menu-item-wrapper']
    }

