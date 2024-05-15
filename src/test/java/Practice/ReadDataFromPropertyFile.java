package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//step 1 : open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\CommonData.properties");//we are using . dot bcz we are not using the complete path
		//step 2 : create an object of properties class from java.util package
		Properties p = new Properties();
		//step 3 : load the input file stream to properties
		p.load(fis);
		//step 4 : provide the key and read the value
		String value = p.getProperty("url");//keys are case sensitive
		System.out.println(value);
		
		String value1 = p.getProperty("username");// here username is the key .keys are case sensitive
		System.out.println(value1);
		}
	

}
