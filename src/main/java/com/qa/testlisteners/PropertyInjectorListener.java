package com.qa.testlisteners;

import java.util.List;
import java.util.Map;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import com.qa.utils.ApplicationProperties;

public class PropertyInjectorListener implements IAlterSuiteListener{

	private ApplicationProperties  properties  = new ApplicationProperties();
	public PropertyInjectorListener() {
		properties.init();
	}
	
	@Override
	public void alter(List<XmlSuite> suites) {

		XmlSuite suite = suites.get(0);
        Map<String, String> params =  properties.getPropertyMap();
        suite.setParameters(params);
       
	}
	
}
