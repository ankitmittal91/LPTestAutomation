package LendingPointTestAutomation.dataProvider;
import org.testng.annotations.DataProvider;
import LendingPointTestAutomation.utility.NewExcelLibrary;

public class DataProviders {
	
	NewExcelLibrary file = new NewExcelLibrary();
	
	@DataProvider(name = "userData")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = file.getRowCount("UserData");
		// Total Columns
		int column = file.getColumnCount("UserData");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) { 
			for (int j = 0; j < column; j++) { 
				data[i][j] = file.getCellData("UserData", j, i + 2);
			}
		}
		return data;
	}
	

}
