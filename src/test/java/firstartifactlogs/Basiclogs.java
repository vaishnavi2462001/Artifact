package firstartifactlogs;
import org.testng.annotations.Test;

public class Basiclogs {
	
	@Test
	public void printstmt() {
		System.out.println("with system.out -----");
		System.out.println("step 1-----");
		System.out.println("step 2----");
		System.out.println("steps done-----");
	}
	
	
	@Test
	public void errstmt() {
		System.err.println("this is error msg----");
		System.err.println("something went wrong------");
	}

}
