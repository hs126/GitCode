package sis.studentinfo;
import java.util.*;

public class CourseSession extends Session{
	private static int count;
	
	public static CourseSession create(Course course, Date startDate){
		return new CourseSession(course, startDate);	
	}
	
	protected CourseSession(Course course, Date startDate){
		super(course, startDate);
        CourseSession.incrementCount();	
	}
	
	private static void incrementCount(){
		count = count + 1;
	}
	
	static void resetCount(){
		CourseSession.count = 0;
	}
	
	static int getCount(){
		return CourseSession.count;
	}
	
	protected int getSessionLength(){
		 return 16;
	 }
}
