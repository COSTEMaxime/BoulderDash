package model.cad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.ICAD;

public class JDBC implements ICAD {

	private Connection connexion;
	private Statement statement;

	public JDBC() {
		openConnexion();
	}

	private void openConnexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {

			String url = "jdbc:mysql://localhost/boulderdash?useSSL=false";
			String login = "root";
			String passwd = "";

			this.connexion = DriverManager.getConnection(url, login, passwd);
			this.statement = connexion.createStatement();

		} catch (SQLException e) {
			System.err.println("SQLException : " + e.getMessage());
		}
	}

	public void closeConnexion() {

		if (this.connexion != null)
			try {
				this.connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		if (this.statement != null)
			try {
				this.statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public ResultSet lireLigneBDD(String nomMap) {

		try {
			String request = "SELECT * FROM maps WHERE mapName LIKE '" + nomMap + "'";
			return statement.executeQuery(request);

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erreur lors de la lecture de la table");
			return null;
		}
	}

	@Override
	public LinkedList<Comparable> load(String nomMap) {
		
		@SuppressWarnings("rawtypes")
		LinkedList<Comparable> result = new LinkedList<Comparable>();

		ResultSet resultset = this.lireLigneBDD(nomMap);

		try {
			resultset.next();
			result.add(resultset.getInt(2));
			result.add(resultset.getInt(3));
			result.add(resultset.getString(4));
			result.set(2, ((String) result.get(2)).replaceAll("[\\r\\n]", ""));
			

		} catch (SQLException e) {
			System.err.println("La table " + nomMap + " n'a pas pu etre lue correctment");
			e.printStackTrace();
		}

		this.closeConnexion();
		return result;
	}
}
