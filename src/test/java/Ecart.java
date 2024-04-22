import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;


public class Ecart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        List<WebElement> items = driver.findElements(By.xpath("//h4[@class='product-name']"));

        //   //h4[@class='product-name']

        /*for(WebElement item: items){
            String itemName = item.getText();
            if(item.getText().contains("Cucumber")){
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).click();
                break;
            }*/

        for(int i=0; i< items.size();i++) {
            String name = items.get(i).getText();
            if(name.contains("Cucumber")) {
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

                break;
            }
        }
        }
    }

