/*
	Location ADT
	Author: J.R.Dermoudy & <<Aidden Mazey>>
	Date: September 2013

	This file holds the Location ADT which represents
	indices to (positions within) the two-dimensional maze.
	A Location consists of a Row number and a Column number.
*/


public class Location implements LocationInterface
{
	private int row;	// the vertical component of the position
	private int column;	// the horizontal component of the position


	public Location(int r, int c)
	{
	/*
		Constructor method.
		Pre-condition: the row number (r) and column number (c)
					   are valid positive integers
		Post-condition: the Location object records the vertical and
						horizontal positions within instance variables
		Informally: intialises the instance variables of the newly
					created Location object to hold the vertical and
					horizontal component values
	*/
		row = r; //set the vertical position
		column = c; //set the horizontal position
		//TODO constructor
	}


	public void setRow(int r)
	/*
		Set method for "row" instance variable.
		Pre-condition: the row number (r) is a valid positive integer
		Post-condition: the Location object's vertical index is
						altered to hold the given (r) value
		Informally: assign the value of the parameter to the Location
					object's vertical component instance variable
	*/
	{
		row = r; //set the vertical position
		//TODO setRow
	}


	public void setColumn(int c)
	/*
		Set method for "column" instance variable.
		Pre-condition: the column number (c) is a valid positive integer
		Post-condition: the Location object's horizontal index is
						altered to hold the given (c) value
		Informally: assign the value of the parameter to the Location
					object's horizontal component instance variable
	*/
	{
		column = c; //set the horizontal position
		//TODO setColumn
	}


	public int getRow()
	/*
		Get method for "row" instance variable.
		Pre-condition: none
		Post-condition: the Location object's vertical index is
						returned
		Informally: examine the Location object's vertical component
					instance variable returning its value
	*/
	{
		return row; //get the vertical position
		//TODO getRow
	}


	public int getColumn()
	/*
		Get method for "column" instance variable.
		Pre-condition: none
		Post-condition: the Location object's horizontal index is
						returned
		Informally: examine the Location object's horizontal component
					instance variable returning its value
	*/
	{
		return column; //get the horizontal position
		//TODO getColumn
	}
}
