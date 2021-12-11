package by.ita.libraryV.controller;

import by.ita.libraryV.command.Command;
import by.ita.libraryV.command.exception.CommandException;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	
	
	public String doAction(String request){
		String commandName;
		
		// parse request and get command name
		/* stub */ commandName = "LOGINATION";
		
		String response;
		try {
			Command command = provider.getCommand(commandName);
			response = command.execute(request);
		} catch (CommandException e) {
			// loggin
			// response with error massage is formed
			/* stub */response = "error";
		}
		
		return response;
		
	}
}
