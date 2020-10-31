package com.qa.tests;
import java.util.Collections;
import java.util.List;
import com.qa.pages.Base;
import com.qa.testdata.Constants;

import org.apache.xmlbeans.impl.jam.JInvokable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.pages.DressesPage;

public class DressesPageTest extends Base
{
	WebDriver driver;
	Constants constant = new Constants();
	DressesPage dressesPage ;
	
	
	@Test
	@Parameters("dressesPageTest.numberDresses.jiraTestId")
	public void numberDresses(String jiraId) throws InterruptedException
	{ 
		dressesPage = new DressesPage(Base.getDriver());
	//	jiraTestId = "NUMBER-dress-101";
//		jiraTestId = properties.getProperty("dressesPageTest.numberDresses.jiraTestId");
	//	System.out.println("Jira test Id:"+properties.getProperty("dressesPageTest.numberDresses.jiraTestId"));
		List<WebElement> numofDresses = dressesPage.numberofDresses();
		System.out.println("Number of dresses present on page : "+numofDresses.size());
		Assert.assertEquals(numofDresses.size(), 5);
	}
	
	@Test
	@Parameters("dressesPageTest.numberDresses.jiraTestId")
	public void Listdresses(String jiraId) throws InterruptedException
	{
		dressesPage = new DressesPage(Base.getDriver());
		//jiraTestId = "List-dress-101";
//		jiraTestId = properties.getProperty("dressesPageTest.Listdresses.jiraTestId");
		Collections.sort(constant.expectedDressList);
		List<String> ListofDress = dressesPage.listofDress();
		Assert.assertEquals(ListofDress,constant.expectedDressList);
	}
	
	@Test
	@Parameters("dressesPageTest.numberDresses.jiraTestId")
	public void Pricedresses(String jiraId) throws InterruptedException
	{
	//	jiraTestId = "Price-dress-101";
		dressesPage = new DressesPage(Base.getDriver());
		Collections.sort(constant.expectedDressPrice);
		List<String> DressPrice = dressesPage.priceofDress();
		Assert.assertEquals(DressPrice,constant.expectedDressPrice);
	}
	
	@Test
	@Parameters("dressesPageTest.numberDresses.jiraTestId")
	public void Discountdresses(String jiraId) throws InterruptedException	{
//		jiraTestId = "Discount-dress-101";
		dressesPage = new DressesPage(Base.getDriver());
		Collections.sort(constant.expectedDressDiscount);
		List<String> DressDiscount = dressesPage.discountonDress();
		Assert.assertEquals(DressDiscount,constant.expectedDressDiscount);
	}

	
}
