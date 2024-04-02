package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consist of generic methods related to excel file
 * @author kritiVyas
 *
 */

public class ExcelFileUtility 
{ 
	/**
	 * this method will read data from excel file and return the value to caller
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String readDataFromExcelfile(String sheetName ,int row , int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\AdSelenium_contacts.xlsx");
		Workbook wbf = WorkbookFactory.create(fis);
		String value = wbf.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();		
		return value;
		
	}

}
