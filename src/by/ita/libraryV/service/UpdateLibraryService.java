package by.ita.libraryV.service;

import by.ita.libraryV.service.exception.ServiceException;

public interface UpdateLibraryService {
	void addNewBook(String title, int price) throws ServiceException;
}
