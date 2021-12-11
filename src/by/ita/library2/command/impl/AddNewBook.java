package by.ita.library2.command.impl;

import by.ita.library2.bean.Book;
import by.ita.library2.command.Command;
import by.ita.library2.command.exception.CommandException;
import by.ita.library2.service.ServiceFactory;
import by.ita.library2.service.UpdateLibraryService;
import by.ita.library2.service.exception.ServiceException;

public class AddNewBook implements Command {

	@Override
	public String execute(String request) throws CommandException {

		String response;

		String[] mas = request.split("\\s+");
		try {
			String name = mas[1];
			String author = mas[2];
			int year = Integer.valueOf(mas[3]);
			boolean onlyForAdults = Boolean.valueOf(mas[4]);

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UpdateLibraryService bookservice = serviceFactory.getLibraryService();

			Book book = new Book(name, author, year, onlyForAdults);
			boolean res = bookservice.addNewBook(book);
			if (res) {
				response = "The book was added";
			} else {
				response = "The book wasn't added";
			}
		} catch (ServiceException | ArrayIndexOutOfBoundsException e) {
			response = "Error duiring procedure.";
		}

		return response;
	}

}
