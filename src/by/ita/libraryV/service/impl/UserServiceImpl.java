package by.ita.libraryV.service.impl;

import by.ita.libraryV.dao.DAOFactory;
import by.ita.libraryV.dao.UserDao;
import by.ita.libraryV.service.UserService;
import by.ita.libraryV.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

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
