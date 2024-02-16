import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class Sel09ChkBoxes {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        int size = checkboxes.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            if (checkboxes.get(i).isSelected() == false) {
                checkboxes.get(i).click();
            }

        }


    }
}
