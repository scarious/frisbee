package sk.frisbee.aplikacia;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import sk.frisbee.domain.Role;
import sk.frisbee.domain.User;
import sk.frisbee.jdbc.UsersDaoImpl;

@Service("myCustomAuthProvider")
public class CustomAuthProvider implements AuthenticationProvider {
	//private static final Logger log = LoggerFactory.getLogger(CustomAuthProvider.class);
	 
/*
 * Autowire tu nefunguje 
 */
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	
	
	UsersDaoImpl usersDao = new UsersDaoImpl();
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Authentication authenticate(Authentication authentication)	throws AuthenticationException {
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl( "jdbc:mysql://localhost:3306/frisbee");
		dataSource.setUsername("root");
		dataSource.setPassword("root"); 
		
		usersDao.setDataSource(dataSource);
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		//log.debug("Trying to authenticate user '{}' via XXXX", username);
        
		//User userr = findUser(username);
		//String usernasme = userr.getUsername();
		
		//System.out.println(usernasme);
		//if(username == null || username.contains("")){
		//	throw new BadCredentialsException("Username not found.");
		//}
        User user = null;
        try{
        	usersDao.loadUserByUsername(username);
        } catch (IndexOutOfBoundsException e){
        	throw new BadCredentialsException("Prihlasovacie meno nenájdené alebo nevyplnené!");
        }
        		
        //user.getAuthorities().
        System.out.println("User nacitany");
        if (user == null) {
        	System.out.println("User je null");
            throw new BadCredentialsException("Chyba pri overovaní prihlasovacieho mena");
        }
        //ak neni null
        System.out.println(user.getUsername() + " | " + user.getPassword() + " | " +
        ((ArrayList<Role>)user.getAuthorities()).get(0).getAuthority());
        
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }
        System.out.println("Vsetko vyzera ok");
        return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
	
	protected User findUser(String uName){
		return usersDao.getUserByUsername(uName);
	}
	
}
