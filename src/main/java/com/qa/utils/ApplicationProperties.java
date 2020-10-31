package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationProperties {
	private Properties configProperties;

	public ApplicationProperties() {

	}

	public void init() {
		loadProperties();
	}

	public String getProperty(String key) {

		return configProperties.getProperty(key);
	}

	public String getProperty(String key, String defautlValue) {

		return configProperties.getProperty(key, defautlValue);
	}

	public void loadProperties() {
		String path = "src/test/resources/config.properties";
		System.out.println("Path::" + path);
		configProperties = new Properties();
		try {
			configProperties.load(new FileInputStream(new File(path)));
			System.out.println("Properties loaded successfully." + configProperties);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, String> getPropertyMap() {
		Map<String, String> propMap = new HashMap<>();
		 for (Map.Entry<Object, Object> each : configProperties.entrySet()) {
			 propMap.put(each.getKey().toString(), each.getValue().toString());

	        }
		 return propMap;
 	}
}
