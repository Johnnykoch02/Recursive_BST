package Addressbook;

public class Contact implements Comparable<Contact> {
	/**
	 * Name Variable	
	 */
	private String name;
	/**
	 * Address Variable
	 */
	private  Address address;
	/**
	 * Phone Number Variable
	 */
	private String phone;
	
	public Contact(String name, Address addy, String phone) {
		this.name = name;
		this.address = addy;
		this.phone = phone;
	}
	
	/**
	 * Gets name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets name
	 * @param name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets address
	 * @return address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets address
	 * @param address to be set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * gets phone number
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets phone number
	 * @param phone number to be set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * Comparable method for the class Contact
	 *  @return compare result
	 */
	@Override
	public int compareTo(Contact o) {
		// TODO Auto-generated method stub
		
		return this.name.compareToIgnoreCase(o.name);
	}
	
	/**
	 *  String variable for Contact
	 */
	public String toString() {
		return (this.name + ", " + address.toString() + ", " + this.phone);
	}
}
