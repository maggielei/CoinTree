/**
 * The GameNode class creates individual nodes that store the number of 
 * pennies per node.
 * 
 * @author Maggie Lei
 * ID: 1087990364
 * Recitation: 04
 * Homework #5 for CSE 214, Fall 2013
 */
public class GameNode {
	/**
	 * The number of pennies in a node.
	 */
	private int numPennies;
	/**
	 * The left child of a node.
	 */
	private GameNode left;
	/**
	 * The middle child of a node.
	 */
	private GameNode middle;
	/**
	 * The right child of a node.
	 */
	private GameNode right;
/**
 * Constructor for the GameNode class. Accepts an integer parameter that
 * sets the number of pennies for the new GameNode. Sets the left, middle, and
 * right GameNodes to null.
 * @param initPennies
 * The number of pennies to be stored in the new GameNode.
 */
public GameNode(int initPennies){
	numPennies = initPennies;
	left = null;
	middle = null;
	right = null;
}
/**
 * This method changes the number of pennies in a node.
 * @param newNum
 * The new number of pennies to change to.
 */
public void setNumPennies(int newNum){
	this.numPennies = newNum;
}
/**
 * This method returns the number of pennies in a specific node.
 * @return
 * Returns the node's number of pennies.
 */
public int getNumPennies(){
	return this.numPennies;
}
/**
 * This method sets the left link of a node to a new node.
 * @param newLeft
 * The GameNode that is being linked to the left.
 */
public void setLeft(GameNode newLeft){
	this.left = newLeft;
}
/**
 * This method returns the left node that is linked on.
 * @return
 * Returns the left node (or left child).
 */
public GameNode getLeft(){
	return this.left;
}
/**
 * This method sets the middle link of a node to a new node.
 * @param newMid
 * The GameNode that is being linked to the middle.
 */
public void setMiddle(GameNode newMid){
	this.middle = newMid;
}
/**
 * This method returns the middle node that is linked on.
 * @return
 * Returns the middle node (or middle child).
 */
public GameNode getMiddle(){
	return this.middle;
}
/**
 * This method sets the right link of a node to a new node.
 * @param newRight
 * The GameNode that is being linked to the right.
 */
public void setRight(GameNode newRight){
	this.right = newRight;
}
/**
 * This method returns the right node that is linked on.
 * @return
 * Returns the right node (or right child).
 */
public GameNode getRight(){
	return this.right;
}
/**
 * This method returns the number of leaves in a subtree recursively.
 * @param x
 * The GameNode to start counting the number of leaves at. Does not have to be the root.
 * @return
 * Returns the number of leaves in the subtree. If the GameNode x is null, this method returns 0. 
 * If the GameNode x does not have any children (left, middle, or right GameNodes) this method returns 1.
 * If the GameNode x is a parent, the method calls itself and traverses down the subtree.
 */
public int numLeaves(GameNode x){
	if(x == null){
		return 0;
	}
	if(x.getLeft() == null && x.getMiddle() == null && x.getRight() == null){
		return 1;
	}
	else{
		return numLeaves(x.getLeft()) + numLeaves(x.getMiddle()) + numLeaves(x.getRight());
	}
}
}
