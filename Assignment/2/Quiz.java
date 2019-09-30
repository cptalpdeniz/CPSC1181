/**
* Assignment 2
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*
*/
public class Quiz
{
	private double scale;	// quiz scale
	private double studentGrade;	// the grade student achieved in the quiz

	public Quiz(double scale, double studentGrade)
	{
		this.scale = scale;
		this.studentGrade = studentGrade;
	}

	public double getScale()
	{
		return scale;
	}
	public double getStudentGrade()
	{
		return studentGrade;
	}

	public void setScale(double scale)
	{
		this.scale = scale;
	}
	public void setStudentGrade(double studentGrade)
	{
		this.studentGrade = studentGrade;
	}
}