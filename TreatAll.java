//TO DO: Finish this!

class TreatAll extends Scenario {
	//******************************************************
	//*******  DO NOT EDIT ANYTHING IN THIS SECTION  *******
	//******************************************************
	
	/**
	 *  The time to administer a treatment regimen.
	 */
	protected final int treatmentTime;
	
	/**
	 *  The line for treatment.
	 */
	protected Line<Person> treatmentLine = new Line<>();
	
	/**
	 * Accepts the treatment time.
	 * 
	 * @param treatmentTime the time to administer a treatment regimen
	 */
	public TreatAll(int treatmentTime) {
		this.treatmentTime = treatmentTime;
	}
	
	/**
	 *  Allows the GUI access to the treatment line.
	 *  
	 *  @return the treatment line
	 */
	public Line<Person> getTreatmentLine() {
		return treatmentLine;
	}
	
	//******************************************************
	//*******         MAKE YOUR CHANGES BELOW        *******
	//******************************************************
	
    // You may NOT add any arrays as a member variable in this class 
	private int remainingTreatmentTime;
	public int getPending() {
		//see comments in Scenario.java
		
		//O(1)
		
		return treatmentLine.getSize(); //replace this default return!
	}
	
	public void addPerson(Person p) {
		//add a person to the back of the treatment line
		treatmentLine.add(p,treatmentLine.getSize());
		//if they are the only person in line, they should
		//start being treated!
		if (remainingTreatmentTime == 0 || treatmentLine.getSize() == 1) {
			remainingTreatmentTime = treatmentTime;
		}
	}
	
	public void tick() {
		//handle any deaths in line
		for (int i = 0; i < treatmentLine.getSize(); i++) {
			treatmentLine.get(i).tick();
			if (treatmentLine.get(i).isDead()) {
				treatmentLine.remove(i);
			}
			if ((remainingTreatmentTime == 0 && treatmentLine.getSize() != 0) || treatmentLine.get(i).isDead()) {
				treatmentLine.remove(0);
				remainingTreatmentTime = treatmentTime;
			}


		}
		//handle treatment being administered
		remainingTreatmentTime--;





		//handle person successfully treated

		//Don't forget... if the first person in line dies (the person being treated)
		//start the next person's treatment!
	}
	
	public String toString() {
		//Replace "??" with the number of minutes until the doctor is free
		//i.e. the treatment time remaining
		String s = String.format("Scenario 1: Doctor Free in " + "%d" + " minute(s).",remainingTreatmentTime);
		return s;
	}
}