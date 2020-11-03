package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.model.TestData;

public class ApplicationProperties {
	private Properties configProperties;
	private static final String PATH = "C:\\work\\workspace\\Ecommerce2\\src\\test\\resources\\testNG_excel.xlsx";
	private List<TestData> data = new ArrayList<>();
	private Map<String, String> propertyMap = new HashMap<>();

	
	public void init() {
//		loadProperties();
		loadExcel();
		System.out.println(convertListToKeyValueMap());;
		System.out.println(data);
	}
	
	public Map<String, String> convertListToKeyValueMap() {
		
		for(TestData testData : data) {
			propertyMap.put(testData.getClassName()+"."+testData.getMethodName()+".jiraTestId", testData.getJiraId());
			propertyMap.put(testData.getClassName()+"."+testData.getMethodName()+".desc", testData.getDescription());
			propertyMap.put(testData.getClassName()+"."+testData.getMethodName()+".enable",Boolean.toString( testData.isEnable()));
		}
		return propertyMap;
	}
	
	private void loadExcel() {
		try {
			FileInputStream file = new FileInputStream(new File(PATH));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				data.addAll(loadSheet(workbook.getSheetName(i), workbook));
				
			} 

			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<TestData> loadSheet(String sheetName, XSSFWorkbook workbook) {
		List<TestData> testDataList = new ArrayList<>();
		try {
			
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			int counter = 0;
			while (rowIterator.hasNext()) {
				
				Row row = rowIterator.next();
				
				if (counter == 0) {
					counter++;
					continue;
				}
				TestData testData = new TestData();
				testData.setClassName(sheetName);
				testData.setJiraId(row.getCell(0).getStringCellValue());
				testData.setDescription(row.getCell(1).getStringCellValue());
				testData.setMethodName(row.getCell(2).getStringCellValue());
				testData.setEnable(row.getCell(3).getBooleanCellValue());
				
				testDataList.add(testData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return testDataList;
	}

	public String getProperty(String key) {

		return propertyMap.get(key);
	}

	public String getProperty(String key, String defautlValue) {
		String value = propertyMap.get(key);
		if(value == null) {
			return defautlValue;
		} else {
			return value;
		}
	}

	/*public void loadProperties() {
		String path = "src/test/resources/config.properties";
		System.out.println("Path::" + path);
		configProperties = new Properties();
		try {
			configProperties.load(new FileInputStream(new File(path)));
			System.out.println("Properties loaded successfully." + configProperties);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	/*public Map<String, String> getPropertyMap() {
		Map<String, String> propMap = new HashMap<>();
		for (Map.Entry<Object, Object> each : configProperties.entrySet()) {
			propMap.put(each.getKey().toString(), each.getValue().toString());
		}
		return propMap;
	}*/
	
	public Map<String , String > getPropertyMap() { 
		return propertyMap;
	}
}
