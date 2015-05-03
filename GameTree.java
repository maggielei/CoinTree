/**
 * The GameTree class creates the tree structure for the game. It links the GameNodes together creating the tree.
 * 
 * @author Maggie Lei
 * ID: 1087990364
 * Recitation: 04
 * Homework #5 for CSE 214, Fall 2013
 */
public class GameTree {
	/**
	 * The first GameNode in the tree. In respect to the game, this GameNode stores the starting number of
	 * pennies. 
	 */
	private GameNode root;
	/**
	 * A cursor used to navigate the tree. 
	 */
	private GameNode gamePosition;
	/**
	 * Constructor for the class. It takes in an integer parameter (starting number of pennies)
	 * to construct the whole tree. It calls the method createTree that creates subtrees recursively.
	 * @param N
	 * Starting number of pennies to create the tree with.
	 */
	public GameTree(int N){
		root = new GameNode(N);
		gamePosition = root;
		createTree(N, root);
	}
	/**
	 * This method takes in parameters to construct the game tree recursively. The left node stores one penny 
	 * less than the starting number of pennies. The middle node stores two pennies less than the starting number
	 * of pennies. The right node stores three pennies less than the starting number of pennies. If the number of pennies
	 * is 0, the method finishes. Otherwise, each if statement creates a node and links it to the correct direction. Then,
	 * the method is called again to create subtrees off of the new node created. 
	 * @param n
	 * The number of pennies to start constructing the subtree with.
	 * @param node
	 * The GameNode to build a subtree off of. 
	 */
	private void createTree(int n, GameNode node){
		if(n <= 0){
			return;
		}
		if((n-1) >= 0){
			GameNode leftNode = new GameNode(n-1);
			node.setLeft(leftNode);
			createTree(n-1, leftNode);
		}
		if((n-2) >= 0){
			GameNode midNode = new GameNode(n-2);
			node.setMiddle(midNode);
			createTree(n-2, midNode);
		}
		if((n-3) >= 0){
			GameNode rightNode = new GameNode(n-3);
			node.setRight(rightNode);
			createTree(n-3, rightNode);
		}
	}
	/**
	 * This method returns the number of possible ways the game can be played. It counts the number of leaves
	 * in the whole tree. Therefore, this method calls the numLeaves method on the root GameNode.
	 * @return
	 * Returns the number of leaves on the root. (The total number of leaves in the entire tree.)
	 */
	public int possibleWays(){
		return root.numLeaves(root);
	}
	/**
	 * This method removes the pennies in the game. If 1 penny is removed, the tree progresses down the left link. If 
	 * 2 pennies are removed, the tree progresses down the middle link. If 3 pennies are removed, the tree progress 
	 * down the right link.
	 * @param x
	 * The number of pennies to be removed. (Must be between 1 and 3. Otherwise, an exception is thrown.)
	 */
	public void removePennies(int x){
		if(x == gamePosition.getLeft().getNumPennies()){
			gamePosition = gamePosition.getLeft();
		}
		else if(x == gamePosition.getMiddle().getNumPennies()){
			gamePosition = gamePosition.getMiddle();
		}
		else if(x == gamePosition.getRight().getNumPennies()){
			gamePosition = gamePosition.getRight();
		}
		else{
			throw new IllegalArgumentException("Invalid input.");
		}

	}
	/**
	 * This method returns the current number of pennies in the GameNode. It returns the number of pennies
	 * in the gamePosition node since the gamePosition node is the current GameNode.
	 * @return
	 * Returns number of pennies in the gamePosition node. 
	 */
	public int currentNumPennies(){
		return gamePosition.getNumPennies();
	}
}
