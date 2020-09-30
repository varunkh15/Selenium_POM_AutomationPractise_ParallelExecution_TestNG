package com.qa.tests;
import java.util.Collections;
import java.util.List;
import com.qa.pages.Base;
import com.qa.testdata.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pages.DressesPage;

public class DressesPageTest extends Base
{
	WebDriver driver;
	Constants constant = new Constants();
	DressesPage dressesPage ;
	
	@Test
	public void Numberdresses() throws InterruptedException
	{ 
		dressesPage = new DressesPage(Base.getDriver());
		List<WebElement> numofDresses = dressesPage.numberofDresses();
		System.out.println("Number of dresses present on page : "+numofDresses.size());
		Assert.assertEquals(numofDresses.size(), 5);
	}
	
	@Test
	public void Listdresses() throws InterruptedException
	{
		dressesPage = new DressesPage(Base.getDriver());
		Collections.sort(constant.expectedDressList);
		List<String> ListofDress = dressesPage.listofDress();
		Assert.assertEquals(ListofDress,constant.expectedDressList);
	}
	
	@Test
	public void Pricedresses() throws InterruptedException
	{
		dressesPage = new DressesPage(Base.getDriver());
		Collections.sort(constant.expectedDressPrice);
		List<String> DressPrice = dressesPage.priceofDress();
		Assert.assertEquals(DressPrice,constant.expectedDressPrice);
	}
	
	@Test
	public void Discountdresses() throws InterruptedException
	{
		dressesPage = new DressesPage(Base.getDriver());
		Collections.sort(constant.expectedDressDiscount);
		List<String> DressDiscount = dressesPage.discountonDress();
		Assert.assertEquals(DressDiscount,constant.expectedDressDiscount);
	}
}
