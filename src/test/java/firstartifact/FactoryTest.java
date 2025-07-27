package firstartifact;

import org.testng.annotations.Test;

public class FactoryTest {

	private String browser;
	
	public FactoryTest(String browser) {
		this.browser=browser;
	}
	
	@Test
	public void testbrowser() {
		System.out.println("testing browser method---"+browser);
	}
	
	
	@Test
	public void testspecificfeature() {
		System.out.println("testing specific browser feature---"+browser);
	}
	
	
}
