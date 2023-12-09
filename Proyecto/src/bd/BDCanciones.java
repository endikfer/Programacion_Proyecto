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
	public List<Cancion> getAllCanciones() throws BDExcepcion {
		List<Cancion> Canc = new ArrayList<Cancion>();
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, name, surname, birthdate FROM user");

			while(rs.next()) {
				Cancion can = new Cancion();
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
	public Cancion getCancion(String nom) throws BDExcepcion {
		try (PreparedStatement stmt = conn.prepareStatement("SELECT nombre, nombre_Ar, duration, album FROM usuario WHERE nombre_usu = ?")) {
			stmt.setString(1, nom);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Cancion can = new Cancion();
				can.setName_can(rs.getString("Nombre"));
				can.setNombre_Ar(rs.getString("Nombre_Ar"));
				can.setDuration(rs.getInt("Duracion"));
				can.setAlbum(rs.getString("Album"));
				return can;
			} else {
				return new Cancion();
			}
		} catch (SQLException e) {
			throw new BDExcepcion("Error obteniendo el usuario con nombre " + nom, e);
		}
	}


	@SuppressWarnings("static-access")
	public void guardarCan(Cancion c) throws BDExcepcion {
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO Cancion (Nombre, Nombre_Ar, Duracion, Album) VALUES (?, ?, ?, ?)");
				Statement stmtForId = conn.createStatement()) {
			stmt.setString(1, c.getNombre_Ar());
			stmt.setString(2, c.getName_can());
			stmt.setInt(3, c.getDuration());
			stmt.setString(4, c.getAlbum());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new BDExcepcion("No se pudo guardar el usuario en la BD", e);
		}
	}

	public void eliminarCan(Cancion can) throws BDExcepcion {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE id=?")) {
			stmt.setString(1, can.getName_can());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new BDExcepcion("No se pudo elimiar el usuario con nombre_usu " + can.getName_can(), e);
		}
	}

	public void CrearTablaCanc() throws BDExcepcion {
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Canc (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, Name_Ar VARCHAR, Duration INT, Album VARCHAR)");
		} catch (SQLException e) {
			throw new BDExcepcion("Error creando la tabla 'canc' en la BD", e);
		}
	}


	public void EliminarTablaCanc() throws BDExcepcion {
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("DROP TABLE IF EXISTS Canc");
		} catch (SQLException e) {
			throw new BDExcepcion("Error borrando la tabla 'canc' en la BD", e);
		}
	}
}
