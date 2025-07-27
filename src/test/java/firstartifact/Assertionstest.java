package firstartifact;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertionstest {

	
	@Test
	public void stringequals() {
		String s1="vaishnavi";
		String s2="vaishnavi";
		String s3="coldplay";
		Assert.assertEquals(s1, s2,"should be equal");
		Assert.assertNotEquals(s1, s3,"should not be equal");
	}
	
	@Test
	public void arrayequal() {
		int[] a= {1,11,2,22};
		int[] b= {1,11,2,22};
		Assert.assertEquals(a, b);
	}
	
	@Test
	public void assertchecktrueorfalse() {
		boolean isthere=true;
		boolean isnotthere=false;
		Assert.assertTrue(isthere);
		// Assert.assertFalse(isthere); //it fails
		Assert.assertFalse(isnotthere);
	}
	
	
	@Test
	public void checknullornot() {
		Object obj=null;
		Object obj2="qwerty";
		Assert.assertNull(obj);
		// fails Assert.assertNotNull(obj);
		Assert.assertNotNull(obj2);
		// fails Assert.assertNotNull(obj);
	}
	
	@Test
	public void sameornot() {
		String s1=new String("coldplay");
		String s2="coldplay";
		String s3=s1;
		Assert.assertEquals(s1, s2); //same string value
		//fails Assert.assertSame(s1, s2); //2 diff object which has diff reference
	}
}
