package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import canciones.Cancion;
import canciones.Usuario;

public class BDCanciones {
	
	private Connection conn = null; 


	public void connect(String dbPath) throws BDExcepcion {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
		} catch (ClassNotFoundException e) {
			throw new BDExcepcion("Error cargando el driver de la BD de canciones", e);
		} catch (SQLException e) {
			throw new BDExcepcion("Error conectando a la BD de canciones", e);
		}
	}

	public void disconnect() throws BDExcepcion {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new BDExcepcion("Error cerrando la conexión con la BD de canciones", e);
		}
	}
	
	
	@SuppressWarnings("static-access")
	public List<Cancion> getAllUsers() throws BDExcepcion {
		List<Cancion> Canc = new ArrayList<Cancion>();
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, name, surname, birthdate FROM user");

			while(rs.next()) {
				Cancion can = new Cancion();
				can.setId(rs.getInt("id"));
				can.setNombre_Ar(rs.getString("Artista"));
				can.setName_can(rs.getString("Cancion"));
				can.setDuration(rs.getInt("Duracion"));
				can.setAlbum(rs.getString("Album"));
				Canc.add(can);
			}
			
			return Canc;
		} catch (SQLException | DateTimeParseException e) {
			throw new BDExcepcion("Error obteniendo todos los usuarios'", e);
		}
	}


	@SuppressWarnings("static-access")
	public void guardar(Cancion c) throws BDExcepcion {
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (name, surname, birthdate) VALUES (?, ?, ?)");
				Statement stmtForId = conn.createStatement()) {
			stmt.setString(1, c.getNombre_Ar());
			stmt.setString(2, c.getName_can());
			stmt.setInt(3, c.getDuration());
			stmt.setString(4, c.getAlbum());

			stmt.executeUpdate();

			//obtiene el id que se acaba de autogenerar
			ResultSet rs = stmtForId.executeQuery("SELECT last_insert_rowid() AS id FROM user");
			if (rs.next()) {
				int newId = rs.getInt("id");
				c.setId(newId);
			} else {
				throw new BDExcepcion("Error generando el id autoincremental");
			}
		} catch (SQLException e) {
			throw new BDExcepcion("No se pudo guardar el usuario en la BD", e);
		}
	}

	public void eliminar(Usuario user) throws BDExcepcion {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE id=?")) {
			stmt.setInt(1, user.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new BDExcepcion("No se pudo elimiar el usuario con id " + user.getId(), e);
		}
	}

	public void CrearTablaUsu() throws BDExcepcion {
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, surname VARCHAR, birthdate VARCHAR)");
		} catch (SQLException e) {
			throw new BDExcepcion("Error creando la tabla 'user' en la BD", e);
		}
	}


	public void EliminarTablaUsu() throws BDExcepcion {
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("DROP TABLE IF EXISTS user");
		} catch (SQLException e) {
			throw new BDExcepcion("Error borrando la tabla 'user' en la BD", e);
		}
	}
}
