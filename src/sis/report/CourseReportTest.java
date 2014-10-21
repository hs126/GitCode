package sis.report;
import junit.framework.*;
import java.util.*;
import sis.studentinfo.*;

public class CourseReportTest extends TestCase{
	public void testReport(){
		final Date date = new Date();
		CourseReport report = new CourseReport();
		report.add(CourseSession.create(new Course("ENGL", "101"), date));
		report.add(CourseSession.create(new Course("CZEL", "200"), date));
		report.add(CourseSession.create(new Course("ITAL", "410"), date));
		
		assertEquals("ENGL 101" + ReportConstant.NEWLINE +
				"CZEL 200" + ReportConstant.NEWLINE +
				"ITAL 410" + ReportConstant.NEWLINE, report.text());
//		report.add(create("ENGL", "101", date));
//		report.add(create("CZEL", "200", date));
//		report.add(create("ITAL", "410", date));
	}
	
//	private Session create(String name, String number, Date date){
//		return CourseSession.create(new Course(name, number), date);	
//	}
}
