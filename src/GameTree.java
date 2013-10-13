/*
	GameTree ADT
	Author: J.R. Dermoudy & <<INSERT YOUR NAME HERE>>
	Date: September 2013

	This file holds the GameTree ADT which is a
	doubly-linked ternary game tree.  The GameTree is
	built using TNode ADTs.  A GameTree object consists
	of a "root" field which refers to a TNode object
	which has a "data" field and "left", "forward",
	and "right" references.
*/


public class GameTree implements GameTreeInterface
{
	private TNode root;	// the node at the top of the tree


	public GameTree()
	/*
		Constructor method 1.
		Pre-condition: none
		Post-condition: the GameTree object's "first" field is null
		Informally: creates an empty tree
	*/
	{
		root = null;
	}


	public GameTree(Object o)
	/*
		Constructor method 2.
		Pre-condition: none
		Post-condition: the GameTree object's "first" field refers
						to a new TNode object containing the
						parameter value (o) with a null parent
						and null children
		Informally: create a tree of a single node (i.e. a leaf)
					with the node value provided on the parameter
					list
	*/
	{
COMPLETE ME
	}


	public GameTree(Object o,GameTree p)
	/*
		Constructor method 3.
		Pre-condition: none
		Post-condition: the GameTree object's "first" field refers
						to a new TNode object containing the
						parameter value (o) with "parent" field
						of the parameter value (p) and null
						children
		Informally: create a tree of a single node (i.e. a leaf)
					with the node value provided on the parameter
					list and the given parent
	*/
	{
COMPLETE ME
	}


	public boolean isEmpty()
	/*
		Pre-condition: none
		Post-condition: true is returned if the GameTree object has no
						items, false is returned if it does
		Informally: indicate if the GameTree contains no nodes
	*/
	{
COMPLETE ME
	}


	public Object getData() throws EmptyGameTreeException
	/*
		Get method for "data" instance variable.
		Pre-condition: none
		Post-condition: the value of the GameTree object's data
						field is returned
		Informally: return the value within the root node,
					throw an exception if the tree is empty
	*/
	{
		if (isEmpty())
		{
			throw new EmptyGameTreeException();
		}

		return root.getData();
	}


	public GameTree getParent() throws EmptyGameTreeException
	/*
		Get method for "parent" instance variable.
		Pre-condition: none
		Post-condition: the value of the GameTree object's parent
						field is returned in a newly
						constructed GameTree object
		Informally: return the GameTree object's parent, throw an
						exception if the tree is empty
	*/
	{
		GameTree r;

		if (isEmpty())
		{
			throw new EmptyGameTreeException();
		}

		r=new GameTree();
		r.root=root.getParent();

		return r;
	}


	public GameTree getLeft() throws EmptyGameTreeException
	/*
		Get method for "left" instance variable.
		Pre-condition: none
		Post-condition: the value of the GameTree object's left
						field is returned in a newly
						constructed GameTree object
		Informally: return the GameTree object's left child, throw
						an exception if the tree is empty
	*/
	{
COMPLETE ME
	}


	public GameTree getForward() throws EmptyGameTreeException
	/*
		Get method for "forward" instance variable.
		Pre-condition: none
		Post-condition: the value of the GameTree object's forward
						field is returned in a newly
						constructed GameTree object
		Informally: return the GameTree object's forward child,
						throw an exception if the tree is empty
	*/
	{
COMPLETE ME
	}


	public GameTree getRight() throws EmptyGameTreeException
	/*
		Get method for "right" instance variable.
		Pre-condition: none
		Post-condition: the value of the GameTree object's right
						field is returned in a newly
						constructed GameTree object
		Informally: return the GameTree object's right child,
						throw an exception if the tree is empty
	*/
	{
COMPLETE ME
	}


	public void setData(Object o) throws EmptyGameTreeException
	/*
		Set method for "data" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's data field is altered to
						hold the given (o) value
		Informally: store the given value in the root node of the
					GameTree object, throw an exception if the tree is
					empty
	*/
	{
		if (isEmpty())
		{
			throw new EmptyGameTreeException();
		}

		root.setData(o);
	}


	public void setParent(GameTree t) throws EmptyGameTreeException
	/*
		Set method for "parent" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's parent field is altered
						to hold the given (t) value
		Informally: assign the given value as the parent of the
					GameTree object, throw an exception if the tree is
					empty
	*/
	{
		if (isEmpty())
		{
			throw new EmptyGameTreeException();
		}

		root.setParent(t.root);
	}


	public void setLeft(GameTree t) throws EmptyGameTreeException
	/*
		Set method for "left" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's left field is altered
						to hold the given (t) value
		Informally: assign the given value as the left child of
					the GameTree object, throw an exception if the tree
					is empty
	*/
	{
COMPLETE ME
	}


	public void setForward(GameTree t) throws EmptyGameTreeException
	/*
		Set method for "forward" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's forward field is
						altered to hold the given (t) value
		Informally: assign the given value as the forward child of
					the GameTree object, throw an exception if the tree
					is empty
	*/
	{
COMPLETE ME
	}


	public void setRight(GameTree t) throws EmptyGameTreeException
	/*
		Set method for "right" instance variable.
		Pre-condition: none
		Post-condition: the TNode object's right field is
						altered to hold the given (t) value
		Informally: assign the given value as the right child of
					the GameTree object, throw an exception if the tree
					is empty
	*/
	{
COMPLETE ME
	}


	public String rootNodeToString()
	/*
		Pre-condition: none
		Post-condition: a String object is returned consisting of the
					String representation of the value within the
					root node, followed by " " or "<>" if the GameTree
					object is the empty tree
		Informally: produce a String representation of the tree's root
					node
	*/
	{
		String s="";
		if (isEmpty())
		{
			return "<>";
		}
		else
		{
			s=s+getData().toString() + " ";
		}
		return s;
	}


	public String toString()
	/*
		Pre-condition: none
		Post-condition: a String object is returned consisting of the
					String representation of all items in the GameTree,
					from top to bottom in depth-first order (left,
					forward, right), separated by " " and
					contained within "<" and ">"
		Informally: produce a String representation of the Stack
	*/
	{
		GameTree c;

		String s="";
		if (isEmpty())
		{
			return "<>";
		}
		else
		{
			s=s.concat(rootNodeToString());
			//Uncomment the following to see the remainder of the tree
			/*c=getLeft();
			if (! c.isEmpty())
			{
				s=s+(c.toString());
			}
			c=getForward();
			if (! c.isEmpty())
			{
				s=s+(c.toString());
			}
			c=getRight();
			if (! c.isEmpty())
			{
				s=s+(c.toString());
			}/**/
		}
		return s;
	}
}
