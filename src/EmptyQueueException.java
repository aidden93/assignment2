/*
	Empty Queue Exception
	Author: J.R. Dermoudy
	Date: September 2013

	This file holds the Empty Queue Exception.  This
	is used when Queue ADTs are accessed and errors
	result.  Specifically, EmptyQueueException objects
	are created and thrown when attempts are made to
	set/get instance variables in an empty Queue through
	front()/remove().
*/


public class EmptyQueueException extends RuntimeException
{
	public EmptyQueueException()
	{
		super("Cannot access a component of an empty queue...");
	}
}