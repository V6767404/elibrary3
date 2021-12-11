package by.ita.library2.command.impl;

import by.ita.library2.command.Command;
import by.ita.library2.command.exception.CommandException;
import by.ita.library2.service.ServiceFactory;
import by.ita.library2.service.UserService;
import by.ita.library2.service.exception.ServiceException;

public class Logination implements Command {

	@Override
	public String execute(String request) throws CommandException {

		String response;

		String[] mas = request.split("\\s+");

		String login = mas[1];
		int password = Integer.valueOf(mas[2]);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userservice = serviceFactory.getUserService();

		try {
			boolean res = userservice.logination(login, password);
			if (res) {
				response = "Logination was successfully completed.";
			} else {
				response = "The user is not found";
			}

		} catch (ServiceException e) {
			response = "Error duiring login procedure.";
		}

		return response;
	}

}
