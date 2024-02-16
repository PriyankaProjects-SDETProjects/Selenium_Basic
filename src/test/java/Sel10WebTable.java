import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class Sel10WebTable {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

        List<WebElement> webTable = driver.findElements(By.xpath("//table[@id=\"customers\"]"));

        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();

        System.out.println(row);

        int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        System.out.println(col);

        //             //table[@id="customers"]/tbody/tr[i]/td[j]

        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        for (int i=2; i<=row; i++){
            for (int j=1; j<=col;j++){
                String dynamic_path = first_part+i+second_part+j+third_part;
                //System.out.println(dynamic_path);
                String data = driver.findElement(By.xpath(dynamic_path)).getText();
                //System.out.println(data);

                //  /following-sibling::td[2]

                if(data.contains("Google")){
                    String temp_path = dynamic_path+"/following-sibling::td[2]";
                    String google_ctry = driver.findElement(By.xpath(temp_path)).getText();
                    System.out.println(google_ctry);
                }
            }
        }
    }
}
