package sis.studentinfo;
import java.util.*;

import com.sun.istack.internal.logging.Logger;

public class Student implements Comparable<Student>{
	private String firstName;
	private String middleName;
	private String lastName;
	private String name;
	private int credits;
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	private String state = "";
	private ArrayList<Grade> grades = new ArrayList<Grade>();
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	private List<Integer> charges = new ArrayList<Integer>();
	enum Grade {A, B, C, D, E};
	static final String TOO_MANY_NAME_PARTS_MSG = "Student name '%s' contains more than %d parts";
	static final int MAX_NAME_PARTS = 3;
	private String ID;
	
	public Student(String fullNname){
		this.name = fullNname;
		credits = 0;
		List<String> nameParts = split(fullNname);
		if(nameParts.size() > MAX_NAME_PARTS){
			String message = 
					String.format(Student.TOO_MANY_NAME_PARTS_MSG, fullNname, MAX_NAME_PARTS);
			log(message);
			throw new StudentNameFormatException(message);
		}
		setName(nameParts);
	}
	
	private void log(String message){
		Logger logger = Logger.getLogger(getClass());
		logger.info(message);
	}
	
	public List<String> split(String fullName){
		List<String> results = new ArrayList<String>();
		for(String name: fullName.split(" ")){
			results.add(name);
		}
		return results;
	}
	
	private void setName(List<String> nameParts){
		this.lastName = removeLast(nameParts);
		String name = removeLast(nameParts);
		if(nameParts.isEmpty())
			this.firstName = name;
		else
			this.middleName = name;
			this.firstName = removeLast(nameParts);;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getMiddleName(){
		return middleName;
	}

	public String getLastName(){
		return lastName;
	}
	
	private String removeLast(List<String> list){
		if(list.isEmpty())
			return "";
		return list.remove(list.size() -1);
	}
	
	public String getName(){
		return name;
	}
	
	boolean isFullTime(){
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}
	
	int getCredits(){
		return credits;
	}
	
	void addCredits(int credits){
		this.credits = this.credits + credits;
	}
	
	void setState(String state){
		this.state = state;
	}
	
	boolean isInState(){
		return state.equals(Student.IN_STATE);	
	}
	
	public int compareTo(Student that){
		return this.getName().compareTo(that.getName());
	}
	
	void addGrade(Grade grade)
	{
		grades.add(grade);
	}
	
	void setGradingStrategy(GradingStrategy gradingStrategy){
		this.gradingStrategy = gradingStrategy;
	}
	
	double getGpa(){
		if(grades.isEmpty())
			return 0.0;
		
		double total = 0.0;
		for(Grade grade:grades){
			total += gradingStrategy.getGradePoinsFor(grade);
		}
		return total/grades.size();
	}
	
	public void addCharge(int charge){
		charges.add(new Integer(charge));
	}
	
	public int totalCharges(){
		int total = 0;
		for(Integer charge: charges){
			total += charge.intValue();
		}
		return total;
	}
	
	public String getId(){
		return ID;
	}
	
	public void setId(String id){
		ID = id;
	}
}
