public class CourseTester
{
	public static void main(String[] args)
	{
		Course cpsc = new Course();
		cpsc.addStudent("Gokay", "Yokus");
		cpsc.addStudent("Alp Deniz", "Senyurt");
		cpsc.addStudent("Ahla", "Tor");
		System.out.println("Printing students:\n");
		for (int i = 0; i < 3; i++)
		{
			System.out.println("- " + cpsc.studentList.get(i).toString());
		}
		System.out.println("\n\n");
		//Quiz tests
		var student1 = cpsc.findStudent(10000001);
		student1.addQuiz(10,3);
		student1.addQuiz(35,32);
		student1.addQuiz(50,46);
		System.out.println("Scale of the Student 1's 1st quiz is: " + student1.quizScores.get(0).getScale());
		System.out.println("Grade of the Student 1's 2nd quiz is: " + cpsc.studentList.get(0).quizScores.get(2).getStudentGrade());

		var student2 = cpsc.findStudent(10000002);
		student2.addQuiz(30,20);
		student2.addQuiz(24,20);
		student2.addQuiz(50,36);
		student2.addQuiz(100,86);
		student2.addQuiz(15,13);

		var student3 = cpsc.findStudent(10000003);
		student3.addQuiz(30,20);
		student3.addQuiz(24,20);
		student3.addQuiz(50,36);
		student3.addQuiz(15,11);

		System.out.println("Trying to find the student whose student number is 10000002\n" + cpsc.findStudent(10000002));
		System.out.println("Trying to find the student whose student number is 10000004\n" + cpsc.findStudent(10000004));
		System.out.println("Top student in this class is: " + cpsc.findTopStudent());
		System.out.println("Average of this class is: " + cpsc.getAverage());
	}
}