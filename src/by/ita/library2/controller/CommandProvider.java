package by.ita.library2.controller;

import by.ita.library2.command.Command;
import by.ita.library2.command.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
	final private Map<String, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put("LOGINATION", new Logination());
		commands.put("REGISTRATION", new Registration());
		commands.put("ADD_NEW_BOOK", new AddNewBook());
		commands.put("DELETE_BOOK", new DeleteBook());
		commands.put("DELETE_BOOK", new DeleteBook());
		commands.put("CHANGE_TO_ADULT", new ChangeToAdult());
	}

	Command getCommand(String commandName) {

		Command command = commands.get(commandName);
		return command;
	}
}
