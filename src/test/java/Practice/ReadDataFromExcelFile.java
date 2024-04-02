package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1: open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\AdSelenium_contacts.xlsx");				
		//step2: create a workbook
		Workbook wbf = WorkbookFactory.create(fis);
		//step3: navigate to required sheet
		String lastname = wbf.getSheet("contacts").getRow(1).getCell(2).getStringCellValue();
		//step4: navigate to required row
	//	Row row = sh.getRow(1);
		//step5: navigate to required cell
	//	Cell cell = row.getCell(2);
		//step6: capture data
	//	String value = cell.getStringCellValue();
		System.out.println(lastname);
		//close the workbook
		wbf.close();

	}

}
