package com.infosys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import lombok.Setter;
import lombok.SneakyThrows;

@Setter
public class JdbcProductDao implements ProductDao {

	// dependencies
	private String driverClassName;
	private String url;
	private String user;
	private String password;

	// an interface representing a connection pool
	private DataSource dataSource;

	@SneakyThrows // converts all checked exceptions being thrown from this function into
					// unchecked exception
	private Connection createConnection() {

		if (dataSource != null) {
			return dataSource.getConnection();
		}

		Class.forName(driverClassName);
		return DriverManager.getConnection(url, user, password);
	}

	@Override
	public int count() throws DaoException {
		String sql = "select count(*) from products";
		try (Connection conn = this.createConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			rs.next();
			return rs.getInt(1);
		} // rs.close(), stmt.close() and conn.close() are automatically called here
		catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
