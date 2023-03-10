package xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Test {
	List<Test> tests = new ArrayList<>();

	public void add(Test test) {	
		tests.add(test);
	}

	public void run(TestResult result) {		
		tests.forEach(t -> {
			t.run(result);
		});
	}
}
