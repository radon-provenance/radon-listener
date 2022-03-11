/* Copyright 2022

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/

package org.radon.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.radon.listener.RadonApp;

public class DBConn {
    
    private static Logger logger = LogManager.getLogger(RadonApp.class);
    private String db_path;


    public DBConn(Logger logger, String db_path) {
        super();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.db_path = db_path;
    }

    private Connection connectDB(String filename) {
        String url = "jdbc:sqlite:" + filename;
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return conn;
    }
    
    
    private Connection connect() {
        return connectDB(this.db_path);
    }
    
    
    private void create_tables() {
        Connection conn = connect();
        String sql = "CREATE TABLE IF NOT EXISTS scripts (\n"
              + " path text PRIMARY KEY,\n"
              + " script text NOT NULL\n"
              + ");";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
    
    
    public void insert(String path, String script) {
        String sql = "INSERT INTO scripts(path, script) VALUES(?, ?)";

        Connection conn = connect();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, path);
            pstmt.setString(2, script);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
    
    
    public void selectAll() {
        String sql = "SELECT path, script FROM scripts";
        
        Connection conn = connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                System.out.println(rs.getString("path") +  "\t" + 
                                   rs.getString("script") + "\t" );
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

}
