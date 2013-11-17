package sk.frisbee.jdbc;

import java.util.List;

import sk.frisbee.domain.Game;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.Statistics;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.Tournament;

public interface SearchDao {
	
	public List<String> searchEverywhere(String keyword);
	
	public List<Player> searchPlayers(String keyword);
	
	public List<Team> searchTeams(String keyword);
	
	public List<Tournament> searchTournaments(String keyword);
	
	public List<Game> searchGames(String keyword);
	
	public List<Statistics> searchStatistics(String keyword);

}
