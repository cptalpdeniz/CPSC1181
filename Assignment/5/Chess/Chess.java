/**
* Assignment 5
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
import javax.swing.JFrame;
public class Chess
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 540;
      final int FRAME_HEIGHT = 540;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Chess");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      GameControllerComponent component = new GameControllerComponent();
      frame.add(component);

      frame.setVisible(true);

      // Note that you should call after set frame to visible.
      component.start();
   }
}
