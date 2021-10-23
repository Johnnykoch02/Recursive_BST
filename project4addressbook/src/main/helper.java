package main;
/**
 * @author Hassib
 * Project 4
 * Qi Wang
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import Addressbook.Address;
import Addressbook.Addressbook;
import Addressbook.Contact;
import bst.TreeException;
import bst.TreeIterator;
import bst.TreeNode;

public class helper {


	/**
	 * scanner object
	 */
	private static Scanner scanner;
	/**
	 * Addressbook Variable
	 */
	private static Addressbook addressbook;
	
	public static void start(String path) { // start
		addressbook = fileInfoGetter(path);
		display(path);
	} // end
	
	public static void display(String path) {
		System.out.println("Project 4 Addressbook by Hassib Tleiji");
		System.out.println();
		System.out.println("Size of Addressbook: " + addressbook.count());
		System.out.println();
		System.out.println("Root, plus the first three elements left and right.");
		TreeIterator<Contact> t = addressbook.iterator();
		t.setPreorder();
		int i = 0;
		while(t.hasNext() && i<6) {
		System.out.println(t.next().toString());
		i++;
		}
		System.out.println();
		Contact newContact = new Contact("John Smith", new Address("15 Hudson Avenue", "Albany", "NY", "12222"), "(518)663-9023");
		System.out.println("Add new contact: " + newContact.toString());
		addressbook.add(newContact);
		addressbook.search("John Smith").getData().setPhone("(518)087-1026");
		System.out.println();
		System.out.println(addressbook.search("John Smith").getData().toString());
		System.out.println("You can modify Contacts even after theyre inserted into the Addressbook.");
		System.out.println();
		System.out.println("You can search a name to find a contact too: \"Lai Gato\": " + addressbook.search("Lai Gato").getData().toString());
		System.out.println("You can also delete contacts like this." );
		addressbook.remove("Natalie Fern");
		System.out.println();
		System.out.println("Now if we search for Natilie Fern we will get a Tree Exception: ");
		try {
			System.out.println(addressbook.search("Natalie Fern").getData().toString());
		}catch(TreeException e) {System.out.println("TreeException Avoided.");}
		System.out.println();
		System.out.println("Tree Exception will also be thrown when you try to remove data thats not in the tree.");
		try {
			addressbook.remove("Jake Revings");
		}catch(TreeException e) {System.out.println("TreeException Avoided.");}
		System.out.println();
		System.out.println("We can also clear our list, and use the isEmpty method to check if the \n addressbook is empty.");
		System.out.println("Before: "+ addressbook.isEmpty());
		addressbook.clear();
		System.out.println("After: " + addressbook.isEmpty());
		System.out.println();
		addressbook = fileInfoGetter(path);
		System.out.println("Finally, we can iterate over the addressbook from front to back,\n up to down, or back to front using Tree Iterator.");
		t = addressbook.iterator();
		System.out.println();
		System.out.println("PostOrder Addressbook: ");
		t.setPostorder();
		while(t.hasNext())
		{
			System.out.println(t.next().toString());
		}
		System.out.println();
		System.out.println("PreOrder Addressbook: ");
		t.setPreorder();
		while(t.hasNext())
		{
			System.out.println(t.next().toString());
		}
		System.out.println();
		System.out.println("InOrder Addressbook: ");
		t.setInorder();
		while(t.hasNext())
		{
			System.out.println(t.next().toString());
		}
		
	}

	private static Addressbook fileInfoGetter(String path) {
		
		try {
			scanner = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Addressbook book = new Addressbook(); 		
		while(scanner.hasNextLine()) 
		{
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			ArrayList<String> al = new ArrayList<String>();
			while(st.hasMoreTokens())
			{	
				String info = st.nextToken("\t");
				if(info.compareTo(" ") > 0)
				{
					al.add(info);
				}
			}
						
			Contact contact = new Contact(al.get(0)+" "+al.get(1), new Address(al.get(2), al.get(3), al.get(4), al.get(5)), al.get(6));
			book.add(contact);	
		}
		book.remove("first_name last_name");
		return book;
	}
	
}
