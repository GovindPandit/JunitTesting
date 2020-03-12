package dao;

import java.util.List;
import model.User;

//
public interface UserDAO
{
	public boolean addUser(User u);
	public boolean deleteUser(String username);
	public boolean updateUser(User u);
	public User displayUserByName(String username);
	public List<User> displayAllUsers();
}
