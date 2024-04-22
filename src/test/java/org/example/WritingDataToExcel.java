package org.example;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WritingDataToExcel {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\myfile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row1 = sheet.createRow(0);
    /*
        //Creating rows, cells and setting data without loop
        row1.createCell(1).setCellValue("Welcome");
        row1.createCell(2).setCellValue("Priyanka");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(1).setCellValue("Welcome1");
        row2.createCell(2).setCellValue("Priyanka1");
*/

        //Creating rows, cells and setting data using loop
        Scanner sc = new Scanner(System.in);

        for(int r=0; r<=5; r++) {
            XSSFRow currentRow = sheet.createRow(r);

            for(int c=0; c<5; c++) {
               // currentRow.createCell(c).setCellValue("welcome");
                System.out.println("Enter a value:");
                String value = sc.next();
                currentRow.createCell(c).setCellValue(value);

            }
        }


        workbook.write(file);
        workbook.close();
        file.close();
    }
}