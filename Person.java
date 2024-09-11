//TO DO: Add JavaDocs

//********************************************************
//*******  DO NOT EDIT ANYTHING BELOW THIS LINE    *******
//*******        EXCEPT TO ADD JAVADOCS            *******
//*******                                          *******
//*******   YOU MAY CHANGE THE toString() method   *******
//*******     OR IMPLEMENT Comparable<Person>      *******
//*******   (IF YOU WOULD FIND HELPFUL TO DO SO)   *******
//********************************************************

/**
 * This class records the ID of a person.
 */
class Person {
    /**
     *
     */
    private static int numPeople = 0;
    /**
     *
     */
    private double testResult;
    /**
     *
     */

    private int timeLeft;
    /**
     *
     */

    private boolean isDead;
    /**
     *
     */
    private final int id;

    /**
     * This is a constructor recording NEW a person's ID, time left to survive and test results.
     *
     * @param testResult the test result whether the person is infected or not
     * @param timeLeft   time alive left of a person
     */

    public Person(double testResult, int timeLeft) {
        this.testResult = testResult;
        this.timeLeft = timeLeft;
        this.id = numPeople++;
    }

    /**
     * This records a person's updated condition.
     *
     * @param testResult the test result whether the person is infected or not
     * @param timeLeft   time alive left of a person
     * @param id         person's ID
     */
    private Person(double testResult, int timeLeft, int id) {
        this.testResult = testResult;
        this.timeLeft = timeLeft;
        this.id = id;
    }

    /**
     * This method reduces timeLeft of a person by 1 minute.
     */
    public void tick() {
        if (timeLeft != Integer.MAX_VALUE) timeLeft--;
    }

    /**
     * Check if the person is dead by comparing if timeLeft <= 0.
     *
     * @return True if the person is dead
     */
    public boolean isDead() {
        return timeLeft <= 0;
    }

    /**
     * This method gets the test result of a person.
     *
     * @return the test result of infection of a person
     */
    public double getTestResult() {
        //Note: test result is created when person is created,
        //but shouldn't be accessed until the person has been
        //through the testing line in scenario 2
        return testResult;
    }

    /**
     * This method gets a person's ID.
     *
     * @return a person's ID
     */
    public int getId() {
        return id;
    }

    /**
     * this method creates a new person with same testResult, timeLeft, and ID.
     *
     * @return a new person.
     */

    public Person clone() {
        return new Person(testResult, timeLeft, id);
    }

    /**
     * Prints out the information whether the person is infected or not
     *
     * @return a description of a person whether they are infected.
     */
    public String toString() {
        return "ID: " + id + ", " + ((timeLeft == Integer.MAX_VALUE) ? "Not Infected" : "Time Left: " + timeLeft + " minutes");
    }
}