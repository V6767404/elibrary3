package by.ita.libraryV.command;

import by.ita.libraryV.command.exception.CommandException;

public interface Command {

	String execute(String request) throws CommandException;
}
