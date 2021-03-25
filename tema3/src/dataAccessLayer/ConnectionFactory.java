package dataAccessLayer;

import java.sql.*;
//import java.util.logging.Logger;

/**
 * Clasa in care se face conexiunea in baza de date
 * 
 * @author laurg
 *
 */
public class ConnectionFactory {
	// private static final Logger LOGGER =
	// Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "com.mysql.jdbc.cj.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/warehouse";
	private static final String USER = "root";
	private static final String PASS = "root";

	// private static ConnectionFactory singleInstance=new ConnectionFactory();

	/**
	 * Metoda ce conecteaza la baza de date
	 */
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Are loc crearea conexiunii
	 * 
	 * @return Argument de tipul Connection
	 */
	public static Connection createConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DBURL, USER, PASS);
			if (conn == null) {
				System.out.println("Connect ERROR!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Are loc inchiderea conexiunii la baza de date
	 * 
	 * @param connection -conexiunea ce va fi inchisa
	 */
	public static void close(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Are loc inchiderea conexiunii la o instructiune SQL
	 * 
	 * @param statement -instructiunea ce va fi inchisa
	 */
	public static void close(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Are loc inchiderea conexiunii la un set de rezultate din baza de date
	 * 
	 * @param resultSet -setul de rezultate ce va fi inchisa
	 */
	public static void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
