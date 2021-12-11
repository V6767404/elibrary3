package by.ita.libraryV.dao;

import by.ita.libraryV.bean.User;
import by.ita.libraryV.dao.exception.DAOException;

public interface UserDao {

	public User registerUser() throws DAOException;
	public User logination(String login, String password) throws DAOException;
	
}
