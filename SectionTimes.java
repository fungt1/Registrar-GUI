package v1;
import java.util.ArrayList;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class SectionTimes {
	
	/**
	 * essentially just an array list of all the time slots available for
	 * class meetings. populated in the driver
	 */
	protected ArrayList <TimeSlot> timeSlots = new ArrayList <TimeSlot>();
	
	public ArrayList<TimeSlot> getTimeSlots(){
		return timeSlots;
	}
	
	public void addTimeSlot(TimeSlot timeSlot){
		timeSlots.add(timeSlot);
	}
}

	