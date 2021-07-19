/*
 *  Company: RS
 *  Project: hibernate-tutorial
 *  Created: 19 lip 2021  12:22:56
 *  Author:  RS 		
 */
package pl.rsof.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <p></p><p>19 lip 2021</p>
 * @author RS
 *
 */
public class TestJdbc {

	
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbtest";
		String pass = "hbtest";
		try {
			System.out.println("Test connection to MySQL");
			
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connected to MySQL");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
