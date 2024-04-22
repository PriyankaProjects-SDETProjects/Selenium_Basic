package org.example;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//File-->Workbook-->Sheet-->Rows-->Cells
//FileInputStream/FileOutputStream-->XSSFWorkbook-->XSSFSheet-->XSSFRow-->XSSFCell
public class ReadingExcel {
    public static void main(String[] args) throws IOException {
        //FileInputStream file = new FileInputStream("C:\\Users\\Priyanka.Pandey\\IdeaProjects\\LearnSeleniumJava\\testdata\\data.xlsx");
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
       XSSFSheet sheet = workbook.getSheet("Sheet1");
       int rowCount = sheet.getLastRowNum();
       int cellCount = sheet.getRow(1).getLastCellNum();

       for(int r=0;r<=rowCount;r++) {
          XSSFRow currentRow =  sheet.getRow(r);
           for(int c=0;c<cellCount;c++) {
            //String value =currentRow.getCell(c).toString();
             XSSFCell cell = currentRow.getCell(c);
               String value = cell.toString();
               System.out.print(value+" ");

           }
           System.out.println();
    workbook.close();
           file.close();

       }
       }

    }

