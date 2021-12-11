package by.ita.library2.command.impl;

import by.ita.library2.bean.User;
import by.ita.library2.command.Command;
import by.ita.library2.command.exception.CommandException;
import by.ita.library2.service.ServiceFactory;
import by.ita.library2.service.UserService;
import by.ita.library2.service.exception.ServiceException;

public class Registration implements Command {

	@Override
	public String execute(String request) throws CommandException {

		String response;

		String[] mas = request.split("\\s+");
		try {
			String name = mas[1];
			String surname = mas[2];
			boolean adult = Boolean.valueOf(mas[3]);
			String login = mas[4];
			int password = Integer.valueOf(mas[5]);

			User user = new User(name, surname, adult, login, password);

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userservice = serviceFactory.getUserService();

			if (userservice.registration(user)) {
				response = "Registration was successfully completed.";
			} else
				response = "Registration was not completed.";
		} catch (ServiceException | ArrayIndexOutOfBoundsException e) {
			response = "Error duiring registration";
		}

		return response;
	}

}
