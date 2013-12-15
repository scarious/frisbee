package sk.frisbee.aplikacia;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sk.frisbee.domain.User;
import sk.frisbee.jdbc.UsersDaoImpl;

@Controller
@RequestMapping(value={"/register/", "/register"})
public class RegisterController {
	
	@Autowired  
	UsersDaoImpl usersDao;
	
	//@RequestMapping(value={"", "/"}, method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
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
	
	@RequestMapping(params="errorRegister")
	public ModelAndView getRegisterBadUsername() {
		String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		ModelAndView maw = new ModelAndView("register", "date", date);
		maw.addObject("command", new User());
		
		maw.addObject("badUsername", "badUsername");
		maw.addObject("pageTitle", "Register");
		maw.addObject("serverTime", formattedDate );
		maw.addObject("loggedUserName", loggedUserName);
		return maw;
	}
	
	//value = "/AddUser", 
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User user, 
			   ModelMap model) {
		//String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		//model.addAttribute("username", user.getUsername());
		//model.addAttribute("password", user.getPassword());
		//model.addAttribute("username", user.getUsername());
		
		//user.setEmailAddress(user.getEmailAddress().replace("@", "(at)"));
		//user.setEmailAddress(user.getEmailAddress().replace(".", "(dot)"));
		try {
			usersDao.addUser(user);
		} catch (DuplicateKeyException e){
			return new ModelAndView("redirect:" + "register?errorRegister");
		}
		
		//Date date = new Date();
		//DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		//String formattedDate = dateFormat.format(date);
		return new ModelAndView("redirect:" + "login?regOk"); //new ModelAndView("index", "date", date);
		
		
		//maw.addObject("pageTitle", "Login");
		//maw.addObject("serverTime", formattedDate );
		//maw.addObject("loggedUserName", loggedUserName);
		//return maw;
		//return new ModelAndView("redirect:" + "/profile");
	}

}
