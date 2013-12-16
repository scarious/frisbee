package sk.frisbee.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import sk.frisbee.aplikacia.DateFormatCustom;
import sk.frisbee.domain.Address;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.Tournament;

import com.mysql.jdbc.Statement;

public class TeamsDaoImpl implements TeamsDao {
	
	@Autowired  
	DataSource dataSource;

	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Team> getAllTeamsData() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Team> teamsList = (List<Team>) jdbcTemplate.query(
				"SELECT * FROM profil_tim;",
				new TeamMapper());
		jdbcTemplate = null;	
		return teamsList;
	}
	
	private static class TeamMapper implements RowMapper<Team>{
		@Override
		public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
			Team team = new Team();
			team.setTeam_id(rs.getInt("id_tim"));
			team.setName(rs.getString("nazov"));
			team.setDisciplines(rs.getString("discipliny"));
			team.setCountry(rs.getString("krajina"));
			team.setDatumZalozenia(DateFormatCustom.fromDB(rs.getString("datumzalozenia")));
			team.setCity(rs.getString("mesto"));
			team.setContact_name(rs.getString("kontakt_meno"));	
			team.setContact_phone(rs.getString("kontakt_cislo"));
			team.setContact_email(rs.getString("kontakt_email"));
			team.setContact_fb(rs.getString("kontakt_fb"));
			team.setInformation(rs.getString("zivotopis"));
			team.setTrainings(rs.getString("treningy"));
			team.setGpsMiestoTreningu((rs.getString("gpsMiestoTreningu")));
			team.setUser_id(rs.getInt("id_user"));
			return team;	
		}
	}

	@Override
	public List<Team> getTeamsData(Integer count) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Team> teamsList = (List<Team>) jdbcTemplate.query(
				"SELECT * FROM profil_tim LIMIT 0," + count,
				new TeamMapper());
		jdbcTemplate = null;	
		return teamsList;
	}
	
	@Override
	public List<Team> getPlayersTeams(Integer id_hrac) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Team> playersList = (List<Team>) jdbcTemplate.query(
				"SELECT * FROM timy_hraca, profil_tim WHERE id_hrac=" + id_hrac + " AND timy_hraca.id_tim = profil_tim.id_tim",
				new TeamMapper());
		jdbcTemplate = null;	
		return playersList;
	}

	@Override
	public Team getTeam(Integer id_tim) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Team> teamsList = (List<Team>) jdbcTemplate.query(
				"SELECT * FROM profil_tim WHERE id_tim=" + id_tim,
				new TeamMapper());
		jdbcTemplate = null;	
		return teamsList.get(0);
	}

	@Override
	public void addTeam(Team team) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO profil_tim (nazov, discipliny, mesto, kontakt_meno, kontakt_cislo, kontakt_email, kontakt_fb, zivotopis, treningy, id_hrac) "
				+ "VALUES ("
				+ "\"" + team.getName() + "\", "
				+ "\"" + team.getDisciplines() + "\", "
				+ "\"" + team.getCity() + "\", "
				+ "\"" + team.getContact_name() + "\", "
				+ "\"" + team.getContactPhone() + "\", "
				+ "\"" + team.getContact_email() + "\", "
				+ "\"" + team.getContact_fb() + "\", "
				+ "\"" + team.getInformation() + "\", "
				+ "\"" + team.getTrainings() + "\", "
				+ team.getUserId() + 
				")";
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}
	
	@Override
	public Integer addTeamWithReturnVal(final Team team) {
		KeyHolder holder = new GeneratedKeyHolder();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		final String SQL = "INSERT INTO profil_tim "
				+ "(nazov, discipliny, mesto, krajina, datumzalozenia, kontakt_meno, kontakt_cislo, kontakt_email, kontakt_fb, zivotopis, treningy, gpsMiestoTreningu, id_user) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() { 
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(SQL.toString(),
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, team.getName());
				ps.setString(2, team.getDisciplines());
				ps.setString(3, team.getCity());
				ps.setString(4, team.getCountry());
				ps.setString(5, DateFormatCustom.dateForDB(team.getDatumZalozenia()));
				ps.setString(6, team.getContact_name());
				ps.setString(7, team.getContactPhone());
				ps.setString(8, team.getContact_email());
				ps.setString(9, team.getContact_fb());
				ps.setString(10, team.getInformation() );
				ps.setString(11, team.getTrainings());
				ps.setString(12, team.getGpsMiestoTreningu());
				ps.setInt(13, team.getUserId());
				return ps;
			}
		}, holder);
		Integer newTeamId = holder.getKey().intValue();
		jdbcTemplate = null; 
		holder = null;
		return newTeamId;
	}

	@Override
	public void updateTeam(Team updatedTeam) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "UPDATE TABLE profil_tim SET ("
				+"nazov="+ updatedTeam.getName() + ","
				+"discipliny="+ updatedTeam.getDisciplines() + ","
				+"nazov="+ updatedTeam.getCity() + ","
				+"kontakt_meno="+ updatedTeam.getContact_name() + ","
				+"kontakt_cislo="+ updatedTeam.getContactPhone() + ","
				+"kontakt_email="+ updatedTeam.getContact_email() + ","
				+"kontakt_fb="+ updatedTeam.getContact_fb() + ","
				+"zivotopis="+ updatedTeam.getInformation() + ","
				+"treningy="+ updatedTeam.getTrainings() + ","
				+"id_hrac="+ updatedTeam.getUserId() + 
				")";
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}

	@Override
	public void deleteTeam(Integer id) {
		String SQL = "DELETE FROM profil_tim WHERE id_tim= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}

	@Override
	public List<Player> getPlayersInTeam(Integer id_tim) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Player> playersList = (List<Player>) jdbcTemplate.query(
				"SELECT * FROM timy_hraca, profil_hrac WHERE id_tim=" + id_tim + " AND timy_hraca.id_hrac = profil_hrac.id_hrac ",
				new PlayerMapper());
		jdbcTemplate = null;	
		return playersList;
	}
	
	@Override
	public void addPlayersToTeam(Integer team_id, List<Player> players) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "";
		for(Player player: players){
			SQL = "INSERT INTO timy_hraca VALUES (" + player.getPlayer_id() + ", " + team_id + ")";
			//System.out.println("INSERTING:" + SQL);
			jdbcTemplate.execute(SQL);
		}
		
		jdbcTemplate = null;
	}
	
	private static class PlayerMapper implements RowMapper<Player>{
		@Override
		public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
			Player player = new Player();
			player.setPlayerId(rs.getInt("id_hrac"));
			player.setUserId(rs.getInt("id_user"));
			player.setFirstName(rs.getString("meno"));
			player.setLastName(rs.getString("priezvisko"));
			player.setDisciplines(rs.getString("discipliny"));
			player.setAddress(new Address(null, null, rs.getString("mesto"), null, rs.getString("krajina")));
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dNar, dActive;
				if(rs.getString("datum_narodenia") != null || rs.getString("aktivny_od") != null) {
					dNar = sdf.parse(rs.getString("datum_narodenia"));
					player.setDateOfBirth(dNar);
					dActive = sdf.parse(rs.getString("aktivny_od"));
					player.setActiveSince(dActive);
				}
				
				sdf = null; dNar = null; dActive = null;
			} catch (ParseException | NullPointerException e) {
				e.printStackTrace();
			}
			player.setHeight(rs.getInt("vyska"));
			player.setDominantHand(rs.getString("dominantna_ruka"));
			//player.setTeams(null);
			return player;	
		}
	}

	@Override
	public List<Tournament> getTeamTournaments() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM zapas, profil_turnaj, supiska_hraci_turnaj WHERE "
				+ "zapas.id_turnaj = profil_turnaj.id_turnaj AND profil_turnaj.id_turnaj = supiska_hraci_turnaj.id_TURNAJ"
				+ " GROUP BY id_turnaj";
		
		return null;
	}
	
	private static class TournamentMapper implements RowMapper<Tournament>{
		@Override
		public Tournament mapRow(ResultSet rs, int rowNum) throws SQLException {
			Tournament tournament = new Tournament();
			
			//player.setTeams(null);
			return tournament;	
		}
	}

	public Integer getNumberOfPlayersInTeam(Integer id_tim){
		String SQL = "SELECT COUNT(*) AS rowcount FROM frisbee.timy_hraca WHERE id_tim=" + id_tim;
		java.sql.Statement statement;
		ResultSet rs;
		Integer vysledok = null;
		try {
			statement = dataSource.getConnection().createStatement();
			rs = statement.executeQuery(SQL);
			rs.next();
			vysledok = rs.getInt("rowcount");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		
		
		return vysledok;
		
		
	}


}
