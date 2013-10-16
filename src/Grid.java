/*
	Grid ADT
	Author: J.R.Dermoudy & <<Aidden Mazey>>
	Date: September 2013

	This file holds the Grid ADT which represents
	the maze.  The Grid consists of a location (of
	the current position of the solver), a
	dimension, a square number (of the stop square),
	and a two-dimensional array (table/matrix) of
	the squares in a maze.
*/


import java.awt.*;


public class Grid implements GridInterface, Cloneable
{
	private Dimension dim;		// size of the maze
	private Square grid[][];	// all the Squares within the maze
	private Location loc;		// current position of solver
	private int goalNumber;		// square number of stop square

	public Grid()
	/*
		Constructor method 1.
		Pre-condition: none
		Post-condition: a 10x12 Grid where all squares are walls
		Informally: create a solid 10x12 maze
	*/
	{
		dim=new Dimension(10,12);
		initialiseGrid();
	}


	public Grid(Dimension m, int g)
	/*
		Constructor method 2.
		Pre-condition: the given Dimension value is defined and
					   valid
		Post-condition: a Grid of given Dimension is created
						where all squares are walls and the
						square number of the goal square is
						recorded from that given
		Informally: create a solid maze of given dimension and
					indicated stop square number
	*/
	{
		dim = m; //set the grids dimensions to the given dimension
		goalNumber = g; //set the goal square number to g
		initialiseGrid();
		//TODO constructor
	}


	public Grid(Dimension m, Location l, int g) throws IllegalGridException
	/*
		Constructor method 3.
		Pre-condition: the given Dimension value is defined and
					   valid and the given Location value is
					   defined to be a location within the given
					   Dimension
		Post-condition: a Grid of given Dimension is created
						where all squares are walls, the square
						number of the goal square is recorded
						from that given, and the square indicated
						by the provided square number is occupied
		Informally: create a solid maze of given dimension,
					indicated stop square number, and indicated
					current position; an exception is thrown if
					the provided location is not within the bounds
					of the maze
	*/
	{
		dim=m;
		goalNumber=g;

		initialiseGrid();
		if (validMove(l))
		{
			loc=l;
			occupySquare(l,true);
		}
		else
		{
			throw new IllegalGridException();
		}
	}


	private void initialiseGrid()
	/*
		Pre-condition: none
		Post-condition: the two-dimensional array of Squares is
						instantiated and filled with newly
						created wall squares each with the
						correct location
		Informally: create a solid maze of known dimension
	*/
	{
		int r,c;
		Location l;

		grid=new Square[dim.getVert()][];
		for (r=0; r<dim.getVert(); r++)
		{
			grid[r]=new Square[dim.getHoriz()];
			for (c=0; c<dim.getHoriz(); c++)
			{
				l=new Location(r+1,c+1);
				grid[r][c]=new Square(l); //wall
			}
		}
	}


	public Object clone()
	/*
		Pre-condition: the current Grid object is validly defined
		Post-condition: the Grid object is copied
		Informally: copy the current Grid
	*/
	{
		Grid b;
		int r,c;
		Dimension d;

		d=new Dimension(dim.getVert(),dim.getHoriz());
		b=new Grid(d,loc,goalNumber);
		for (r=0; r<dim.getVert(); r++)
		{
			for (c=0; c<dim.getHoriz(); c++)
			{
				b.grid[r][c]=(Square) grid[r][c].clone();
			}
		}

		return b;
	}


	public void setSquare(Location l, Square s) throws IllegalGridException
	/*
		Set method for an element of the "grid" instance variable.
		Pre-condition: the given Location value is defined and
					   valid within the enclosing maze
		Post-condition: the given square is assigned to an element
						of the Grid object selected according to
						the given location within the maze
		Informally: insert the given square into the maze at the
					appropriate location
	*/
	{
		int r;
		int c;

		if (!validMove(l))
		{
			throw new IllegalGridException();
		}
		else
		{
			r=l.getRow();
			c=l.getColumn();
		}

		grid[r-1][c-1]=s;
	}


	public Square getSquare(Location l) throws IllegalGridException
	/*
		Get method for an element of the "grid" instance variable.
		Pre-condition: the given Location value is within the
					   bounds of the current maze
		Post-condition: the Square object at the appropriate
						element of the "grid" selected according
						to the given Location value is returned
		Informally: return the square of the maze at the given
					location, an exception is thrown if the
					location is not within the maze
	*/
	{
		//TODO getSquare
		return grid[l.getRow()-1][l.getColumn()-1]; //get the square at the location specified
	}


	public void setDimension(Dimension d)
	/*
		Set method for the "dim" instance variable.
		Pre-condition: the given Dimension value is defined and
					   valid
		Post-condition: the instance variable "dim" is assigned
						the given Dimension value
		Informally: assign the given dimension to the Grid object
	*/
	{
		dim=d;
	}


	public Dimension getDimension()
	/*
		Get method for "dim" instance variable.
		Pre-condition: none
		Post-condition: the value of the Grid object's
						dimension field is returned
		Informally: return the current maze's dimension
	*/
	{
		return dim;
	}


