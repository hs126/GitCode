package sis.report;
import java.util.*;
import sis.studentinfo.*;

public class CourseReport{
	private ArrayList<CourseSession> sessions = new ArrayList<CourseSession>();
	
	public void add(CourseSession session){
		sessions.add(session);
	}
	
	public String text()
	{
		StringBuilder builder = new StringBuilder();
		for(CourseSession session:sessions){
			builder.append(session.getDepartment() + " " + 
			session.getNumber() + ReportConstant.NEWLINE);
		}
//		System.out.print(builder.toString());
		return builder.toString();
	}
	


}
