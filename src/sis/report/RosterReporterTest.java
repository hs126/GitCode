package sis.report;
import junit.framework.*;
import sis.studentinfo.*;

public class RosterReporterTest extends TestCase{
	CourseSession session;
	
	public void testRosterReport(){
		CourseSession session = CourseSession.create(new Course("ENGL", "101"), 
				DateUtil.createDate(2003, 1, 6));
		
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		
		String rosterReport = new RosterReporter(session).getReport();
	    System.out.println(rosterReport);
		
		assertEquals(RosterReporter.ROSTER_REPORT_HEADER + 
				"A" + ReportConstant.NEWLINE + 
				"B" + ReportConstant.NEWLINE + 
				RosterReporter.ROSTER_REPORT_FOOTER + "2" + ReportConstant.NEWLINE,
				rosterReport);
	}
		
}
