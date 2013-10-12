/*
	GameTree Node ADT
	Author: J.R. Dermoudy
	Date: September 2013

	This file holds the GameTree Node ADT which represents
	the nodes in a doubly-linked ternary tree.  GameTree
	nodes consist of a "data" field and four references
	to other nodes (these being the parent node ("parent"),
	and the three child nodes ("left", "forward", and
	"right")).
*/


public class TNode implements TNodeInterface
{
	private Object data;	// the value stored in the node
	private TNode parent;	// the parent node to the current node
	private TNode left;		// the left child node of the current node
	private TNode forward;	// the forward child node of the current node
	private TNode right;	// the right child node of the current node


	public TNode(Object o)
	/*
		Constructor method 1.
		Pre-condition: none
		Post-condition: the TNode object holds the parameter value
						(o) within its "data" field and its "parent",
						"left", "forward", and "right" fields are null
		Informally: intialises the instance variables of the newly
					created TNode object to hold the given parameter
					and to terminate the "parent", "left", "forward",
					and "right" fields
	*/
	{
		data=o;
		parent=null;
		left=null;
		forward=null;
		right=null;
	}


	public TNode(Object o, TNode p)
	/*
		Constructor method 2.
		Pre-condition: the parent parameter (p) is defined to be a
					   valid TNode reference value
		Post-condition: the TNode object holds the parameter value
						(o) within its "data" field and the parameter
						value (p) within its "parent" field, and the
						"left", "forward", and "right" fields are null
		Informally: intialises the instance variables of the newly
					created TNode object to hold the given parameter
					value (o) and have the given parameter (p) as
					parent and to terminate the "parent", "left",
					"forward", and "right" fields
	*/
	{
		data=o;
		parent=p;
		left=null;
		forward=null;
		right=null;
	}


	public void setData(Object o)
	/*
		Set method for "data" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's data field is altered to
						hold the given (o) value
		Informally: assign the value of the parameter to the TNode
					object's "data" instance variable
	*/
	{
		data=o;
	}


	public void setParent(TNode n)
	/*
		Set method for "parent" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's parent field is altered to
						hold the given (n) value
		Informally: assign the value of the parameter to the TNode
					object's "parent" instance variable
	*/
	{
		parent=n;
	}


	public void setLeft(TNode n)
	/*
		Set method for "left" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's left field is altered to
						hold the given (n) value
		Informally: assign the value of the parameter to the TNode
					object's "left" instance variable
	*/
	{
		left=n;
	}


	public void setForward(TNode n)
	/*
		Set method for "forward" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's forward field is altered
						to hold the given (n) value
		Informally: assign the value of the parameter to the TNode
					object's "forward" instance variable
	*/
	{
		forward=n;
	}


	public void setRight(TNode n)
	/*
		Set method for "right" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's right field is altered
						to hold the given (n) value
		Informally: assign the value of the parameter to the TNode
					object's "right" instance variable
	*/
	{
		right=n;
	}


	public Object getData()
	/*
		Get method for "data" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's data field is returned
		Informally: examine the TNode object's "data" instance
					variable returning its value
	*/
	{
		return data;
	}


	public TNode getParent()
	/*
		Get method for "parent" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's parent field is
						returned
		Informally: examine the TNode object's "parent" instance
					variable returning its value
	*/
	{
		return parent;
	}


	public TNode getLeft()
	/*
		Get method for "left" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's left field is returned
		Informally: examine the TNode object's "left" instance
					variable returning its value
	*/
	{
		return left;
	}


	public TNode getForward()
	/*
		Get method for "forward" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's forward field is
						returned
		Informally: examine the TNode object's "forward"
					instance variable returning its value
	*/
	{
		return forward;
	}


	public TNode getRight()
	/*
		Get method for "right" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's right field is
						returned
		Informally: examine the TNode object's "right" instance
					variable returning its value
	*/
	{
		return right;
	}
}
