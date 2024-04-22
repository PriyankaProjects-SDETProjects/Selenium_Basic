package org.example.PracticePrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebtableRowsAndClms {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // find total rows in a webtable

        int rowCount = driver.findElements(By.xpath("(//table[@id='product'])[1]/tbody/tr")).size();
        System.out.println(rowCount);

        // find total columns in a webtable
        int colCount = driver.findElements(By.xpath("(//table[@id='product'])[1]/tbody/tr[1]/th")).size();
        System.out.println(colCount);
    }
}
