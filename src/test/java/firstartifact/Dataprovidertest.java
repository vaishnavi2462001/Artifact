package firstartifact;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


public class Dataprovidertest {
	
	@DataProvider(name="login data")
	public Object[][] providingdata(){
			return new Object[][] {
					{"vaish1","passwd1"},
					{"vaish2","passwd2"},
					{"vaish3","passwd3"},
	};
	}
	
	
	@DataProvider(name="diff login data")
	public Object[][] providingdiffdata(){
		return new Object[][] {
			{"coldplay",123,true},
			{"scandal",456,false},
			{"jermaiah",789,true}
		};
	}
	
	@Test(dataProvider="login data")
	public void login(String username, String password) {
		System.out.println(username+":"+password);
	}
	
	@Test(dataProvider="diff login data")
	public void mullogin(String username,int password,boolean present) {
		System.out.println(username+":"+password+"-"+present);
	}
	
	
	
	//use xml file as a parameter passing using testtestng.xml file
	@Test
	@Parameters({"username", "password"})
	public void login2(String username, String password) {
		System.out.println("username -- "+username);
		System.out.println("password --"+password);
	}
	
	
	
	//data provider in separate class
	@DataProvider(name="externaluserdata")
	public static Object[][] userdata(){
	return new Object[][] {
		{"vaish", "navi1", "admin"},
		{"akc","navi2","user"},
		{"kush","navi3","guest"}
	};
	}
	
	@Test(dataProvider="externaluserdata", dataProviderClass=Dataprovidertest.class)  //Dataprovidertest is this file class name
	public void testexternaldata(String username, String navinumber, String role) {
		System.out.println("Usernamee---"+username);
		System.out.println("navinumberr---"+navinumber);
		System.out.println("rolee--"+role);
	}
}
