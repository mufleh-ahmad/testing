package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Mufleh on 24/03/2019.
 */
public class Table {

    protected WebDriver driver;

    public int getTableColNum(String tableXpath, WebElement element){
        WebElement tableCol = driver.findElement(By.xpath(tableXpath + "/thead/tr/th"));
        List<WebElement> th = driver.findElements((By) tableCol);

        String e= driver.findElement((By) element).getText();
        int col_position = 1;
        boolean found = false;
        for (WebElement cell : th) {
            String cellData = cell.getText();
            if (cellData.equals(e)){
                found = true;
                break;
            }
            col_position++;
        }
        if (!found){
            col_position =0;
        }
        return col_position;
    }

    //get cell data in specified column

    public List<WebElement> getTableCellDataByColumn(String tableXpath, Integer iCol){
        WebElement tableCol = driver.findElement(By.xpath(tableXpath + "tbody/tr/td["+ iCol+"]"));
        List<WebElement> rows = driver.findElements((By) tableCol);
        return rows;
    }

    public String getTableDataCellText(String tableXpath, Integer iRow, Integer iCol){
        WebElement tableData = driver.findElement(By.xpath(tableXpath+ "/tbody/tr["+ iRow+"]"));
        String cellTextValue = driver.findElement((By) tableData).getText();
        return cellTextValue;
    }
}
