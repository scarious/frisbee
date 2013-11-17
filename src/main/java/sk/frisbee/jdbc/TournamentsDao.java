package sk.frisbee.jdbc;

import java.util.List;
import sk.frisbee.domain.Tournament;

public interface TournamentsDao {
	
	public List<Tournament> getAllTournamentsData();
	
	public List<Tournament> getTournamentsData(Integer count);
	
	public Tournament getTournament(Integer id);
	
	public void addTournament(Tournament Tournament);
	
	public void updateTournament(Tournament updatedTournament);
	
	public void deleteTournament(Integer id);

}
