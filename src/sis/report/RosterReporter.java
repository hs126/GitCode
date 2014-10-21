package sis.report;
import sis.studentinfo.*;

public class RosterReporter {
//	static final String ReportConstant.NEWLINE = System.getProperty("line.separator");
	static final String ROSTER_REPORT_HEADER = "Student" + ReportConstant.NEWLINE + "-" + ReportConstant.NEWLINE;
	static final String ROSTER_REPORT_FOOTER = ReportConstant.NEWLINE + "# students = ";
	private CourseSession session;
	
	RosterReporter(CourseSession session){
		this.session = session;
	}
	
	String getReport(){
		StringBuilder buffer = new StringBuilder();
		writeHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);
		
		return buffer.toString();
	}
	
	void writeHeader(StringBuilder buffer){
		buffer.append(ROSTER_REPORT_HEADER);
	}
	
	void writeBody(StringBuilder buffer){
		for(Student student: session.getAllStudents()){
			buffer.append(student.getName());
			buffer.append(ReportConstant.NEWLINE);
		}
	}
	
	void writeFooter(StringBuilder buffer){
		buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + ReportConstant.NEWLINE);
	}
}
