package by.ita.libraryV.service;

import by.ita.libraryV.service.exception.ServiceException;

public interface UserService {
	void logination(String login, String password) throws ServiceException;
}
