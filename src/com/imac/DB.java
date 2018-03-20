package com.imac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

	private Connection con;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/java";
	private String user = "root";
	private String psw = "334794";

	public DB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, psw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isLogin(String username, String password) {
		boolean result = false;
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from client where username = ? and password = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void signup(Client c) {
		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into client(username,password,gender,age,wechat) values(?,?,?,?,?)");
			pstmt.setString(1, c.getUsername());
			pstmt.setString(2, c.getPassword());
			pstmt.setString(3, c.getGender());
			pstmt.setString(4, c.getAge());
			pstmt.setString(5, c.getWechat());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
