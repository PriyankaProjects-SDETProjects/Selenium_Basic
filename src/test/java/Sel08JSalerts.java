import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sel08JSalerts {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]"));
      element.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebElement element1 = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        element1.click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.dismiss();

        WebElement element2 = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        element2.click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.sendKeys("Priyanka");
        alert2.accept();

        String result_text = driver.findElement(By.id("result")).getText();
        System.out.println(result_text);
    }
}
