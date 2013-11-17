package sk.frisbee.domain;

public class User {

	private String firstName;
	private Integer id;
	

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public Integer getUserId(){
		return id;
	}

}
