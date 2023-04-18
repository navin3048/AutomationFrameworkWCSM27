package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getData")
	public void addToCart(String name, int price, int qty, String colour, boolean isAvailable) 
	{
		System.out.println("---"+name+"-"+price+"-"+qty+"-"+colour+"-"+isAvailable+"---");
	}
	
	@DataProvider
	public Object[][] getData()
	{							  //row//cell
		Object[][] data = new Object[2][5];		//2 data sets of 5 details inside
		
		data[0][0] = "Samsung";
		data[0][1] = 10000;
		data[0][2] = 12;
		data[0][3] = "Black";
		data[0][4] = true;
		
		data[1][0] = "Iphone";
		data[1][1] = 12000;
		data[1][2] = 5;
		data[1][3] = "White";
		data[1][4] = false;
		
		return data;	
	}
	
	@Test(dataProvider = "getDataDeatails")
	public void addToCart(String name, int price, String colour, boolean isAvailable)
	{
		System.out.println("---"+name+"-"+price+"-"+colour+"-"+isAvailable+"---");
	}
	
	@DataProvider
	public Object[][] getDataDeatails()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0] = "Hp";
		data[0][1] = 10000;
		data[0][2] = "White";
		data[0][3] = true;
		
		data[1][0] = "Dell";
		data[1][1] = 15000;
		data[1][2] = "Black";
		data[1][3] = false;
		
		data[2][0] = "Lenovo";
		data[2][1] = 8000;
		data[2][2] = "Grey";
		data[2][3] = true;
		
		return data;
	}

}
