package sk.frisbee.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Tournament implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7254088587054114213L;

	private Long tournament_id;
	
	private Integer user_id;
	
	private String name;
	
	private String disciplines;
	
	private String surface;
	
	private String division;
	
	private String level_of_play;
	
	private String format;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	private Integer durationDays;
	
	private String country;
	
	private String city;
	
	private String contact_email,contact_fb,contact_number;
	
	private List<Team> teams = new ArrayList<Team>(); 
	
	private List<Player> players = new ArrayList<Player>();
	
	private List<TRoster> tRosters = new ArrayList<TRoster>();

	private String gps_coord;
	
	private Integer regpoplatokhrac;
	private Integer regpoplatoktim;
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Long getId_tournament() {
		return tournament_id;
	}

	public Integer getId_user() {
		return user_id;
	}

	public void setId_user(Integer id_user) {
		this.user_id = id_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(String string) {
		this.disciplines = string;
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
		this.division = "zeny";
	}

	public String getLevel_of_play() {
		return level_of_play;
	}

	public void setLevel_of_play(String level_of_play) {
		this.level_of_play = level_of_play;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Date getTournamentDate() {
		return date;
	}

	public void setTournamentDate(Date date) {
		this.date = date;
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

	public String getGps_coord() {
		return gps_coord;
	}
	
	public void setGps_coord(String gps){
		this.gps_coord = gps;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(Integer durationDays) {
		this.durationDays = durationDays;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getContact_fb() {
		return contact_fb;
	}

	public void setContact_fb(String contact_fb) {
		this.contact_fb = contact_fb;
	}

	public Integer getRegpoplatokhrac() {
		return regpoplatokhrac;
	}

	public void setRegpoplatokhrac(Integer regpoplatokhrac) {
		this.regpoplatokhrac = regpoplatokhrac;
	}

	public Integer getRegpoplatoktim() {
		return regpoplatoktim;
	}

	public void setRegpoplatoktim(Integer regpoplatoktim) {
		this.regpoplatoktim = regpoplatoktim;
	}
	
}
