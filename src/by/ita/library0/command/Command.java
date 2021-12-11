package by.ita.library0.command;

import by.ita.library0.command.exception.CommandException;

public interface Command {

	String execute(String request) throws CommandException;
}
