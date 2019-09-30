import java.util.*;
/**
* Assignment 2
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*
*/
public class Course
{
	/**
	* Course class is a BASIC representation of a real life school course. It only has one variable. 
	* @param studentList An ArrayList<Student> that has Student objects in it's indexes.
	*/
	public ArrayList<Student> studentList = new ArrayList<Student>();
	
	/* Constructor
	* Doesn't take any parameters
	*/
	public void Course()
	{ }

	/**
	* Adds a new student to the list of the students.
	* @param name First name of the student to be added.
	* @param familyName Surname of the student to be added.
	* @return If succeeded, returns the reference of the newly created student. In case of failure, returns null.
	*/
	public Student addStudent(String name, String familyName)
	{
		Student s1 = new Student(name, familyName);
		studentList.add(s1);
		return s1;
	}
	
	/**
	* Searches for the student that has the matching Student Number.
	* @param studentNum Student Number of the student to be searched for the list.
	* @return If succeeds, the reference of the student. If not, null
	*/
	public Student findStudent (long studentNum)
	{
		for (Student student : studentList) 
		{
			if (student.getStudentNumber() == studentNum)
			{
				return student;
			}
		}
		return null;
	}
	
	/** 
	* Removes the student that has the matching student number from the list.
	* @param studentNum Student Number of the student to be deleted from the list.
	* @return If succeeds, the reference of the student. If not, null
	*/
	public Student deleteStudent(long studentNum)
	{
		for (Student student : studentList) 
		{
			if (student.getStudentNumber() == studentNum)
			{
				var temp1 = student;
				studentList.remove(student);
				return temp1;
			}
		}
		return null;
	}
	
	/** adds a quiz to a student given studentId
	* @param scale the scale of the quiz
	* @param studenGrade the grade student achieved
	* @return true is case succeed, or false in case of failure 
	*/
	public boolean addQuiz(long studentId, double scale, double studentGrade)
	{
		try
		{
			for (Student student : studentList) 
			{
				if (student.getStudentNumber() == studentId)
				{
					Quiz quiz = new Quiz(scale, studentGrade);
					student.quizScores.add(quiz);
				}
			}
		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	/**
	* Finds the top student in this course. Calculation is very inefficient. The top student is found by doing a linear comparison of each student.
	* Since student class does not provide average variable, or a method for average calculation, the average is calculated here.
	* Score of each student = studentGrade / scale -> % score out of 0 - 1.0
	* As said earlier, this approach is very inefficient and linear. There are more efficient ways to calculate or structure the program to help with it
	* however, for the sake of this assignment and simplicity, it will be kept as is.
	* @return Returns the reference of the student that has the highest average grade in this course.
	*/	
	public Student findTopStudent()
	{
		var max = 0.0;
		Student temp = studentList.get(0);
		for (Student student : studentList) 
		{
			if (!student.quizScores.isEmpty())
			{
				var score = (student.quizScores.get(0).getStudentGrade() / student.quizScores.get(0).getScale()); //created for initilization
				for (int i = 1; i < student.quizScores.size() ; i++) 
				{
					score += (student.quizScores.get(i).getStudentGrade() / student.quizScores.get(i).getScale());
				}
				var avg = score / student.quizScores.size();
				if (avg >= max)
				{
					max = avg;
					temp = student;
				}
			}
		}
		if (max != 0.0)
		{
			return temp;
		}
		return null;
	}
	
	/**
	* Finds the average of the course. Just like findTopStudents() method, it is very inefficient and uses linear comparison.
	* @return Average of the course in % format [(avg / studentList.size()) * 100]
	*/
	public double getAverage()
	{
		var avg = 0.0;
		for (Student student : studentList) 
		{
			if (!student.quizScores.isEmpty())
			{
				var score = (student.quizScores.get(0).getStudentGrade() / student.quizScores.get(0).getScale()); //created for initilization
				for (int i = 1; i < student.quizScores.size() ; i++) 
				{
					score += (student.quizScores.get(i).getStudentGrade() / student.quizScores.get(i).getScale());
				}
				var averageStudent = score / student.quizScores.size();
				avg += averageStudent;
			}
		}
		return (avg / studentList.size()) * 100;
	}
}