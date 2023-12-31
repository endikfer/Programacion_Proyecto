package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import canciones.Usuario;

public class BDManejoUsu {
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


	public List<Usuario> getTodosUsu() throws BDExcepcion {
		List<Usuario> users = new ArrayList<Usuario>();
		
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT nombre, gmail, nombre_usu, contraseña from usuario");

			while(rs.next()) {
				Usuario user = new Usuario();
				user.setName_real(rs.getString("Nombre"));
				user.setGmail(rs.getString("Gmail"));
				user.setName_us(rs.getString("Nombre_usu"));
				user.setPassword(rs.getString("Contraseña"));
				users.add(user);
			}

			return users;
		} catch (SQLException e) {
			throw new BDExcepcion("Error obteniendo todos los usuarios'", e);
		}
	}


	public Usuario getUser(String nom) throws BDExcepcion {
		try (PreparedStatement stmt = conn.prepareStatement("SELECT nombre, gmail, nombre_usu, contraseña FROM usuario WHERE nombre_usu = ?")) {
			stmt.setString(1, nom);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Usuario user = new Usuario();
				user.setName_real(rs.getString("Nombre"));
				user.setGmail(rs.getString("Gmail"));
				user.setName_us(rs.getString("Nombre_usu"));
				user.setPassword(rs.getString("Contraseña"));
				return user;
			} else {
				return new Usuario();
			}
		} catch (SQLException e) {
			throw new BDExcepcion("Error obteniendo el usuario con nombre " + nom, e);
		}
	}


	public void guardar(Usuario user) throws BDExcepcion {
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO usuario (nombre, gmail, nombre_usu, contraseña) VALUES (?, ?, ?, ?)");
				Statement stmtForId = conn.createStatement()) {
			stmt.setString(1, user.getName_real());
			stmt.setString(2, user.getGmail());
			stmt.setString(3, user.getName_us());
			stmt.setString(4, user.getPassword()); 
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new BDExcepcion("No se pudo guardar el usuario en la BD", e);
		}
	}

	
	public void eliminar(Usuario user) throws BDExcepcion {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuario WHERE nombre_usu=?")) {
			stmt.setString(1, user.getName_us());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new BDExcepcion("No se pudo elimiar el usuario con nombre_usu " + user.getName_us(), e);
		}
	}

	public void CrearTablaUsu() throws BDExcepcion {
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS usuario (nombre_usu VARCHAR PRIMARY KEY, nombre VARCHAR, gmail VARCHAR, contraseña VARCHAR)");
		} catch (SQLException e) {
			throw new BDExcepcion("Error creando la tabla 'usuario' en la BD", e);
		}
	}


	public void EliminarTablaUsu() throws BDExcepcion {
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("DROP TABLE IF EXISTS usuario");
		} catch (SQLException e) {
			throw new BDExcepcion("Error borrando la tabla 'usuario' en la BD", e);
		}
	}
	
	private static void actualizarDB(String str) {
		//TODO
		/**
		 * Este método cargará el arraylist de usuarios en la base de datos de usuarios
		 * para mantenerla actualizada.
		 */
		String sql = String.format("INSERT INTO usuarios VALUES ('%s', '%s', %s, '%s')", "txtNomRealR.getText(), txtMailR.getText(), txtNomR.getText(), passConR.getText()");
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" +"lib/Usuarios.db");
			
			Statement stm = conn.createStatement();
			int rows = stm.executeUpdate(sql);
			
			stm.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void cargarUsuarios(ArrayList<Usuario> usuarios, String dbPath){
		//TODO
		/**
		 * Este método lee de una base de datos, y carga los usuarios almacenados en ella en
		 * un arraylist que es con lo que trabaja luego la ventana.
		 */
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" +"lib/Usuarios.db");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT nombre, gmail, nombre_usu, contraseña FROM usuario WHERE nombre_usu = ?");
			
			while(rs.next()) {
				String nombre = rs.getString("nombre_usu");
				String nombreReal = rs.getString("nombre");
				String mail = rs.getString("gamil");
				String password = rs.getString("contraseña");
				
				Usuario us = new Usuario(nombre, nombreReal, password, mail);
				usuarios.add(us);
			}
			
			rs.close();
			stm.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
