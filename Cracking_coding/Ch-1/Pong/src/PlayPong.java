import javax.swing.*;
import java.awt.*;




/*
 * Contact me if you have any question: hmt4224@g.rit.edu
 * Han Min Thu
 */
public class PlayPong extends JFrame
{
	
	
	
	
	public PlayPong()
	{
		getContentPane().setLayout(new FlowLayout());
		add(new PongComponent());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new PlayPong();
	}
}