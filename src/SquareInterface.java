/*
	Square ADT
	Author: J.R.Dermoudy
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


public interface SquareInterface
{
	//public Square(Location l);
	//public Square(Location l,int n);
	//public Square(Location l, boolean o, boolean g, int n);
	public Object clone();
	public Location getLocation();
	public void setLocation(Location l);
	public Color getColour();
	public void setColour(Color c);
	public boolean isWall();
	public void solidWall(boolean w);
	public boolean isOccupied();
	public void occupied(boolean o);
	public int numbered();
	public void squareNumber(int n);
	public boolean isStopSquare();
	public void stopSquare();
	public boolean isStartSquare();
	public void startSquare();
	public void showSquare(Display s);
}
