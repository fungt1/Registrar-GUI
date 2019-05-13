package v1;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

/**
 * Registrar Project
 * @author Tyler Fung
 *@version v1, completed 11/14/16
 */

public class Driver {
	
	protected static Integer crn = 40001;
	
	public static void main(String[] args) {

		// Build the objects needed to represent the registration process
		
		Catalog catalog = new Catalog();
		Term term = new Term("Spring 2017");  // change to the current term
		Faculty faculty = new Faculty();
		SectionTimes sectionTimes = new SectionTimes(); 
		Student student = new Student(1, "Fung");// change to your last name
		RegistrarGUI gui = new RegistrarGUI(student, term); //instantiate GUI
				
		// Populate these objects
		createInstructors(faculty);  // Send the faculty object to method for instructor population
		createCourses(catalog);	     // Send the catalog object to method for course population
		createSectionTimes(sectionTimes); //send the section times objects to the method for section time population
		generateSections(term, catalog);	//create traditional, online, and hybrid for each course
		specifySections(term, faculty, sectionTimes);	//randomly assign instructors and time slots for each section
		generateCRNs(term);	//generate a crn for each section, starting with 40001
	}

	private static void createInstructors(Faculty faculty) {
		faculty.addInstructor(new Instructor(101, "Johnson"));
		faculty.addInstructor(new Instructor(102, "Kay"));
		faculty.addInstructor(new Instructor(103, "Xu"));
		faculty.addInstructor(new Instructor(104, "Mulligan"));
		faculty.addInstructor(new Instructor(105, "Muldoon"));
		faculty.addInstructor(new Instructor(106, "Stanzione"));
		faculty.addInstructor(new Instructor(107, "Brady"));
		faculty.addInstructor(new Instructor(108, "Sawyer"));
		faculty.addInstructor(new Instructor(109, "Brown"));
		faculty.addInstructor(new Instructor(110, "Harrison"));
		faculty.addInstructor(new Instructor(111, "Ford"));
		faculty.addInstructor(new Instructor(112, "Danzinger"));
		faculty.addInstructor(new Instructor(113, "Clarke"));
		faculty.addInstructor(new Instructor(114, "Abraham"));
		faculty.addInstructor(new Instructor(115, "Perkowski"));
		faculty.addInstructor(new Instructor(116, "Brando"));
	}
	
	private static void createCourses(Catalog catalog) {
		catalog.addCourse(new Course("ART 01.101", "Art Appreciation", Department.ART));	
		catalog.addCourse(new Course("ART 01.201", "Painting with Oils", Department.ART));
		catalog.addCourse(new Course("ART 01.202", "Painting with Water Colors", Department.ART));
		catalog.addCourse(new Course("BIOL 01.110", "Genetics", Department.BIOLOGY));
		catalog.addCourse(new Course("BIOL 04.301", "Anatomy and Physiology", Department.BIOLOGY));		
		catalog.addCourse(new Course("CHEM 01.101", "Introduction to Chemistry", Department.CHEMISTRY));
		catalog.addCourse(new Course("CHEM 01.201", "Organic Chemistry", Department.CHEMISTRY));
		catalog.addCourse(new Course("CHEM 01.301", "Analytical Chemistry", Department.CHEMISTRY));
		catalog.addCourse(new Course("CSC 04.114", "Object Oriented Programming", Department.COMPUTER_SCIENCE));
		catalog.addCourse(new Course("CSC 04.301", "Human Computer Interaction", Department.COMPUTER_SCIENCE));
		catalog.addCourse(new Course("CSC 07.211", "Artificial Intelligence", Department.COMPUTER_SCIENCE));
		catalog.addCourse(new Course("CSC 04.370", "Software Engineering", Department.COMPUTER_SCIENCE));
		catalog.addCourse(new Course("CSC 04.210", "Data Structures and Algorithms", Department.COMPUTER_SCIENCE));
		catalog.addCourse(new Course("ECON 01.101", "Microeconomics", Department.ECONOMICS));
		catalog.addCourse(new Course("HIS 01.101", "Western Civilization", Department.HISTORY));
		catalog.addCourse(new Course("HIS 01.331", "Civil Wars", Department.HISTORY));
		catalog.addCourse(new Course("MUS 01.214", "The Genres of Rock Music", Department.MUSIC));
		catalog.addCourse(new Course("PHIL 01.111", "Ethics", Department.PHILOSOPHY));
		catalog.addCourse(new Course("PHIL 01.221", "Existentialism", Department.PHILOSOPHY));
		catalog.addCourse(new Course("PHY 02.121", "Introduction to Mechanics", Department.PHYSICS));
		catalog.addCourse(new Course("PSY 04.114", "Abnormal Psychology", Department.PSYCHOlOGY));		
	}	
	
