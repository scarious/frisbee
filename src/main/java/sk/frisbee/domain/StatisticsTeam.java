package sk.frisbee.domain;

import java.io.Serializable;

public class StatisticsTeam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7400588445419567407L;

	private Long team_id;
	
	private Long stat_id;

	private Integer passes;

	private Integer points;

	private Integer breaks;

	private Integer turnovers;

	private Integer discarded;

	private Integer points_gave;

	private Integer points_received;

	private Integer defences;

	public Long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}

	public Integer getPasses() {
		return passes;
	}

	public void setPasses(Integer passes) {
		this.passes = passes;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getBreaks() {
		return breaks;
	}

	public void setBreaks(Integer breaks) {
		this.breaks = breaks;
	}

	public Integer getTurnovers() {
		return turnovers;
	}

	public void setTurnovers(Integer turnovers) {
		this.turnovers = turnovers;
	}

	public Integer getDiscarded() {
		return discarded;
	}

	public void setDiscarded(Integer discarded) {
		this.discarded = discarded;
	}

	public Integer getPoints_gave() {
		return points_gave;
	}

	public void setPoints_gave(Integer points_gave) {
		this.points_gave = points_gave;
	}

	public Integer getPoints_received() {
		return points_received;
	}

	public void setPoints_received(Integer points_received) {
		this.points_received = points_received;
	}

	public Integer getDefences() {
		return defences;
	}

	public void setDefences(Integer defences) {
		this.defences = defences;
	}

	public Long getStat_id() {
		return stat_id;
	}

	

}
