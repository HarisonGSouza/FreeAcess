package com.freeacess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.freeacess.entity.Employer;

public class EmployerDAO {

	public boolean create(Employer employer) {

		Connection conn;
		PreparedStatement pst;
		int result = 0;
		String query = "INSERT INTO employer (id,full_name,date_birth,cell_phone,cpf,rg,adress,email,user_id) VALUES (?,?,?,?,?,?,?,?,?);";

		try {
			conn = DB.getConnection();
			pst = conn.prepareStatement(query);
			pst.setInt(1, employer.getId());
			pst.setString(2, employer.getFullName());
			pst.setString(3, employer.getDateBirth());
			pst.setLong(4, employer.getCellPhone());
			pst.setString(5, employer.getCpf());
			pst.setString(6, employer.getRg());
			pst.setString(7, employer.getAdress());
			pst.setString(8, employer.getEmail());
			pst.setInt(9, employer.getUserId());

			// if(employer.getTel() == null)
			// pst.setArray(3, null);
			// else {
			// java.sql.Array phones = conn.createArrayOf("VARCHAR",
			// employer.getTel().toArray());
			// pst.setArray(3, phones);
			// }

			System.out.println(pst);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			showSQLException(e);
		}

		return result == 0 ? false : true;
	}

	public Employer getEmployer(int id) {

        Connection conn;
        Statement st;
        ResultSet rs = null;

        String query = "SELECT * FROM employer WHERE id = " + id + ";";

		Employer employer = new Employer();

        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);

			if (rs.next()) {
				employer.setId(rs.getInt("id"));
				employer.setFullName(rs.getString("full_name"));
				employer.setDateBirth(rs.getString("date_birth"));
				employer.setCellPhone(rs.getLong("cell_phone"));
				employer.setCpf(rs.getString("cpf"));
				employer.setRg(rs.getString("rg"));
				employer.setAdress(rs.getString("adress"));
				employer.setEmail(rs.getString("email"));
				employer.setUserId(rs.getInt("user_id"));
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return employer;
    }

	private void showSQLException(SQLException e) {
		String message = e.getErrorCode() + "\n" + e.getMessage() + "\n" + e.getLocalizedMessage() + "\n"
				+ e.getCause();
		JOptionPane.showMessageDialog(null, message);
	}
}