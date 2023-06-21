package com.freeacess.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TablesDbDAO {

    public ResultSet getLastRegister(String table_name) {

        Connection conn;
        Statement st;
        ResultSet rs = null;

        String query = "SELECT * FROM " + table_name + " ORDER BY id DESC LIMIT 1;";

        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            return rs;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    public int getLastIdFrom(String table_name) {
        ResultSet obj = this.getLastRegister(table_name);
        int id = 0;
        try {
            if (obj.next()) {
                id = obj.getInt("id");
                return id;
            } else {
                id = 0;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return id;
    }

}