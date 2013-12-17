package sk.frisbee.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import sk.frisbee.aplikacia.DateFormatCustom;
import sk.frisbee.domain.Game;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.TRoster;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.Tournament;

import com.mysql.jdbc.Statement;

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
	public List<Tournament> getAllTournamentsDataByDate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM profil_turnaj WHERE datum >= curdate()  ORDER BY datum";
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
			tournament.setLevel_of_play(rs.getString("uroven_hry"));
			tournament.setRegpoplatokhrac(rs.getInt("regpoplatokhrac"));
			tournament.setRegpoplatoktim(rs.getInt("regpoplatoktim"));
			tournament.setDurationDays(rs.getInt("dobatrvania"));
			tournament.setFormat(rs.getString("format"));
			tournament.setTournamentDate(DateFormatCustom.fromDB(rs.getString("datum")));
			tournament.setCity(rs.getString("miesto"));
			tournament.setCountry(rs.getString("krajina"));
			tournament.setGps_coord(rs.getString("gps"));//tournament.setGps(rs.getString("gps"));
			tournament.setContact_email(rs.getString("kontakt_email"));
			tournament.setContact_number(rs.getString("kontakt_telefon"));
			tournament.setId_user(rs.getInt("id_user"));
			tournament.setContact_fb(rs.getString("kontakt_fb"));
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
	public Tournament getTournament(Integer id_turnaj) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM profil_turnaj WHERE id_turnaj=" + id_turnaj;
		List<Tournament> tournamentList = (List<Tournament>) jdbcTemplate.query(SQL, 
				new TournamentMapper());
		jdbcTemplate = null;
		if(tournamentList.size() == 0) return null;
		return tournamentList.get(0);
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
	public void addTournament(Tournament tournament) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO profil_turnaj (meno, discipliny, povrch, divizie, uroven_hry, regpoplatokhrac, regpoplatoktim, format, datum, dobatrvania, gps, miesto, krajina, kontakt_email, kontakt_telefon, id_user, kontakt_fb) "
				+ "VALUES ("
				+ "\"" + tournament.getName() + "\", "
				+ "\"" + tournament.getDisciplines() + "\", "
				+ "\"" + tournament.getSurface() + "\", "
				+ "\"" + tournament.getDivision() + "\", "
				+ "\"" + tournament.getLevel_of_play() + "\", "
				+ "\"" + tournament.getRegpoplatokhrac() + "\", "
				+ "\"" + tournament.getRegpoplatoktim() + "\", "
				+ "\"" + tournament.getFormat() + "\", "
				+ "\"" + tournament.getTournamentDate() + "\", "
				+ "\"" + tournament.getDurationDays() + "\", "
				+ "\"" + tournament.getGps_coord() + "\", "
				+ "\"" + tournament.getCity() + "\", "
				+ "\"" + tournament.getCountry() + "\", "
				+ "\"" + tournament.getContact_email() + "\", "
				+ "\"" + tournament.getContact_number() + "\", "
				+ "\"" + tournament.getId_user() + "\", "
				+ "\"" + tournament.getContact_fb()+
				")";
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
		
	}
	@Override
	public Integer addTournamentWithReturnVal(final Tournament tournament) {
		KeyHolder holder = new GeneratedKeyHolder();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		final String SQL = "INSERT INTO profil_turnaj "
				+ "(meno, discipliny, povrch, divizie, uroven_hry, regpoplatokhrac, regpoplatoktim, format, datum, dobatrvania, gps, miesto, krajina, kontakt_email, kontakt_telefon, id_user, kontakt_fb) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(SQL.toString(),
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, tournament.getName());
				ps.setString(2, tournament.getDisciplines());
				ps.setString(3, tournament.getSurface());
				ps.setString(4, tournament.getDivision());
				ps.setString(5, tournament.getLevel_of_play());
				ps.setInt(6, tournament.getRegpoplatokhrac());
				ps.setInt(7, tournament.getRegpoplatoktim());	
				ps.setString(8, tournament.getFormat());
				ps.setString(9, DateFormatCustom.dateForDB(tournament.getTournamentDate()));
				ps.setInt(10, tournament.getDurationDays());
				ps.setString(11, tournament.getGps_coord());
				ps.setString(12, tournament.getCity() );
				ps.setString(13, tournament.getCountry());
				ps.setString(14, tournament.getContact_email());
				ps.setString(15, tournament.getContact_number());
				ps.setInt(16, tournament.getId_user());
				ps.setString(17, tournament.getContact_fb());
				return ps;
			}
		}, holder);
		Integer newTournamentId = holder.getKey().intValue();
		jdbcTemplate = null; 
		holder = null;
		return newTournamentId;
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
		Date date = (Date) updatedTournament.getTournamentDate();
			String SQL = "UPDATE profil_hrac SET " +
					"meno=\"" + updatedTournament.getName()  + "\", " +
					"discipliny=\"" + updatedTournament.getDisciplines() + "\", " +
					"povrch=\"" + updatedTournament.getSurface() + "\", " +
					"divizie=\"" + updatedTournament.getDivision() + "\"," +
					"uroven_hry=\"" + updatedTournament.getLevel_of_play() + "\", " +
					"regpoplatokhrac=\"" + updatedTournament.getRegpoplatokhrac() + "\"," +
					"regpoplatoktim=\"" + updatedTournament.getRegpoplatoktim() + "\"," +
					
					"format=" + updatedTournament.getFormat() + ", " +
					"dobatrvania=" + updatedTournament.getDurationDays() + ", " +
					"datum=\"" + DateFormatCustom.dateForDB(date) + "\", " +
					"gps=\"" + updatedTournament.getGps_coord() + "\", " +	
					"miesto=\"" + updatedTournament.getCity() + "\", " +
					"krajina=\"" + updatedTournament.getCountry() + "\", " +				
					"kontakt_email=\"" + updatedTournament.getContact_email() + "\", " +
					"kontakt_telefon=\"" + updatedTournament.getContact_number() + "\", " +
					"kontakt_fb=\"" + updatedTournament.getContact_fb() + "\", " +
					" WHERE id_user=" + updatedTournament.getId_user();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.execute(SQL);
			jdbcTemplate = null;
		
	}

	@Override
	public void deleteTournament(Integer id) {
		String SQL = "DELETE FROM profil_turnaj WHERE id_turnaj= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
		
	}

	@Override
	public List<Tournament> getTournamentsWithGps() {
		String SQL = "SELECT * FROM profil_turnaj WHERE gps IS NOT NULL";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Tournament> tournamentList = (List<Tournament>) jdbcTemplate.query(SQL, 
				new TournamentMapper());
		jdbcTemplate = null;
		return tournamentList;
	}

}
