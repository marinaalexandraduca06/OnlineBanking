/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Marina
 */
public class Database {

    static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";

    static final String DB_USER = "SYSTEM";
    static final String DB_PASSWORD = "manaus123";

    public boolean checkAccount(String cnp, String password, int isConnected) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {

            conn = DatabaseHelper.getInstance().getConnection();
            String sql = "select * from client where cnp=? and password=? and isConnected=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cnp);
            pstmt.setString(2, password);
            pstmt.setInt(3, isConnected);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            if (pstmt != null) {
                pstmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return check;

    }

    public ArrayList<String> getAccount(String cnp) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<String> user = new ArrayList<String>();

        try {

            conn = DatabaseHelper.getInstance().getConnection();
            String sql = "select cnp,bankacount,firstname,lastname,password,amountofmoney from client where cnp=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cnp);
            rs = pstmt.executeQuery();
            user.add("User");

            while (rs.next()) {
                user.add(rs.getString(1));
                user.add(rs.getString("bankacount"));
                user.add(rs.getString("firstname"));
                user.add(rs.getString("lastname"));
                user.add(rs.getString("password"));
                user.add(rs.getString("amountofmoney"));
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            if (pstmt != null) {
                pstmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return user;

    }

    public ArrayList<String> getMoney(String cnp) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<String> user = new ArrayList<String>();

        try {

            conn = DatabaseHelper.getInstance().getConnection();
            String sql = "select amountofmoney from client where cnp=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cnp);
            rs = pstmt.executeQuery();
            user.add("User");

            while (rs.next()) {
                user.add(rs.getString(1));
                user.add(rs.getString("bankacount"));
                user.add(rs.getString("firstname"));
                user.add(rs.getString("lastname"));
                user.add(rs.getString("password"));
                user.add(rs.getString("amountofmoney"));
            }

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            if (pstmt != null) {
                pstmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return user;

    }

}
