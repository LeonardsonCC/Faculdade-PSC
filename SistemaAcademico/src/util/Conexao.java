package util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection conn() {
		Connection c = null;
		try {
			File f = new File("database/uc_programacao.sqlite");
			if (f.exists()) {
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:database/uc_programacao.sqlite");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
}
