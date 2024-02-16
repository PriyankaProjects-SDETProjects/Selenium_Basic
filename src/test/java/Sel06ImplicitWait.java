import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Sel06ImplicitWait {
    WebDriver driver ;

    @BeforeTest
    public void openBrowser(){
        driver = new EdgeDriver();
        //driver.get("https://app.vwo.com/");
        driver.navigate().to("https://app.vwo.com/");
    }
    @Test
    public void negative_TC() throws InterruptedException {

        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();

        WebElement user_name = driver.findElement(By.id("login-username"));
        user_name.sendKeys("priyanka.pandey@abc.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("abc");

        WebElement submit = driver.findElement(By.id("js-login-btn"));
        submit.click();

       /* try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        WebElement err_msg = driver.findElement(By.id("js-notification-box-msg"));
        //Trying to print without wait. It will not find the text in the element
        System.out.println("1-->"+err_msg.getText());


        //Explicit wait till element err_msg has text condition
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("2-->"+err_msg.getText());
        Assert.assertEquals(err_msg.getText(),"Your email, password, IP address or location did not match");
        //Assert.assertEquals(err_msg.getText(), "Your email, password, IP address or location did not match");
       /* WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(err_msg,"Your email, password, IP address or location did not match"));
        System.out.println("2-->"+err_msg.getText());
        Assert.assertEquals(err_msg.getText(), "Your email, password, IP address or location did not match");*/


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
