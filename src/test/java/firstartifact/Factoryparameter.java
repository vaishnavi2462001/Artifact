package firstartifact;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class Factoryparameter {

	
	@Test
	@Factory
	public Object[] createobj() {
	return new Object[] {
		new FactoryTest("chrome1"),
	    new FactoryTest("chrome2"),
	    new FactoryTest("chrome3"),
	};
}
}
