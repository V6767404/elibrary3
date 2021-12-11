package by.ita.library2.service;

import by.ita.library2.service.impl.BookServiceImpl;
import by.ita.library2.service.impl.UserServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final UpdateLibraryService updateLiraryService = new BookServiceImpl();
	private final UserService userService = new UserServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public UpdateLibraryService getLibraryService() {
		return updateLiraryService;
	}

}
