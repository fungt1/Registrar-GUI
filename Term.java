package v1;
import java.util.ArrayList;


public class Term {
	protected String termString;
	protected ArrayList<Section> sections = new ArrayList<Section>();
	
	
	public Term (String termString){
		this.termString = termString;
	}
	
	public ArrayList<Section> getSections(){
		return sections;
	}
	
	public void addSection(Section newSection){
		sections.add(newSection);
	}
	


}

