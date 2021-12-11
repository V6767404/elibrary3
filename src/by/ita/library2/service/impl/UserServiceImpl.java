package by.ita.library2.service.impl;

import by.ita.library2.bean.User;
import by.ita.library2.dao.DAOFactory;
import by.ita.library2.dao.UserDao;
import by.ita.library2.dao.exception.DAOException;
import by.ita.library2.service.UserService;
import by.ita.library2.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public boolean logination(String login, int password) throws ServiceException {

		boolean res = false;

		if (login == null || login.isEmpty()) {
			throw new ServiceException("Incorrect login");
		}
		if (password == 0) {
			throw new ServiceException("Incorrect password");
		}
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDao userDAO = daoFactory.getUserDAO();
			res = userDAO.logination(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return res;

	}

	@Override
	public boolean registration(User user) throws ServiceException {

		boolean res = false;

		if (user.getName() == null || user.getName().isEmpty()) {
			throw new ServiceException("Incorrect name");
		}
		if (user.getSurname() == null || user.getSurname().isEmpty()) {
			throw new ServiceException("Incorrect surname");
		}
		if (user.getLogin() == null || user.getLogin().isEmpty()) {
			throw new ServiceException("Incorrect login");
		}
		if (user.getPassword() == 0) {
			throw new ServiceException("Incorrect password");
		}
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDao userDAO = daoFactory.getUserDAO();
			userDAO.registerUser(user);
			res = true;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return res;
	}

	@Override
	public boolean changeToAdult(String name, String surname) throws ServiceException {
		boolean res = false;

		if (name == null || name.isEmpty()) {
			throw new ServiceException("Incorrect name");
		}
		if (surname == null || surname.isEmpty()) {
			throw new ServiceException("Incorrect surname");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDao userDAO = daoFactory.getUserDAO();
			userDAO.changeToAdult(name, surname);
			res = true;

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return res;
	}
}
