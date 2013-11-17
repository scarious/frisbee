package sk.frisbee.jdbc;

import java.util.List;

import sk.frisbee.domain.User;

public interface UsersDao {
	
	public List<User> getAllUsersList();
	public List<User> getUsersList(int count);
	public User getUser(Integer id);

}
