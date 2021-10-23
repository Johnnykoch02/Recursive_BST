package bst;

/**
 * @author Hassib
 * Project 4
 * Qi Wang
 * @param <e>
 */

public class TreeNode<e> {

	/**
	 * The data portion of this node
	 */
	private e data;
	/**
	 * The reference to left child of this node
	 */
	private TreeNode<e> left;
	/**
	 * The TreeNode<T> to right child of this node
	 */
	private TreeNode<e> right;
	
	/**
	 * Constructs a default node.
	 */
	public TreeNode() {
		this(null, null, null);
	}
	
	/**
	 * Constructs a node with a specific element.
	 * @param data A reference to the item of this node
	 */
	public TreeNode(e data) {
		this(data, null, null);
	}
	
	/**
	 * Constructs a node with an element and two descendant nodes. 
	 * @param data A reference to the data of this node
	 * @param left Reference to the left child of this node
	 * @param right Reference to the right child of this node
	 */
	public TreeNode(e data, TreeNode<e> left, TreeNode<e> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Returns the element of this node.
	 * @return A reference to the data of this node
	 */
	public e getData() {
		return this.data;
	}
	
	/**
	 * Changes the element of this node.
	 * @param data The element of this node
	 */
	public void setData(e data) {
		this.data = data;
	}
	
	/**
	 * Returns the left child of this node.
	 * @return A reference to the left child of this node
	 */
	public TreeNode<e> getLeft() {
		return this.left;
	}
	
	/**
	 * Returns the right child of this node. 
	 * @return A reference to the right child of this node
	 */
	public TreeNode<e> getRight() {
		return this.right;
	}
	
	/**
	 * Changes the left child of this node.
	 * @param leftChild A reference to the left child of this node
	 */
	public void setLeft(TreeNode<e> left) {
		this.left = left;
	}
	
	/**
	 * Changes the right child of this node. 
	 * @param rightChild A reference to the right child of this node
	 */
	public void setRight(TreeNode<e> right) {
		this.right = right;
	}
}
