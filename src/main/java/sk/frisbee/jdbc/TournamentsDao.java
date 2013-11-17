package sk.frisbee.jdbc;

import java.util.List;

import sk.frisbee.domain.Game;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.TRoster;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.Tournament;

public interface TournamentsDao {
	
	public List<Tournament> getAllTournamentsData();
	
	public List<Tournament> getTournamentsData(Integer count);
	
	public List<Team> getTeamsFromTournament(Integer id);
	
	public List<Player> getPlayersFromTournament(Integer id);
	
	public Tournament getTournament(Integer id);
	
	public List<Game> getGames();
	
	public List<Game> getGame(Integer id);
	
	public TRoster getTRoster(Integer id);
	
	public void addTournament(Tournament Tournament);
	
	public void addTeamToTournament(Integer id);
	
	public void addPlayerToTournament(Integer id);
	
	public void addGame(Integer id);
	
	public void addTRoster(Integer id);
	
	public void addTRoster(TRoster tRoster);
	
	public void updateTournament(Tournament updatedTournament);
	
	public void deleteTournament(Integer id);
}
