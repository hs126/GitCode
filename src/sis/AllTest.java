package sis;
import sis.studentinfo.CourseSessionTest;
import sis.studentinfo.StudentTest;
import sis.report.RosterReporterTest;
import junit.framework.TestSuite;

public class AllTest {
	public static TestSuite suite(){
		TestSuite suite = new TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);	
		suite.addTestSuite(RosterReporterTest.class);	
		return suite;
	}
}
