package com.qa.pages;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.utils.ElementUtil;

public class TShirtsPage {

	public WebDriver driver;
	ElementUtil elementUtil;

	By tShirt = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a[1]");
	By numoftshirt = By.xpath("//*[@id='center_column']/ul/li");
	By listoftshirt = By.xpath("//*[@id='center_column']/ul/li/div/div/h5/a");
	By priceoftshirt = By.xpath("//*[@id='center_column']/ul[1]/li/div[1]/div[2]/div[1]/span[@class='price product-price']");

	ArrayList<String> actualDressList = new ArrayList<String>();
	ArrayList<String> actualDressPrice = new ArrayList<String>();
	ArrayList<String> actualDressDiscount = new ArrayList<String>();

	public TShirtsPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public List<WebElement> numberoftshirts() throws InterruptedException {
		List<WebElement> tshirtNumber ;
		clickonTShirtbutton();
		elementUtil.visibilityOfAllElements(numoftshirt, 10);
		tshirtNumber = driver.findElements(numoftshirt);
		return (tshirtNumber);
	}

	public ArrayList<String> listoftshirts(){
		List<WebElement> elementsDressList;
		elementsDressList = driver.findElements(listoftshirt);   
		System.out.println("\nList of TShirts : ");
		for(WebElement list : elementsDressList)
		{
			actualDressList.add(list.getText());
			System.out.println(list.getText());
		} 
		Collections.sort(actualDressList);
		return actualDressList;
	}

	public ArrayList<String> priceoftshirts(){
		List<WebElement> pricelistofDresses;
		pricelistofDresses = driver.findElements(priceoftshirt);
		System.out.println("\nPrice of TShirts : ");
		for(WebElement list : pricelistofDresses)
		{
			actualDressPrice.add(list.getText());
			System.out.println(list.getText());
		} 
		Collections.sort(actualDressPrice);
		return actualDressPrice;
	}
	private void clickonTShirtbutton()
	{
		elementUtil.waitForElementPresent(tShirt, 10);
		elementUtil.doClick(tShirt);
	}
}

