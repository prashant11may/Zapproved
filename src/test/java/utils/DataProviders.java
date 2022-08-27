package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {

	private static String path = System.getProperty("user.dir") + "//Zapproved.xlsx";

	@DataProvider(name = "data")
	public static Object[] getData2() throws Exception {
		File excelFile = new File(path);
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("ZapprovedData");
		int rowNum = sheet.getLastRowNum();
		int columnNum = sheet.getRow(0).getLastCellNum();

		DataFormatter formatter = new DataFormatter();
		Object[] data = new Object[rowNum];
		Map<String, String> map;
		for (int i = 1; i <= rowNum; i++) {
			map = new HashMap<String, String>();
			for (int j = 0; j < columnNum; j++) {

				String key = formatter.formatCellValue(sheet.getRow(0).getCell(j));
				String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
				map.put(key, value);
				data[i - 1] = map;
			}
		}

		workbook.close();
		fis.close();

		return data;
	}

}
