package by.ita.library0.service.impl;

import by.ita.library0.dao.DAOFactory;
import by.ita.library0.dao.UserDao;
import by.ita.library0.dao.exception.DAOException;
import by.ita.library0.dao.impl.UserDaoImpl;
import by.ita.library0.service.UserService;
import by.ita.library0.service.exception.ServiceException;

public class UserServiceImpl implements UserService{

	@Override
	public void logination(String login, String password) throws ServiceException {
		// parameters validation
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDao userDAO = daoFactory.getUserDAO();
		
		/*
		 * UserDao userDAO = UserDaoImpl.getInstance(); try { userDAO.logination(login,
		 * password); } catch (DAOException e) { throw new ServiceException(e); }
		 */
		
	}

}
