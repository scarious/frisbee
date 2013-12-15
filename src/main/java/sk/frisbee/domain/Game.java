package sk.frisbee.domain;

import java.io.Serializable;

public class Game implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3588204972666900425L;

	private Integer team1_id;

	private Integer team2_id;

	private Integer team1_points;

	private Integer team1_passes;

	private Integer team1_breaks;

	private Integer team1_turnovers;

	private Integer team1_defences;

	private Integer team1_discarded;

	private Integer team2_points;

	private Integer team2_passes;

	private Integer team2_breaks;

	private Integer team2_turnovers;

	private Integer team2_defences;

	private Integer team2_discarded;
	
	public Integer getTeam1_id() {
		return team1_id;
	}

	public void setTeam1_id(Integer team1_id) {
		this.team1_id = team1_id;
	}

	public Integer getTeam2_id() {
		return team2_id;
	}

	public void setTeam2_id(Integer team2_id) {
		this.team2_id = team2_id;
	}

	public Integer getTeam1_points() {
		return team1_points;
	}

	public void setTeam1_points(Integer team1_points) {
		this.team1_points = team1_points;
	}

	public Integer getTeam1_passes() {
		return team1_passes;
	}

	public void setTeam1_passes(Integer team1_passes) {
		this.team1_passes = team1_passes;
	}

	public Integer getTeam1_breaks() {
		return team1_breaks;
	}

	public void setTeam1_breaks(Integer team1_breaks) {
		this.team1_breaks = team1_breaks;
	}

	public Integer getTeam1_turnovers() {
		return team1_turnovers;
	}

	public void setTeam1_turnovers(Integer team1_turnovers) {
		this.team1_turnovers = team1_turnovers;
	}

	public Integer getTeam1_defences() {
		return team1_defences;
	}

	public void setTeam1_defences(Integer team1_defences) {
		this.team1_defences = team1_defences;
	}

	public Integer getTeam1_discarded() {
		return team1_discarded;
	}

	public void setTeam1_discarded(Integer team1_discarded) {
		this.team1_discarded = team1_discarded;
	}

	public Integer getTeam2_points() {
		return team2_points;
	}

	public void setTeam2_points(Integer team2_points) {
		this.team2_points = team2_points;
	}

	public Integer getTeam2_passes() {
		return team2_passes;
	}

	public void setTeam2_passes(Integer team2_passes) {
		this.team2_passes = team2_passes;
	}

	public Integer getTeam2_breaks() {
		return team2_breaks;
	}

	public void setTeam2_breaks(Integer team2_breaks) {
		this.team2_breaks = team2_breaks;
	}

	public Integer getTeam2_turnovers() {
		return team2_turnovers;
	}

	public void setTeam2_turnovers(Integer team2_turnovers) {
		this.team2_turnovers = team2_turnovers;
	}

	public Integer getTeam2_defences() {
		return team2_defences;
	}

	public void setTeam2_defences(Integer team2_defences) {
		this.team2_defences = team2_defences;
	}

	public Integer getTeam2_discarded() {
		return team2_discarded;
	}

	public void setTeam2_discarded(Integer team2_discarded) {
		this.team2_discarded = team2_discarded;
	}

}
