package sk.frisbee.jdbc;

import java.util.List;

import sk.frisbee.domain.Player;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.Tournament;

public interface TeamsDao {
	
	public List<Team> getAllTeamsData();
	
	public List<Team> getTeamsData(Integer count);
	
	public List<Player> getPlayersInTeam(Integer id);
	
	public List<Tournament> getTeamTournaments();
	
	public Team getTeam(Integer id);
	
	public void addTeam(Team team);
	
	public Integer addTeamWithReturnVal(Team team);
	
	public void updateTeam(Team updatedTeam);
	
	public void deleteTeam(Integer id);
	
	public void addPlayersToTeam(Integer team_id, List<Player> players);
	
}
