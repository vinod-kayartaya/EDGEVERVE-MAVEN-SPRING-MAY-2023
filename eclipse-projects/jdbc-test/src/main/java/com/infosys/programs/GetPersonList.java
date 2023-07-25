package com.infosys.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetPersonList {
	
	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:mysql://66.55.65.239:3306/infydb"; // change to your IP and DB name
		String username = "root";
		String password = "Welcome#123"; // change to your password
		String sql = "select * from persons";
		try(
				Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
		){
			while(rs.next()) {
				System.out.printf("id = %d, name = %s%n", rs.getInt(1), rs.getString(2));
			}
		}
	}

}
