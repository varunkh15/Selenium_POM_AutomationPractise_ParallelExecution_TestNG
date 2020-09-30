package com.qa.tests;
import java.util.Collections;
import java.util.List;
import com.qa.pages.Base;
import com.qa.testdata.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pages.TShirtsPage;

public class TShirtsPageTest extends Base
{
	WebDriver driver;
	Constants constant = new Constants();
	TShirtsPage tshirtpage;
	
	@Test
	public void Numberdresses() throws InterruptedException
	{ 
		tshirtpage = new TShirtsPage(Base.getDriver());
		List<WebElement> NumofDresses = tshirtpage.numberoftshirts();
		System.out.println("\nNumber of TShirts on page : "+NumofDresses.size());
		Assert.assertEquals(NumofDresses.size(), 1);	
	}
	
	@Test
	public void Listdresses() throws InterruptedException
	{
		tshirtpage = new TShirtsPage(Base.getDriver());
		Collections.sort(constant.expectedDressList);
		List<String> ListofDress = tshirtpage.listoftshirts();
		Assert.assertEquals(constant.expectedtshirtList,ListofDress);
	}
	
	@Test
	public void Pricedresses() throws InterruptedException
	{
		tshirtpage = new TShirtsPage(Base.getDriver());
		Collections.sort(constant.expectedDressPrice);
		List<String> DressPrice = tshirtpage.priceoftshirts();
		Assert.assertEquals(constant.expectedtshirtPrice,DressPrice);
	}

}
