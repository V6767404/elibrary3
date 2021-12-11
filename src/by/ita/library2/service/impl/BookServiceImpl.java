package by.ita.library2.service.impl;

import by.ita.library2.bean.Book;
import by.ita.library2.dao.BookDao;
import by.ita.library2.dao.DAOFactory;
import by.ita.library2.dao.exception.DAOException;
import by.ita.library2.service.UpdateLibraryService;
import by.ita.library2.service.exception.ServiceException;

public class BookServiceImpl implements UpdateLibraryService {

	@Override
	public boolean addNewBook(Book book) throws ServiceException {
		boolean res = false;
		if (book.getName().isEmpty() || book.getName() == null) {
			throw new ServiceException("Incorrect name");
		}
		if (book.getAuthor().isEmpty() || book.getAuthor() == null) {
			throw new ServiceException("Incorrect author");
		}
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			BookDao bookDAO = daoFactory.getBookDAO();
			bookDAO.addBook(book);
			res = true;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return res;
	}

	@Override
	public boolean deleteBook(Book book) throws ServiceException {
		boolean res = false;
		if (book.getName().isEmpty() || book.getName() == null) {
			throw new ServiceException("Incorrect name");
		}
		if (book.getAuthor().isEmpty() || book.getAuthor() == null) {
			throw new ServiceException("Incorrect author");
		}
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			BookDao bookDAO = daoFactory.getBookDAO();
			bookDAO.deleteBook(book);
			res = true;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return res;
	}

}
