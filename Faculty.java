package v1;
import java.util.ArrayList;

public class Faculty {
	protected ArrayList <Instructor> professors = new ArrayList<Instructor>();
	
	public ArrayList <Instructor> getProfessors(){
		return professors;
	}
	
	public void addInstructor(Instructor newProfessor){
		professors.add(newProfessor);
	}
}
