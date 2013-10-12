/*
	Grid Exception
	Author: J.R. Dermoudy
	Date: September 2013

	This file holds the Grid Exception.  This
	is used when Grid ADTs are accessed beyond the
	boundary of the defined maze and errors	result.
	Specifically, IllegalGridException objects are
	created and thrown when attempts are made to
	set/get Square variables outside the rows and
	columns defined for the maze object through
	the third constructor, setSquare()/getSquare().
*/


public class IllegalGridException extends RuntimeException
{
	public IllegalGridException()
	{
		super("Cannot access a component not in the maze...");
	}
}