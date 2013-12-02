package sk.frisbee.jdbc;

import java.util.List;

import sk.frisbee.domain.Game;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.TRoster;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.Tournament;

public class TournamentsDaoImpl implements TournamentsDao {

	@Override
	public List<Tournament> getAllTournamentsData() {
		String SQL = "SELECT * FROM profil_turnaj";
		return null;
	}

	@Override
	public List<Tournament> getTournamentsData(Integer count) {
		String SQL = "SELECT * FROM profil_turnaj LIMIT 0," + count;
		return null;
	}

	@Override
	public Tournament getTournament(Integer id) {
		String SQL = "SELECT * FROM profil_turnaj WHERE id_turnaj = " + id;
		return null;
	}

	@Override
	public void addTournament(Tournament Tournament) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTournament(Tournament updatedTournament) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTournament(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Team> getTeamsFromTournament(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayersFromTournament(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGame(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTeamToTournament(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlayerToTournament(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGame(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TRoster getTRoster(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTRoster(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTRoster(TRoster tRoster) {
		// TODO Auto-generated method stub
		
	}

}
