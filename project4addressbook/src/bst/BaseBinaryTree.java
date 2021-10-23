package bst;

/**
 * @author Hassib
 * Project 4
 * Qi Wang
 * @param <e>
 */

public abstract class BaseBinaryTree<e> {
	 /**
	   * The root of this tree
	   */
	protected TreeNode<e> root;
	/**
	  * Creates an empty binary tree.
	  */
	
	public BaseBinaryTree() {
		this(null);		 
	  }
	
	 /**
	   * Creates a one-node binary tree whose root contains a root item.
	   * @param rootItem The item of the root
	   */
	public BaseBinaryTree(e data) {
		this.root = new TreeNode<e>( data, null, null);
	}
	
	/**
	  * Returns true if the tree is empty, else returns false.
	  * @return A value specifying if the tree is empty
	  */
	public boolean isEmpty() {
		  return this.root == null;
	}
	
	/**
	 * Removes all nodes from the tree.
	 */
	public void makeEmpty() {
	    this.root = null;
	  }
	
	 /**
	   * Returns the element in the tree's root.
	   * @return A reference to the item of the root
	   * @throws TreeException if the tree is empty
	   */
	  public e getRoot() throws TreeException {
	    if (this.root == null) {
	      throw new TreeException("TreeException: Empty tree");
	    }
	    else {
	      return this.root.getData();
	    }
	    
	  }
	  
	  /**
	   * Changes the root element of this binary tree. An UnsupportedOperationException object is 
	   * thrown if operation is not supported.
	   * @param newItem A reference to the new root
	   * @throws  UnsupportedOperationException if operation is not supported.
	   */
	  public abstract void setRoot(e newItem) throws UnsupportedOperationException;
	    
}
