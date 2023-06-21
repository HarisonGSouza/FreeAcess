package com.freeacess.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VideosPathDAO {

    List<String> array_paths = new ArrayList<String>();

    public List<String> getPathVideosFromDB(String course) {

        Connection conn;
        Statement st;
        ResultSet rs = null;

        String query = "SELECT path FROM videospath WHERE course_name = '" + course  + "' ORDER BY id DESC;";

        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while(rs.next()) {
                array_paths.add(rs.getString("path"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return array_paths;
    }
}
