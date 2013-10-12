/*
	Dimension ADT
	Author: J.R.Dermoudy
	Date: September 2013

	This file holds the Dimension ADT which represents
	the two-dimensional size of a maze.  The maze's
	dimension consists of vertical and horizontal
	components.
*/


public interface DimensionInterface
{
	//public Dimension(int v, int h);
	public void setVert(int v);
	public void setHoriz(int h);
	public int getVert();
	public int getHoriz();
}


