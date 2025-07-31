package firstartifact;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


public class Xmlparameter {

	@Test
	@Parameters({"username", "passwrd"})
	public void logintest(String username, String passwrd) {
		System.out.println("login details-----");
		System.out.println("userid---"+username);
		System.out.println("password--"+passwrd);
	}
	
	@Test(dependsOnMethods = "logintest")   //if we put simple @Test then connection execute first and then logintest
	@Parameters({"url","timeout"})
	public void connection(String url, int timeout) {
		System.out.println("connecting to server----");
		System.out.println("url---"+url);
		System.out.println("timeout---"+timeout);
	}
	
	
}
