package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	public static Logger log=Logger.getLogger(Scenario_Search.class);
	
	@Test(dataProvider="dp_InvalidSearch" , dataProviderClass=DataProvider_Component.Dataprovider_testdata.class, groups={"smoke"})
	public void testInvalidSearch(Map<String,String> Search) throws IOException, InterruptedException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		String Search_Item = Search.get("Search_Item");
		String Exp_Result = Search.get("Exp_Result");
		
		Start_Server();
		Launch_App();
		
		log.info("Executing the Testcase " +TC_ID+ " Order set is  "+Order_Set);
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		BS_Pob.EnterSearchItem(Search_Item);		
		
		Explicit_Wait(BS_Pob.Invalid_searchmsg, 35);		
		String Actual_Result = BS_Pob.getInvalidSearchmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is  " +Actual_Result + "  Expected Result is  "+Exp_Result);
		}
		else
		{
			log.info("Failed as Actual Result is  " +Actual_Result + "  Expected Result is  "+Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is  " +Actual_Result + "  Expected Result is  "+Exp_Result);
		}
		
		
		Stop_Server();
		
		sAssert.assertAll();
		
		
	}
	
	
	
	@Test(dataProvider="dp_ValidSearch" , dataProviderClass=DataProvider_Component.Dataprovider_testdata.class, groups={"regression"})
	public void testvalidSearch(Map<String,String> Search) throws IOException, InterruptedException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		String Search_Item = Search.get("Search_Item");
		String Exp_Result = Search.get("Exp_Result").replace(".0", "");
		
		Start_Server();
		Launch_App();
		
		log.info("Executing the TestCase  " +TC_ID  + " Order set is  "+Order_Set);
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		BS_Pob.EnterSearchItem(Search_Item);
		
		Explicit_Wait(BS_Pob.Valid_searchcount, 20);
		String Output = BS_Pob.getValidSearchmsg();
		String Actual_Result = Output.replace(" products", "");
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is  " +Actual_Result  + "  Expected Result is  "+Exp_Result);
			
		}
		else
		{
			log.info("Failed as Actual Result is  " +Actual_Result  + "  Expected Result is  "+Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is  " +Actual_Result  + "  Expected Result is  "+Exp_Result);
		}
		
		Stop_Server();
		sAssert.assertAll();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
