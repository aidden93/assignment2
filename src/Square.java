/*
	Square ADT
	Author: J.R.Dermoudy & <<Aidden Mazey>>
	Date: September 2013

	This file holds the Square ADT which represents
	a physical space within a maze.  A Square in a
	maze consists of a location, a colour, a number,
	and four flags indicating whether or not the
	Square object is: a wall, visited as part of
	the attempt to find a solution, the start square
	of the maze, and/or the stop square of the maze.
*/


import java.awt.*;


public class Square implements SquareInterface, Cloneable
{
	private Location loc;		// the location of the current square within the maze
	private Color colour;		// the colour of the current square
	private boolean wall;		// whether the square is a wall
	private boolean visited;	// whether the square has been visited yet
	private boolean start;		// whether the square is the start square
	private boolean stop;		// whether the square is the stop square
	private int number;			// the number of the square


	public Square(Location l)
	/*
		Constructor method 1.
		Pre-condition: the given location value is defined
		Post-condition: the Square object's "loc" field is the value
						given, its "colour" field is 'black', its
						"wall" field is true, its "visited", "start",
						and "stop" fields are false, and its "number"
						field is given the integer value -1 to
						represent undefined
		Informally: creates a wall square at the given location
	*/
	{
		loc=l;
		colour=Color.black;
		wall=true;
		visited=false;
		start=false;
		stop=false;
		number=-1;
	}


	public Square(Location l,int n)
	/*
		Constructor method 2.
		Pre-condition: the given location value is defined
		Post-condition: the Square object's "loc" field is the value
						given, its "colour" field is 'white', its
						"wall", "visited", "start",	and "stop" fields
						are false, and its "number" field is assigned
						the given value
		Informally: creates a non-wall square at the given location
						with the given square number
	*/
	{
		loc = l; //set location of the square
		colour = Color.white; //set colour of the square to white
		wall = false; //set the square to not be a wall
		visited = false; //set square to not visited
		start = false; //set square to not be the start square
		stop = false; //set square to not be the stop square
		number = n; //the squares number
	}


	public Square(Location l, boolean o, boolean g, int n)
	/*
		Constructor method 3.
		Pre-condition: the given location value is defined and the
						given boolean values are valid
		Post-condition: the Square object's "loc" field is the value
						given, its "colour" field is 'yellow' if
						either of the given boolean values (o for
						origin, i.e. start, and g for goal, i.e. stop),
						are true, and 'white' otherwise, its
						"wall" and "visited" fields are false, its
						"number" field is assigned the given value,
						and its "start" and "stop" fields are assigned
						the given values of o and g respectively
		Informally: creates a non-wall square at the given location
						with the given square number, that may be the
						start and/or stop square
	*/
	{
		loc=l;
		wall=false;
		visited=false;
		start=o;
		stop=g;
		if (start || stop)
		{
			colour=Color.yellow;
		}
		else
		{
			colour=Color.white;
		}
		number=n;
	}


	public Object clone()
	/*
		Pre-condition: the current Square object is validly defined
		Post-condition: the Square object is copied
		Informally: copy the current Square
	*/
	{
		Square s;

		if (isWall())
		{
			s=new Square(loc);
		}
		else
		{
			s=new Square(loc,start,stop,number);
		}
		s.occupied(isOccupied());

		return s;
	}


	public Location getLocation()
	/*
		Get method for "loc" instance variable.
		Pre-condition: none
		Post-condition: the value of the Square object's
						location field is returned
		Informally: return the current square's location
	*/
	{
		return loc; //get the squares position in the grid
	}


	public void setLocation(Location l)
	/*
		Set method for "loc" instance variable.
		Pre-condition: the given Location value is defined and
					   valid within the enclosing maze
		Post-condition: the value of the Square object's loc
						field is altered to contain the given
						Location value
		Informally: update the Square object's Location to the
					given value
	*/
	{
		loc = l; //set the squares location in the grid
	}


	public Color getColour()
	/*
		Get method for "colour" instance variable.
		Pre-condition: none
		Post-condition: the value of the Square object's
						colour field is returned
		Informally: return the current square's colour
	*/
	{
		return colour; //get the squares colour
	}


	public void setColour(Color c)
	/*
		Set method for "colour" instance variable.
		Pre-condition: none
		Post-condition: the value of the Square object's colour
						field is altered to contain the given
						Color value
		Informally: update the Square object's Color to the
					given value
	*/
	{
		colour = c; //set the squares colour
	}


