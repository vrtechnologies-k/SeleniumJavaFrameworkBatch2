package utilities;

import java.io.File;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelUtils {
	
	private static Workbook workbook;
	
	private static Sheet sheet;
	
	private static Cell cell;
	
	static String getData;
	
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
		
		String[][] tabArray = null;
		
		try {
			
			workbook = Workbook.getWorkbook(new File(FilePath));
			   
			   sheet = workbook.getSheet(SheetName);
			   
			   int startRow = 1;
			   
			   int startCol = 0;
			   
			   int totalRows = sheet.getRows();
			   
			   System.out.println(totalRows);
			   
			   int totalCols = sheet.getColumns();
			   
			   System.out.println(totalCols);
			   
			   tabArray = new String[totalRows][totalCols];
			   int ci, cj;
			   ci=0;

			   for (int i=startRow;i<totalRows;i++, ci++) {           	   

				  cj=0;

				   for (int j=startCol;j<totalCols;j++, cj++){

					   tabArray[ci][cj] = getCellData(i,j);

					   //System.out.println(tabArray[ci][cj]);  

					}
			   }
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		return (tabArray);
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		
		try{
		getData = sheet.getCell(ColNum, RowNum).getContents();
		if (getData == "") {
			
			return "";
		} else {
			return getData;
		}
		} catch(Exception e) {
			e.getMessage();
		}
		return getData;

	}
}