package by.ita.library2.service;

import by.ita.library2.bean.Book;
import by.ita.library2.service.exception.ServiceException;

public interface UpdateLibraryService {
	public boolean addNewBook(Book book) throws ServiceException;

	public boolean deleteBook(Book book) throws ServiceException;
}
