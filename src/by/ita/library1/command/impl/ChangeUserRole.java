package by.ita.library1.command.impl;

import by.ita.library1.bean.Role;
import by.ita.library1.command.Command;
import by.ita.library1.command.exception.CommandException;
import by.ita.library1.service.ServiceFactory;
import by.ita.library1.service.exception.ServiceException;

public class ChangeUserRole implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String[] params = request.split("\\s+");
		Role accessRole = Role.JUNIOR;
		Role targetRole = Role.ADULT;
		String targetUserLogin;
		boolean success;
		
		try {
			accessRole = Role.valueOf(params[0]);
				
			if (!accessRole.equals(Role.ADULT)) {
				return params[0] + " This command can't be executed with your access!";
			}
					
			if (params.length > 2) {
				targetUserLogin = params[2];
			} else {
				throw new CommandException("There is no target user login!");
			}
		
			if (params.length > 3) {	
				targetRole = Role.valueOf(params[3]);
			}
				
			success = ServiceFactory.getInstance().getUserService().changeUserRole(targetUserLogin, targetRole);
			
		} catch (IllegalArgumentException e) {
			throw new CommandException("UnrecognizableRole", e);
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		
		if (success) {
			return params[0] + " The " + targetUserLogin + "'s role is set to the " + targetRole.toString();
		} else {
			return params[0] + " Such user doesn't exist!";
		}
	}

}
