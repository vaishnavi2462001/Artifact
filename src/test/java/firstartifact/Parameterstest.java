package firstartifact;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterstest {

		@Test
		@Parameters({"browser","version"})
		public void checkversion(String browser, String version) {
			System.out.println(browser +"version is "+version);
		}
		
	}

	

