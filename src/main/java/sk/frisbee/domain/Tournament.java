package sk.frisbee.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tournament implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7254088587054114213L;

	private Long tournament_id;
	
	private Long user_id;
	
	private String name;
	
	private Integer disciplines;
	
	private String surface;
	
	private String division;
	
	private Integer level_of_play;
	
	private String format;
	
	private Date date;
	
	private String place;
	
	private String contact;
	
	private List<Team> teams = new ArrayList<Team>(); 
	
	private List<Player> players = new ArrayList<Player>();
	
	private List<TRoster> tRosters = new ArrayList<TRoster>();

	public Long getId_tournament() {
		return tournament_id;
	}

	public Long getId_user() {
		return user_id;
	}

	public void setId_user(Long id_user) {
		this.user_id = id_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(Integer disciplines) {
		this.disciplines = disciplines;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Integer getLevel_of_play() {
		return level_of_play;
	}

	public void setLevel_of_play(Integer level_of_play) {
		this.level_of_play = level_of_play;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<TRoster> gettRosters() {
		return tRosters;
	}

	public void settRosters(List<TRoster> tRosters) {
		this.tRosters = tRosters;
	}
	
}
