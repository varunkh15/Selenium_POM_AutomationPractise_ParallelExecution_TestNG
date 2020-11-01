package com.qa.tests;
import java.util.Collections;
import java.util.List;
import com.qa.pages.Base;
import com.qa.testdata.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.pages.WomensPage;

public class WomensPageTest extends Base 
{
	WebDriver driver;
	Constants constant = new Constants();
	WomensPage WomensPage;
	
	@Test
	@Parameters({"dressesPageTest.numberDresses.jiraTestId", "dressesPageTest.numberDresses.desc" })
	public void Numberdresses(String jiraId, String description) throws InterruptedException
	{ 
		WomensPage = new WomensPage(Base.getDriver());
		List<WebElement> NumofDresses = WomensPage.numberofWomenDresses();
		System.out.println("\nNumber of Womens dresses on page : "+NumofDresses.size());
		Assert.assertEquals(NumofDresses.size(), 7);	
	}
	
	@Test
	@Parameters("dressesPageTest.numberDresses.jiraTestId")
	public void Listdresses(String jiraId) throws InterruptedException
	{
		WomensPage = new WomensPage(Base.getDriver());
		Collections.sort(constant.expectedWomanDressList);
		List<String> ListofDress = WomensPage.listofWomenDress();
		Assert.assertEquals(constant.expectedWomanDressList,ListofDress);
	}
	
	@Test
	@Parameters("dressesPageTest.numberDresses.jiraTestId")
	public void Pricedresses(String jiraId) throws InterruptedException
	{
		WomensPage = new WomensPage(Base.getDriver());
		Collections.sort(constant.expectedWomanDressPrice);
		List<String> DressPrice = WomensPage.priceofWomenDress();
		Assert.assertEquals(constant.expectedWomanDressPrice,DressPrice);
	}
	
	@Test
	@Parameters("dressesPageTest.numberDresses.jiraTestId")
	public void Discountdresses(String jiraId) throws InterruptedException
	{
		WomensPage = new WomensPage(Base.getDriver());
		Collections.sort(constant.expectedWomanDressDiscount);
		List<String> DressDiscount = WomensPage.discountonWomenDress();
		Assert.assertEquals(constant.expectedWomanDressDiscount,DressDiscount);
	}
	
	
	

}
