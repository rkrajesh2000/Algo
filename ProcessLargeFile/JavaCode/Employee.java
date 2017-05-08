package Algo.Test;


/**
 * This is is Employee class and it would be use as data transfer object.
 * @author Rajesh Kumar
 *
 */
public class Employee {
	private String fName;
	private String lName;
	private String gender;
	private double salary;
	
	
    /**
     * Public constructor to initialize the local member variables
     * @param fName
     * @param lName
     * @param gender
     * @param salary
     */
    public Employee(String fName, String lName, String gender, double salary) {
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.salary = salary;        
    }
    
    /**
     * Getter for First name
     * @return
     */
    public String getFirstName() {
        return fName;
    }

    /**
     * Getter for Last Name
     * @return
     */
    public String getLastName() {
    	return lName;
    }
    
    /**
     * Getter for Gender
     * @return
     */
    public String getGender() {
    	return gender;
    }

    /**
     * Getter for Salary
     * @return
     */
    public double getSalary() {
    	return salary;
    }    
}
