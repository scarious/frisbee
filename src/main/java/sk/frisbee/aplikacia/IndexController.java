package sk.frisbee.aplikacia;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sk.frisbee.domain.Player;
import sk.frisbee.domain.StatisticsPlayer;
import sk.frisbee.domain.StatisticsTeam;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.Tournament;
import sk.frisbee.domain.User;
import sk.frisbee.jdbc.SearchDaoImpl;
import sk.frisbee.jdbc.StatisticsDaoImpl;
import sk.frisbee.jdbc.TeamsDaoImpl;
import sk.frisbee.jdbc.TournamentsDaoImpl;
import sk.frisbee.jdbc.UsersDaoImpl;

/**
 * Handles requests for the application home page.
 */

@Controller
public class IndexController {
	
	@Autowired  
	UsersDaoImpl usersDao;
	 
	@Autowired  
	StatisticsDaoImpl statsDao;
	
	@Autowired  
	TeamsDaoImpl teamsDao;
	
	@Autowired  
	TournamentsDaoImpl tournamentsDao;
	
	@Autowired  
	SearchDaoImpl searchDao;
	 
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value={"/index", "/", "/aplikacia/"})
	public String getIndex(ModelMap map) {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		//Vytvorenie zoznamu najlepsich timov, nacitanie statistiky z DB + ziskanie nazvu timov pre danu statistiku podla id
		List<StatisticsTeam> topTeamsList = statsDao.getAllTeamStats();
		List<Team> topTeamsListData = new ArrayList<Team>();
		for(StatisticsTeam s : topTeamsList){
			topTeamsListData.add(teamsDao.getTeam(s.getTeam_id()));
		}
		
		List<StatisticsPlayer> topUsersList = statsDao.getAllPlayerStats();
		
		map.addAttribute("topTeamsList", topTeamsList);
		map.addAttribute("topTeamsListData", topTeamsListData);
		map.addAttribute("topUsersList", topUsersList);
		map.addAttribute("pageTitle", "Index");
		map.addAttribute("serverTime", formattedDate);
		map.addAttribute("loggedUserName", loggedUserName);
		
		return "index";
	}
	
	@RequestMapping(value = "/playersTop")
	public ModelAndView getTopPlayers() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		List<StatisticsPlayer> topUsersList = statsDao.getAllPlayerStats();
		ModelAndView maw = new ModelAndView("playersTop", "topUsersList", topUsersList);
		
		maw.addObject("pageTitle", "Top Players");
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}

	
	@RequestMapping(value = "/login")
	public ModelAndView getLogin() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("serverTime", formattedDate);
		return modelAndView;  
	}
	
	 @RequestMapping(value="/login", params="errorLogin")  
	 public String loginerror(ModelMap model) {  
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
			
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("loginFailed", true);
		return "login";  
	 }  
	   
	 @RequestMapping(value="/logout", method = RequestMethod.GET)  
	 public String logout(ModelMap model) {  
		 String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
	  model.addAttribute("loggedUserName", loggedUserName);
	  return "login";  
	   
	 }  
	
	@RequestMapping(value = "/newTeam")
	public ModelAndView getNewTeam() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		
		ModelAndView maw = new ModelAndView("newTeam", "date", date);
		
		List<Player> playerData = usersDao.getAllPlayerData();
		
		maw.addObject("pageTitle", "Nový tým");
		maw.addObject("playerData", playerData);
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	@RequestMapping(value = "/newTeam", method = RequestMethod.POST)
	public ModelAndView getNewTeamAdd(@ModelAttribute Team team) {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		System.out.println("Vytvoreny tim: " + team.getName() + " " + team.getPlayersForParsing());
		ModelAndView maw = new ModelAndView("newTeam", "date", date);
		
		User loggedUserData = (User) usersDao.getUserByUsername(loggedUserName);
		team.setUser_id(loggedUserData.getUser_id());
		//Pridanie noveho timu do DB
		//teamsDao.addTeam(team);
		Integer newTeamId = teamsDao.addTeamWithReturnVal(team);
		//Parsovanie hracov a pridanie k timu
		List<Player> playersFromParsedData = new ArrayList<Player>();
		String unParsedPlayerId = team.getPlayersForParsing();
		Pattern pattern = Pattern.compile(".*?;");
		Matcher matcher = pattern.matcher(unParsedPlayerId);
		while (matcher.find()) {
		    String pId = matcher.group().substring(0, matcher.group().indexOf(";"));
			Player forAdding = new Player();
			forAdding.setPlayerId(Integer.valueOf(pId));
		    playersFromParsedData.add(forAdding);
			System.out.println(pId);
		}
		System.out.println("Returned ID:" + newTeamId);
		teamsDao.addPlayersToTeam(newTeamId, playersFromParsedData);
		
		List<Player> playerData = usersDao.getAllPlayerData();
		
		maw.addObject("pageTitle", "Nový tým");
		maw.addObject("playerData", playerData);
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public ModelAndView getPlayers() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("players", "date", date);
		
		maw.addObject("pageTitle", "Login");
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	
	
	
	@RequestMapping(value = "/profileTeam", method = RequestMethod.GET)
	public ModelAndView getTeamProfile() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("profileTeam", "date", date);
		
		maw.addObject("pageTitle", "Profil tim");
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	@RequestMapping(value = "/profileTournament", method = RequestMethod.GET)
	public ModelAndView getTournamentProfile() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("profileTournament", "date", date);
		
		maw.addObject("pageTitle", "profileTournament");
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	
	
	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public ModelAndView getTeams() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("teams", "date", date);
		
		maw.addObject("pageTitle", "Teams");
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	/*
	 * Stranka s tabulkou vsetkych timov zoradenych podla skore
	 */
	@RequestMapping(value = "/teamsTop", method = RequestMethod.GET)
	public ModelAndView getTopTeams() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		//Vytvorenie zoznamu najlepsich timov, nacitanie statistiky z DB + ziskanie nazvu timov pre danu statistiku podla id
		List<StatisticsTeam> topTeamsList = statsDao.getAllTeamStats();
		List<Team> topTeamsListData = new ArrayList<Team>();
		for(StatisticsTeam s : topTeamsList){
			topTeamsListData.add(teamsDao.getTeam(s.getTeam_id()));
		}
		
		ModelAndView maw = new ModelAndView("teamsTop", "date", date);
		
		maw.addObject("topTeamsList", topTeamsList);
		maw.addObject("topTeamsListData", topTeamsListData);
		maw.addObject("pageTitle", "teamsTop");
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	@RequestMapping(value = "/tournaments", method = RequestMethod.GET)
	public ModelAndView getTournaments() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("tournaments", "date", date);
		
		maw.addObject("pageTitle", "tournaments");
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	@RequestMapping(value = "/tournamentsNew", method = RequestMethod.GET)
	public ModelAndView getNewTournaments() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("tournamentsNew", "date", date);
		
		maw.addObject("pageTitle", "tournamentsNew");
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	@RequestMapping(value = "/tournamentsNew", method = RequestMethod.POST)
	public ModelAndView getNewTournamentsAdd(@ModelAttribute Tournament tournament) {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		User loggedUserData = (User) usersDao.getUserByUsername(loggedUserName);
		tournament.setId_user(loggedUserData.getUser_id());
		tournamentsDao.addTournamentWithReturnVal(tournament);
		//tournamentsDao.addTournament(tournament);
		ModelAndView maw = new ModelAndView("tournamentsNew", "date", date);
		
		maw.addObject("pageTitle", "Vytvor tím");
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}

}
