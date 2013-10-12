/*
	Dimension ADT
	Author: J.R.Dermoudy & <<Aidden Mazey>>
	Date: September 2013

	This file holds the Dimension ADT which represents
	the two-dimensional size of a maze.  The maze's
	dimension consists of vertical and horizontal
	components.
*/


public class Dimension implements DimensionInterface
{
	private int vert;	// the height of a maze (number of rows)
	private int horiz;	// the width of a maze (number of columns)


	public Dimension(int v, int h)
	/*
		Constructor method.
		Pre-condition: the height (v) and width (h) are valid
					   positive integers
		Post-condition: the Dimension object records the vertical and
						horizontal sizes within instance variables
		Informally: intialises the instance variables of the newly
					created Dimension object to hold the vertical and
					horizontal component values
	*/
	{
		vert = v; //set number of rows(height) of maze to v
		horiz = h; //set number of columns(width) of maze to h 
	}


	public void setVert(int v)
	/*
		Set method for "vert" instance variable.
		Pre-condition: the height (v) is a valid positive integer
		Post-condition: the Dimension object's vertical size is
						altered to hold the given (v) value
		Informally: assign the value of the parameter to the Dimension
					object's vertical component instance variable
	*/
	{
		vert = v; //set number of rows(height) of maze to v
	}


	public void setHoriz(int h)
	/*
		Set method for "horiz" instance variable.
		Pre-condition: the width (h) is a valid positive integer
		Post-condition: the Dimension object's horizontal size is
						altered to hold the given (h) value
		Informally: assign the value of the parameter to the Dimension
					object's horizontal component instance variable
	*/
	{
		horiz = h; //set number of columns(width) of maze to h 
	}


	public int getVert()
	/*
		Get method for "vert" instance variable.
		Pre-condition: none
		Post-condition: the Dimension object's vertical size is
						returned
		Informally: examine the Dimension object's vertical component
					instance variable returning its value
	*/
	{
		return vert; //get number of rows(height) 
	}


	public int getHoriz()
	/*
		Get method for "vert" instance variable.
		Pre-condition: none
		Post-condition: the Dimension object's vertical size is
						returned
		Informally: examine the Dimension object's vertical component
					instance variable returning its value
	*/
	{
		return horiz; //get number of columns(width)
	}
}