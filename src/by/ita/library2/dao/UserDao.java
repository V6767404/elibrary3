package by.ita.library2.dao;

import by.ita.library2.bean.User;
import by.ita.library2.dao.exception.DAOException;

public interface UserDao {

	public boolean registerUser(User user) throws DAOException;

	public boolean logination(String login, int password) throws DAOException;

	public boolean changeToAdult(String name, String surname) throws DAOException;

}
