/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;

/**
 *
 * @author Marina
 */
public class Database {
    
    static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";

    static final String DB_USER = "SYSTEM";
    static final String DB_PASSWORD = "proiectpao";
    
    public boolean checkAccount(String cnp, String password, int isConnected) throws SQLException {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	boolean check = false;
	
        try {

            conn = DatabaseHelper.getInstance().getConnection();
            String sql = "select id from accounts where cnp=? and password=? and isConnected=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cnp);
            pstmt.setString(2, password);
            pstmt.setInt(3, isConnected);
            rs = pstmt.executeQuery();
	
            if (rs.next())
		check = true;

	} catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }finally {
            // finally block used to close resources
            if (pstmt != null)
		pstmt.close();
            if (rs != null)
		rs.close();
        }
	
        return check;
        
    }


}
