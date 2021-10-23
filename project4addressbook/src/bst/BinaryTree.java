package bst;

/**
 * Project 4
 * Qi Wang
 * @param <e>
 */

public class BinaryTree<e extends Comparable<e>> extends BaseBinaryTree<e> {

	/**
	 * Creates an empty BinaryTree
	 */
	public BinaryTree() {
		super.root = null;
	}
	/**
	 * BinaryTree Constructor with data as the root data
	 * @param data is the root data for the superclass
	 */
	public BinaryTree(e data) {
		super(data);
	}
	
	/**
	 * Overrides SuperClass Method to set Root's Data
	 */
	@Override
	public void setRoot(e newItem) throws UnsupportedOperationException {
		super.root.setData(newItem);
	}
	
	/**
	 * Inserts data into the BinaryTree in the right Position
	 * @param data is the data being inserted
	 */
	public void insert(e data) {
		if (super.root == null)
		{
			super.root = new TreeNode<e>(data, null, null); 
		}
		else {
			TreeNode<e> node = new TreeNode<e>(data, null, null);		
			ins(node, super.root);
		}
	}
	
	/**
	 * This method recursively calls itself until it finds the right spot to put node
	 * @param node is the TreeNode being inserted
	 * @param current keeps track of the current node
	 */
	private void ins(TreeNode<e> node, TreeNode<e> current) {	
		
		/**
		 * Check to see if we found the right spot to put our node
		 */
		if(node.getData().compareTo(current.getData()) < 0) 
		{
			if(current.getLeft() != null)
			{
				ins(node, current.getLeft()); // the right spot is left of the current node
			} else current.setLeft(node); // we found the right spot		
		}
		
		else if(node.getData().compareTo(current.getData()) > 0)
		{
			if(current.getRight() != null)
			{
				ins(node, current.getRight()); // the right  spot is right of the current node
			} else current.setRight(node);	 // we found the right spot
		}
		
	}
	
	/**
	 * Public search method for BinaryTree
	 * @param data is the data being searched for
	 * @return a TreeNode with data, or null if data is not in the BinaryTree
	 */
	public TreeNode<e> search(e data) {
		return searchRecursive(data,  root);
	}
	
	/**
	 * Recursively finds the data and returns it
	 * @param data is the data being searched for
	 * @param current keeps track of the current node
	 * @return a TreeNode with data, or null if data is not in the BinaryTree
	 */
	private TreeNode<e> searchRecursive(e data, TreeNode<e> current) throws TreeException {
		/**
		 * Check if current is our node
		 */
		if(data.compareTo(current.getData()) == 0) return current;
		/**
		 * Check to see if it is to the left
		 */
		if(data.compareTo(current.getData()) < 0)
		{
			if(current.getLeft() != null)
			{
				return searchRecursive(data, current.getLeft()); //search left of the current
			} else throw new TreeException("Data Not Found.");	 // item is not in our list
		}
		/**
		 * Check to see if it is to the right
		 */
		else if(data.compareTo(current.getData()) > 0)
		{
			if(current.getRight() != null)
			{
				return searchRecursive(data, current.getRight()); //search right of the current
			} else throw new TreeException("Data Not Found.");	//item is not in our list
		}
		return current;	
	}
	
	public void remove(e data) throws TreeException {
		removeRecursive(data, super.root, super.root, "right"); // putting previous to null and side to null throws a nullpointerexception
	}
	
	private void removeRecursive(e data, TreeNode<e> current, TreeNode<e> previous, String side) throws TreeException {
		if(current == null)
			throw new TreeException("Data Not Found"); // Data is not in our tree
		/**
		 * the data is left of the current node
		 */
		if(data.compareTo(current.getData()) < 0) 
		{
			removeRecursive(data, current.getLeft(), current, "left");
		}
		/**
		 * the data is right of the current node
		 */
		else if(data.compareTo(current.getData()) > 0) 
		{
			removeRecursive(data, current.getRight(), current, "right");
		}
		/**
		 * Element is Found
		 */
		else {
			if(current.getLeft() == null && current.getRight() == null)//Has no Children
			{

				System.out.println(current.getData().toString());
				if (current == previous.getLeft()) previous.setLeft(null);
				else previous.setRight(null);
			}
			else if(current.getLeft() != null && current.getRight() == null) //One branch
			{

				if(side.equalsIgnoreCase("left")) { //from left
					previous.setLeft(current.getLeft());
				}
				else previous.setRight(current.getLeft());// from right
			}
			else if(current.getRight() != null && current.getLeft() == null) { // One branch

				if(side.equalsIgnoreCase("right")) { //from right
					previous.setRight(current.getRight());
				}
				else previous.setLeft(current.getRight()); //from left
			}
			else // Current has 2 children
			{

				TreeNode<e> newMax = findMax(current.getRight());	// newMax variable
				current.setData(newMax.getData());	// to set currents data, and then 
//				System.out.println(newMax.getData().toString());
//				System.out.println(current.getData().toString());
				removeRecursive(newMax.getData(), current.getRight(), current, "right"); // remove newMax	
			}
		}
		
		
	}
	
	/**
	 * Finds next maximum element in the BinaryTree
	 * @param node is the current node
	 * @return The max node
	 */
	private TreeNode<e> findMax(TreeNode<e> node) {
		while(node.getLeft() != null)
		{
			node = node.getLeft();
		}
		return node;		
	}
	
	/**
	 * Iterator of Binary Tree
	 * @return a Tree Iterator for this BinaryTree
	 */
	public TreeIterator<e> iterator() {
		return new TreeIterator<e>(this);
	}

}
