/**
* Assignment 9
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.*;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoUnit;
import java.time.Period;
import java.time.DateTimeException;

/**
* DateCounterPanel class is the main panel class which incorprates all the elements.
* @param startDate LocalDate object for the start date
* @param textField1 JTextField object, first text field
* @param textField2 JTextField object, second text field
* @param button JButton object for the "count" button
*/
public class DateCounterPanel extends JPanel
{
	private LocalDate startDate;
	private JTextField textField1;
	private JTextField textField2;
	private	JButton button;

	public DateCounterPanel()
	{
		Def.startDateLabel.setFont(Def.SANS_SERIF_FONT);
		Def.endDateLabel.setFont(Def.SANS_SERIF_FONT);
		
		startDate = LocalDate.of(2000, Month.JANUARY, 1);

		textField1 = new JTextField("01/01/2000");
		textField2 = new JTextField(Def.localDate.format(Def.dateStringFormatter));
		textField1.setFont(Def.MONO_FONT);
		textField2.setFont(Def.MONO_FONT);

		button = new JButton("count");

		this.add(Def.startDateLabel);
		this.add(textField1);
		this.add(Def.endDateLabel);
		this.add(textField2);
		this.add(button);

		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent events) 
			{
				try
				{
					var date1 = DateVerifier.verifyDate(textField1.getText(), "Start Date "); //true for isFirstTextField argument
					var date2 = DateVerifier.verifyDate(textField2.getText(), "Start Date "); //true for isFirstTextField argument
					Period period = Period.between(date1, date2);
					JOptionPane.showMessageDialog(null, period.getDays() + " days\n" + period.getMonths() + " months\n" + period.getYears() + " years\n" + ChronoUnit.DAYS.between(date1, date2) + " total days");
				}
				catch (DateTimeException e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}
}