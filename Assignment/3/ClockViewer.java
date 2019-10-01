/**
* Assignment 3
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import javax.swing.JFrame;
import java.awt.Color;
public class ClockViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 400;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Clock");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ClockComponent component = new ClockComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
