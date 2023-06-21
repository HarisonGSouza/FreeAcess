package com.freeacess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.swing.JOptionPane;

import com.freeacess.entity.User;

public class UserDAO {

    public boolean create(User user) {

        Connection conn;
        PreparedStatement pst;
        int result = 0;
        String query = "INSERT INTO users (id,user_name,password) VALUES (?,?,?);";

        try {
            conn = DB.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, user.getId());
            pst.setString(2, user.getUserName());
            pst.setString(3, user.getPassword());

            // if(employer.getTel() == null)s
            // pst.setArray(3, null);
            // else {
            // java.sql.Array phones = conn.createArrayOf("VARCHAR",
            // employer.getTel().toArray());
            // pst.setArray(3, phones);
            // }

            System.out.println(pst);

            result = pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: UserDAO.create() / Erro na hora de salvar usuário no banco de dados.");
            showSQLException(e);
        }

        return result == 0 ? false : true;
    }

    private void showSQLException(SQLException e) {
        String message = e.getErrorCode() + "\n" + e.getMessage() + "\n" + e.getLocalizedMessage() + "\n"
                + e.getCause();
        JOptionPane.showMessageDialog(null, message);
    }
}