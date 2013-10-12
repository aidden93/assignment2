/*
	GameTree ADT
	Author: J.R. Dermoudy
	Date: September 2013

	This file holds the GameTree ADT which is a
	doubly-linked ternary game tree.  The GameTree is
	built using TNode ADTs.  A GameTree object consists
	of a "root" field which refers to a TNode object
	which has a "data" field and "left", "forward",
	and "right" references.
*/


public interface GameTreeInterface
{
	//public GameTree();
	//public GameTree(Object o);
	//public GameTree(Object o, GameTree p);
	public boolean isEmpty();
	public void setData(Object o) throws EmptyGameTreeException;
	public Object getData() throws EmptyGameTreeException;
	public void setLeft(GameTree c) throws EmptyGameTreeException;
	public GameTree getLeft() throws EmptyGameTreeException;
	public void setForward(GameTree s) throws EmptyGameTreeException;
	public GameTree getForward() throws EmptyGameTreeException;
	public void setRight(GameTree s) throws EmptyGameTreeException;
	public GameTree getRight() throws EmptyGameTreeException;
	public void setParent(GameTree p) throws EmptyGameTreeException;
	public GameTree getParent() throws EmptyGameTreeException;
	public String toString();
}
