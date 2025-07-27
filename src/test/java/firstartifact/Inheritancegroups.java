package firstartifact;
import org.testng.annotations.Test;



	@Test(groups= {"base-group"})
	class Basetest{
	public void parentmethod() {
		System.out.println("parent method runs in base group");
	}
}

	public class Inheritancegroups extends Basetest {
	
		@Test
		public void childmethod() {
			System.out.println("child method also in base group due to inheritgroups=true");
		}
		
	}
	