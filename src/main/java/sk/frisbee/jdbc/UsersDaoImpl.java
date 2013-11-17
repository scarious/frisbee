package sk.frisbee.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sk.frisbee.domain.Address;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.Roster;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.User;

public class UsersDaoImpl implements UsersDao {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired  
	DataSource dataSource;

	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@Override
	public User getUser(Integer id) {
		String SQL = "SELECT * FROM user WHERE id_user = " + id;
		return null;
	}

	@Override
	public List<Player> getAllPlayerData() {		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Player> usersList = (List<Player>) jdbcTemplate.query(
				"SELECT * FROM profil_hrac;",
				new PlayerMapper());
		jdbcTemplate = null;	
		return usersList;
	}

	@Override
	public List<Player> getPlayerData(int count) {
		String SQL = "SELECT * FROM profil_hrac LIMIT 0, " + count;
		return null;
	}

	@Override
	public Player getPlayer(Integer id) {
		String SQL = "SELECT * FROM profil_hrac WHERE id_user = " + id;
		return null;
	}

	@Override
	public List<User> getAllUserData() {
		String SQL = "SELECT * FROM user, profil_jrac";
		return null;
	}

	@Override
	public List<User> getUserData(int count) {
		String SQL = "SELECT * FROM user LIMIT 0," + count;
		return null;
	}

	@Override
	public List<Address> getAllAddressData() {
		String SQL = "SELECT * FROM address";
		return null;
	}

	@Override
	public Address getAddresForUserId(Integer id) {
		String SQL = "SELECT * FROM address WHERE id_user=" + id;
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePlayer(Player updatedPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAddress(Address updatedAddress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePlayer(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAddress(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Roster getRoster() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getPlayersTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPlayer(Integer user_id, Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTeamToPlayer(Integer player_id, Team team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePlayerFromTeam(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	private static class PlayerMapper implements RowMapper<Player>{
		@Override
		public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
			Player player = new Player();
			player.setFirstName(rs.getString(3));
			return player;	
		}
		
	}

}
