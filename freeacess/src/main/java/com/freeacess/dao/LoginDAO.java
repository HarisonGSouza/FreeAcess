package com.freeacess.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	public HashMap<Boolean, Integer> verifyLogin(String username, String pass) {
		
		HashMap<Boolean, Integer> hm = new HashMap<Boolean, Integer>();
		Connection conn;
		Statement st;
		ResultSet rs;
	
		String query = "SELECT id FROM users WHERE user_name='" + username + "' AND password='" + pass + "';";
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query);
						
			if(rs.next()) {
				hm.put(true, rs.getInt("id"));
				return hm;
			} else {
				hm.put(false, 0);
				return hm;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hm;
	}
	
}
