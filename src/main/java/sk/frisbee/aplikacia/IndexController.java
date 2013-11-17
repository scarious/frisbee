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
import sk.frisbee.jdbc.JdbcUsersDao;
import sk.frisbee.jdbc.UsersDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	
	 @Autowired  
	 JdbcUsersDao usersdao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getUserList() {
		logger.info("Welcome home! The client locale is {}.");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		List<User> usersList = usersdao.getAllUsersList();
		
		for(User s : usersList){
			logger.info("A" + s.getFirstName());
		}
		
		ModelAndView maw = new ModelAndView("index", "usersList", usersList);
		

		
		maw.addObject("pageTitle", "Index");
		
		maw.addObject("serverTime", formattedDate );
		
		return maw;
	}

}
