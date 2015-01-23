package fr.afcepf.al22.gestionpersonne.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.rmi.CORBA.Util;
import javax.sql.DataSource;

public class UtilCnxAl22 implements DataSource{
	private static String url;
	private static String login;
	private static String mdp;
	private static String driver;
	static {
		ResourceBundle rb =
			ResourceBundle.getBundle(
			"fr.afcepf.al22.gestionpersonne.resources.dbal22");
		url = rb.getString("url");
		login = rb.getString("login");
		driver = rb.getString("driver");
		mdp = rb.getString("mdp");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Connection getConnection() throws SQLException {
		Connection cnx = null;
		cnx = DriverManager.getConnection(
				UtilCnxAl22.url,
				UtilCnxAl22.login,
				UtilCnxAl22.mdp);
		return cnx;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
