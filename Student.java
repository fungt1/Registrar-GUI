package v1;

import java.util.HashMap;

public class Student extends Person {
	
	private String major;
	private HashMap <Integer, Section> currentSections = new HashMap <Integer, Section>();
	
	public Student(Integer id, String lastName) {
		super(id, lastName);
	}
	/**
	 * Getters and setters
	  */
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * Overrides display method from superclass (Person) in order to display major as well as other shared fields
	 */
	
	public void display()
	{
		super.display();
		System.out.println(getMajor());
	}
	/**
	 * called when the user selects a section. Adds to the list and is 
	 * displayed in the feedback portion of the GUI
	 * @param section, the section to be added
	 */
	
	public void add(Section section){
		currentSections.put(section.getCrn(), section);
	}
	
	/**
	 * called when the user re-selects a section. removes the selection from the student's 
	 * list and from the feedback portion of the GUI
	 * @param section, the section being removed
	 */
	public void drop(Section section){
		currentSections.remove(section.getCrn());
	}
	
	/**
	 * returns the collection of sections for which the student is registered
	 * @return the HashMap containing the crn as keys and sections as values
	 */
	public HashMap<Integer, Section> getCurrentSections(){
		return currentSections;
	}
	
	public String getLastName(){
		return lastName;
	}
}
