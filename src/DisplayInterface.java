/*
	Display ADT
	Author: J.R.Dermoudy
	Date: September 2013

	This file holds the Display ADT which represents
	the computer Display.  Internally, the Display is
	represented by a graphics context.
*/


import java.awt.*;


public interface DisplayInterface
{
	//public Display();
	public void setGraphics(Graphics g);
	public Graphics getGraphics();
}
