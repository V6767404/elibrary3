package by.ita.library0.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;

import by.ita.library0.bean.User;
import by.ita.library0.dao.UserDao;
import by.ita.library0.dao.exception.DAOException;

public class UserDaoImpl implements UserDao{
	
	@Override
	public User registerUser() throws DAOException {
		// stub
		return new User();
	}

	@Override
	public User logination(String login, String password) throws DAOException {
		try {
			FileReader reader = new FileReader("user.txt");
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		}
		return new User();
	}
	
	

}
