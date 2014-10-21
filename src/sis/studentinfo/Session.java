package sis.studentinfo;
import java.util.*;
import java.net.*;

abstract public class Session implements Comparable<Session>{
	private static int count;
	private Course course;
	private List<Student> students = new ArrayList<Student>();
	private Date startDate;
	private int numberOfCredits;
	private URL url;
	
	abstract protected int getSessionLength();
	
	protected Session(Course course, Date startDate){
		this.course = course;
		this.startDate = startDate;	
	}
	
	public int compareTo(Session that){
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if(compare == 0){
			compare = this.getNumber().compareTo(that.getNumber());
		}
		
		return compare;
	}
	
	void setNumberOfCredits(int numberOfCredits){
		this.numberOfCredits = numberOfCredits;
	}
	
	public String getDepartment(){
		return course.getDepartment();
	}
	
	public String getNumber(){
		return course.getNumber();
	}
	
	int getNumberOfStudents()
	{
		return students.size();
	}

	public void enroll(Student student){
//		numberOfStudents += 1;
		student.addCredits(numberOfCredits);
		students.add(student);
	}
	
	Student get(int index){
		return students.get(index);
	}
	
	protected Date getStartDate(){
		return startDate;
	}
	
	public List<Student> getAllStudents(){
		return students;
	}
	
	public Date getEndDate(){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		final int sessionLength = 16;
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numberOfDays = sessionLength*daysInWeek - daysFromFridayToMonday;
	
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}
	
//	public void setUrl(String urlString) throws MalformedURLException{
	public void setUrl(String urlString) throws SessionException{
		try{
			this.url = new URL(urlString);
		}
		catch(MalformedURLException e){
			log(e);
//			throw (e);
			throw new SessionException(e);
		}
		
	}
	
	public URL getUrl(){
		return url;
	}
	
	private void log(Exception e){
		
	}
}
