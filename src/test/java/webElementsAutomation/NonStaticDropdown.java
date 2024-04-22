package webElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class NonStaticDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
       WebElement pass_info = driver.findElement(By.id("divpaxinfo"));
       pass_info.click();

        Thread.sleep(2000);
        int i= 1;
        while(i<5) {

            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        System.out.println(pass_info.getText());
        driver.findElement(By.id("btnclosepaxoption")).click();



    }


}
