import javax.swing.*;
import java.awt.*;

public class PlayCatch extends JFrame
{
	public PlayCatch()
	{
		getContentPane().setLayout(new FlowLayout());
		add(new CatchComponent());
		// Causes this Window to be sized to fit
		// the preferred size and layouts of its subcomponents. 
		// The resulting width and height of the window are automatically enlarged 
		// if either of dimensions is less than the minimum size as specified by 
		// the previous call to the setMinimumSize method.


		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new PlayCatch();
	}
}
