package WebLibrary;

import org.openqa.selenium.WebElement;

public class Library {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Method Name:clickOnElement
	 * 
	 * Description:It will verify,element is displayed and enabled and click on the given WebElement and return boolean status.
	 * 
	 * Input:WebElement element
	 * 
	 * Output:Boolean Status
	 * 
	 * Author:Chandrika
	 * 
	 * CreationDate:03-03-2020
	 * 
	 * Modified by: NA
	 * 
	 * Modified date:NA
	 * 
	 * Modification Comments:NA
	 */
	
	
	
	
	public static boolean clickOnElement(WebElement element)
	{
		boolean status=false;
		try {
			if(element.isDisplayed())
			{
				if(element.isEnabled())
				{
					element.click();
					status=true;
				}
				else
				{
					status=false;
				}
			}
			else
			{
				status=false;
			}
		} catch (Exception e) {
			status=false;
		}
		
		return status;
	}

}
