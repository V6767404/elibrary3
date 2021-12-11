package by.ita.library1.dao;

import by.ita.library1.bean.Book;
import by.ita.library1.bean.Role;
import by.ita.library1.dao.exception.DAOException;

import java.util.List;

public interface BookDao {	
	public void add(Book book) throws DAOException;
	public List<Book> allLibrary(Role access) throws DAOException;
}
