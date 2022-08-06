package utilities;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excelutilities {
	
	
	public String[][] getTestData() throws Exception {
		
		//String[][] tabArray;
		
		File file= new File("./");
		
		Workbook workbook = Workbook.getWorkbook(new File(file.getCanonicalPath()+"\\TestData\\formSubmission.xls"));
		
		Sheet sheet = workbook.getSheet("submitForm");
		
		int rows = sheet.getRows();
		
		int cols = sheet.getColumns();
		
		String[][] tabArray = new String[rows][cols];
		
		int ri, cj;
		
		ri=0;
		
		for (int i = 1; i<rows; i++,ri++) {
			
			cj = 0;
			
			for (int j= 0; j<cols; j++, cj++) {
				
				String getData = sheet.getCell(cols, rows).getContents();
				
				System.out.println(getData);
				
				tabArray[ri][cj] = getData;
				// String[] str = {"venkat", "Ramya"}
				// String[][] str = {{"venkat", "Ramya"},{"Anu","Rithwik"}}}
				
			}
			
		}
		
		return (tabArray);
		
	}

}