	public void setLocation(Location l)
	/*
		Set method for the "loc" instance variable.
		Pre-condition: the given Location value is defined and
					   valid
		Post-condition: the instance variable "loc" is assigned
						the given Location value
		Informally: 'move to' the given location on the Grid object
	*/
	{
		loc = l; //move to the specified location
		//TODO setLocation
	}


	public Location getLocation()
	/*
		Get method for "loc" instance variable.
		Pre-condition: none
		Post-condition: the value of the Grid object's
						loc field is returned
		Informally: return the current position within
					the maze
	*/
	{
		return loc; //get the current position in the grid
		//TODO getLocation
	}


	public void occupySquare(Location l, boolean o)
	/*
		Pre-condition: the given Location value is within
					   the bounds of the current Grid
					   object
		Post-condition: the square at the position in the
						maze indicated by the given Location
						value is altered by the visitation
						value indicated in the given Boolean
						value
		Informally: update the visitation component of the
					square at the nominated location of the
					maze with the given value
	*/
	{
		Square s = grid[l.getRow()-1][l.getColumn()-1];
				s.occupied(o); //set the square at the specified locations occupied value to o
		setLocation(s.getLocation());
		//TODO set square visited
	}


	public boolean squareOccupied(Location l)
	/*
		Pre-condition: the given Location value is within
					   the bounds of the current maze
		Post-condition: a Boolean value is returned which
						represents whether the visitation
						property of the square of the
						current Grid object with the given
						Location value is set to true
		Informally: return whether or not the square at
					the given location has been visited
	*/
	{
		//TODO squareOccupied
		return grid[l.getRow()-1][l.getColumn()-1].isOccupied(); //returns true if the square at the specified location has been visited, otherwise false
	}


	public void makeWall(Location l, boolean o)
	/*
		Pre-condition: the given Location value is a valid
					   value within the bounds of the
					   current Grid object
		Post-condition: the Square of the current Grid object
						selected according to the given
						Location value is altered to be a
						wall
		Informally: update the square of the maze at the
					given location to be a wall
	*/
	{
		Square s;

		s=getSquare(l);
		s.solidWall(o);
		setSquare(l,s);
	}


	public boolean isWall(Location l)
	/*
		Pre-condition: the given Location value is within
					   the bounds of the current Grid
					   object
		Post-condition: true is returned if the square at
						the given location within the
						current Grid object is a wall,
						false is returned if it is not
		Informally: return whether or not the square in the
					maze at the given location is a wall
	*/
	{
		return getSquare(l).isWall();
	}


	public void setGoal(int g)
	/*
		Set method for the "goalNumber" instance variable.
		Pre-condition: the given goal number value is defined
					   and valid within the current Grid object
		Post-condition: the instance variable "goalNumber" is
						assigned the given square number value,
						and the square in the maze with that
						square number is located and set as the
						stop square
		Informally: update the square within the maze that has
					the given square number value to be the stop
					square and also remember that square number
					value as the goal
	*/
	{
		Square s;
		int r,c;
		Location l;

		goalNumber=g;
		for (r=1; r<=dim.getVert(); r++)
		{
			for (c=1; c<=dim.getHoriz(); c++)
			{
				l=new Location(r,c);
				s=getSquare(l);
         		if (s.numbered() == goalNumber)
         		{
         			s.stopSquare();
         			setSquare(l,s);
         		}
         	}
		}
	}


	public int getGoal()
	/*
		Get method for "goalNumber" instance variable.
		Pre-condition: none
		Post-condition: the value of the Grid object's
						goalNumber field is returned
		Informally: return the current maze's stop
					square's square number
	*/
	{
		return goalNumber;
	}


	public boolean validMove(Location l)
	/*
		Pre-condition: none
		Post-condition: true is returned if the given
						Location is within the bounds of
						the current Grid object, false is
						returned if it is not
		Informally: return whether or not the given
					location lies within the current maze
	*/
	{
		/*
		 * return true if the row and column provided inside the location object is greater than 0 but less than the column/row length
		 * otherwise return false
		 */
		return (l.getColumn() > 0) && 
				(l.getColumn() < dim.getHoriz()) && 
				(l.getRow() > 0) && 
				(l.getRow() < dim.getVert()); 
		//TODO validMove
	}


	public void showGrid(Display s)
	/*
		Pre-condition: the Display parameter is correctly defined
		Post-condition: the Display representation of the Grid
						object is displayed on the given Display
						with top-left coordinate (35,85) and
						squares of 20 pixels
		Informally: display the current maze
	*/
	{
		final int pixelMultiplier=20;

		int r;
		int c;
		Location l;

		s.getGraphics().setColor(Color.lightGray);
		s.getGraphics().fillRect(35,85,pixelMultiplier*dim.getHoriz(),
									pixelMultiplier*dim.getVert());

		for (r=1; r<=dim.getVert(); r++)
		{
			for (c=1; c<=dim.getHoriz(); c++)
			{
				l=new Location(r,c);
         		getSquare(l).showSquare(s);
         	}
		}
   	}
}
