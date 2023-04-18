package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderTxt;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getContactHeaderTxt( ) {
		return ContactHeaderTxt;
	}
	
	//Business Library
	/**
	 * This method will get the contact header text and return it to caller
	 * @return
	 */
	public String getContactHeader()
	{
		return ContactHeaderTxt.getText();
	}

}
