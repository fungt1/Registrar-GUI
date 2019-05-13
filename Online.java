package v1;

import javax.swing.JOptionPane;

public class Online extends Section{

	public Online(Course course) {
		super(course);
		
	}
	
	/**
	 * returns the string "online", because remote classes have no meeting time
	 */
	@Override
	public String getSchedule() {
		return "Online";
		
	}
	
	/**
	 * creates a confirm dialog box to validate that the user wants an online course
	 * @return either 1 (yes) or -1(no or cancel). The listener for registration
	 * only finishes execution of the output from this method is 1
	 */
	
	public int validateChoice(){
		int value;
		value = JOptionPane.showConfirmDialog(null, "Remote classes require online connectivity and good time management skills" +
										"\n" + "Are you sure you want to register for this class?");
		if(value == JOptionPane.YES_OPTION){
			return 1;
		}
		else{
			return -1;
		}
	}
}
