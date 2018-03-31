package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Search {
	
	//2nd section
	
	@FindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	public WebElement Search_txtbox;	
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Item_txtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Invalid_searchmsg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement Valid_searchcount;
	
	
	//1st section
	
	public PageObject_Search(AppiumDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//3rd section
	
	public void EnterSearchItem(String Search_Item)
	{
		Search_txtbox.click();
		Item_txtbox.sendKeys(Search_Item +"\n");
		
	}
	
	
	public String getInvalidSearchmsg()
	{
		
		return Invalid_searchmsg.getText();
	}
	
	
	public String getValidSearchmsg()
	{
		return Valid_searchcount.getText();
		
	}
	

}
