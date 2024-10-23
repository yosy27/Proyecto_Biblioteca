package pe.com.cibertec.Proyecto_biblioteca.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Utilitarios {
	public static String extraerHash(String passwordTextoPlano) {
		return BCrypt.hashpw(passwordTextoPlano, BCrypt.gensalt());
	}
	
	public static boolean checkPassword(String passwordInput, String hashPassword) {
		return BCrypt.checkpw(passwordInput, hashPassword);
	}

}
