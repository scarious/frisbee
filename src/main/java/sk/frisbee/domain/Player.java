package sk.frisbee.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Player implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6341141042415792923L;

	private Long player_id;
    
    private Long user_id;

    private String firstName;
    
    private String lastName;

    private Date dateOfBirth;

    private Address address = new Address();
    
    private Integer disciplines;
    
    private List<Team> teams = new ArrayList<Team>(); 

    public Long getPlayerId() {
        return this.player_id;
    }

    public Long getUserId() {
        return this.user_id;
    }
    
    public Long setUserId() {
        return this.user_id;
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

	public Integer getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(Integer disciplines) {
		this.disciplines = disciplines;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

   
}