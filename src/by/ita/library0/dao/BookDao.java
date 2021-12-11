package by.ita.library0.dao;

import by.ita.library0.bean.Book;
import by.ita.library0.dao.exception.DAOException;

public interface BookDao {
	
	public void addBook(Book book) throws DAOException;

}
