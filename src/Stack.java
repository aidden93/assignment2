/*
	Stack ADT
	Author: J.R. Dermoudy & <<Aidden Mazey>>
	Date: September 2013

	This file holds the Stack ADT.  The Stack is built
	using a linked list of Node ADTs.  A Stack object
	consists of a "tos" field which refers to a Node
	object.
 */


public class Stack implements StackInterface
{
	private Node tos;	// the node on the top of the stack


	public Stack()
	/*
		Constructor method 1.
		Pre-condition: none
		Post-condition: the Stack object's "tos" field is null
		Informally: intialises the instance variable of the newly
					created Stack object by terminating the "tos"
					field
	 */
	{
		tos = null; //set top of stack to null (there is no stack)
		//TODO constructor
	}


	public Stack(Object o)
	/*
		Constructor method 2.
		Pre-condition: none
		Post-condition: the Stack object holds a reference to a Node
						object within its "tos" field which holds
						the parameter value (o)
		Informally: intialises the instance variable ("tos") of the
					newly created Stack object to hold a reference to
					a new Node object containing the given parameter
	 */
	{
		tos = new Node(o); //set top of stack to be a new node containing object o
		//TODO constructor
	}


	public boolean isEmpty()
	/*
		Pre-condition: none
		Post-condition: true is returned if the Stack object has no
						items, false is returned if it does
		Informally: examine the Stack object's tos instance variable
						returning whether or not it is null
	 */
	{
		return tos == null; //return true if top of stack is null
		//TODO isEmpty
	}


	public Object top() throws EmptyStackException
	/*
		Pre-condition: the stack is non-empty
		Post-condition: a reference to the item on the top of the
						stack is returned
		Informally: return a reference to the top of the Stack or
					throw an exception if the Stack is empty
	 */
	{
		if (isEmpty()) //check if the stack is empty
			throw new EmptyStackException(); //if stack is empty throw an exception. no objects in stack to return
		//TODO top
		return tos.getData(); //return the node at the top of the stack
	}


	public void pop() throws EmptyStackException
	/*
		Pre-condition: the stack is non-empty
		Post-condition: the "tos" instance variable is re-assigned to
						refer to the value of the second Node object
						in the linked list
		Informally: bypass the node on the top of the Stack so that
					the second node on the Stack becomes the top.  If
					the Stack is empty, throw an exception
	 */
	{
		if (isEmpty()) //check if the stack is empty
			throw new EmptyStackException(); //if empty throw an exception. no objects in stack to remove
		//TODO pop
		tos = tos.getNext(); //remove node at top of stack by setting top of stack to the next node
	}


	public void push(Object o)
	/*
		Pre-condition: none
		Post-condition: the Stack object's instance variable "tos" is
						made to refer to a new Node object containing
						the parameter (o) and the Node's "next" field
						is assigned the original value of the "tos"
						instance variable
		Informally: create a new Node and insert it	before the others
					on the stack making it the new top of stack
	 */
	{
		if (isEmpty()) { //check is stack is empty
			tos = new Node(o); //if empty set top of stack to a new node containing the object o
		}
		else { //otherwise
			Node n = new Node(o); //create a new node containing object o
			n.setNext(tos); //set the new nodes next field to top of stack
			tos = n; //set top of stack to the new node
		}
		//TODO push
	}


	public String toString()
	/*
		Pre-condition: none
		Post-condition: a String object is returned consisting of the
					String representation of all items on the Stack,
					from top to bottom in order, separated by " " and
					contained within "<" and ">"
		Informally: produce a String representation of the Stack
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
			c=tos;
			while (c != null)
			{
				s=s.concat(c.getData().toString() + " ");
				c=c.getNext();
			}

			return s;
		}
	}
}
