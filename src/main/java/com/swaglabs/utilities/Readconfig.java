package com.swaglabs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	Properties property;
	
	public Readconfig()  {
		
		
		File src = new File("./Configuration/config.properties");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			property = new Properties();
			try {
				property.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	public String getbaseurl() {
		String baseurl = property.getProperty("Baseurl");
		return baseurl;
	}
	public String getusername() {
		String username = property.getProperty("Username");
		return username;
	}
	public String getpassword() {
		String password = property.getProperty("Password");
		return password;
	}

}
