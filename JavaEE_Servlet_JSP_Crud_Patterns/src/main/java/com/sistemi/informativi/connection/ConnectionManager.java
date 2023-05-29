package com.sistemi.informativi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager implements DbParameters {

	/* quattro metodi che implementano */

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(dbDriver);
		Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		return connection;
		/* apertura di una connessione e restituizione della stessa */
	}

	public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
		return ps;
		/*
		 * inizializza di una variabile di tipo prepared Statement che ha come parametro
		 * un valore String generico e ritorna un oggetto PreparedStatement che potrà
		 * essere usato in base allo script sql che gli verrà mostrato in input
		 */
	}

	public static ResultSet getResultSet(String sql) throws SQLException, ClassNotFoundException {
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
		/*
		 * istanzia di tipo Statement su cui verrà eseguita la query. Da cui risultato
		 * sarà creato un'istanza di ResultSet
		 */
	}

	/* questo metodo chiude la connesione */
	public static void closeConnection() throws SQLException, ClassNotFoundException {
		ConnectionManager.getConnection().close();
	}

}
