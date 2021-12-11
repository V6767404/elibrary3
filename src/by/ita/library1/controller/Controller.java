package by.ita.library1.controller;

import by.ita.library1.command.Command;
import by.ita.library1.command.exception.CommandException;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(String request){
		String commandName = request.split("\\s+")[1];
		String response = request.split("\\s+")[0];
		
		try {
			Command command = provider.getCommand(commandName);
			response = command.execute(request);
		} catch (CommandException e) {
			System.out.println(e.getMessage());
			response += " Error occured, please try again after a while";
		}
		
		return response;
	}
}