	// I realized shortly after writing the following method that a for loop
	// would have done the job in about 1/20th of the lines. don't judge me
	/**
	 * Adds the required time slots to the list of available sectio times
	 * employs the LocalTime and DayOfWeek classes
	 * is embarassingly ham fisted. I would clean it up but it's 2:30 am
	 * @param sectionTimes, an Object containg an Array List of timeslots
	 */
	public static void createSectionTimes (SectionTimes sectionTimes){
		LocalTime eight = LocalTime.of(8, 0);
		LocalTime nine = LocalTime.of(9, 0);
		LocalTime ten = LocalTime.of(11, 0);
		LocalTime eleven = LocalTime.of(11, 0);
		LocalTime twelve = LocalTime.of(12, 0);
		LocalTime thirteen = LocalTime.of(13, 0);
		LocalTime fourteen = LocalTime.of(14, 0);
		LocalTime fifteen = LocalTime.of(15, 0);
		LocalTime sixteen = LocalTime.of(16, 0);
		LocalTime seventeen = LocalTime.of(17, 0);
		LocalTime eighteen = LocalTime.of(18, 0);		
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.MONDAY, eight)); //nullpointer
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.MONDAY, nine));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.MONDAY, ten));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.MONDAY, eleven));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.MONDAY, twelve));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.MONDAY, thirteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.MONDAY, fourteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.MONDAY, fifteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.MONDAY, sixteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.MONDAY, seventeen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.MONDAY, eighteen));
		
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.TUESDAY, eight));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.TUESDAY, nine));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.TUESDAY, ten));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.TUESDAY, eleven));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.TUESDAY, twelve));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.TUESDAY, thirteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.TUESDAY, fourteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.TUESDAY, fifteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.TUESDAY, sixteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.TUESDAY, seventeen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.TUESDAY, eighteen));
		
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, eight));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, nine));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, ten));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, eleven));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, twelve));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, thirteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, fourteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, fifteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, sixteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, seventeen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.WEDNESDAY, eighteen));
		
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.THURSDAY, eight));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.THURSDAY, nine));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.THURSDAY, ten));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.THURSDAY, eleven));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.THURSDAY, twelve));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.THURSDAY, thirteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.THURSDAY, fourteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.THURSDAY, fifteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.THURSDAY, sixteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.THURSDAY, seventeen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.THURSDAY, eighteen));
		
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.FRIDAY, eight));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.FRIDAY, nine));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.FRIDAY, ten));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.FRIDAY, eleven));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.FRIDAY, twelve));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.FRIDAY, thirteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.FRIDAY, fourteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.FRIDAY, fifteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.FRIDAY, sixteen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.FRIDAY, seventeen));
		sectionTimes.addTimeSlot(new TimeSlot(DayOfWeek.FRIDAY, eighteen));
	}
	
	/**
	 * Generates one of each type of section per course. adds to the term's array list
	 * @param term, the current term
	 * @param catalog, containing the array list of available courses
	 */
	public static void generateSections(Term term, Catalog catalog){
		for(Course c: catalog.getCourses()){
			Online o = new Online(c);
			term.getSections().add(o);
			Hybrid h = new Hybrid(c);
			term.getSections().add(h);
			Traditional t = new Traditional(c);
			term.getSections().add(t);
		}
	}
	
	/**
	 * uses Random to randomly assign instructors and meeting times to
	 * classes, as necessary (i.e., no meeting times for online)
	 * @param term, the current term
	 * @param faculty, for its array list of instructors
	 * @param sectionTimes, for its array list of available time slots
	 */
	public static void specifySections(Term term, Faculty faculty, SectionTimes sectionTimes){
		Random rand = new Random();
		
		for(Section s: term.getSections()){
			Integer profRandom = rand.nextInt(faculty.getProfessors().size());
			Integer secRandom = rand.nextInt(sectionTimes.getTimeSlots().size());
			Integer secRandom2 = rand.nextInt(sectionTimes.getTimeSlots().size());
			s.setInstructor(faculty.getProfessors().get(profRandom));
			if(s.getClass().getSimpleName().equals("Traditional")){
				Traditional t = (Traditional) s;	//cast if instance is traditional
				t.setTimeSlots(sectionTimes.getTimeSlots().get(secRandom), 
						sectionTimes.getTimeSlots().get(secRandom2));
			}
			else if(s.getClass().getSimpleName().equals("Hybrid")){
				Hybrid h = (Hybrid) s;
				h.setMeetingTime(sectionTimes.getTimeSlots().get(secRandom));
			}			
		}	
	}
	
	/**
	 * Assigns a crn to each course. Goes through the collection of sections in order.
	 * Random enough if you ask me. 
	 * @param term, the current term
	 */
	public static void generateCRNs (Term term){
		for(Section s: term.getSections()){
			s.setCrn(crn);
			crn++;
		}
	}
}
