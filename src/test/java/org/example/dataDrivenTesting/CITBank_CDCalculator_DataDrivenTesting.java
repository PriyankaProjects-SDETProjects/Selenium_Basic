package org.example.dataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CITBank_CDCalculator_DataDrivenTesting {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String file = System.getProperty("user.dir") + "\\testdata\\caldata2.xlsx";
        int rows = ExcelUtils.getRowCount(file, "Sheet1");

        for (int i = 1; i <= rows; i++) {
            //read data from excel
       String depAmt = ExcelUtils.getCellData(file,"Sheet1",i,0);
       String intRate = ExcelUtils.getCellData(file,"Sheet1",i,1);
       String lenCD = ExcelUtils.getCellData(file,"Sheet1",i,2);
       String cmpd = ExcelUtils.getCellData(file,"Sheet1",i,3);
       String exp_ttl = ExcelUtils.getCellData(file,"Sheet1",i,4);

            //pass data to the app

            WebElement appDepAmt = driver.findElement(By.id("mat-input-0"));
            appDepAmt.clear();
            appDepAmt.sendKeys(depAmt);

            WebElement appLenCD = driver.findElement(By.id("mat-input-1"));
            appLenCD.clear();
            appLenCD.sendKeys(lenCD);

            WebElement appIntRate = driver.findElement(By.id("mat-input-2"));
            appIntRate.clear();
            appIntRate.sendKeys(intRate);


            WebElement compoundrp = driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));   //select class object compounddrp will find elelment by id
            compoundrp.click();
          List<WebElement> cmpdList= driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
            for(WebElement option:cmpdList)
            {
                if(option.getText().equals(cmpd))
                    option.click();

            }
            driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")).click();

           String actTtlVal = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
            System.out.println(actTtlVal);
           if (actTtlVal.equals(exp_ttl)) {

               System.out.println("Test Passed");
               ExcelUtils.setCellData(file, "Sheet1",i,6,"Passed");
               ExcelUtils.fillGreenColor(file, "Sheet1",i,6);
           }
           else{
               System.out.println("Test Failed");
               ExcelUtils.setCellData(file, "Sheet1",i,6,"Failed");
               ExcelUtils.fillRedColor(file, "Sheet1",i,6);
           }
            Thread.sleep(3000);
        }
        System.out.println("calculation has been completed");
        driver.close();
    }
}
