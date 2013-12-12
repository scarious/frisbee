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
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import sk.frisbee.domain.Address;
import sk.frisbee.domain.Game;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.Statistics;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.Tournament;

public class SearchDaoImpl implements SearchDao {

	
	@Autowired  
	DataSource dataSource;

	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	@Override
	public List<String> searchEverywhere(String keyword) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM login_data, profil_hrac, profil_turnaj, profil_tim WHERE" + 
					"(profil_hrac.meno OR priezvisko OR mesto OR krajina OR datum_narodenia OR"
					+ " login OR email OR profil_turnaj.meno OR profil_turnaj.discipliny OR "
					+ "profil_turnaj.miesto OR profil_turnaj.krajina OR profil_turnaj.povrch OR "
					+ "profil_tim.nazov OR profil_tim.mesto OR profil_tim.kontakt_meno OR profil_tim.kontak_email OR "
					+ "zivotopis OR treningy) LIKE \"%"+keyword+"\"%";	
//		List<String> result = (List<String>) jdbcTemplate.query(SQL, RowMapperResultSetExtractor<String>);
		return null;
	}

	@Override
	public List<Player> searchPlayers(String keyword) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM profil_hrac, login_data WHERE "
				+ "(login OR email OR meno OR priezvisko OR discipliny OR mesto OR krajina OR datum_narodenia OR pohlavie OR vyska OR dominantna_ruka OR aktivny_od"
				+ ") LIKE \"" + keyword + "%\" ";
		List<Player> playersList = (List<Player>) jdbcTemplate.query(SQL, new PlayerMapper());
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
	public List<Team> searchTeams(String keyword) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM profil_tim WHERE (nazov OR discipliny OR mesto OR kontakt_cislo OR kontakt_meno OR zivotopis OR treningy"
				+ ") LIKE \"" + keyword + "%\" ";
		//List<Team> listTeam = (List<Team>) jdbcTemplate.query(SQL, null);
		jdbcTemplate = null;
		return null;
	}

	@Override
	public List<Tournament> searchTournaments(String keyword) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		return null;
	}

	@Override
	public List<Game> searchGames(String keyword) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		return null;
	}

	@Override
	public Statistics searchStatistics(String keyword) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		return null;
	}

}
