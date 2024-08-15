//package com.trungtamjava.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class JDBCConnection {
//	public Connection getConnection() {
//		final String username = "root";
//		final String password = "123456789";
//		final String url = "jdbc:mysql://localhost:3306/javaweb20";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			return DriverManager.getConnection(url, username, password);
//		} catch (Exception e) {
//			System.out.println("Ket noi failed " + e);
//		}
//		
//		return null; 
//	}
//	
//	public static void main(String[] args) {
//		JDBCConnection jdbc = new JDBCConnection();
//		Connection conn = jdbc.getConnection();
//		if (conn == null) {
//			System.out.println("THAT BAI");
//		} else {
//			System.out.println("THANH CONG");
//		}
//	}
//}
