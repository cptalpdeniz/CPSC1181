import javax.swing.JFrame;
import java.awt.Color;
public class FaceViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 800;
      final int FRAME_HEIGHT = 800;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Circles");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      FaceComponent component = new FaceComponent();
      frame.add(component);

      frame.setVisible(true);

      /*
      Draw a half circle to replicate a smile
      For a face with diameter 95, just need to make sure that necessary calculations are done for coordinates and it should be fine
      */
   }
}
