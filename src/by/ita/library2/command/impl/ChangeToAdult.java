package by.ita.library2.command.impl;

import by.ita.library2.command.Command;
import by.ita.library2.command.exception.CommandException;
import by.ita.library2.service.ServiceFactory;
import by.ita.library2.service.UserService;
import by.ita.library2.service.exception.ServiceException;

public class ChangeToAdult implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String response;

		String[] mas = request.split("\\s+");
		try {
			String name = mas[1];
			String surname = mas[2];

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userservice = serviceFactory.getUserService();

			boolean res = userservice.changeToAdult(name, surname);

			if (res) {
				response = "The change was successfully completed.";
			} else {
				response = "The change was not completed.";
			}
		} catch (ServiceException | ArrayIndexOutOfBoundsException e) {
			response = "Error duiring procedure.";
		}

		return response;
	}

}
