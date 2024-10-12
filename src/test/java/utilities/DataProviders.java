package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
	String path =	"./testData/LoginData.xlsx"; //identifying source excel file
	
	ExcelUtility xlutility = new ExcelUtility(path);
	
	int totalrows = xlutility.getRowCount("Sheet1");
	int totalcols = xlutility.getCellCount("Sheet1", 1);
	
	String logindata[][] = new String[totalrows][totalcols];
	
	int[][] name = new int [2][6];
	
	for(int i=1; i<totalrows; i++) {
		for(int j=0; j<totalcols; j++) {
			logindata[i-1][j]=xlutility.getCellData("Sheet1", i, j);
		}
	}
	return logindata;
	}
	
	//DataProvider2
	//DataProvider3
	//DataProvider4

	
}
