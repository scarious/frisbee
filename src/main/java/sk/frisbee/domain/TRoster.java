package sk.frisbee.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TRoster implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9196848566393712286L;
	
	private Long tournament_id;
	
	private Long roster_id;
	
	private String roster_name;

	private List<Player> players = new ArrayList<Player>();

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Long getTournament_id() {
		return tournament_id;
	}

	public void setTournament_id(Long tournament_id) {
		this.tournament_id = tournament_id;
	}

	public Long getRoster_id() {
		return roster_id;
	}


	public String getRoster_name() {
		return roster_name;
	}

	public void setRoster_name(String roster_name) {
		this.roster_name = roster_name;
	}


}
