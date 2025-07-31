package firstartifact;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test2 {

	@Test(priority=7)
	public void add3() {
		System.out.println("this is add3 method");
	}
	
	@Test(enabled=false)
	public void add1() {
		System.out.println("this is add method");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void add2() {
		System.out.println("this is before method");
		//Assert.fail();
	}
	
	@Test(priority = 1)
	public void add4() {
		System.out.println("this is add4 method");
		throw new SkipException("skipped intentionally by me");
	}
	
	
	@Test(groups= {"smoke"})
	public void add5() {
		System.out.println("this is from add5");
	}
	
	
	@Test(groups={"regression"})
	public void add6() {
		System.out.println("this is from add6");
	}
	
	
	
}

//if @BeforeMethod fails all test methods gets skipped
//@prority is used to prioritize method or else method execute based on alphabetic order

