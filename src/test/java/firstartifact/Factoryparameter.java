package firstartifact;
import org.testng.annotations.Factory;

public class Factoryparameter {

	
	@Factory
	public Object[] createobj() {
	return new Object[] {
		new FactoryTest("chrome1"),
	    new FactoryTest("chrome2"),
	    new FactoryTest("chrome3"),
	};
}
}
