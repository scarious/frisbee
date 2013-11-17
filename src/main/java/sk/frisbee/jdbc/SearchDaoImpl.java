package sk.frisbee.jdbc;

import java.util.List;

import sk.frisbee.domain.Game;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.Statistics;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.Tournament;

public class SearchDaoImpl implements SearchDao {

	@Override
	public List<String> searchEverywhere(String keyword) {
		String SQL = "SELECT * FROM user, profiles, tournaments, stats...;";
		return null;
	}

	@Override
	public List<Player> searchPlayers(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> searchTeams(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tournament> searchTournaments(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> searchGames(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Statistics> searchStatistics(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
