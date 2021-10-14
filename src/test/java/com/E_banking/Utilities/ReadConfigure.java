package com.E_banking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigure {

	public static Properties prop;

	public ReadConfigure() {
		File path = new File("D:\\e-banking\\Configurations\\configure.properties");

		try {
			FileInputStream file = new FileInputStream(path);
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			System.out.println("Exception is :" + e.getMessage());
		}
	}

	public String getApplicationUrl() {
		String url = prop.getProperty("baseUrl");
		return url;
	}

	public String getUsername() {
		String username = prop.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

	public String getchromePath() {
		String chromePath = prop.getProperty("chromepath");
		return chromePath;
	}

	public String getFirefox() {
		String firfox = prop.getProperty("firefoxpath");
		return firfox;
	}

	public String getEdge() {
		String edgepath = prop.getProperty("edgepath");
		return edgepath;
	}
}
