package sk.frisbee.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Day {

	private List<Tournament> tournaments;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	public List<Tournament> getTournaments() {
		return tournaments;
	}
	
	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
