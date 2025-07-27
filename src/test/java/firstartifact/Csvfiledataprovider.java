package firstartifact;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Csvfiledataprovider {

	
	@DataProvider(name="csvfiledata")
	public Object[][] csvdata() throws IOException{
		String csvfile="src/test/resources/sample.csv";
		List<Object[]> testcases=new ArrayList<>();
		String[] data;
		
		try(BufferedReader b=new BufferedReader(new FileReader(csvfile))){
			String line;
			while((line=b.readLine())!=null) {
				data=line.split(",");
				testcases.add(data);
			}
		}
		return testcases.toArray(new Object[testcases.size()][]);
	}
	
	
	@Test(dataProvider="csvfiledata", dataProviderClass=Csvfiledataprovider.class)
	
	public void checkingcsvfiledata(String year, String value, String code) {
		System.out.println("year----"+year);
		System.out.println("value----"+value);
		System.out.println("Industry_code_ANZSIC06----"+code);
	}
	
}
