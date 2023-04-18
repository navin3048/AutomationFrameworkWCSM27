package vtiger.Organization.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;


@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void craeteOrgTest() throws IOException
	{
		
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//Step 5: Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("navigated to organizations link",true);		//Printed in report as well as console
		
		//Step 6: Click on Create Organization LookUp image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg(); 
		Reporter.log("clicked on create organization look up image");		//Printed inn report only
		
		Assert.fail();		//To fail the script
		
		//Step 7: Create Organization with Mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		Reporter.log("new organization created");
		
		//Step 8: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrganizationHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
	}
	
	@Test
	public void demo()
	{
		System.out.println("This is demo");
	}

}















