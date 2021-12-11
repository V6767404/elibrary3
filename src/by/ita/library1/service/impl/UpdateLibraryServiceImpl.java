package by.ita.library1.service.impl;

import by.ita.library1.bean.Book;
import by.ita.library1.bean.Role;
import by.ita.library1.dao.DAOFactory;
import by.ita.library1.dao.exception.DAOException;
import by.ita.library1.service.UpdateLibraryService;
import by.ita.library1.service.exception.ServiceException;

import java.util.List;

public class UpdateLibraryServiceImpl implements UpdateLibraryService {

	@Override
	public void addNewBook(String title, int price, Role access) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		
		try {
			daoFactory.getBookDAO().add(new Book(title, price, access));
		} catch (DAOException e) {
			throw new ServiceException(e);
		}	
	}

	@Override
	public List<Book> showLibrary(Role access) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		List<Book> books;
		
		try {
			books = daoFactory.getBookDAO().allLibrary(access);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return books;
	}

}
