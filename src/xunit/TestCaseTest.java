package xunit;

public class TestCaseTest extends TestCase {

	public TestCaseTest(String name) {
		super(name);
	}	
	
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.add(new TestCaseTest("testTemplateMethod"));
		suite.add(new TestCaseTest("testResult"));
		suite.add(new TestCaseTest("testFailedResultFormatting"));
		suite.add(new TestCaseTest("testFailedResult"));
		suite.add(new TestCaseTest("testSuite"));
		return suite;
	}
	
	public void testTemplateMethod () {
		WasRun wasRun = new WasRun("testMethod");
		TestResult result = new TestResult();
		wasRun.run(result);
		Assert.assertEquals("setUp testMethod tearDown", wasRun.log);
	}
	
	public void testResult() {
		WasRun wasRun = new WasRun("testMethod");
		TestResult result = new TestResult();
		wasRun.run(result);
		Assert.assertEquals("1 run, 0 faild", result.getSummary());		
	}
	
	public void testFailedResultFormatting() {
		TestResult result = new TestResult();
		result.testStarted();
		result.testFailed();
		Assert.assertEquals("1 run, 1 faild", result.getSummary());	
	}
	
	public void testFailedResult() {
		WasRun wasRun = new WasRun("testBrokenMethod");
		TestResult result = new TestResult();
		wasRun.run(result);
		Assert.assertEquals("1 run, 1 faild", result.getSummary());
	}
	
	public void testSuite() {
		TestSuite suite = new TestSuite();
		suite.add(new WasRun("testMethod"));
		suite.add(new WasRun("testBrokenMethod"));
		TestResult result = new TestResult();
		suite.run(result);
		Assert.assertEquals("2 run, 1 faild", result.getSummary());
	}
}
