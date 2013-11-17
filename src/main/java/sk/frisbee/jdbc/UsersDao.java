package sk.frisbee.jdbc;

import java.util.List;

import sk.frisbee.domain.Address;
import sk.frisbee.domain.Player;
import sk.frisbee.domain.User;

/* Users Data access object - interface */
public interface UsersDao {

	/** SELECTY */
	/** Len pre tablulku profil hraca */
	public List<Player> getAllPlayerData();
	
	public List<Player> getPlayerData(int count);
	
	public Player getPlayer(Integer id);
	
	/** Len pre tablulku user - informacie pre prihlasenie */
	public List<User> getAllUserData();
	
	public List<User> getUserData(int count);
	
	public User getUser(Integer id);
	
	/** Len pre tablulku user - informacie pre prihlasenie */
	public List<Address> getAllAddressData();
	
	public Address getAddresForUserId(Integer id);
	
	/** INSERT */
	public void addPlayer(Player player);
	
	public void addUser(User user);
	
	public void addAddress(Address address);
	
	/** UPDATE */
	public void updatePlayer(Player updatedPlayer);
	
	public void updateUser(User updatedUser);
	
	public void updateAddress(Address updatedAddress);
	
	/** DELETE */
	public void removePlayer(Integer id);
	
	public void removeUser(Integer id);
	
	public void removeAddress(Integer id);

}
