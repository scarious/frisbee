package sk.frisbee.domain;

import java.util.List;

import sk.frisbee.domain.Day;
import sk.frisbee.domain.Tournament;

public interface Calendar {

	List<Day> generateCList(int month, List<Tournament> tournaments);
	
}
