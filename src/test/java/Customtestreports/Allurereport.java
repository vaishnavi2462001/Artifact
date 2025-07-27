package Customtestreports;

import org.testng.ITestListener;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Reporting Tests")
@Feature("Basic Math Operations")
public class Allurereport implements ITestListener{
	@Test
	@Story("Addition Operation")
	@Description("This test verifies basic addition functionality")
	@Severity(SeverityLevel.CRITICAL)
	public void testAddition() {
		Assert.assertEquals(2 + 2, 4, "Addition test failed");
	}

	@Test
	@Story("Subtraction Operation")
	@Description("This test verifies basic subtraction functionality")
	@Severity(SeverityLevel.NORMAL)
	public void testSubtraction() {
		Assert.assertEquals(5 - 3, 2, "Subtraction test failed");
	}

	@Test
	@Story("Division Operation")
	@Description("This test verifies division by zero handling")
	@Severity(SeverityLevel.BLOCKER)
	public void failingTest() {
		Assert.assertEquals(10 / 0, 1, "This test should fail");
	}
}
