package sk.frisbee.domain;

import java.io.Serializable;

public class StatisticsPlayer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7001876560007030579L;

	private Long player_id;

	private Long stat_id;
	
	private Integer points;
	
	private Integer sent_passes;
	
	private Integer successfull_passes;
	
	private Integer caught_passes;
	
	private Integer drops;
	
	private Integer defences;

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getSent_passes() {
		return sent_passes;
	}

	public void setSent_passes(Integer sent_passes) {
		this.sent_passes = sent_passes;
	}

	public Integer getSuccessfull_passes() {
		return successfull_passes;
	}

	public void setSuccessfull_passes(Integer successfull_passes) {
		this.successfull_passes = successfull_passes;
	}

	public Integer getCaught_passes() {
		return caught_passes;
	}

	public void setCaught_passes(Integer caught_passes) {
		this.caught_passes = caught_passes;
	}

	public Integer getDrops() {
		return drops;
	}

	public void setDrops(Integer drops) {
		this.drops = drops;
	}

	public Integer getDefences() {
		return defences;
	}

	public void setDefences(Integer defences) {
		this.defences = defences;
	}

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public Long getStat_id() {
		return stat_id;
	}

}
