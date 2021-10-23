package Addressbook;

/**
 * Project 4
 * Qi Wang
 */

import bst.BinaryTree;
	import bst.TreeIterator;
	import bst.TreeNode;

public interface AddressbookADT {
		
	/**
	 * Makes the Addressbook empty
	 */
	public void clear();

	/**
	 * Gets number of contacts
	 * @return count of contacts
	 */
	public int count();
		
	/**
	 * Searches for the contact with name
	 * @param name of contact being looked for
	 * @return the contact found or throw a TreeException
	 * @throws TreeException if the Contact isnt found
	 */
	public TreeNode<Contact> search(String name);
	
	/**
	 * Returns the iterator for this Addressbook
	 * @return TreeIterator of contacts
	 */
	public TreeIterator<Contact> iterator();
		
	/**
	 * Adds a new contact into the Addressbook
	 * @param data is the Contact being added
	 */
	public void add(Contact data);
		
	/**
	 * Removes this contact from the Binary Tree
	 * @param name is the contacts name
	 */
	public void remove(String name);

	/**
	 * Sees if the Addressbook is empty
	 * @return Empty or not Empty (true/false)
	 */
	public boolean isEmpty();
		

}