	public boolean isWall()
	/*
		Get method for "wall" instance variable.
		Pre-condition: none
		Post-condition: the value of the Square object's
						wall field is returned
		Informally: return whether the current square is a
					wall
	*/
	{
		return wall; //return true if the square is a wall, otherwise false
	}


	public void solidWall(boolean w)
	/*
		Set method for "wall" instance variable.
		Pre-condition: none
		Post-condition: the given value is assigned to the Square
						object's wall field.  If the value alters
						the Square to be a wall its colour is set
						to black, otherwise it is set to white
		Informally: update the Square object's wall to the
					given value
	*/
	{
		wall=w;
		if (wall)
		{
			colour=Color.black;
		}
		else
		{
			colour=Color.white;
		}
	}


	public boolean isOccupied()
	/*
		Get method for "visited" instance variable.
		Pre-condition: none
		Post-condition: the value of the Square object's
						visitation field is returned
		Informally: return whether the current square has
					been visited in the current attempt at
					finding a solution
	*/
	{
		return visited; //returns true if the square has been visited, otherwise false
	}


	public void occupied(boolean o)
	/*
		Set method for "visited" instance variable.
		Pre-condition: none
		Post-condition: the given value is assigned to the Square
						object's visited field and if the Square
						is now visited its colour is changed to red
		Informally: record whether or not the current Square is
					visited
	*/
	{
		visited=o;
		if (visited)
		{
			colour=Color.red;
		}
	}


	public int numbered()
	/*
		Get method for "number" instance variable.
		Pre-condition: none
		Post-condition: the value of the Square object's
						number field is returned
		Informally: return the current square's number
	*/
	{
		return number; //get the squares number
	}


	public void squareNumber(int n)
	/*
		Set method for "number" instance variable.
		Pre-condition: the given value is a legal square number
		Post-condition: the given value is assigned to the Square
						object's number field
		Informally: update the Square object's square number to the
					given value
	*/
	{
		number = n; //set the squares number
	}


	public boolean isStopSquare()
	/*
		Get method for "stop" instance variable.
		Pre-condition: none
		Post-condition: the value of the Square object's
						stop field is returned
		Informally: return whether the current square is
					the stop square
	*/
	{
		return stop; //returns true if the square is the goal square, otherwise false
	}


	public void stopSquare()
	/*
		Set method for "stop" instance variable.
		Pre-condition: none
		Post-condition: the Square object's "stop" instance
						variable is set to true and its "colour"
						instance variable is set to yellow
		Informally: record that the current Square is the stop
					square
	*/
	{
		stop=true;
		colour=Color.yellow;
	}


	public boolean isStartSquare()
	/*
		Get method for "start" instance variable.
		Pre-condition: none
		Post-condition: the value of the Square object's
						start field is returned
		Informally: return whether the current square is
					the start square
	*/
	{
		return start; //returns true if the square is the starting square, otherwise false
	}


	public void startSquare()
	/*
		Set method for "start" instance variable.
		Pre-condition: none
		Post-condition: the Square object's "stop" instance
						variable is set to true, its colour is
						set to yellow, and the square number is
						set to 0
		Informally: record that the current Square is the stop
					square
	*/
	{
		start=true;
		colour=Color.yellow;
		number=0;
	}


	public void showSquare(Display s)
	/*
		Pre-condition: the Display parameter is correctly defined
		Post-condition: the Display representation of the Square
						object is displayed on the given Display at
						the position related to its location using
						the Square object's colour to display the
						square (of 20 pixels) and also write the
						Square's number	on the displayed square
		Informally: display the current square
	*/
	{
		final int pixelMultiplier=20;
		final int horizOffset=15;
		final int vertOffset=65;

		int row=loc.getRow();
		int column=loc.getColumn();

		s.getGraphics().setColor(getColour());

		s.getGraphics().fillRect(pixelMultiplier*(column)+horizOffset,
						pixelMultiplier*(row)+vertOffset,20,20);

		if (! isWall())
		{
			s.getGraphics().setColor(Color.black);
			s.getGraphics().drawString(Integer.toString(numbered()),
							pixelMultiplier*(column)+horizOffset+6,
							pixelMultiplier*(row)+vertOffset+10);
		}
	}
}
