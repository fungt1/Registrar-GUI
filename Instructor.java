package v1;

public class Instructor extends Person{
	
	public Instructor(Integer id, String lastName) {
		super(id, lastName);
		// TODO Auto-generated constructor stub
	}


	private String department;
		
	/**
	 * getters and setters
	 *
	 */
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	/**
	 * Overrides superclass (Person) display method, in order to display department as well as other shared fields
	 * 
	 */
	
	public void display()
	{
		super.display();
		System.out.println(getDepartment());
	}
}

