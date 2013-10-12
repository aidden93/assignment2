/*
	GameTree Node ADT
	Author: J.R. Dermoudy
	Date: September 2013

	This file holds the GameTree Node ADT which represents
	the nodes in a doubly-linked ternary tree.  Game tree
	nodes consist of a "data" field and four references
	to other nodes (these being the parent node ("parent"),
	and the three child nodes ("left", "forward", and
	"right")).
*/


public interface TNodeInterface
{
	//public TNode(Object o);
	//public TNode(Object o, TNode p);
	public void setData(Object o);
	public Object getData();
	public void setParent(TNode n);
	public TNode getParent();
	public void setLeft(TNode n);
	public TNode getLeft();
	public void setForward(TNode n);
	public TNode getForward();
	public void setRight(TNode n);
	public TNode getRight();
}
