/**
* Assignment 9
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.Font;
import javax.swing.JLabel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
* Def class which has static variables which are shared throughout the program
*/
public class Def
{
	static final Font SANS_SERIF_FONT = new Font("SansSerif", 1, 24);
	static final Font MONO_FONT = new Font("MONOSPACED", 1, 24);
	static final JLabel startDateLabel = new JLabel("Start Date: ");
	static final JLabel endDateLabel = new JLabel("End Date: ");
	static final LocalDate localDate = LocalDate.now();
	static final DateTimeFormatter dateStringFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static final int[] DAYS_OF_MONTH = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
}