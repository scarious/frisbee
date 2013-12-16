package sk.frisbee.aplikacia;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import sk.frisbee.domain.Address;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.StatisticsPlayer;
import sk.frisbee.domain.Team;
import sk.frisbee.domain.User;
import sk.frisbee.jdbc.StatisticsDaoImpl;
import sk.frisbee.jdbc.TeamsDaoImpl;
import sk.frisbee.jdbc.UsersDaoImpl;

@Controller
@RequestMapping(value="/profile")
public class PlayerProfileController {
	
	@Autowired  
	UsersDaoImpl usersDao;

	@Autowired  
	TeamsDaoImpl teamsDao;
	
	@Autowired  
	StatisticsDaoImpl statsDao;
	
	@RequestMapping(value={"", "/"}, method = RequestMethod.GET)
	public ModelAndView getProfile(@RequestParam(value = "id", required = false) String player_id) {
		Authentication loggedUser = SecurityContextHolder.getContext().getAuthentication();
		String loggedUserName = loggedUser.getName();
		
		User loggedUserData = (User) usersDao.getUserByUsername(loggedUserName);
		//System.out.println("ID prihlaseny UID " + loggedUserData.getUser_id());
		
		Player loggedPlayerData = null;
		Player otherPlayerData = null;
		if(player_id == "" || player_id == null){
			loggedPlayerData = (Player) usersDao.getPlayerByUserId(loggedUserData.getUser_id());
			
		} else {
			otherPlayerData = (Player) usersDao.getPlayer(Integer.parseInt(player_id));
			loggedPlayerData = (Player) usersDao.getPlayer(Integer.parseInt(player_id));//usersDao.getPlayerByUserId(loggedUserData.getUser_id());//usersDao.getPlayer(Integer.parseInt(player_id));
			//System.out.println("Iny hrac");
		}
		//System.out.println("ID prihlaseny: " + loggedPlayerData.getPlayer_id() + "UID" + loggedPlayerData.getUser_id());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);

		ModelAndView maw = new ModelAndView("profile", "serverTime", formattedDate);
		Address playerAddress ;
		List<Team> playerTeams;// = new ArrayList<>();
		StatisticsPlayer playerStats;
		if (loggedPlayerData != null){
			playerAddress = usersDao.getAddresForPlayerId(loggedPlayerData.getPlayer_id());
			maw.addObject("playerAddress", playerAddress);
			
			playerTeams = teamsDao.getPlayersTeams(loggedPlayerData.getPlayer_id());
			maw.addObject("playerTeams", playerTeams);
			
			playerStats = statsDao.getStatsForPlayer(loggedPlayerData.getPlayer_id());
			maw.addObject("playerStats", playerStats);
		}
		
		maw.addObject("loggedPlayerData", loggedPlayerData);
		maw.addObject("otherPlayerData", otherPlayerData);
		maw.addObject("pageTitle", "Profil");
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView getProfileEdit(@ModelAttribute Player player, @ModelAttribute Address addr,
			   ModelMap model) {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		User loggedUserData = (User) usersDao.getUserByUsername(loggedUserName);
		player.setUserId(loggedUserData.getUser_id()); 
		player.setAddress(addr);
		usersDao.updatePlayer(player);
		ModelAndView maw = new ModelAndView("redirect:" + "profile");//new ModelAndView("profile","serverTime", formattedDate );
		return maw;
	}
	
	@RequestMapping(value={"/New/", "/New"}, method = RequestMethod.POST)
	public ModelAndView getProfileNew(@ModelAttribute Player player,  @ModelAttribute Address addr,
			   ModelMap model) {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		//Integer player_idd = 1;
		
		User loggedUserData = (User) usersDao.getUserByUsername(loggedUserName);
		Integer userId = loggedUserData.getUser_id();
		player.setUserId(userId); 
		player.setAddress(addr);
		usersDao.addPlayer(player, userId);
		
		ModelAndView maw = new ModelAndView("redirect:" + "/profile");//new ModelAndView("profile","serverTime", formattedDate );
		return maw;
	}
}
