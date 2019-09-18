/**
	StudentTester tests class Student and class Address 

*/
class StudentTester{
	public static void main(String[] args){
		// test Student constructor
		Student student = new Student("Marry","jones",10000001);
		System.out.println(student); 

		// test Student getName, geyStudentNumber(), getLoginId()
		System.out.println(student.getName());
		System.out.println(student.getStudentNumber());
		System.out.println(student.getLoginId());


		// test Student getInfo()
		System.out.println(student.getInfo());

		// test Student addQuiz and getAverage
		student.addQuiz(6.0);
		student.addQuiz(8.5);
		student.addQuiz(9.8);
		System.out.println(student.getQuizAverage());

		// add your test cases:
		System.out.println("\n\n\n"); 
		Student s1 = new Student("Alp", "Senyurt", 100342433);
		System.out.println(s1);
		System.out.println("\n" + s1.getName());
		System.out.println(s1.getStudentNumber());
		System.out.println(s1.getLoginId());
		s1.setAddress("100", "W 49th Ave", "Vancouver", "BC", "V5Y 2Z6");
		System.out.println(s1.getAddress());
		s1.addQuiz(0.0);
		s1.addQuiz(10.0);
		s1.addQuiz(5.0);
		System.out.println(s1.getQuizAverage());





	}
}