import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Sel_04_LocatebyLinkText {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
        //WebElement freeTrial_link = driver.findElement(By.linkText("Start a free trial"));
        WebElement freeTrial_link = driver.findElement(By.partialLinkText("free trial"));
        System.out.println(freeTrial_link.getText());
        freeTrial_link.click();
        driver.quit();
    }
}
