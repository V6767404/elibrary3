package by.ita.library1.command;

import by.ita.library1.command.exception.CommandException;

public interface Command {
	String execute(String request) throws CommandException;
}
