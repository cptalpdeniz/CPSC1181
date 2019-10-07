import java.util.*;
/**
* Assignment 1
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*
* Note to self: Javadoc is very time consuming.
*
*/
public class Student
{
	/**
	* Student class is a class for each student with various variables.
	* @param firstName First name variable String
	* @param lastName Last name variable [String]
	* @param studentNumber Stores student number [Long]
	* @param address Address of the student which is stored in another class called "Address" [Address]
	* @param quizAverage Stores the average of the quiz scores of the student [Double]
	* @param loginID Login ID of the student. Created by the {@code createLoginID()} method which called at the end of the constructor. [String]
	* @param quizScores Stores the quiz scores of the student. [{@code List<Double>}]
	*/
	private String firstName;
	private String lastName;
	private long studentNumber;
	private Address address;
	private String loginID;
	private List<Double> quizScores;


	/**
	* This method creates the Login ID for the student and is called by the constructor at the end of initilization of the instance object.
	* It has a simple check for last 2 digits as the way to obtain the last 2 digits of the student number is to modulo operation.
	* studentNumber % 100 gives the last 2 digits. However, if the remainder is less than 10, it will be single digit without the leading zero. 
	* The if condition in line 52 checks for the leading zero.
	* Stores the loginID in the {@code loginID, private String} variable.
	*/
	private void createLoginID()	//private since it is only accessible from constructor. No need to be accessible from outside
	{
		loginID = String.valueOf(firstName.charAt(0));
		if (lastName.length() >= 4)
		{
			loginID += lastName.substring(0, 4);
		}
		else
		{
			loginID += lastName;
		}
		loginID = loginID.toLowerCase();

		long tempINT = studentNumber % 100;
		String tempString = "0";
		if (tempINT < 10)	//simple test for remainder
		{
			tempString = "0" + Long.toString(tempINT);
			loginID += tempString;
		}
		else 
		{
			loginID += Long.toString(studentNumber % 100);
		}
		loginID = loginID;
	}

	/**
	* Constructor for Student class.
	* @param firstName First name of the student
	* @param surName Surname of the student
	* @param studentNumber Student Number of the student
	*/
	public Student(String firstName, String surName, long studentNumber)
	{
		this.firstName = firstName;
		this.lastName = surName;
		this.studentNumber = studentNumber;
		quizScores = new ArrayList<Double>();
		address = new Address();
		createLoginID();
	}

	/**
	* Sets the student's name, surname and student number. NOTE: Changing student's name does not affect the students's loginId
	* @param firstName First name of the student
	* @param surName Surname of the student
	* @param studentNumber Student Number of the student
	*/
	public void setName(String firstName, String surName, long studentNumber)
	{
		this.firstName = firstName;
		this.lastName = surName;
		this.studentNumber = studentNumber;
	}

	/** Returns name and surname separated by comma (name, surname)
	* @return "First name, Last name"
	*/
	public String getName()
	{
		return firstName + ", " + lastName;
	}
	
	/** Returns student number
	* @return studentNumber in {@code String} format
	*/
	public long getStudentNumber()
	{
		return studentNumber;
	}
	
	/** Returns the students login Id. Login Id is generated by class Student.
	* @return loginID in {@code String} format
	*/
	// Refer to “About Your Implementation” for details.
	public String getLoginId()
	{
		return loginID;
	}
	
	/** Returns student's information.
	* @return Uses the following format: firstName, lastName (loginID, studentNumber)
	*/
	public String getInfo()
	{
		return getName() + " (" + loginID + ", " + studentNumber + ")";
	}
	
	/** Sets address of the student
	* @param number Apt number
	* @param street Street address
	* @param city City
	* @param province State/Province
	* @param postalCode Postal Code 
	*/
	public void setAddress(String number, String street, String city, String province, String postalCode)
	{
		address = new Address(number, street, city, province, postalCode);
	}
	
	/** Returns student's address in classical address format which is achieved by calling the overriden {@code toString()} method in Address class:
	* 100 W 49th Ave
	* Vancouver, BC
	* V5Y 2Z6
	* @return Address of the student
	*/
	public String getAddress()
	{
		return address.toString();
	}
	
	/** Adds a quiz score to the student by {@code quizScores.add(quiz)}
	* @param quiz score of the quiz that will be added to the list
	*/
	public void addQuiz(double quiz)
	{
		quizScores.add(quiz);
	}
	
	/** Returns the average of the quiz of a student. Has a built in empty check for the list. 
	* @return returns the average by calculating the sum with a for-each statement than dividing it by {@code quizScores.size()}
	*/
	public double getQuizAverage()
	{
		double average = 0;
		if (!quizScores.isEmpty())	//simple to check to make sure that the list is not empty
		{
			for (double score : quizScores)
			{
				average += score;
			}
		}

		return average / quizScores.size();
	}
	
	/** Override toString() method
	* @return Returns the Student class as a string with the following format: [firstName, lastName, studentNumber, loginID]
	*/
	public String toString()
	{
		return "[" + firstName + ", " + lastName + ", " + studentNumber + ", " + loginID + "]";
	}

}