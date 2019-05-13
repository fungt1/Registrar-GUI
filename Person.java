package v1;

import java.util.regex.*;
import java.util.HashMap;
public class Person {
	
	// forgot to get rid of all the extra code from University. 
	// apologies
	protected Integer id;
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String email;
	protected String ssn;
	protected Integer age;
	protected static Integer oldestAge = -1;
	
	public Person (Integer id, String lastName){
		this.id = id;
		this.lastName = lastName;
	}
	
	/**
	 * Getters and Setters for all fields except id
	 * 
	 */
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Integer getAge(){
		return age;
	}
	public void setAge(Integer age){
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	
	/**
	 * Generates a String corresponding to the full name of the person
	 * @return A string containing the first, middle, and last name, separated by a space
	 */
	
	public String toString(){
		
		return (firstName + " " + middleName + " " + lastName);
		
	}
	
	/**
	 * substrings the email at the @ symbol in order to isolate the domain of the account
	 * @return the string corresponding to the email domain
	 */
	
	public String getEmailDomain(){
		int index = email.indexOf("@");
		return email.substring(index + 1);		
	}
	
	/**
	 * substrings the input social security number in order to return the last 4 digits
	 * @return the string containing the last four digits
	 */
	
	public String getLast4SSN(){
		return ssn.substring(7);
	}
	
	/**
	 * Validity check for the input age. Makes sure value is 16 or larger
	 * @param age, the age of the person as entered
	 * @return true of false, depending on whether or not the age is valid
	 */
	
	public static boolean isAgeValid(Integer age){

		if (age > 16 )
			return true;
		else
			return false;
	}
	
	/**
	 * Validity check for the input email. Makes sure it contains 1 and only one @ symbol, and that the . character, of which
	 * there must be at least one, follows the @
	 * @param email, the email as input by the user
	 * @return true or false, depending on whether or not the email is valid
	 */
	
	public static boolean isEmailValid(String email){
		if (email.contains("@")){
		int i = email.indexOf("@");
		String trimmed = email.substring(i+1);
		
		if (email.contains(".") && (email.indexOf("@") < email.indexOf(".")) && !(trimmed.contains("@")))
			return true;
		}
			return false;		
	}
	
	/**
	 * Validity check for the input ssn. The regular expression used makes sure 9 digits are entered in the correct format
	 * @param ssn, the ssn as input by the user
	 * @return true or false, depending on whether or not the ssn is valid
	 */
	
	public static boolean isSsnValid(String ssn){
		
		if (Pattern.matches("^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$", ssn))
			return true;
		else
			return false;
		
	}
	
	/**
	 * Displays the full name, type, email domain, last 4 digits of ssn, and whether or not the person is the oldest at 
	 * the University
	 */
	
	public void display()
	{
		System.out.println("");
		System.out.println(toString());
		System.out.println(getClass().getSimpleName());
		System.out.println(getEmailDomain());
		System.out.println(getLast4SSN());
		if (getAge() == oldestAge){
			System.out.println("Oldest at University");
		}
		else{
			System.out.println("Not Oldest at University");
			}
		}
	
	/**
	 * Set the oldest age of anyone at the university
	 * @param age, the age of the oldest individual
	 */
	
	public static void setOldestAge(int age){
		oldestAge = age;
	}
		
	}
	
	
		

			
		
	
		


