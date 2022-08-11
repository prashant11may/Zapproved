package utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataUtils {

	private static String testdatafilepath = System.getProperty("user.dir") + "\\CreateRFQ.xlsx";

	public static Properties loadPropertiesfile() throws IOException {

		FileReader DestFile = new FileReader(System.getProperty("user.dir") + "\\Resources\\");

		Properties properties = new Properties();
		properties.load(DestFile);

		return properties;
	}

	public static String getDataFromExcel(String sheetName, int rowNumber, int columnNumber) throws IOException {

		String path = testdatafilepath;

		String data = null;
		FileInputStream fis = new FileInputStream(path);

		try {

			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheet(sheetName);// first sheet
			Row row = sheet.getRow(rowNumber); // first row
			Cell cell = row.getCell(columnNumber);

			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
			// String value = cell.getStringCellValue();// use a loop to read all the cells

			// in the rows.

		}

		catch (Exception e) {

			e.printStackTrace();
		} finally {
			fis.close();
		}

		return data;
	}

	public static String getTestData(String sheetname, String id, String field) {
		String value = null;
		try {

			Fillo fillo = new Fillo();

			Connection connection = fillo.getConnection(testdatafilepath);
			String strQuery = "Select * from " + sheetname + " " + "where ID='" + id + "'";
			Recordset recordset = null;

			recordset = connection.executeQuery(strQuery);

			while (recordset.next()) {
				value = recordset.getField(field);
			}

			recordset.close();
			connection.close();

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return value;
	}

	public static String getProperty(String key) throws IOException {

		return loadPropertiesfile().getProperty(getProperty(key));
	}

	public static String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

}
