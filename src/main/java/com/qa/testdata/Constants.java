package com.qa.testdata;

import java.util.ArrayList;

public class Constants {
	
	public static String url = "http://automationpractice.com/index.php";   // Static as can be easily accesible in Base class by classname.
    public static String browser = "chrome";
    public ArrayList<String> expectedDressList = new ArrayList<String>();
	public ArrayList<String> expectedDressPrice = new ArrayList<String>();	
	public ArrayList<String> expectedWomanDressPrice = new ArrayList<String>();	
	public ArrayList<String> expectedDressDiscount = new ArrayList<String>();
    public ArrayList<String> expectedWomanDressList = new ArrayList<String>();
    public ArrayList<String> expectedWomanDressDiscount = new ArrayList<String>();
    public ArrayList<String> expectedtshirtList = new ArrayList<String>();
   	public ArrayList<String> expectedtshirtPrice = new ArrayList<String>();	
	public Constants()
	{
	expectedDressList.add("Printed Dress");
	expectedDressList.add("Printed Dress");
	expectedDressList.add("Printed Summer Dress");
	expectedDressList.add("Printed Summer Dress");
	expectedDressList.add("Printed Chiffon Dress");
	expectedDressPrice.add("$26.00");
	expectedDressPrice.add("$50.99");
	expectedDressPrice.add("$28.98");
	expectedDressPrice.add("$30.50");
	expectedDressPrice.add("$16.40");
	expectedDressDiscount.add("-5%");
	expectedDressDiscount.add("-20%");
	expectedWomanDressList.add("Faded Short Sleeve T-shirts");
	expectedWomanDressList.add("Blouse");
	expectedWomanDressList.add("Printed Dress");
	expectedWomanDressList.add("Printed Dress");
	expectedWomanDressList.add("Printed Summer Dress");
	expectedWomanDressList.add("Printed Summer Dress");
	expectedWomanDressList.add("Printed Chiffon Dress");	
	expectedWomanDressPrice.add("$16.51");
	expectedWomanDressPrice.add("$27.00");
	expectedWomanDressPrice.add("$26.00");
	expectedWomanDressPrice.add("$50.99");
	expectedWomanDressPrice.add("$28.98");
	expectedWomanDressPrice.add("$30.50");
	expectedWomanDressPrice.add("$16.40");
	expectedWomanDressDiscount.add("-5%");
	expectedWomanDressDiscount.add("-20%");
	expectedtshirtList.add("Faded Short Sleeve T-shirts");
	expectedtshirtPrice.add("$16.51");
	
	}
}
