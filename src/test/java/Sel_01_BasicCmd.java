import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Sel_01_BasicCmd {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        //WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.wikipedia.com");
        driver.navigate().back();
        driver.navigate().forward();

        driver.quit();
    }
}
