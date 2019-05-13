package v1;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class TimeSlot {
	/**
	 * this is the class used for creating meeting times for the 
	 * available sections. Employs DayOfWeek and local time
	 */
	protected DayOfWeek weekDay;
	protected LocalTime startTime;
	protected LocalTime endTime; 
	
	/**
	 * constructor for instances of time slot. Each end time is 50 minutes after
	 * the start time
	 * @param weekDay, the day of the week for the time slot
	 * @param startTime, the start of the time slot
	 */
	
	public TimeSlot(DayOfWeek weekDay, LocalTime startTime){
		this.weekDay = weekDay;
		this.startTime = startTime;
		endTime = startTime.plusMinutes(50);
	}
	
	/**
	 * overrides the method inherited from Object. returns a legible representation
	 * of the time slot. 
	 */
	public String toString(){
		return weekDay.toString() + " " + startTime.toString() + " to " + endTime.toString();
	}
}
