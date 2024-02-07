import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sel_03_LocateByID {

    WebDriver driver ;
@Owner("Priyanka")
    @BeforeTest
    public void openBrowser(){
         driver = new EdgeDriver();
        //driver.get("https://app.vwo.com/");
    driver.navigate().to("https://app.vwo.com/");
    }
    @Test
    public void negative_TC() throws InterruptedException {

        //<input type="email" class="text-input W(100%)" name="username" id="login-username" data-qa="hocewoqisi">
        //<input type="password" class="text-input W(100%)" name="password" id="login-password" data-qa="jobodapuxe">

        //<button type="submit" id="js-login-btn" class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)" onclick="login.login(event)" data-qa="sibequkica">
        //									<span class="icon loader hidden" data-qa="zuyezasugu"></span>
        //									<span data-qa="ezazsuguuy">Sign in</span>
        //								</button>


        //<div class="notification-box-description" id="js-notification-box-msg" data-qa="rixawilomi">Your email, password, IP address or location did not match</div>



        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();

        WebElement user_name = driver.findElement(By.id("login-username"));
        user_name.sendKeys("priyanka.pandey@abc.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("abc");

        WebElement submit = driver.findElement(By.id("js-login-btn"));
        submit.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement err_msg = driver.findElement(By.id("js-notification-box-msg"));
        System.out.println(err_msg.getText());

        Assert.assertEquals(err_msg.getText(), "Your email, password, IP address or location did not match");
        user_name.clear();
        password.clear();
    }

    @Test
    public void positive_TC(){
    //driver.navigate().refresh();
        WebElement user_name = driver.findElement(By.id("login-username"));
        user_name.sendKeys("contact+atb5x@thetestingacademy.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("ATBx@1234");

        WebElement submit = driver.findElement(By.id("js-login-btn"));
        submit.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //<span class="Fw(semi-bold) ng-binding" data-qa="lufexuloga">Aman</span>
        WebElement dashboard_text = driver.findElement(By.xpath("//*[@data-qa='lufexuloga']"));

        Assert.assertEquals(dashboard_text.getText(),"Aman");
    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


    }

