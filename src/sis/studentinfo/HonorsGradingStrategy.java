package sis.studentinfo;

public class HonorsGradingStrategy extends BasicGradingStrategy{
	
	public int getGradePoinsFor(Student.Grade grade){
		int points = super.getGradePoinsFor(grade);
		if(points > 0)
			points += 1;
		return points;
	}
}
