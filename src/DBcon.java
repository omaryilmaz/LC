



//2


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBcon {
 
	
	static Connection conn ;  
    public static  Connection connect()   {  
        
        try {  
        	Class.forName("org.sqlite.JDBC");

          // create a connection to the database  
              conn = DriverManager.getConnection("jdbc:sqlite:/C:/IraqJavaWorkSpace/LC/LcDB.db");
          
          // for windows users    =>    DriverManager.getConnection("jdbc:sqlite:D:\\db\\my-db.sqlite").
          
			  JOptionPane.showMessageDialog(null,"Connection to SQLite has been established.");

              return conn;
        } catch (Exception e) { 
			  JOptionPane.showMessageDialog(null,e.getMessage());

            System.out.println();
            return null;
        }  
    }  
    public static  ResultSet  MSelect(String User,String pass) throws SQLException
    {
    	 
        	ResultSet rs;
    	    String sql = "select UserID,Permision,UserName from Users where UserName=? and Password=?";  
    	   //System.out.println("adada");
    	    PreparedStatement pst  = conn.prepareStatement(sql);  
    	    
    	    //System.out.println(User+ "////"+pass);
            pst.setString(1, User); 
            pst.setString(2, pass);
           
            
             rs = pst.executeQuery();
             
             
             return rs;
  
	
		
        
    }
//    @overload
    public static  ResultSet  MSelect(int Barcode) throws SQLException
    {
    	 
        	ResultSet rstable;
    	    String sql = "select * from Clothes where Clothes.Barcode=?"; 
    		//JOptionPane.showMessageDialog(null,sql);
    	    PreparedStatement pst  = conn.prepareStatement(sql);  
    	    
    	    
            pst.setInt(1, Barcode); 
         
            JOptionPane.showMessageDialog(null, pst);
           
           
            
            rstable = pst.executeQuery();
             
             
             return rstable;
  
	
		
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static  void  InsertUser(String User,String pass,Integer Permission) throws SQLException
    {
    	 
    	    String sql = "insert into Users ( UserName,Password,Permision) values(?,?,?)";  
    
    	    PreparedStatement pst  = conn.prepareStatement(sql);  
    	    
    	    //System.out.println(User+ "////"+pass);
            pst.setString(1, User); 
            pst.setString(2, pass);
            pst.setInt(3, Permission);
            
           
            
              pst.execute();
             
        
    }
    
    public static  void  InsertSale(int user ,int clothedid ,int qty ,String date) throws SQLException
    {
    	 
    	    String sql = "insert into Seling ( UserID,ClothesID,QTY,Datetime) values(?,?,?,?)";  
    System.out.println(sql);
    	    PreparedStatement pst  = conn.prepareStatement(sql);  
    	    
    	    //System.out.println(User+ "////"+pass);
            pst.setInt(1, user); 
            pst.setInt(2, clothedid);
            pst.setInt(3, qty);
            pst.setString(4, date);
            
           
            
              pst.execute();
             
        
    }
    
//    
    
    public static  void  Updatesale(int clothedid ,int qty ) throws SQLException
    {
    	 
    	    String sql = "update Clothes set  qty=? where ClothesID=? ";  
             //System.out.println(sql);
    	    PreparedStatement pst  = conn.prepareStatement(sql);  
    	    
    	    //System.out.println(User+ "////"+pass);
    	    pst.setInt(1, qty);
            pst.setInt(2, clothedid); 
          
    
              pst.execute();
             
        
    }
	
    
    
}
