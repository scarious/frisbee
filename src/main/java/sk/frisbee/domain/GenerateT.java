package sk.frisbee.domain;

import java.util.List;

import sk.frisbee.domain.Player;
import sk.frisbee.domain.Schedule;
import sk.frisbee.domain.TRoster;

public interface GenerateT {

	List<TRoster> generateRosters(List<Player> players, Long tournament_id);
	
	Schedule generateSchedule(List<TRoster> rosters, Long tournament_id);

}
