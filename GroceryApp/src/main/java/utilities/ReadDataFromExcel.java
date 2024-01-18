
  package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
    
	static FileInputStream f;
    static XSSFWorkbook w;
    static XSSFSheet s;

    //method to read String value
    //parameters a=row,b=cell
    public static int GetStringdata(int a,int b) throws IOException {
    
            //f=new FileInputStream(<path of excel file )
            f=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//data.xlsx");
            //opening the workbook
            w=new XSSFWorkbook(f);
            //opening the sheet1 where data is stored
            s=w.getSheet("Sheet1");
            Row r=s.getRow(a);
            Cell c=r.getCell(b);
            return (int) c.getNumericCellValue();
              }
}
  
 
 