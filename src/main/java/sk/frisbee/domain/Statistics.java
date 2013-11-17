package sk.frisbee.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Statistics implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5948425823387325940L;

	private List<StatisticsPlayer> players = new ArrayList<StatisticsPlayer>();
	
	private List<StatisticsTeam> teams = new ArrayList<StatisticsTeam>();
	
	private List<StatisticsTournament> tournaments = new ArrayList<StatisticsTournament>();

	public List<StatisticsPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<StatisticsPlayer> players) {
		this.players = players;
	}

	public List<StatisticsTeam> getTeams() {
		return teams;
	}

	public void setTeams(List<StatisticsTeam> teams) {
		this.teams = teams;
	}

	public List<StatisticsTournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<StatisticsTournament> tournaments) {
		this.tournaments = tournaments;
	}
	
	
}
