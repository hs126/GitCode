package sis.summer;

import static sis.studentinfo.DateUtil.createDate;
import junit.framework.*;
import java.util.*;

import sis.studentinfo.*;

public class SummerCourseSessionTest extends SessionTest{
	public void testEndDate(){
		Date startDate = DateUtil.createDate(2003, 6, 9);
		Session session = createSession(new Course("ENGL", "200"), startDate);
		Date eightWeeksOut = createDate(2003, 8, 1);
		assertEquals(eightWeeksOut, session.getEndDate());
	}
	
	protected Session createSession(Course course, Date startDate){
		return SummerCourseSession.create(course, startDate);	
	}

}
