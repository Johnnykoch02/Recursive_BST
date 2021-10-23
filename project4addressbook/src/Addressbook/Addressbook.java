package Addressbook;

import bst.BinaryTree;
import bst.TreeIterator;
import bst.TreeNode;
/**
 * @author Hassib
 * Project 4
 * Qi Wang
 */


public class Addressbook implements AddressbookADT {

	/**
	 * Binary Tree Variable
	 */
	private BinaryTree<Contact> tree;
	/**
	 * Count Variable
	 */
	private int count;
	
	/**
	 * Creates an empty Addressbook
	 */
	public Addressbook() {
		tree = new BinaryTree<Contact>();
	}
	
	/**
	 * Makes the Addressbook empty
	 */
	@Override
	public void clear() {
		tree.makeEmpty();
	}
	
	/**
	 * Gets number of contacts
	 * @return count of contacts
	 */
	@Override
	public int count() {
		return this.count;
	}
	
	/**
	 * Searches for the contact with name
	 * @param name of contact being looked for
	 * @return the contact found, throws a TreeException
	 * @throws TreeException if the Contact isn't found
	 */
	@Override
	public TreeNode<Contact> search(String name) {
		return tree.search(new Contact(name, new Address(" ", " ", " ", " "), " "));
	}
	
	/**
	 * Returns the iterator for this Addressbook
	 * @return TreeIterator of contacts
	 */
	@Override
	public TreeIterator<Contact> iterator() {
		return tree.iterator();
	}
	
	/**
	 * Adds a new contact into the Addressbook
	 * @param data is the Contact being added
	 */
	@Override
	public void add(Contact data)  {
		tree.insert(data);
		this.count++;
	}
	
	/**
	 * Removes this contact from the Binary Tree
	 * @param name is the contacts name
	 */
	@Override
	public void remove(String name) {
		tree.remove(new Contact(name, new Address(" ", " ", " ", " "), " "));
		this.count--;
	}

	/**
	 * Sees if the Addressbook is empty
	 * @return Empty or not Empty (true/false)
	 */
	@Override
	public boolean isEmpty() {
		return tree.isEmpty();
	}
	
	

}
