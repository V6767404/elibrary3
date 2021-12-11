package by.ita.library1.controller;

import by.ita.library1.command.Command;
import by.ita.library1.command.exception.CommandException;
import by.ita.library1.command.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
	final private Map<String, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put("LOGIN", new Logination());
		commands.put("SIGNUP", new Registration());
		commands.put("ADDBOOK", new AddNewBook());
		commands.put("CHANGEROLE", new ChangeUserRole());
		commands.put("SHOWLIB", new ShowLibrary());
	}

	Command getCommand(String commandName) throws CommandException {
		Command command = commands.get(commandName);
		if (command == null) {
			throw new CommandException("Incorrect command name!");
		}
		return command;
	}

}
