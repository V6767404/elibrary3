package by.ita.library2.service;

import by.ita.library2.bean.User;
import by.ita.library2.service.exception.ServiceException;

public interface UserService {
	boolean logination(String login, int password) throws ServiceException;

	boolean registration(User user) throws ServiceException;

	boolean changeToAdult(String name, String surname) throws ServiceException;
}
