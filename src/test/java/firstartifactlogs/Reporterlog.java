package firstartifactlogs;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Reporterlog {
	
	@Test
	public void testingreporter() {
		Reporter.log("starting with reporter-----", true);
		Reporter.log("this msg appears in testng reports as well",false);
		
		Reporter.log("INFO level message---");
		Reporter.log("WARN level message---",1);
		Reporter.log("ERROR level message---",2);
		Reporter.log("DEBUG level message---",3);
	}

}
