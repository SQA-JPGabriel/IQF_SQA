package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class ReadPropertyFile 
{

	public static void main(String[] args) throws IOException 
	{
		FileReader fr = new FileReader("D:\\Eclipse workplace\\SQAMAutomationDemo\\IQF_SQA\\src\\test\\resources\\configfiles\\config.properties");

		Properties p = new Properties();
		
		p.load(fr);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		
		System.out.println("===========================================");
		System.out.println("Config Properties  "+now.format(formatter)+"-JPG");
		System.out.println("Browser used: "+p.getProperty("browser"));
		System.out.println("Test Url: "+p.getProperty("testurl"));
		System.out.println("===========================================");
	}

}
