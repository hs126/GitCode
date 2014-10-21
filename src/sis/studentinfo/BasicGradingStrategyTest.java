package sis.studentinfo;

import junit.framework.*;

public class BasicGradingStrategyTest extends TestCase{
	public void testGetGradePoints(){
		BasicGradingStrategy strategy = new BasicGradingStrategy();
		assertEquals(4, strategy.getGradePoinsFor(Student.Grade.A));
		assertEquals(3, strategy.getGradePoinsFor(Student.Grade.B));
		assertEquals(2, strategy.getGradePoinsFor(Student.Grade.C));
		assertEquals(1, strategy.getGradePoinsFor(Student.Grade.D));
		assertEquals(0, strategy.getGradePoinsFor(Student.Grade.E));
	}
}
