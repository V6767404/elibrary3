package by.ita.libraryV.dao;

import by.ita.libraryV.bean.Book;
import by.ita.libraryV.dao.exception.DAOException;

public interface BookDao {
	
	public void addBook(Book book) throws DAOException;

}
