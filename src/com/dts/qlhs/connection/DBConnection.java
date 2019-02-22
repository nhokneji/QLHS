
package com.dts.qlhs.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    Connection conn = null;
    Statement stmt = null;
    
    private static DBConnection Instance = null;
    
    public static DBConnection getInstence() {
    	if(Instance == null) {
    		Instance = new DBConnection();
    	}
    	return Instance;
    }
    
    private DBConnection() {
        try {  
            //driver
            Class.forName("com.mysql.jdbc.Driver");
            //Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsv","root", "");
            System.out.println("Connected");
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }catch (Exception ex) {
        	ex.printStackTrace(); 
        }
        
    }



    
  //get info from xml
//    private DBConnection(String URL, String userName, String password){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(URL, userName, password);
//            System.out.println("Connected");
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
    
    public Connection getConnection(){
        return conn;
    }
    
//    private static void main(String[] args) {
//        new DBConnection();
//    }
//    
//    public ResultSet getData(String sql) {
//    	try {
//			stmt = conn.createStatement();
//			return stmt.executeQuery(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	return null;
//    }
//    
//    public boolean updateData(String sql) {
//    	try {
//			stmt = conn.createStatement();
//			return stmt.executeUpdate(sql) > 0 ? true:false;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	return false;
//    }
}
