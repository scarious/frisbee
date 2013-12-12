package sk.frisbee.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sk.frisbee.domain.Address;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.Tournament;

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
	public List<Team> getTeamsData(Integer count) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Team> teamsList = (List<Team>) jdbcTemplate.query(
				"SELECT * FROM profil_tim LIMIT 0," + count,
				new TeamMapper());
		jdbcTemplate = null;	
		return teamsList;
	}

	@Override
	public Team getTeam(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Team> teamsList = (List<Team>) jdbcTemplate.query(
				"SELECT * FROM profil_tim WHERE id_tim=" + id,
				new TeamMapper());
		jdbcTemplate = null;	
		return teamsList.get(0);
	}

	@Override
	public void addTeam(Team team) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO profil_tim(nazov, discipliny,mesto,kontakt_meno,kontakt_cislo,kontakt_email,kontakt_fb,zivotopis,treningy,id_hrac) "
				+ "VALUES ("
				+ team.getName() + ","
				+ team.getDisciplines() + ","
				+ team.getCity() + ","
				+ team.getContact_name() + ","
				+ team.getContactPhone() + ","
				+ team.getContact_email() + ","
				+ team.getContact_fb() + ","
				+ team.getInformation() + ","
				+ team.getTrainings() + ","
				+ team.getPlayerId() + 
				")";
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
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
				+"id_hrac="+ updatedTeam.getPlayerId() + 
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
	public List<Player> getPlayersInTeam(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Player> playersList = (List<Player>) jdbcTemplate.query(
				"SELECT * FROM timy_hraca, profil_hrac WHERE id_tim=" + id + "AND timy_hraca.id_hrac = profil_hrac.id_hrac "
						+ "GROUP BY id_hrac",
				new PlayerMapper());
		jdbcTemplate = null;	
		return playersList;
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
				player.setDateOfBirth(DateFormat.getInstance().parse(rs.getString("datum_narodenia")));
				player.setActiveSince(DateFormat.getInstance().parse(rs.getString("aktivny_od")));
			} catch (ParseException e) {
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

}
