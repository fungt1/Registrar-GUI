package v1;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
public class RegistrarGUI extends JFrame{	
	
	protected Term term;
	protected Student student;
	protected Dimension min = new Dimension(1200, 120);
	protected Dimension max = new Dimension(1200, 750);
	protected static Department[] departments = Department.values();
	protected static String[] departmentStrings = generateDepartmentStrings(departments);
	protected ArrayList<Section> matchingSections = new ArrayList<Section>();
	protected Integer sectionsFound = 0;
	protected Section sectionSelected;
	protected String displayString = "";
	protected Integer initialHeight = 120;
	protected String initial;
	
	protected JLabel lblDept = new JLabel("Select a Department");
	protected JComboBox<String> selectDept = new JComboBox<String>(departmentStrings);
	protected JLabel lblSouth = new JLabel("Matching Sections");
	protected JPanel pnlNorth = new JPanel();
	protected JPanel pnlSouth = new JPanel();
	
	protected JPanel pnlTop = new JPanel();		//label to add to pnl center(north)
	protected JPanel pnlSections = new JPanel();	//sections to add to pnl center(center)
	
	protected JPanel pnlCenter = new JPanel();
	
	// Controls for top row: column labels
	protected JLabel lblCrnTop = new JLabel("CRN");
	protected JLabel lblCourseNumTop = new JLabel("Course Number");
	protected JLabel lblTitleTop = new JLabel ("Title");
	protected JLabel lblInstructorTop = new JLabel("Instructor");
	protected JLabel lblScheduleTop = new JLabel("Schedule");
	
	/**
	 * Constructor for the user interface. 
	 * @param student
	 * @param term
	 */
	public RegistrarGUI(Student student, Term term){
		this.student = student;
		this.term = term;
		this.setTitle("Banner self service for " + student.getLastName());
		this.setUpFrame();
		this.setVisible(true);
	}
	/**
	 * Calls methods to add components/listeners to frame. Sets min/max sizes for controls
	 */
	public void setUpFrame() {
		this.setMinimumSize(min);
		this.setMaximumSize(max);
		pnlCenter.setMaximumSize(max);
		pnlSections.setMaximumSize(max);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());	
		this.addComponents();
		this.addActionListeners();
	}
	/**
	 * adds key controls to panels/frame
	 */
	public void addComponents(){
		pnlNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlCenter.setLayout(new BorderLayout());
		selectDept.setEditable(true);
		pnlNorth.add(lblDept);
		pnlNorth.add(selectDept);
		pnlSouth.add(lblSouth);
		this.add(pnlNorth, BorderLayout.NORTH);
		this.add(pnlSouth, BorderLayout.SOUTH);
		this.add(pnlCenter, BorderLayout.CENTER);
	}
	/**
	 * adds action listener for combo box only
	 * action listener for buttons added as button objects are added to pnlSections
	 */
	public void addActionListeners(){
		selectDept.addActionListener(departmentListener);
		//other listener added during button creation
	}
	
	/**
	 * action listener for the combo box. adds matching sections from
	 * term's array list to another array list, then creates adds the 
	 * information for each of those sections to pnlSections, which is in turn added to 
	 * pnlCenter, along with pnlTop (the label panel). Lblsouth and the size of 
	 * the frame are also updated based on the number of matching sections found
	 */
	
	ActionListener departmentListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String dept = selectDept.getSelectedItem().toString();
			pnlCenter.removeAll();
			pnlSections.removeAll();
			matchingSections.removeAll(matchingSections);
			sectionsFound = 0;
			if(selectDept.getSelectedItem() == "  "){
				System.out.println("Blank Selected");
				pnlCenter.setVisible(false);
				setSize(min);
				lblSouth.setText("Matching Sections");
			}
			else{
				pnlCenter.setVisible(true);
				pnlTop.setLayout(new GridLayout(1,5));
				pnlTop.add(lblCrnTop);
				pnlTop.add(lblCourseNumTop);
				pnlTop.add(lblTitleTop);
				pnlTop.add(lblInstructorTop);
				pnlTop.add(lblScheduleTop);
				pnlCenter.add(pnlTop, BorderLayout.NORTH);
						for(Section s: term.getSections()){
							if(s.getCourse().getDepartment().equals((dept))){		//bug?
								sectionsFound++;
								matchingSections.add(s);
							}
						}
				pnlSections.setLayout(new GridLayout(sectionsFound, 5));
					for(Section s: matchingSections){
						JButton btnCRN = new JButton(s.getCrn().toString());
						btnCRN.addActionListener(buttonListener);	//button listener added
						JLabel lblCourseNum = new JLabel(s.getCourse().getCourseNumber());
						JLabel lblTitle = new JLabel(s.getCourse().getTitle());
						JLabel lblInstructor = new JLabel(s.getInstructor().getLastName());
						JLabel lblSchedule = new JLabel(s.getSchedule());
						pnlSections.add(btnCRN);
						pnlSections.add(lblCourseNum);
						pnlSections.add(lblTitle);
						pnlSections.add(lblInstructor);
						pnlSections.add(lblSchedule);
						pnlCenter.add(pnlSections, BorderLayout.CENTER);
						}
					setSize(1200, ((sectionsFound*initialHeight)/2));
				lblSouth.setText(sectionsFound + "Sections of " + dept + " found.");
				initial = lblSouth.getText();
			}
			
		}
	};
	
	/**
	 * action listener for the buttons corresponding to each section. clicking 
	 * one of the buttons adds it to the students HashMap of current sections
	 * unless said section is already part of the collection, in which case it 
	 * is removed. This listener also calls the validate choice methods 
	 * for any selected section, which results in the creation of JOptionPanes
	 * only for hybrid and online classes. In order to register for a class,
	 * the yes option must be selected in the confirm dialog. Lbl south is also
	 * continually updated with the classes for which the student is registered
	 */
	
	ActionListener buttonListener = new ActionListener(){		
		public void actionPerformed(ActionEvent e) {
			displayString = "";
			JButton btnSelected = (JButton) e.getSource();
			String crn = btnSelected.getText();
			for(int i = 0; i<term.getSections().size(); i++){
				if(crn.equals(term.getSections().get(i).getCrn().toString())){
					sectionSelected = term.getSections().get(i);		
					
					if(!student.getCurrentSections().containsValue(sectionSelected)){
						int test = sectionSelected.validateChoice();
						if(test == 1){
						student.add(sectionSelected);
						}
						for(Section s: student.getCurrentSections().values()){
							displayString += s.getCrn().toString() + " " + s.getCourse().getTitle() + " ";
							lblSouth.setText(displayString);
							}
						}
					else{
						student.drop(sectionSelected);
							if(student.getCurrentSections().isEmpty()){
							lblSouth.setText(initial);
							}
							else{
								for(Section s: student.getCurrentSections().values()){
									displayString += s.getCrn().toString() + s.getCourse().getTitle();
									lblSouth.setText(displayString);
									}
							}
						  }
						
					}			
				}			
			}		
		};
		
		/**
		 * converts the fixed sized array of departmens into a fixed sized array
		 * of strings, to be used by the combo box. 
		 * @param departments, the values of the Department enum, as an Array
		 * @return a string array corresponding to the enum values, along 
		 * with a blank value
		 */
		public static String[] generateDepartmentStrings(Department[] departments){
			ArrayList<String> temp = new ArrayList<String>();
			for(Department d: departments){
				temp.add(d.toString());
			}
				temp.add(0, "  ");
			departmentStrings = new String[temp.size()];
			departmentStrings = temp.toArray(departmentStrings);
			return departmentStrings;
		}
	// inner class for crn button listeners


}
