package com.org.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {
	
	public static Properties props = new Properties();
	
	static {
		String confPath = "C:\\Users\\thaku\\eclipse-workspace\\29thSeleniumAutomationFramework\\config\\projectproperties.properties";
		File file = new File(confPath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			props.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
