/*
	Queue ADT
	Author: J.R. Dermoudy & <<Aidden Mazey>>
	Date: September 2013

	This file holds the Queue ADT.  The Queue is built
	using a linked list of Node ADTs.  A Queue object
	consists of a "first" field which refers to a Node
	object.
*/


public class Queue implements QueueInterface
{
	private Node first;	// the node at the front of the queue


	public Queue()
	/*
		Constructor method 1.
		Pre-condition: none
		Post-condition: the Queue object's "first" field is null
		Informally: intialises the instance variable of the newly
					created Queue object by terminating the
					"first"	field
	*/
	{
		first = null; //set first to null (creates an empty queue)
		//TODO constructor
	}


	public Queue(Object o)
	/*
		Constructor method 2.
		Pre-condition: none
		Post-condition: the Queue object holds a reference to a Node
						object within its "first" field which holds
						the parameter value (o)
		Informally: intialises the instance variable ("first") of
					the newly created Queue object to hold a
					reference to a new Node object containing the
					given parameter
	*/
	{
		first = new Node(o); //set the first object in the queue to a new node containing object o
		//TODO constructor
	}


	public boolean isEmpty()
	/*
		Pre-condition: none
		Post-condition: true is returned if the Queue object has no
						items, false is returned if it does
		Informally: examine the Queue object's first instance variable
						returning whether or not it is null
	*/
	{
		return first == null; //return true if first is null (queue is empty), otherwise false
		//TODO isEmpty
	}


	public Object front() throws EmptyQueueException
	/*
		Pre-condition: the queue is non-empty
		Post-condition: a reference to the item at the front of the
						queue is returned
		Informally: return a reference to the front of the Queue or
					throw an exception if the Queue is empty
	*/
	{
		if (isEmpty()) //check if queue is empty
			throw new EmptyQueueException(); //if empty, throw exception. nothing in the queue
		//TODO front
		return first.getData();
	}


	public void remove() throws EmptyQueueException
	/*
		Pre-condition: the queue is non-empty
		Post-condition: the "first" instance variable is re-assigned
						to refer to the value of the second Node
						object in the linked list
		Informally: bypass the node at the front of the Queue so that
					the second node in the Queue becomes the front.
					If the Queue is empty, throw an exception
	*/
	{
		if (isEmpty()) //check if queue is empty
			throw new EmptyQueueException(); //if empty throw exception. nothing to remove
		//TODO remove
		first = first.getNext(); //set the second object in the queue as the first object, thus removing the first item from the queue
	}


	public void add(Object o)
	/*
		Pre-condition: none
		Post-condition: a new Node object containing the parameter
						(o) is created and referred to by the "next"
						field of the last Node in the linked list.
						The "first" instance variable is assigned to
						refer to this node if its original value
						was null
		Informally: create a new Node and append it	after the others
					on the stack making it the last item in the
					queue
	*/
	{
		if (isEmpty()) { //check if empty
			first = new Node(o); //if empty set first object in queue to a new node containing object o
		}
		else { //otherwise
			Node n = new Node(o); //create a new node containing the object o
			Node c = first; //create a new node c, and set it to first
			
			while(c.getNext() != null) { //while c has a next object, continue looping
				c = c.getNext(); //set c to the next object
			}
			c.setNext(n); //add the new node n to the end of the queue 
		}
		//TODO add
	}


	public String toString()
	/*
		Pre-condition: none
		Post-condition: a String object is returned consisting of the
					String representation of all items in the Queue,
					from first to last in order, separated by " " and
					contained within "<" and ">"
		Informally: produce a String representation of the Queue
	*/
	{
		Node c;

		String s="";
		if (isEmpty())
		{
			return "<>";
		}
		else
		{
			c=first;
			while (c != null)
			{
				s=s.concat(c.getData().toString() + " ");
				c=c.getNext();
			}
			return s;
		}
	}
}
