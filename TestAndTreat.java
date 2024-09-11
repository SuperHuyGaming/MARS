//TO DO: Finish this!

// You may NOT add any arrays as a member variable in this class

// You MAY add an import to java.util.Comparable if
// you are making the Person class Comparable. 
// No other imports are allowed.

class TestAndTreat extends TreatAll {
	//extend the TreatAll class to work for the test-and-treat scenario
	//you might want to use a similar model
	
	public TestAndTreat(int testingTime, int treatmentTime) {
		super(treatmentTime); //replace this default!
	}
	Line<Person> testingLine = new Line<>();
	public Line<Person> getTestingLine() {
		return testingLine;
//		return ; //replace this default return!
	}
	
	public String toString() {
		//Replace "??" with the time until the next test is available and
		//the number of minutes until the doctor is free
		return "Scenario 2: Test available in " + "??" + " minute(s). Doctor Free in " + "??" + " minute(s).";
	}
}