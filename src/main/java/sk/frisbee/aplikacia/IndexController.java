package sk.frisbee.aplikacia;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sk.frisbee.domain.Player;
import sk.frisbee.domain.StatisticsPlayer;
import sk.frisbee.domain.StatisticsTeam;
import sk.frisbee.domain.Team;
import sk.frisbee.jdbc.StatisticsDaoImpl;
import sk.frisbee.jdbc.TeamsDaoImpl;
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
	 
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value={"/index", "/", "/aplikacia/"})
	public String getIndex(ModelMap map) {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		//System.out.println(usersDao.getUser(1).getUsername());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		
		//Vytvorenie zoznamu najlepsich timov, nacitanie statistiky z DB + ziskanie nazvu timov pre danu statistiku podla id
		List<StatisticsTeam> topTeamsList = statsDao.getAllTeamStats();
		List<Team> topTeamListData = new ArrayList<Team>();
		for(StatisticsTeam s : topTeamsList){
			topTeamListData.add(teamsDao.getTeam(s.getTeam_id()));
		}
		
		List<StatisticsPlayer> topUsersList = statsDao.getAllPlayerStats();
		
		//ModelAndView maw = new ModelAndView("index", "topUsersList", topUsersList);
		map.addAttribute("topTeamsList", topTeamsList);
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
		//String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("serverTime", formattedDate);
		return modelAndView;  
	}
	
	 @RequestMapping(value="/login", params="errorLogin")  
	 public String loginerror(ModelMap model) {  
		 String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
	  model.addAttribute("loginFailed", true);
	  model.addAttribute("loggedUserName", loggedUserName);
	  return "login";  
	   
	 }  
	   
	 @RequestMapping(value="/logout", method = RequestMethod.GET)  
	 public String logout(ModelMap model) {  
		 String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
	  model.addAttribute("loggedUserName", loggedUserName);
	  return "login";  
	   
	 }  
	
	@RequestMapping(value = "/newTeam", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/teamsTop", method = RequestMethod.GET)
	public ModelAndView getTopTeams() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("teamsTop", "date", date);
		
		
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
	
	@RequestMapping(value = "/tournamentsNewAdd", method = RequestMethod.POST)
	public ModelAndView getNewTournamentsAdd() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("tournaments", "date", date);
		
		
		
		maw.addObject("pageTitle", "tournamentsNew");
		
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}

}
