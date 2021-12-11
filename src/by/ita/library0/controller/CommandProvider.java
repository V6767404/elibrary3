package by.ita.library0.controller;

import java.util.HashMap;
import java.util.Map;

import by.ita.library0.command.Command;
import by.ita.library0.command.impl.AddNewBook;
import by.ita.library0.command.impl.Logination;
import by.ita.library0.command.impl.Registration;

final class CommandProvider {
	final private Map<String, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put("LOGINATION", new Logination());
		commands.put("REGISTRATION", new Registration());
		commands.put("ADD_NEW_BOOK", new AddNewBook());
	}

	Command getCommand(String commandName) {
		Command command = commands.get(commandName);
		return command;
	}

}
