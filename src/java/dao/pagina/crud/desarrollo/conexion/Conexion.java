
package dao.pagina.crud.desarrollo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
     Connection con;
    
    public Conexion(){
        
     try{
         
         Class.forName("com.mysql.jdbc.Driver");
         
         con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
         
     }catch(Exception e){
         
         System.out.println("Error: "+e);
         
     }
     
    }
     
     public Connection getConnection(){
         return con;
     }
}
