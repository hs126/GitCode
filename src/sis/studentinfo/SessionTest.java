package sis.studentinfo;

import java.util.*;
import java.net.*;
import junit.framework.TestCase;
import static sis.studentinfo.DateUtil.createDate;

abstract public class SessionTest extends TestCase{
	private Session session;
	private Date startDate;
	private static final int CREDITS = 3;
	
	public void setUp(){
		startDate = DateUtil.createDate(2003, 1, 6);
		session = createSession(new Course("ENGL", "101"), startDate);
		session.setNumberOfCredits(SessionTest.CREDITS);
	}
	
	abstract protected Session createSession(Course course, Date startDate);	
	
	public void testCreate(){
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}
	
	public void testEnrollStudents(){
		Student student1 = new Student("Cain Divoe");
		session.enroll(student1);
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(SessionTest.CREDITS, student1.getCredits());
		
		Student student2 = new Student("Coralee Devaughn");
		session.enroll(student2);
		assertEquals(2, session.getNumberOfStudents());	
		assertEquals(student2, session.get(1));
		assertEquals(SessionTest.CREDITS, student1.getCredits());
	}
	
	public void testComparable(){
		final Date date = new Date();
		Session sessionA = createSession(new Course("CMSC", "101"), date);
		Session sessionB = createSession(new Course("ENGL", "101"), date);
		assertTrue(sessionA.compareTo(sessionB) < 0);
		assertTrue(sessionB.compareTo(sessionA) > 0);
		
		Session sessionC = createSession(new Course("CMSC", "101"), date);
		assertEquals(0, sessionA.compareTo(sessionC));
	}
	
//	public void testSessionUrl() throws MalformedURLException{
	public void testSessionUrl() throws SessionException{
		final String url = "https://course.langrsoft.com/cmsc300*";
		session.setUrl(url);
		assertEquals(url, session.getUrl().toString());	
	}
	
	public void testInvalidSessionUrl(){
		final String url = "httsp://course.langrsoft.com/cmsc300*";
		try{
			session.setUrl(url);
			fail("expected exception due to invalid protocol in URL");	
		}
//		catch(MalformedURLException success){
//			
//		}
		catch(SessionException expectedException){
			Throwable cause = expectedException.getCause();
			assertEquals(MalformedURLException.class, cause.getCause());
		}
	}
}
