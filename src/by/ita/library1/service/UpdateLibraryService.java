package by.ita.library1.service;

import by.ita.library1.bean.Book;
import by.ita.library1.bean.Role;
import by.ita.library1.service.exception.ServiceException;

import java.util.List;

public interface UpdateLibraryService {
	void addNewBook(String title, int price, Role access) throws ServiceException;
	List<Book> showLibrary(Role access) throws ServiceException;
}
