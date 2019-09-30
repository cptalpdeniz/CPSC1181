import javax.swing.JFrame;
public class DisplayViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 600;
      final int FRAME_HEIGHT = 400;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Tutorial #3");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DisplayComponent component= new DisplayComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}
