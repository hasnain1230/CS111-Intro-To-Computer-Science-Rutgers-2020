package edu.Rutgers.IntroToCS111.Assignment7;

import java.util.Arrays;

/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author:
 *
 *************************************************************************/

public class HeartTransplant {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    /* ------ Constructor  -------- */
    
    /*
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {
        this.listOfPatients = null;
        this.survivabilityByAge = null;
        this.survivabilityByCause = null;
    }

    /* ------ Methods  -------- */

    /*
     * Inserts Person p into listOfPatients
     * 
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) {
        try {
            this.listOfPatients[arrayIndex] = p;
            return 0;
        } catch (ArrayIndexOutOfBoundsException exception) {
            return -1;
        }
    }

    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {
        this.listOfPatients = new Person[numberOfLines];
        StdIn.readLine(); // Seriously? Whatever.

        for (int x = 0; x < this.listOfPatients.length; x++) {
            String[] currentLineData = StdIn.readLine().split("\\s+");
            this.listOfPatients[x] = new Person(Integer.parseInt(currentLineData[0]), Integer.parseInt(currentLineData[1]),
                    Integer.parseInt(currentLineData[2]), Integer.parseInt(currentLineData[3]),
                    Integer.parseInt(currentLineData[4]), Integer.parseInt(currentLineData[5]),
                    Integer.parseInt(currentLineData[6]));
        }
        return listOfPatients.length;
    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {
        this.survivabilityByAge = new SurvivabilityByAge[numberOfLines];
        StdIn.readLine();

        for (int x = 0; x < this.survivabilityByAge.length; x++) {
            String[] currentLineData = StdIn.readLine().trim().split("\\s+");
            this.survivabilityByAge[x] = new SurvivabilityByAge(Integer.parseInt(currentLineData[0]),
                    Integer.parseInt(currentLineData[1]), Double.parseDouble(currentLineData[2]));
        }

        return this.survivabilityByAge.length;
    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {
        this.survivabilityByCause = new SurvivabilityByCause[numberOfLines];
        StdIn.readLine();

        for (int x = 0; x < this.survivabilityByCause.length; x++) {
            String[] currentLineData = StdIn.readLine().split("\\s+");
            this.survivabilityByCause[x] = new SurvivabilityByCause(Integer.parseInt(currentLineData[0]),
                    Integer.parseInt(currentLineData[1]), Double.parseDouble(currentLineData[2]));
        }
        return this.survivabilityByCause.length;
    }
    
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with age above the parameter age.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) { // It would be much better to use an ArrayList for this method, but the assignment didn't specify if that was allowed.
        int amountOfPatientsOverAge = 0;
        for (Person patients : this.listOfPatients) {
            if (patients.getAge() > age) {
                amountOfPatientsOverAge++;
            }
        }

        if (amountOfPatientsOverAge == 0) {
            return null;
        }

        Person[] peopleOverTheAge = new Person[amountOfPatientsOverAge];
        int y = 0;

        for (Person patients : this.listOfPatients) {
            if (patients.getAge() > age) {
                peopleOverTheAge[y] = patients;
                y++;
            }
        }


        return peopleOverTheAge;
    }
    
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the state of health equal to the parameter state.
     * 
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) {
        int patientsInStateOfHealth = 0;
        for (Person patients : this.listOfPatients) {
            if (patients.getStateOfHealth() == state) {
                patientsInStateOfHealth++;
            }
        }

        if (patientsInStateOfHealth == 0) {
            return null;
        }

        Person[] stateOfHealth = new Person[patientsInStateOfHealth];
        int y = 0;

        for (Person patients : this.listOfPatients) {
            if (patients.getStateOfHealth() == state) {
                stateOfHealth[y] = patients;
                y++;
            }
        }


        return stateOfHealth;
    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) {
        int patientsWithCause = 0;
        for (Person patients : this.listOfPatients) {
            if (patients.getCause() == cause) {
                patientsWithCause++;
            }
        }

        if (patientsWithCause == 0) {
            return null;
        }

        Person[] causes = new Person[patientsWithCause];
        int y = 0;

        for (Person patients : this.listOfPatients) {
            if (patients.getCause() == cause) {
                causes[y] = patients;
                y++;
            }
        }


        return causes;
    }

    /*
     * Assume there are numberOfHearts available for transplantation surgery.
     * Also assume that the hearts are of the same blood type as the
     * persons on the listOfPatients.
     * This method finds a set of persons to be the recepients of these
     * hearts.
     * 
     * The method returns a Person array from the listOfPatients
     * array that have the highest potential for survivability after
     * the transplant. The array size is numberOfHearts.
     * 
     * If numberOfHeartsAvailable is greater than listOfPatients
     * array size all Persons will receive a transplant.
     * 
     * If numberOfHeartsAvailable is smaller than listOfPatients
     * array size find the set of people with the highest
     * potential for survivability.
     * 
     * There is no correct solution, you may come up with any set of
     * persons from the listOfPatients array.
     */ 
    public Person[] match(int numberOfHearts) { // We are not even allowed to touch ArrayLists, so I have to do it the long and hard way. :(
        /*
        This method will see if there are enough hearts available. If so, everyone gets a heart. If not, then it will see
        who needs the heart the most and who is in the worst condition and prioritize them. Then it will see who needs it the most
        and prioritize them. Then it will see who's health is the worst and prioritize them. Since not much is known about the patients,
        certain assumptions are made. Finally, if there are still hearts left over, we resort to the lottery system in which
        a random person will get the remaining hearts. There are many optimizations that could be made here to make things more robust
        (and using array lists), but the logic will stay the same. More data could be collected about the patients and those statistics
        could have been used. I could have used the survivability classes to make this more specific, but with being so limited in this assignment,
        this is the best elementary approach. More factors could have been considered and I am aware of that.
         */
        if (numberOfHearts >= this.listOfPatients.length) {
            return this.listOfPatients;
        } else {
            Person[] peopleWhoGetNumOfHearts = new Person[numberOfHearts];
            int patientsAddedToList = 0;
            for (int x = 0; x < this.listOfPatients.length; x++) {
                if (this.listOfPatients[x].getUrgency() == Person.URGENCY_EXTREME &&
                        this.listOfPatients[x].getStateOfHealth() == Person.HEALTH_POOR &&
                        patientsAddedToList < peopleWhoGetNumOfHearts.length) {
                    peopleWhoGetNumOfHearts[patientsAddedToList] = this.listOfPatients[x];
                    patientsAddedToList++;
                }
            }
            if (patientsAddedToList < peopleWhoGetNumOfHearts.length) {
                for (int x = 0; x < this.listOfPatients.length; x++) {
                    if (this.listOfPatients[x].getUrgency() == Person.URGENCY_EXTREME &&
                            patientsAddedToList < peopleWhoGetNumOfHearts.length) {
                        peopleWhoGetNumOfHearts[patientsAddedToList] = this.listOfPatients[x];
                        patientsAddedToList++;
                    }
                }
            }

            if (patientsAddedToList < peopleWhoGetNumOfHearts.length) {
                for (int x = 0; x < this.listOfPatients.length; x++) {
                    if (this.listOfPatients[x].getStateOfHealth() == Person.HEALTH_POOR &&
                            patientsAddedToList < peopleWhoGetNumOfHearts.length) {
                        peopleWhoGetNumOfHearts[patientsAddedToList] = this.listOfPatients[x];
                        patientsAddedToList++;
                    }
                }
            }

            if (patientsAddedToList < peopleWhoGetNumOfHearts.length) {
                while (patientsAddedToList < peopleWhoGetNumOfHearts.length) {
                    int randomPatient = (int) (Math.random() * this.listOfPatients.length);
                    for (Person priorityList : peopleWhoGetNumOfHearts) {
                        if (priorityList.equals(this.listOfPatients[randomPatient])) {
                            break;
                        } else {
                            peopleWhoGetNumOfHearts[patientsAddedToList] = priorityList;
                            patientsAddedToList++;
                        }
                    }
                }
            }

            return peopleWhoGetNumOfHearts;
        }
    }

    /*
     * Client to test the methods you write
     */
    public static void main (String[] args) {
        HeartTransplant ht = new HeartTransplant();
        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");

        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        // list all patients
        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        // list survivability by age rates
        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        // list survivability by cause rates
        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
            StdOut.println(rate);
        }
    }
}
