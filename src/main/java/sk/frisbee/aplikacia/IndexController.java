package sk.frisbee.aplikacia;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import sk.frisbee.domain.Address;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.StatisticsPlayer;
import sk.frisbee.domain.User;
import sk.frisbee.jdbc.StatisticsDaoImpl;
import sk.frisbee.jdbc.UsersDaoImpl;

import com.mysql.jdbc.StringUtils;

/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes("meno")
public class IndexController {
	
	@Autowired  
	 UsersDaoImpl usersDao;
	 
	 @Autowired  
	 StatisticsDaoImpl statsDao;
	
	 
	 
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
		
		
		List<StatisticsPlayer> topUsersList = statsDao.getAllPlayerStats();
		
		//ModelAndView maw = new ModelAndView("index", "topUsersList", topUsersList);
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

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		ModelAndView modelAndView = new ModelAndView("login");
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
		
		maw.addObject("pageTitle", "Nový tím");
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
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView getProfile(@RequestParam(value = "id", required = false) String player_id) {
		Authentication loggedUser = SecurityContextHolder.getContext().getAuthentication();
		String loggedUserName = loggedUser.getName();
		
		User loggedUserData = (User) usersDao.getUserByUsername(loggedUserName);
		//System.out.println("Profil IDcka uid " + loggedUserData.getUser_id());
		
		Player loggedPlayerData = (Player) usersDao.getPlayer(loggedUserData.getUser_id());
		
		//System.out.println("Profil " + loggedPlayerData.getPlayer_id() + " Pohl" + loggedPlayerData.getPohlavie());
		Integer player_idd = 1;
		
		if(!StringUtils.isNullOrEmpty(player_id)) 
		player_idd = Integer.parseInt(player_id);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		Player player = usersDao.getPlayer(player_idd);	
		
		ModelAndView maw = new ModelAndView("profile", "loggedPlayerData", loggedPlayerData);
		
		Address playerAddress = usersDao.getAddresForPlayerId(player_idd);
		
		maw.addObject("playerAddress", playerAddress);
		
		maw.addObject("pageTitle", "Profil");
		
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	@RequestMapping(value = "/profileEdit")
	public ModelAndView getProfileEdit() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Integer player_idd = 1;
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		Player player = usersDao.getPlayer(player_idd);	
		
		ModelAndView maw = new ModelAndView("profile", "player", player);
		
		Address playerAddress = usersDao.getAddresForPlayerId(player_idd);
		
		maw.addObject("playerAddress", playerAddress);
		
		maw.addObject("pageTitle", "Profil");
		
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
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getRegister() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("register", "date", date);
		
		maw.addObject("command", new User());
		maw.addObject("pageTitle", "Register");
		
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	@RequestMapping(value = "/registerAddUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User user, 
			   ModelMap model) {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		model.addAttribute("username", user.getUsername());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("username", user.getUsername());
		
		user.setEmailAddress(user.getEmailAddress().replace("@", "(at)"));
		user.setEmailAddress(user.getEmailAddress().replace(".", "(dot)"));
		usersDao.addUser(user);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("index", "date", date);
		
		
		maw.addObject("pageTitle", "Register");
		
		maw.addObject("Registrovany", formattedDate );
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

}
