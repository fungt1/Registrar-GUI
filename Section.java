package v1;

public abstract class Section {

	protected Integer crn;
	protected Integer numberOfSections = 0;
	protected Course course;
	protected Instructor instructor;
	
	public Section(Course course){
		this.course = course;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public Integer getCrn(){
		return crn;
	}
	
	public void setCrn(Integer crn){
		this.crn = crn;
	}
	
	/**
	 * below are two methods implemented by each of the three subclasses (hybrid, 
	 * traditional, and online)
	 * 
	 */
	public abstract String getSchedule();
	public abstract int validateChoice();
	
}
