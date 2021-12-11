package by.ita.libraryV.controller;

import by.ita.libraryV.command.Command;
import by.ita.libraryV.command.impl.AddNewBook;
import by.ita.libraryV.command.impl.Logination;
import by.ita.libraryV.command.impl.Registration;

import java.util.HashMap;
import java.util.Map;

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
