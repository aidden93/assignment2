/*
	Empty GameTree Exception
	Author: J.R. Dermoudy
	Date: September 2013

	This file holds the Empty GameTree Exception.  This is
	used when Game Tree ADTs are accessed and errors
	result.  Specifically, EmptyGameTreeException objects
	are created and thrown when attempts are made to
	set/get instance variables in an empty Game Tree.
*/


class EmptyGameTreeException extends RuntimeException {
	public EmptyGameTreeException()
	{
		super("Cannot access a component of an empty game tree...");
	}
}