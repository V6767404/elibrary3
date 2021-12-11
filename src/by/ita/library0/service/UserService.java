package by.ita.library0.service;

import by.ita.library0.service.exception.ServiceException;

public interface UserService {
	void logination(String login, String password) throws ServiceException;
}
