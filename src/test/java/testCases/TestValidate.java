package testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import utilities.Payload;
import utilities.ReusableMethods;

public class TestValidate {
	
	JsonPath js;
	
	@Test(priority=1,description = "Validate that team has only 4 foreign players")
	public void tc1_validateForeignPlayers() throws Exception {

		Reporter.log("Test Started");  
		js=ReusableMethods.rawToJson(Payload.jsonPayload());

		int iCount=0;

		//Loop to verify the country name
		for(int i=0;i<js.getInt("player.size()");i++)
		{
			String countryName=js.get("player["+i+"].country");
			if(!countryName.equalsIgnoreCase("India"))
			{
				iCount=iCount+1;
			}

		}

		//assert to check the value 
		if(iCount<=4)
		{
			Reporter.log("Test Pass: Team has only 4 foregin players");  
			System.out.println("Test Pass: Team has only 4 foregin players");
		}
		else
		{	
		Assert.assertTrue(iCount>4,"Team has more than 4 foreign players");
		}
	}
	
	@Test(priority=2,description = "validate that there is at least one wicket keeper")
	public void tc2_validateWicketKeeper() throws Exception
	{
		Reporter.log("Test Started");  
		js=ReusableMethods.rawToJson(Payload.jsonPayload());
		
		int iCount=0;
		//Loop to verify the Wicket keeper 
				for(int i=0;i<js.getInt("player.size()");i++)
				{
					String role=js.get("player["+i+"].role");
					if(role.equalsIgnoreCase("Wicket-keeper"))
					{
				        Assert.assertEquals("Wicket-keeper", role);
						iCount=iCount+1;
						Reporter.log("Test Pass: Team has  wicket keeper");  
					}

				}
				//assert to check the value  
				if(iCount<1)
				{
					Reporter.log("Test Fail: Team has no wicket keeper");  
					System.out.println("Test Fail: Team has no wicket keeper");
					Assert.assertFalse(iCount==0,"Team has no Wicket keeper");
				}
						
		
	}
	  
  }

