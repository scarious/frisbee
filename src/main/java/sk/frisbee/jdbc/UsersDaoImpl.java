package sk.frisbee.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import sk.frisbee.domain.Address;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.Roster;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.User;

@Component
@Repository
public class UsersDaoImpl implements UsersDao, UserDetailsService {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired  
	@Qualifier("dataSource")
	DataSource dataSource;

	
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@Override
	public User getUser(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//String SQL = "SELECT * FROM login_data WHERE id_user = " + id;
		List<User> user = (List<User>) jdbcTemplate.query(
				"SELECT * FROM login_data WHERE id_user = " + id,
				new UserMapper());
		jdbcTemplate = null;
		return user.get(0);
	}
	
	private static class UserMapper implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUser_id(rs.getInt("id_user"));
			user.setUsername(rs.getString("login"));
			user.setPassword(rs.getString("heslo"));
			user.setEmailAddress(rs.getString("email"));
			return user;	
		}
	}
	

	@Override
	public List<Player> getAllPlayerData() {		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Player> playersList = (List<Player>) jdbcTemplate.query(
				"SELECT * FROM profil_hrac;",
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
			player.setPohlavie(rs.getString("pohlavie"));
			player.setHeight(rs.getInt("vyska"));
			player.setDominantHand(rs.getString("dominantna_ruka"));
			//player.setTeams(null);
			return player;	
		}
	}

	@Override
	public List<Player> getPlayerData(Integer count) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Player> playersList = (List<Player>) jdbcTemplate.query(
				"SELECT * FROM profil_hrac LIMIT 0, " + count,
				new PlayerMapper());
		jdbcTemplate = null;	
		return playersList;
	}


	@Override
	public Player getPlayer(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//String SQL = "SELECT * FROM profil_hrac WHERE id_hrac = " + id + "LIMIT 1";
		List<Player> player = (List<Player>) jdbcTemplate.query(
				"SELECT * FROM profil_hrac WHERE id_hrac = " + id,
				new PlayerMapper());
		jdbcTemplate = null;	
		if(player.size() == 0) return null;
		
		return player.get(0);
	}
	
	@Override
	public Player getPlayerByUserId(Integer id_user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//String SQL = "SELECT * FROM profil_hrac WHERE id_hrac = " + id + "LIMIT 1";
		List<Player> player = (List<Player>) jdbcTemplate.query(
				"SELECT * FROM profil_hrac WHERE id_user = " + id_user,
				new PlayerMapper());
		jdbcTemplate = null;	
		return player.get(0);
	}

	@Override
	public List<User> getAllUserData() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<User> userList = (List<User>) jdbcTemplate.query(
				"SELECT * FROM login_data",
				new UserMapper());
		jdbcTemplate = null;
		return userList;
	}

	@Override
	public List<User> getUserData(Integer count) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<User> userList = (List<User>) jdbcTemplate.query(
				"SELECT * FROM login_data LIMIT 0," + count,
				new UserMapper());
		jdbcTemplate = null;
		return userList;
	}

	@Override
	public List<Address> getAllAddressData() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT mesto,krajina FROM profil_hrac";
		List<Address> addressList = (List<Address>) jdbcTemplate.query(SQL, new AddressMapper());
		jdbcTemplate = null;
		return addressList;
	}

	@Override
	public Address getAddresForPlayerId(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT mesto,krajina FROM profil_hrac WHERE id_hrac=" + id;
		List<Address> address = (List<Address>) jdbcTemplate.query(SQL, new AddressMapper());
		return address.get(0);
	}

	private static class AddressMapper implements RowMapper<Address>{
		@Override
		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
			Address address = new Address();
			address.setCity(rs.getString("mesto"));
			address.setCountry(rs.getString("krajina"));
			return address;	
		}
	}
	
	@Override
	public void addUser(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO login_data (`login`, `heslo`, `email`, `facebook_id`)" + 
		"VALUES (\"" + user.getUsername()  + "\"," +
				"\"" +user.getPassword() + "\"," +
				"\"" +user.getEmailAddress() + "\"," +
				"\"" +user.getFacebookId() +"\")";
	   jdbcTemplate.execute(SQL);
	   jdbcTemplate = null;
	}

	@Override
	public void updatePlayer(Player updatedPlayer) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateUser(User updatedUser) {
		String SQL = "UPDATE TABLE login_data SET (" +
						"login=" + updatedUser.getUsername()  +
						"heslo=" + updatedUser.getPassword()  +
						"email=" + updatedUser.getEmailAddress() +
						"facebook_id" + updatedUser.getFacebookId() +
						"WHERE id_user=" + updatedUser.getUser_id();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}

	@Override
	public void removePlayer(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "DELETE FROM `frisbee`.`profil_hrac` WHERE `id_hrac`=" + id;
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}

	@Override
	public void removeUser(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "DELETE FROM `frisbee`.`login_data` WHERE `id_user`=" + id;
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}

	@Override
	public Roster getRoster() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM supiska_timy, profil_hrac WHERE profil_hrac.id_hrac = supiska_timy.id_hrac"
				+ "GROUP BY id_supiska";
		return null;
	}

	private static class RosterMapper implements RowMapper<Roster>{
		@Override
		public Roster mapRow(ResultSet rs, int rowNum) throws SQLException {
			Roster roster = new Roster();
			
			return roster;	
		}
	}
	
	@Override
	public List<Team> getPlayersTeams(Integer player_id) {
		String SQL = "SELECT * FROM timy_hraca WHERE id_hrac=" + player_id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.query(SQL, new TeamMapper());
		// TODO Auto-generated method stub
		return null;
	}
	
	private static class TeamMapper implements RowMapper<Team>{
		@Override
		public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
			Team team = new Team();
			team.setCity(rs.getString("mesto"));
			//team.setCountry(rs.getString("krajina"));
			return team;	
		}
	}

	@Override
	public void addPlayer(Player player) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO login_data (`meno`,`priezvisko`,`discipliny`,`mesto`,`krajina`,`datum_narodenia`,`pohlavie`,`vyska`,`dominantna_ruka`,`aktivny_od`)" + 
		"VALUES (" + 
				"\"" + player.getFirstName() + "\"," +
				"\"" + player.getLastName() + "\"," +
				"\"" + player.getDisciplines() + "\"," +
				"\"" + player.getAddress().getCity() + "\"," +
				"\"" + player.getAddress().getCountry() + "\"," +
				"\"" + player.getDateOfBirth().toString() + "\"," +
				"\"" + player.getPohlavie() + "\"," +
				player.getHeight() + "," +
				"\"" + player.getDominantHand() + "\"," +
				"\"" + player.getActiveSince().toString() +"\")";
	   jdbcTemplate.execute(SQL);
	   jdbcTemplate = null;
		
	}

	@Override
	public void addTeamToPlayer(Integer player_id, Team team) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO profil_tim (`nazov`,`discipliny`,`mesto`,`kontakt_meno`,`kontakt_cislo`,`kontakt_email`,`kontakt_fb`,`zivotopis`,`treningy`, `id_hrac`) VALUES (" +
				team.getName() + "," +
				team.getDisciplines() + "," +
				team.getCity() + 
				team.getContact_name() +
				team.getContactPhone() +
				team.getContact_email() +
				team.getContact_fb() +
				team.getInformation() +
				team.getTrainings() +
				+ player_id + ")";
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}

	@Override
	public void removePlayerFromTeam(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "DELETE FROM timy_hraca WHERE id_hrac = " + id;
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}

	@Override
	public User getUserByUsername(String login) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//String SQL = "SELECT * FROM login_data WHERE id_user = " + id;
		List<User> user = (List<User>) jdbcTemplate.query(
				"SELECT * FROM login_data WHERE login = \"" + login + "\"",
				new UserMapper());
		jdbcTemplate = null;
		return user.get(0);
	}

	@Override
	public User loadUserByUsername(String arg0) throws UsernameNotFoundException {
		return getUserByUsername(arg0);
	}
	
	

}
