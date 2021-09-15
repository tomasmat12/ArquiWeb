package Practico1Ej1;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.derby.jdbc.EmbeddedDriver;

public class BaseDeDatos {

	public static void main(String[] args) {
		
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			
			e.printStackTrace();
			System.exit(1);
		}
		
		String uri = "jdbc:derby:MyDerbyDb;create=true";
		
		try {
			Connection conn = DriverManager.getConnection(uri);
			createTables(conn);
			//addPerson(conn,1,"Juan",20);
			//addPerson(conn,2,"Paula",30);
			
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
	}

	private static void addPerson(Connection conn, int id, String name, int years) throws SQLException {
		String insert = "INSERT INTO persona (id,nombre,edad) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, years);
		ps.executeUpdate();
		ps.close();
		conn.commit();
	}

	private static void createTables(Connection conn) throws SQLException {
		String table = "CREATE TABLE persona (" +
		"id INT," +
		"nombre CARCHAR(500)," +
		"edad INT," +
		"PRIMARY KEY(id))";
		
		conn.prepareStatement(table).execute();
		conn.commit();
	}

}
