package Framework.listeners;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import Framework.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class TestUtil extends BaseTest {


	public static String mailscreenshotpath;

	public static void captureScreenshot() {


		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH); //4
		int year = cal.get(Calendar.YEAR); //2013
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);

		try {
			mailscreenshotpath = System.getProperty("user.dir") + "\\test-output\\html\\" + year + "_" + date + "_" + (month + 1) + "_" + day + "_" + min + "_" + sec + ".jpeg";
			File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShotFile, new File(mailscreenshotpath));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static Object[][] getData(String sheetName) {


		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		System.out.println("Total rows are : " + rows);
		System.out.println("Total cols are : " + cols);


		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) { //2

			for (int colNum = 0; colNum < cols; colNum++) {

				//data[0][0]
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum); //-2
			}


		}
		return data;
	}

		
		
/*Object[][] data = new Object[rows-1][1];
		

		Hashtable<String, String> table;
		
		for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ //2
			
			table = new Hashtable<String,String>();
			
			for(int colNum=0 ; colNum< cols; colNum++){
				
				
					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				
				data[rowNum-2][0]=table;
				//-2
			}
		}
		

		return data;

		
	}*/
	
}
