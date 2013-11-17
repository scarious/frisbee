package sk.frisbee.jdbc;

import java.util.List;

import sk.frisbee.domain.Statistics;
import sk.frisbee.domain.StatisticsPlayer;
import sk.frisbee.domain.StatisticsTeam;
import sk.frisbee.domain.StatisticsTournament;

public interface StatisticsDao {

	public List<Statistics> getAllStats();
	
	public List<StatisticsTeam> getAllTeamStats();
	
	public List<StatisticsPlayer> getAllPlayerStats();
	
	public List<StatisticsTournament> getAllTournamentStats();
	
	public StatisticsTeam getStatsForTeam(Integer id);
	
	public StatisticsPlayer getStatsForPlayer(Integer id);
	
	public StatisticsTournament getStatsForTournament(Integer id);
	
	public void addStatsForTeam(StatisticsTeam teamStats);
	
	public void addStatsForPlayer(StatisticsPlayer playerStats);
	
	public void addStatsForTournament(StatisticsTournament tournamentStats);
	
	public void deleteStatsForTeam(Integer id);
	
	public void deleteStatsForPlayer(Integer id);
	
	public void deleteStatsForTournament(Integer id);

}
