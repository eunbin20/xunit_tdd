package xunit;

public class xUnitTest {
	public static void main(String[] args) {
		TestSuite suite = TestCaseTest.suite();
		TestResult result  = new TestResult();
		suite.run(result);
		System.out.println(result.getSummary());
		
		TestSuite suite2 = new TestSuite();
		suite2.add(new TestCaseTest("testTemplateMethod"));
		suite2.add(suite);
		suite2.add(suite);
		suite2.add(suite);
		TestResult result2 = new TestResult();
		suite2.run(result2);
		System.out.println(result2.getSummary());
		
	}
}
