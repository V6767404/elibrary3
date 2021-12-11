package by.ita.library2.command;

import by.ita.library2.command.exception.CommandException;

public interface Command {

	String execute(String request) throws CommandException;
}
