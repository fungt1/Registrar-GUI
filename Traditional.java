package v1;
import java.util.ArrayList;

public class Traditional extends Section {
	public Traditional(Course course) {
		super(course);
		
	}

	protected ArrayList <TimeSlot> meetingTimes = new ArrayList<TimeSlot>();
	protected String classTimes = "";

	/**
	 * calls the method the loops through the collection of meeting times 
	 * to display a readable representation of the schedule
	 */
	@Override
	public String getSchedule() {
		return showMeetingTimes();
	}
	
	/**
	 * provides access to the ArrayList that contains the time slots for class meeting
	 * @return the collection of interest
	 */
	public ArrayList getMeetingTimes(){
		return meetingTimes;
	}
	/**
	 * iterates through the collection (of size 2) of meeting times 
	 * @return a string representation of the times during which the class will meet
	 */
	
	public String showMeetingTimes(){
		for (TimeSlot t: meetingTimes){
			classTimes += (t.toString()+ " & ");
		}
		return classTimes;
	}
	/**
	 * This method sets the schedule of the class
	 * @param time1, the first time slot during which the class will meet
	 * @param time2, the second time slot during which the class will meet
	 */
	public void setTimeSlots(TimeSlot time1, TimeSlot time2){
		meetingTimes.add(time1);
		meetingTimes.add(time2);
	}

	/**
	 * this is somewhat of a dummy method. The conditional check following its calling
	 * on a traditional section will always evaulate to true. it was added for the sake
	 *  of simplifying the code of the button listener in the GUI. adding this method
	 * to this subclass and making it abstract in the Section super class allowed us 
	 * to avoid a lot of code duplication in the listener. 
	 */
	@Override
	public int validateChoice() {
		return 1;
	}
}
