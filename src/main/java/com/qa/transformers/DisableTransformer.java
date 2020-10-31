package com.qa.transformers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITest;
import org.testng.annotations.ITestAnnotation;

import com.qa.utils.ApplicationProperties;

public class DisableTransformer implements IAnnotationTransformer {
	
	private ApplicationProperties  properties  = new ApplicationProperties();
	public DisableTransformer() {
		properties.init();
	}
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
//		System.out.println("Class Name "+testMethod.getDeclaringClass().getSimpleName());
//		System.out.println("Mehtod name"+testMethod.getName() +" ");
			
		
		String propertyKey =  testMethod.getDeclaringClass().getSimpleName() +"."+testMethod.getName()+".enable";
		boolean isEanbled= Boolean.parseBoolean(properties.getProperty(propertyKey, "true"));
//		System.out.println(isEanbled);
		annotation.setEnabled(isEanbled);
		
	}
}
