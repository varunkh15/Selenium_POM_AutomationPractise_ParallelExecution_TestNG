package com.qa.tests;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.Base;
import com.qa.pages.DressesPage;
import com.qa.testdata.Constants;

public class DressesPageTest extends Base {
	WebDriver driver;
	Constants constant = new Constants();
	DressesPage dressesPage;

	@Test
	@Parameters({ "DressesPageTest.numberDresses.jiraTestId", "DressesPageTest.numberDresses.desc" })
	public void numberDresses(String jiraId, String description) throws InterruptedException {
		dressesPage = new DressesPage(Base.getDriver());
		// jiraTestId = "NUMBER-dress-101";
//		jiraTestId = properties.getProperty("DressesPageTest.numberDresses.jiraTestId");
		// System.out.println("Jira test
		// Id:"+properties.getProperty("DressesPageTest.numberDresses.jiraTestId"));
		List<WebElement> numofDresses = dressesPage.numberofDresses();
		System.out.println("Number of dresses present on page : " + numofDresses.size());
		Assert.assertEquals(numofDresses.size(), 5);
	}

	@Test
	@Parameters("DressesPageTest.Listdresses.jiraTestId")
	public void Listdresses(String jiraId) throws InterruptedException {
		dressesPage = new DressesPage(Base.getDriver());
		// jiraTestId = "List-dress-101";
//		jiraTestId = properties.getProperty("dressesPageTest.Listdresses.jiraTestId");
		Collections.sort(constant.expectedDressList);
		List<String> ListofDress = dressesPage.listofDress();
		Assert.assertEquals(ListofDress, constant.expectedDressList);
	}

	@Test
	@Parameters("DressesPageTest.Pricedresses.jiraTestId")
	public void Pricedresses(String jiraId) throws InterruptedException {
		// jiraTestId = "Price-dress-101";
		dressesPage = new DressesPage(Base.getDriver());
		Collections.sort(constant.expectedDressPrice);
		List<String> DressPrice = dressesPage.priceofDress();
		Assert.assertEquals(DressPrice, constant.expectedDressPrice);
	}

	@Test
	@Parameters("DressesPageTest.Discountdresses.jiraTestId")
	public void Discountdresses(String jiraId) throws InterruptedException {
//		jiraTestId = "Discount-dress-101";
		dressesPage = new DressesPage(Base.getDriver());
		Collections.sort(constant.expectedDressDiscount);
		List<String> DressDiscount = dressesPage.discountonDress();
		Assert.assertEquals(DressDiscount, constant.expectedDressDiscount);
	}
	
	
	

}
