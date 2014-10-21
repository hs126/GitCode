package sis.studentinfo;

import junit.framework.*;

public class StudentTest extends TestCase {
	public void testCreate(){
		final String firstStudent = "Jane Doe";
		Student student = new Student(firstStudent);
		assertEquals(firstStudent, student.getName());
		assertEquals("Jane", student.getFirstName());
		assertEquals("Doe", student.getLastName());
		assertEquals("", student.getMiddleName());
	}
	
	public void testStudentStatus(){
		Student student = new Student("a");
		assertEquals(0, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(3);
		assertEquals(3, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(9);
		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
		assertTrue(student.isFullTime());
	}
	
	public void testInState(){
		Student student = new Student("a");
		student.setState("SZ");
		assertFalse(student.isInState());
		
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());	
	}
	
	public void testBadlyFormattedName(){
		final String studentName = "a b c d";
		try{
			new Student(studentName);
			fail("expected exception from 4-part name");
		}
		catch(StudentNameFormatException expectedException){
			assertEquals(String.format(Student.TOO_MANY_NAME_PARTS_MSG, 
					studentName, Student.MAX_NAME_PARTS), expectedException.getMessage());
			
		}
	}
}
