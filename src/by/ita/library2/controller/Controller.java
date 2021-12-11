package by.ita.library2.controller;

import by.ita.library2.command.Command;
import by.ita.library2.command.exception.CommandException;

public class Controller {
	private final CommandProvider provider = new CommandProvider();

	public String doAction(String request) {
		String commandName;
		String[] mas = request.split("\\s+");
		commandName = mas[0];
		commandName = commandName.toUpperCase();

		String response;
		try {
			Command command = provider.getCommand(commandName);
			response = command.execute(request);
		} catch (CommandException | NullPointerException e) {
			response = "Error";
		}
		return response;

	}
}
