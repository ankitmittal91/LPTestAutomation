package LendingPointTestAutomation.dataProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import LendingPointTestAutomation.utility.NewExcelLibrary;

public class DataProviders {
	
	NewExcelLibrary file = new NewExcelLibrary();
	
	@DataProvider(name = "userData")
	public Iterator<Object[]> getCredentials() {
		// Totals rows count
		int rows = file.getRowCount("UserData");
		// Total Columns
		int column = file.getColumnCount("UserData");
		int actRows = rows - 1;
		List<Map<String,String>> listOfMap = new ArrayList<>();
		ArrayList<Object[]> list = new ArrayList<>();
		Map<String,String> map = new HashMap<>();
		for(int i=0; i<actRows; i++) {
			for(int j=0; j<column; j++) {
				map.put(file.getCellData("UserData", j, 1), file.getCellData("UserData", j, i+2));
			}
			listOfMap.add(map);
			map = new HashMap<>();
		}
		
		for(Map<String,String> mapping : listOfMap) {
			list.add(new Object[] {mapping});
		}

		/*
		 * Object[][] data = new Object[actRows][column];
		 * for (int i = 0; i < actRows;i++) { 
		 * 		for (int j = 0; j < column; j++) { 
		 * 			data[i][j] = file.getCellData("UserData", j, i + 2); } }
		 */
		return list.iterator();
	}
}
