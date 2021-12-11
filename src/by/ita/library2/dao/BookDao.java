package by.ita.library2.dao;

import by.ita.library2.bean.Book;
import by.ita.library2.dao.exception.DAOException;

public interface BookDao {

	public boolean addBook(Book book) throws DAOException;

	public boolean deleteBook(Book book) throws DAOException;

}
