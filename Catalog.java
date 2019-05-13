package v1;
import java.util.ArrayList;

public class Catalog {
	protected ArrayList <Course> courses = new ArrayList<Course>();
	
	public ArrayList<Course> getCourses(){
		return courses;
	}
	
	public void addCourse(Course newCourse){
		courses.add(newCourse);
	}
}
