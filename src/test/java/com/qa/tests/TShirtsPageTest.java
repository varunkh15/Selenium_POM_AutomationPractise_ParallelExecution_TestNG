package com.qa.tests;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.Base;
import com.qa.pages.TShirtsPage;
import com.qa.testdata.Constants;

public class TShirtsPageTest extends Base 
{
	WebDriver driver;
	Constants constant = new Constants();
	TShirtsPage tshirtpage;
	
	@Test
	@Parameters("dressesPageTest.numberDresses.jiraTestId")
	public void Numberdresses(String jiraId) throws InterruptedException
	{ 
		System.out.println("Execution Jira Id:"+jiraId);
		tshirtpage = new TShirtsPage(Base.getDriver());
		List<WebElement> NumofDresses = tshirtpage.numberoftshirts();
		System.out.println("\nNumber of TShirts on page : "+NumofDresses.size());
		Assert.assertEquals(NumofDresses.size(), 1);	
	}
	
	@Test
	@Parameters("dressesPageTest.numberDresses.jiraTestId")
	public void Listdresses(String jiraId) throws InterruptedException
	{
		tshirtpage = new TShirtsPage(Base.getDriver());
		Collections.sort(constant.expectedDressList);
		List<String> ListofDress = tshirtpage.listoftshirts();
		Assert.assertEquals(constant.expectedtshirtList,ListofDress);
	}
	
	@Test
	@Parameters("dressesPageTest.numberDresses.jiraTestId")
	public void Pricedresses(String jiraId) throws InterruptedException
	{
		tshirtpage = new TShirtsPage(Base.getDriver());
		Collections.sort(constant.expectedDressPrice);
		List<String> DressPrice = tshirtpage.priceoftshirts();
		Assert.assertEquals(constant.expectedtshirtPrice,DressPrice);
	}
	
	

}
