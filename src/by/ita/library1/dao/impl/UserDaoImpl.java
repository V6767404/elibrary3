package by.ita.library1.dao.impl;

import by.ita.library1.bean.Role;
import by.ita.library1.bean.User;
import by.ita.library1.dao.UserDao;
import by.ita.library1.dao.exception.DAOException;

import java.io.*;

public class UserDaoImpl implements UserDao{
	
	private static final String USER_FILE_NAME = "users.txt";
	
	@Override
	public User registerUser(String login, String password) throws DAOException {
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			
			br = new BufferedReader(reader);
			
			// Читаем первую строку
			String line;
			line = br.readLine();
			
			// Проверяем нет ли уже пользователя с таким логином
			boolean found = false;
			String userLogin = null;
			while(line != null) {
				userLogin = line.split("\\s+")[0];
				if (userLogin.equals(login)) {
					found = true;
					break;
				}
				
				line = br.readLine();
			}
			
			if (found) {
				throw new DAOException("SuchUserAlreadyExists");
			}
			
			// Добавляем нового пользователя в базу
			FileWriter out = new FileWriter(USER_FILE_NAME, true);			
			BufferedWriter bw = new BufferedWriter(out);
			pw = new PrintWriter(bw);
			
			pw.println(login + " " + password + " " + "JUNIOR");
			
		} catch (FileNotFoundException e) {
			throw new DAOException("FileNotFound", e);
		} catch (IOException e) {
			throw new DAOException("IOError", e);
		} finally {
			// Закрываем потоки перед выходом из метода
			if (pw != null) {
				pw.close(); // Не бросает исключений, как ни странно
			}
			
			try {	
				if (br != null) {
					br.close();
				}
			} catch (IOException e1) {
				throw new DAOException("IOClosingError", e1);
			}
		}

		return new User(login, password);
	}

	@Override
	public User logination(String login, String password) throws DAOException {
		BufferedReader br = null;
		boolean found;
		String[] userParams;
		
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);			
			br = new BufferedReader(reader);
			
			// Читаем первую строку
			String line;			
			line = br.readLine();
			
			found = false;
			userParams = null;
			while(line != null) {
				userParams = line.split("\\s+");
				if (userParams[0].equals(login) && userParams[1].equals(password)) {
					found = true;
					break;
				}
				
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			throw new DAOException("FileNotFound", e);
		} catch (IOException e) {			
			throw new DAOException("IOError", e);
		} finally {
			// Закрываем поток перед выходом из метода
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e1) {
				throw new DAOException("IOClosingError", e1);
			}						
		}
		
		if (found && userParams != null) {
			return new User(login, password, Role.valueOf(userParams[2]));
		} else {
			throw new DAOException("UserNotFound");
		}
	}

	@Override
	public boolean changeUserRole(String login, Role newRole) throws DAOException {
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(USER_FILE_NAME, "rw");
			
			String line;					
			line = raf.readLine();
			
			String[] userParams = null;
			while(line != null) {
				userParams = line.split("\\s+");
				
				if (userParams[0].equals(login)) {							
					// Считываем текущую роль целевого пользователя
					Role currentRole;						
					currentRole = Role.valueOf(userParams[2]);
										
					if (!currentRole.equals(newRole)) {						
						// Возвращаем позицию чтения/записи назад на длину самой длинной (в строковом представлении) роли + \r\n
						raf.seek(raf.getFilePointer() - roleMaxLength() - 2);
						// Затираем старую запись пробелами (на случай, если новая будет короче)
						for (int i = 0; i < roleMaxLength(); i++) {
							raf.writeByte(' ');
						}
						// Снова возвращаемся и пишем новую запись
						raf.seek(raf.getFilePointer() - roleMaxLength());
						raf.writeBytes(newRole.toString());						
					}
					
					return true;
				}
				
				line = raf.readLine();
			}			
		} catch (FileNotFoundException e) {
			throw new DAOException("FileNotFound", e);
		} catch (IOException e) {
			throw new DAOException("IOError", e);
		} catch (IllegalArgumentException e) {
			throw new DAOException("UnrecognizableRole", e);
		} finally {
			// Закрываем поток перед выходом из метода
			try {
				if (raf != null) {
					raf.close();
				}
			} catch (IOException e1) {
				throw new DAOException("IOClosingError", e1);
			}
		}
		
		return false;
	}
	
	// Наибольшая длина роли как строки
	private static byte roleMaxLength() {
		byte maxLength = 0;
		for (Role role: Role.values()) {
			if (role.toString().length() > maxLength) {
				maxLength = (byte)role.toString().length();
			}
		}
		return maxLength;
	}
}
