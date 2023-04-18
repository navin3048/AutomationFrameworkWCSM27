package vtiger.Contact.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;


@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass {


	@Test(groups = "RegressionSuite")
	public void createContactWithOrgTest() throws IOException
	{
		
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		
		//Step 5: Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 6: Click on Create Organization LookUp image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 7: Create Organization with Mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		//Assert.fail();			//For fail the script to take screenshot
		
		//Step 8: Validate for Organization	
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrganizationHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		
		//Step 9: Navigate to Contacts Link
		hp.clickOnContactLink();
		
		//Step 10: Click on Create Contact LookUp image		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImage();
		
		//Step 11: Create Contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		
		//Step 12: Validate for Contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
	}

}
