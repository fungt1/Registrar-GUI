package v1;

public class Course {
	protected String courseNumber;
	protected String title;
	protected Department department;
	
	public Course (String courseNumber, String title, Department department){
		this.courseNumber = courseNumber;
		this.title = title;
		this.department = department;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getDepartment() {
		return department.toString();
	}
}
