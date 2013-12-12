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

	private Integer player_id;
    
    private Integer user_id;
    
    private Integer height;

    private String firstName;
    
    private String lastName;

    private String dominantHand;
    
    private Date dateOfBirth;
    
    private Date activeSince;

    private Address address = new Address();
    
    private String disciplines;
    
    private List<Team> teams = new ArrayList<Team>();

	private String pohlavie; 

    public Integer getPlayer_id() {
        return this.player_id;
    }

    public Integer getUser_id() {
        return this.user_id;
    }
    
    public void setPlayerId(Integer player_id) {
        this.player_id = player_id;
    }
    
    public void setUserId(Integer user_id) {
        this.user_id = user_id;
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
    
    public Integer getHeight() {
        return this.height;
    }
    
    public void setHeight(int height){
    	this.height = height;
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
    
    public Date getActiveSince() {
        return this.activeSince;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

	public String getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(String string) {
		this.disciplines = string;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public void setActiveSince(Date date){
		this.activeSince = date;
	}

	public String getDominantHand() {
		return dominantHand;
	}

	public void setDominantHand(String dominantHand) {
		this.dominantHand = dominantHand;
	}

	public String getPohlavie() {
		return pohlavie;
	}
	
	public void setPohlavie(String Pohlavie) {
		this.pohlavie = Pohlavie;
	}
   
}