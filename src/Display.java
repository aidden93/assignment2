/*
	Display ADT
	Author: J.R.Dermoudy
	Date: September 2013

	This file holds the Display ADT which represents
	the computer Display.  Internally, the Display is
	represented by a graphics context.
*/


import java.awt.*;


public class Display implements DisplayInterface
{
	private Graphics graphics;	// the window on which to draw etc.


	public Display()
	/*
		Constructor method.
		Pre-condition: none
		Post-condition: the Display object's "graphics" instance
						variable is set to null
		Informally: intialises the graphics window to null
	*/
	{
		graphics=null;
	}


	public void setGraphics(Graphics g)
	/*
		Set method for "graphics" instance variable.
		Pre-condition: the graphics context (g) is a valid window
		Post-condition: the Display object's graphics instance variable
						is altered to hold the given (g) value
		Informally: assign a graphics window value to the object
	*/
	{
		graphics=g;
	}


	public Graphics getGraphics()
	/*
		Get method for "graphics" instance variable.
		Pre-condition: none
		Post-condition: the Display object's graphics value is
						returned
		Informally: examine the Graphics object's window component
					instance variable returning its value
	*/
	{
		return graphics;
	}
}