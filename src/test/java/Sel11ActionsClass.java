import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sel11ActionsClass {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new EdgeDriver();
        //driver.get("https://app.vwo.com/");
        driver.navigate().to("https://www.makemytrip.com/");
        //driver.manage().window().maximize();
    }

    @Test
    public void testBrowser() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(10000);

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        actions.moveToElement(fromCity).click().sendKeys("New Delhi, India").build().perform();

        //List<WebElement> li = driver.findElements(By.xpath("//li[@role=\"option\"]/div/div/p[1]"));
        List<WebElement> li = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));

        for (WebElement e : li) {
            System.out.println(e.getText());
            if(e.getText().contains("New Delhi, India")){
                e.click();
                break;
            }


        }
    }

        @AfterTest
        public void closeBrowser () {
            //driver.quit();
        }

    }
