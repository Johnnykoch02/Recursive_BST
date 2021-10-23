package Addressbook;

/**
 * Project 4
 * Qi Wang
 */

public class Address {

	/**
	 * Street Variable
	 */
	private String street;
	/**
	 * City Variable
	 */
	private String city;
	/**
	 * State Variable
	 */
	private String state;
	/**
	 * Zipcode Variable
	 */
	private String zipcode;
	
	/**
	 * Address Constructor
	 * @param street is the street
	 * @param city is the city
	 * @param state is the state
	 * @param zipcode is the zipcode
	 */
	public Address(String street, String city, String state, String zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	/**
	 * Gets street
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets street
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Gets city
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets city
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets state
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * sets state
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets zipcode
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * Sets zipcode
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	/**
	 * String variable for Address
	 */
	public String toString() {
		return (this.street+ ", " + this.city + " " + this.state + ", " + this.zipcode);
	}
}
