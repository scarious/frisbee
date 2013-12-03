package sk.frisbee.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sk.frisbee.domain.Game;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.TRoster;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.Tournament;

public class TournamentsDaoImpl implements TournamentsDao {

	@Autowired  
	DataSource dataSource;

	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Tournament> getAllTournamentsData() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM profil_turnaj";
		List<Tournament> tournamentList = (List<Tournament>) jdbcTemplate.query(SQL, 
				new TournamentMapper());
		jdbcTemplate = null;
		return tournamentList;
	}
	
	private static class TournamentMapper implements RowMapper<Tournament>{
		@Override
		public Tournament mapRow(ResultSet rs, int rowNum) throws SQLException {
			Tournament tournament = new Tournament();
			tournament.setName(rs.getString("meno"));
			tournament.setDisciplines(rs.getString("discipliny"));
			tournament.setSurface(rs.getString("povrch"));
			tournament.setDivision(rs.getString("divizie"));
			tournament.setLevel_of_play(rs.getInt("uroven_hry"));
			tournament.setFormat(rs.getString("format"));
			tournament.setDate(null);
			tournament.setPlace(rs.getString("miesto"));
			tournament.setGps(rs.getString("gps"));
			tournament.setContact(rs.getString("kontakt"));
			return tournament;	
		}
	}

	@Override
	public List<Tournament> getTournamentsData(Integer count) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM profil_turnaj LIMIT 0," + count;
		List<Tournament> tournamentList = (List<Tournament>) jdbcTemplate.query(SQL, 
				new TournamentMapper());
		jdbcTemplate = null;
		return tournamentList;
	}

	@Override
	public List<Team> getTeamsFromTournament(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM supiska_hraci_turnaj, profil_team "
				+ "WHERE supiska_hraci_turnaj.id_tim = profil_tim.id_tim AND id_turnaj = " + id + " GROUP BY id_tim";
		List<Team> teamsList = (List<Team>) jdbcTemplate.query(SQL, 
				new TeamMapper());
		jdbcTemplate = null;
		return teamsList;
	}
	
	private static class TeamMapper implements RowMapper<Team>{
		@Override
		public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
			Team team = new Team();
			team.setCity(rs.getString("mesto"));
			team.setContact_email(rs.getString("kontakt_email"));
			team.setContact_fb(rs.getString("kontakt_fb"));
			team.setContact_name(rs.getString("kontakt_meno"));
			team.setDisciplines(rs.getString("discipliny"));
			team.setName(rs.getString("nazov"));
			return team;	
		}
	}

	@Override
	public List<Player> getPlayersFromTournament(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tournament getTournament(Integer id) {
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
	public TRoster getTRoster(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTournament(Tournament Tournament) {
		// TODO Auto-generated method stub
		
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
	public void addTRoster(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTRoster(TRoster tRoster) {
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
}
