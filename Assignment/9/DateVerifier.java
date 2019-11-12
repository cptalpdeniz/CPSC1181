/**
* Assignment 9
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.time.DateTimeException;
import java.time.LocalDate;

/**
* DateVerifier class is a verifier class for the date entered by the user 
*/
public class DateVerifier
{
	//static method to verify the date, if its valid, returns a LocalDate object
	public static LocalDate verifyDate(String date, String textField) throws DateTimeException
	{
		//checks for length and format
		if (date.chars().filter(ch -> ch =='/').count() != 2 || (date.length() >= 10 && date.length() <= 8))
		{
			throw new DateTimeException(textField + "wrong format\nFormat should be: dd/MM/yyyy");
		}
		
		int day;
		int month;
		int year;
		try
		{
			var splitString = date.split("/");
			day = Integer.parseInt(splitString[0]);
			month = Integer.parseInt(splitString[1]);
			year = Integer.parseInt(splitString[2]);
		}
		catch (NumberFormatException ex)
		{
			throw new DateTimeException(textField + "only digits are allowed for date");
		}
		
		//individual verifications
		if (year < 1000 || year > 3000)
			throw new DateTimeException(textField + "only dates between year 1000 and 3000 are allowed");
		if (month < 1 || month > 12)
			throw new DateTimeException(textField + "incorrect month, should be between 1-12");
		if (day < 1 || day > Def.DAYS_OF_MONTH[month - 1])
			throw new DateTimeException(textField + "incorrect day, should be a valid day for that month");
		return LocalDate.of(year, month, day);
	}
}