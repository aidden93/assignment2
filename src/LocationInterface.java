/*
	Location ADT
	Author: J.R.Dermoudy
	Date: September 2013

	This file holds the Location ADT which represents
	indices to (positions within) the two-dimensional maze.
	A Location consists of a Row number and a Column number.
*/


public interface LocationInterface
{
	//public Location(int r, int c);
	public void setRow(int r);
	public void setColumn(int c);
	public int getRow();
	public int getColumn();
}
