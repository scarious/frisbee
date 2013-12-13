package sk.frisbee.aplikacia;

import java.text.DateFormat;
import java.util.Date;

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
import sk.frisbee.domain.User;
import sk.frisbee.jdbc.UsersDaoImpl;

@Controller
@RequestMapping(value="/profile")
public class ProfileController {
	
	@Autowired  
	UsersDaoImpl usersDao;

	@RequestMapping(value={"", "/"}, method = RequestMethod.GET)
	public ModelAndView getProfile(@RequestParam(value = "id", required = false) String player_id) {
		Authentication loggedUser = SecurityContextHolder.getContext().getAuthentication();
		String loggedUserName = loggedUser.getName();
		
		User loggedUserData = (User) usersDao.getUserByUsername(loggedUserName);
		//System.out.println("Profil IDcka uid " + loggedUserData.getUser_id());
		
		Player loggedPlayerData = (Player) usersDao.getPlayer(loggedUserData.getUser_id());
		
		//System.out.println("Profil " + loggedPlayerData.getPlayer_id() + " Pohl" + loggedPlayerData.getPohlavie());
		//Integer player_idd = 1;
		
		//if(!StringUtils.isNullOrEmpty(player_id)) 
		//player_idd = Integer.parseInt(player_id);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		//Player player = usersDao.getPlayer(player_idd);	
		
		ModelAndView maw = new ModelAndView("profile", "loggedPlayerData", loggedPlayerData);
		Address playerAddress ;
		if (loggedPlayerData != null){
			playerAddress = usersDao.getAddresForPlayerId(loggedPlayerData.getPlayer_id());
			maw.addObject("playerAddress", playerAddress);
		}
		
		
		maw.addObject("pageTitle", "Profil");
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	@RequestMapping(value = "/Edit", method = RequestMethod.POST)
	public ModelAndView getProfileEdit(@ModelAttribute Player player, 
			   ModelMap model) {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		//Integer player_idd = 1;
		
		User loggedUserData = (User) usersDao.getUserByUsername(loggedUserName);
		//Player player = usersDao.getPlayer(player_idd);	
		player.setUserId(loggedUserData.getUser_id()); 
		usersDao.updatePlayer(player);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		ModelAndView maw = new ModelAndView("profile","serverTime", formattedDate );
		
		//Address playerAddress = usersDao.getAddresForPlayerId(player_idd);
		
		//maw.addObject("playerAddress", playerAddress);
		
		maw.addObject("loggedUserName", loggedUserName);
		//return maw;
		 return new ModelAndView("redirect:" + "/profile");
	}
}
