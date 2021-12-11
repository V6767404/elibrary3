package by.ita.library1.service;

import by.ita.library1.bean.Role;
import by.ita.library1.bean.User;
import by.ita.library1.service.exception.ServiceException;

public interface UserService {
	User logination(String login, String password) throws ServiceException;
	User registerUser(String login, String password) throws ServiceException;
	boolean changeUserRole(String login, Role newRole) throws ServiceException;
}
