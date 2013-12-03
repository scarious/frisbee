package sk.frisbee.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Team  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -322253261031694437L;

    private Long team_id;
    
    private Long user_id;

    private String name;
    
    private String disciplines;
    
    private Integer phone;
    
    private String city, contact_name, contact_email, contact_fb, trainings;
    
    private List<Player> players = new ArrayList<Player>();
    
    private List<Roster> rosters = new ArrayList<Roster>();
    
    private String information;

	public Long getTeam_id() {
		return team_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPlayerId() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(String disciplines) {
		this.disciplines = disciplines;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Roster> getRosters() {
		return rosters;
	}

	public void setRosters(List<Roster> rosters) {
		this.rosters = rosters;
	}

	public String getContact_fb() {
		return contact_fb;
	}

	public void setContact_fb(String contact_fb) {
		this.contact_fb = contact_fb;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTrainings() {
		return trainings;
	}

	public void setTrainings(String trainings) {
		this.trainings = trainings;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public Integer getContactPhone() {
		return phone;
	}
}
