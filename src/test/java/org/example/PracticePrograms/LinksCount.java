package org.example.PracticePrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Iterator;
import java.util.Set;

public class LinksCount {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // Find total link counts in the web page

        System.out.println(driver.findElements(By.tagName("a")).size());

        // find links count in the footer section only by limiting the driver's scope

        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
       int footerLinkscount = footerDriver.findElements(By.tagName("a")).size();
        System.out.println(footerLinkscount);

        // find links count from a columnar section of footer
       WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
       int columnLinksCount = columnDriver.findElements(By.tagName("a")).size();

       //click on each link of column & see if they are opening

        for(int i=1; i<columnLinksCount;i++) {
            String clickonLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
            Thread.sleep(3000);
        }
         Set<String> windows =  driver.getWindowHandles();
         Iterator <String>it = windows.iterator();
         while (it.hasNext()) {
             driver.switchTo().window(it.next());
             System.out.println(driver.getTitle());

         }

         }
        }



