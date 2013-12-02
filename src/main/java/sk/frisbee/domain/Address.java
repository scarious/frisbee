package sk.frisbee.domain;

import java.io.Serializable;


public class Address implements Serializable {

  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String street;
    private String houseNumber;   
    private String city;
    private String postalCode;  
    private String country;

    public Address() {
        super();
    }

    public Address(String street, String houseNumber, String city, String postalCode, String country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }


    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}