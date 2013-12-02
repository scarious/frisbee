package sk.frisbee.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Roster implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9196848566393712286L;
	
	private Long team_id;
	
	private Long supiska_id;

	private List<Player> players = new ArrayList<Player>();

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}

	public Long getSupiska_id() {
		return supiska_id;
	}

	public void setSupiska_id(Long supiska_id) {
		this.supiska_id = supiska_id;
	}
}
