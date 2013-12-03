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

import sk.frisbee.domain.Statistics;
import sk.frisbee.domain.StatisticsPlayer;
import sk.frisbee.domain.StatisticsTeam;
import sk.frisbee.domain.StatisticsTournament;

public class StatisticsDaoImpl implements StatisticsDao{


	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired  
	DataSource dataSource;

	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	@Override
	public Statistics getAllStats() {
		Statistics st = new Statistics();
		st.setPlayers(getAllPlayerStats());
		st.setTeams(getAllTeamStats());
		st.setTournaments(getAllTournamentStats());
		
		return st;
	}

	@Override
	public List<StatisticsTeam> getAllTeamStats() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "SELECT * FROM frisbee.statistika_tim";
		List<StatisticsTeam> stats = (List<StatisticsTeam>) jdbcTemplate.query(SQL, new TeamStatsMapper());
		jdbcTemplate = null;
		return stats;
	}

	@Override
	public List<StatisticsPlayer> getAllPlayerStats() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//String SQL = "SELECT * FROM frisbee.statistika_hrac ORDER BY body DESC";
		String SQL = "SELECT profil_hrac.id_hrac, body, meno, priezvisko FROM frisbee.statistika_hrac, frisbee.profil_hrac WHERE statistika_hrac.id_hrac=profil_hrac.id_hrac ORDER BY body DESC";
		List<StatisticsPlayer> stats = (List<StatisticsPlayer>) jdbcTemplate.query(SQL, new PlayerStatsMapper());
		jdbcTemplate = null;
		return stats;
	}
	
	private static class PlayerStatsMapper implements RowMapper<StatisticsPlayer>{
		@Override
		public StatisticsPlayer mapRow(ResultSet rs, int rowNum) throws SQLException {
			StatisticsPlayer stats = new StatisticsPlayer();
			stats.setPoints(rs.getInt("body"));
			stats.setPlayerid(rs.getInt("profil_hrac.id_hrac"));
			stats.setName(rs.getString("meno") + " " + rs.getString("priezvisko"));
			return stats;	
		}
	}
	

	@Override
	public List<StatisticsTournament> getAllTournamentStats() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//String SQL = "SELECT * FROM frisbee.statistika_hrac ORDER BY body DESC";
		String SQL = "SELECT * FROM zapas";
		List<StatisticsTournament> stats = (List<StatisticsTournament>) jdbcTemplate.query(SQL, new TournamentStatsMapper());
		jdbcTemplate = null;
		return stats;

	}
	
	private static class TournamentStatsMapper implements RowMapper<StatisticsTournament>{
		@Override
		public StatisticsTournament mapRow(ResultSet rs, int rowNum) throws SQLException {
			StatisticsTournament stats = new StatisticsTournament();
			stats.setTournament_id(rs.getLong("turnaj_id"));
			return stats;	
		}
	}

	@Override
	public StatisticsTeam getStatsForTeam(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//String SQL = "SELECT * FROM frisbee.statistika_hrac ORDER BY body DESC";
		String SQL = "SELECT * FROM frisbee.statistika_tim WHERE statistika_hrac.id_tim=" + id;
		List<StatisticsTeam> stats = (List<StatisticsTeam>) jdbcTemplate.query(SQL, new TeamStatsMapper());
		jdbcTemplate = null;
		return stats.get(0);
	}

	private static class TeamStatsMapper implements RowMapper<StatisticsTeam>{
		@Override
		public StatisticsTeam mapRow(ResultSet rs, int rowNum) throws SQLException {
			StatisticsTeam stats = new StatisticsTeam();
			stats.setPoints(rs.getInt("body"));
			stats.setPasses(rs.getInt("prihravky"));
			stats.setTeam_id(rs.getLong("id_tim"));
			stats.setBreaks(rs.getInt("breaky"));
			stats.setTurnovers(rs.getInt("turnovery"));
			stats.setDiscarded(rs.getInt("zahodenie"));
			stats.setPoints_gave(rs.getInt("body_dali"));
			stats.setPoints_received(rs.getInt("body_dostali"));
			stats.setDefences(rs.getInt("obrany"));
			return stats;	
		}
	}
	
	@Override
	public StatisticsPlayer getStatsForPlayer(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//String SQL = "SELECT * FROM frisbee.statistika_hrac ORDER BY body DESC";
		String SQL = "SELECT * FROM frisbee.statistika_hrac WHERE statistika_hrac.id_hrac=" + id;
		List<StatisticsPlayer> stats = (List<StatisticsPlayer>) jdbcTemplate.query(SQL, new PlayerStatsMapper());
		jdbcTemplate = null;
		return stats.get(0);
	}

	@Override
	public StatisticsTournament getStatsForTournament(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//String SQL = "SELECT * FROM frisbee.statistika_hrac ORDER BY body DESC";
		String SQL = "SELECT * FROM zapas WHERE id_turnaj =" + id;
		List<StatisticsTournament> stats = (List<StatisticsTournament>) jdbcTemplate.query(SQL, new TournamentStatsMapper());
		jdbcTemplate = null;
		return stats.get(0);
	}

	@Override
	public void addStatsForTeam(StatisticsTeam teamStats) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO statistika_tim (id_tim, prihravky, body, breaky, turnovery, zahodenie, body_dali, body_dostali, obrany) VALUES (" + 
				teamStats.getTeam_id() + "," + 	
				teamStats.getPasses() + "," + 	
				teamStats.getPoints() + "," + 	
				teamStats.getBreaks() + "," + 	
				teamStats.getTurnovers() + "," + 	
				teamStats.getDiscarded() + "," + 	
				teamStats.getPoints_gave() + "," + 	
				teamStats.getPoints_received() + "," + 	
				teamStats.getDefences() + 
				"" + ")";
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}

	@Override
	public void addStatsForPlayer(StatisticsPlayer playerStats) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "INSERT INTO statistika_hrac (id_hrac, body, prihravky, uspesne_prihravky, dropy, obrany) VALUES (" + 
				playerStats.getPlayer_id() + "," + 	
				playerStats.getPoints() + "," + 	
				playerStats.getSent_passes() + "," + 	
				playerStats.getSuccessfull_passes() + "," + 	
				playerStats.getDrops() + "," + 	
				playerStats.getDefences() +  	
				"" + ")";
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;

	}

	@Override
	public void addStatsForTournament(StatisticsTournament tournamentStats) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteStatsForTeam(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "DELETE FROM statistika_tim WHERE id_tim=" + id;
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}

	@Override
	public void deleteStatsForPlayer(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "DELETE FROM statistika_hrac WHERE id_hrac=" + id;
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}

	@Override
	public void deleteStatsForTournament(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String SQL = "DELETE FROM zapas WHERE id_turnaj=" + id;
		jdbcTemplate.execute(SQL);
		jdbcTemplate = null;
	}

}
