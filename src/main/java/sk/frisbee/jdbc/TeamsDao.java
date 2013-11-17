package sk.frisbee.jdbc;

import java.util.List;
import sk.frisbee.domain.Team;

public interface TeamsDao {
	
	public List<Team> getAllTeamsData();
	
	public List<Team> getTeamsData(Integer count);
	
	public Team getTeam(Integer id);
	
	public void addTeam(Team team);
	
	public void updateTeam(Team updatedTeam);
	
	public void deleteTeam(Integer id);
	
}
