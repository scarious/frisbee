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
    
    private Integer disciplines;
    
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

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Integer getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(Integer disciplines) {
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
}
