package by.ita.libraryV.dao.impl;

import by.ita.libraryV.bean.User;
import by.ita.libraryV.dao.UserDao;
import by.ita.libraryV.dao.exception.DAOException;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class UserDaoImpl implements UserDao {
	
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
