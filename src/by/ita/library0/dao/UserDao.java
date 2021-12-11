package by.ita.library0.dao;

import by.ita.library0.bean.User;
import by.ita.library0.dao.exception.DAOException;

public interface UserDao {

	public User registerUser() throws DAOException;
	public User logination(String login, String password) throws DAOException;
	
}
