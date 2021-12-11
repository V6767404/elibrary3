package by.ita.library1.dao;

import by.ita.library1.bean.Role;
import by.ita.library1.bean.User;
import by.ita.library1.dao.exception.DAOException;

public interface UserDao {
	public User registerUser(String login, String password) throws DAOException;
	public User logination(String login, String password) throws DAOException;
	public boolean changeUserRole(String login, Role newRole) throws DAOException;
}
