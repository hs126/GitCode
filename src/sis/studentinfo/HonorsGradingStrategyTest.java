package sis.studentinfo;

import junit.framework.TestCase;

public class HonorsGradingStrategyTest extends TestCase{
	public void testGetGradePoints(){
		BasicGradingStrategy strategy = new HonorsGradingStrategy();
		assertEquals(5, strategy.getGradePoinsFor(Student.Grade.A));
		assertEquals(4, strategy.getGradePoinsFor(Student.Grade.B));
		assertEquals(3, strategy.getGradePoinsFor(Student.Grade.C));
		assertEquals(2, strategy.getGradePoinsFor(Student.Grade.D));
		assertEquals(0, strategy.getGradePoinsFor(Student.Grade.E));
	}
}
