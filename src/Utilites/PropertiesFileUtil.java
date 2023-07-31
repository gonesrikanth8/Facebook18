package Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtil {
	
	public static String getValueForKey(String Key) throws Throwable, Throwable
	{
		
	Properties ConfigProperties = new Properties();
	ConfigProperties.load(new FileInputStream(new File("./DataFolder/Environment.properties")));
	return ConfigProperties.getProperty(Key);
	
	}
	

}
