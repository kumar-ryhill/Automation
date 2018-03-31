package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Cart;
import PageObject_Component.PageObject_Search;

public class Scenario_Cart extends Base_Class {
	
	public static Logger log=Logger.getLogger(Scenario_Cart.class);
	
	@Test(dataProvider="dp_AddCart",dataProviderClass=DataProvider_Component.Dataprovider_testdata.class, groups={"smoke"})
	public void testAddCart(Map<String,String> Cart) throws IOException, InterruptedException
	{
		
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Cart.get("TC_ID");
		String Order_Set = Cart.get("Order_Set");
		String Search_Item = Cart.get("Search_Item");
		String Exp_Result = Cart.get("Exp_Result");
		
		
		Start_Server();
		Launch_App();
		
		PageObject_Search BS_Pob=new PageObject_Search(driver);
		BS_Pob.EnterSearchItem(Search_Item);
		
		PageObject_Cart BC_Pob= new PageObject_Cart(driver);
		
		Explicit_Wait(BC_Pob.Add_btn, 35);
		BC_Pob.Click_addbtn();
		
		Explicit_Wait(BC_Pob.Cart_img, 35);
		BC_Pob.Click_imgcart();
		
		
		Explicit_Wait(BC_Pob.AddCart_msg, 35);
		String Actual_Result = BC_Pob.getAddCartmsg();
		
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is  "+Actual_Result + "  Expected Result is " + Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
		}
		else
		{
			log.info("Failed as Actual Result is  "+Actual_Result + "  Expected Result is " + Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is  "+Actual_Result + "  Expected Result is " + Exp_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
	}
	
	
	@Test(dataProvider="dp_DeleteCart",dataProviderClass=DataProvider_Component.Dataprovider_testdata.class, groups={"regression"})
	public void testDeleteCart(Map<String,String> Cart) throws IOException, InterruptedException
	{
		
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Cart.get("TC_ID");
		String Order_Set = Cart.get("Order_Set");
		String Search_Item = Cart.get("Search_Item");
		String Exp_Result = Cart.get("Exp_Result");
		
		
		Start_Server();
		Launch_App();
		
		PageObject_Search BS_Pob=new PageObject_Search(driver);
		BS_Pob.EnterSearchItem(Search_Item);
		
		PageObject_Cart BC_Pob= new PageObject_Cart(driver);
		
		Explicit_Wait(BC_Pob.Add_btn, 35);
		BC_Pob.Click_addbtn();
		
		Explicit_Wait(BC_Pob.Cart_img, 35);
		BC_Pob.Click_imgcart();
		
		
		Explicit_Wait(BC_Pob.AddCart_msg, 35);
		BC_Pob.Click_Deletebtn();
		
		Explicit_Wait(BC_Pob.Deletecart_msg, 35);		
		String Actual_Result = BC_Pob.getDeleteCartmsg();
		
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is  "+Actual_Result + "  Expected Result is " + Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
		}
		else
		{
			log.info("Failed as Actual Result is  "+Actual_Result + "  Expected Result is " + Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is  "+Actual_Result + "  Expected Result is " + Exp_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
	}
	
	

}
