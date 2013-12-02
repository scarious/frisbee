package sk.frisbee.aplikacia;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sk.frisbee.domain.User;
import sk.frisbee.jdbc.UsersDaoImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	
	 @Autowired  
	 UsersDaoImpl usersdao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value={"/index", "/", "/aplikacia/"})
	public ModelAndView getIndex() {
		logger.info("Welcome home! The client locale is {}.");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		List<User> usersList = usersdao.getAllUserData();
		
		for(User s : usersList){
			logger.info("A" + s.getUsername());
		}
		
		ModelAndView maw = new ModelAndView("index", "usersList", usersList);
		

		
		maw.addObject("pageTitle", "Index");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}
	
	@RequestMapping(value = "/playersTop", method = RequestMethod.GET)
	public ModelAndView getTopPlayers() {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("playersTop", "date", date);
		
		
		maw.addObject("pageTitle", "Top Players");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin() {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("login", "date", date);
		
		
		maw.addObject("pageTitle", "Login");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}
	
	@RequestMapping(value = "/newTeam", method = RequestMethod.GET)
	public ModelAndView getNewTeam() {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("newTeam", "date", date);
		
		
		maw.addObject("pageTitle", "New Team");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}
	
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public ModelAndView getPlayers() {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("players", "date", date);
		
		
		maw.addObject("pageTitle", "Login");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView getProfile(Integer player_id) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("profile", "date", date);
		
		
		maw.addObject("pageTitle", "Profil");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}
	
	@RequestMapping(value = "/profileTeam", method = RequestMethod.GET)
	public ModelAndView getTeamProfile() {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("profileTeam", "date", date);
		
		
		maw.addObject("pageTitle", "Profil tim");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}
	
	@RequestMapping(value = "/profileTournament", method = RequestMethod.GET)
	public ModelAndView getTournamentProfile() {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("profileTournament", "date", date);
		
		
		maw.addObject("pageTitle", "profileTournament");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getRegister() {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("register", "date", date);
		
		
		maw.addObject("pageTitle", "Register");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}
	
	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public ModelAndView getTeams() {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("teams", "date", date);
		
		
		maw.addObject("pageTitle", "Teams");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}
	
	@RequestMapping(value = "/teamsTop", method = RequestMethod.GET)
	public ModelAndView getTopTeams() {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("teamsTop", "date", date);
		
		
		maw.addObject("pageTitle", "teamsTop");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}
	
	@RequestMapping(value = "/tournaments", method = RequestMethod.GET)
	public ModelAndView getTournaments() {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("tournaments", "date", date);
		
		
		maw.addObject("pageTitle", "tournaments");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}
	
	@RequestMapping(value = "/tournamentsNew", method = RequestMethod.GET)
	public ModelAndView getNewTournaments() {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("tournamentsNew", "date", date);
		
		
		maw.addObject("pageTitle", "tournamentsNew");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}

}
