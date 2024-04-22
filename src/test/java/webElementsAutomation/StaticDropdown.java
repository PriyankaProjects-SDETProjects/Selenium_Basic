package webElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement static_dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select static_currencyList = new Select(static_dropdown);
        static_currencyList.selectByIndex(3);
        System.out.println(static_currencyList.getFirstSelectedOption().getText());

        static_currencyList.selectByVisibleText("AED");
        System.out.println(static_currencyList.getFirstSelectedOption().getText());

        static_currencyList.selectByValue("INR");
        System.out.println(static_currencyList.getFirstSelectedOption().getText());
        //driver.quit();
    }
}
