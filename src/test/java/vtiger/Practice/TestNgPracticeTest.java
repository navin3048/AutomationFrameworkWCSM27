package vtiger.Practice;

import org.testng.annotations.Test;

public class TestNgPracticeTest {
	
	@Test(invocationCount = 1 )
	public void createUserTest()
	{
		System.out.println("user created");
	}

	@Test(priority = 1) 
	public void modifyUserTest() 
	{
		System.out.println("user modified");
	}
	
	@Test(priority = 2)
	public void deleteUserTest()
	{
		System.out.println("user deleted");
	}
	
}
