package sk.frisbee.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StatisticsTournament implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3681196944076920466L;

	private Long tournament_id;

	private Long stat_id;

	private List<Game> games = new ArrayList<Game>();

	public Long getTournament_id() {
		return tournament_id;
	}

	public void setTournament_id(Long tournament_id) {
		this.tournament_id = tournament_id;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Long getStat_id() {
		return stat_id;
	}

}
