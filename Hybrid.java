package v1;

import javax.swing.JOptionPane;

public class Hybrid extends Section {
	
	protected TimeSlot meetingTime;
	
	public Hybrid(Course course) {
		super(course);		
	}
	
	/**
	 * @return a string representation of the classes meeting time
	 */
	@Override
	public String getSchedule() {
		return meetingTime.toString();
		
	}
	
	/**
	 * creates a confirm dialog box to validate that the user wants an online course
	 * @return either 1 (yes) or -1(no or cancel). The listener for registration
	 * only finishes execution of the output from this method is 1
	 */
	
	public int validateChoice(){
		int value;
		value = JOptionPane.showConfirmDialog(null, "Hybrid classes require online connectivity."
				+ "\n" + "Are you sure you want to register for this class?");
		if(value == JOptionPane.YES_OPTION){
			return 1;
		}
		else{
			return -1;
		}
		
	}
	
	/**
	 * setter for the meeting time of the class
	 * @param meetingTime, the time slot during which the class will meet
	 */
	public void setMeetingTime(TimeSlot meetingTime){
		this.meetingTime = meetingTime;		//move to constructor? overload?
	}
}
