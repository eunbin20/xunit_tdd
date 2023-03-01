package xunit;

public class TestResult {
	int runCount = 0;
	int errorCount = 0;
	
	public void testStarted() {
		runCount++;
	}
	
	public void testFailed() {		
		errorCount++;
	};
	
	public String getSummary() {
		return runCount + " run, " +  errorCount +   " faild";
	}

}
