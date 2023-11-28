package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDManejo {
private Connection conn = null; 
	

	public void connect(String dbPath) throws BDExcepcion {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
		} catch (ClassNotFoundException e) {
			throw new BDExcepcion("Error cargando el driver de la BD", e);
		} catch (SQLException e) {
			throw new BDExcepcion("Error conectando a la BD", e);
		}
	}
	
	public void disconnect() throws BDExcepcion {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new BDExcepcion("Error cerrando la conexión con la BD", e);
		}
	}

}
