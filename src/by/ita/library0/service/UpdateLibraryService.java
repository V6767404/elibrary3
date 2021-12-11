package by.ita.library0.service;

import by.ita.library0.service.exception.ServiceException;

public interface UpdateLibraryService {
	void addNewBook(String title, int price) throws ServiceException;
}
