
package dao.pagina.crud.desarrollo.dao;

import dao.pagina.crud.desarrollo.conexion.Conexion;
import dao.pagina.crud.desarrollo.interfaces.CRUD;
import dao.pagina.crud.desarrollo.models.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUD{
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    int res;
    String msg;
    

    @Override
    public List mostrarPersonas() {
       List<Persona> datos = new ArrayList<>();
       
       String sql = "select * from personas";
       try{
           con= conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           while(rs.next()){
               Persona p = new Persona();
               p.setId(rs.getInt("id"));
               p.setDni(rs.getString("dni"));
               p.setNombre(rs.getString("nombre"));
               
             datos.add(p);
           }
           
       }catch(Exception e){
           
       }
       
       return datos;
    }

    @Override
    public Persona mostrarPersona(int id) {
        String sql = "select * from personas where id="+id;
         Persona p = new Persona();
        
         try{
           con= conex.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           while(rs.next()){
            
               p.setId(rs.getInt("id"));
               p.setDni(rs.getString("dni"));
               p.setNombre(rs.getString("nombre"));
              
           }
           
       }catch(Exception e){
           
       }
        
        return p;
    }

    @Override
    public String insertarPersona(String dni, String nombre) {
        String sql = "insert into personas(dni,nombre) values(?,?)";
        try{
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, nombre);
           res = ps.executeUpdate();
           ps.close();
            
          if(res == 1){
              msg = "Persona insertada correctamente";
               
          }else {
              msg = "Error al insertar Persona";
               
          }
         
        }catch(Exception e){
            
        }
        
        return msg;
    }

    @Override
    public String actualizarPersona(int id, String dni, String nombre) {
       String sql = "update personas set dni=?, nombre=? where id="+id;
       try{
           con= conex.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1,dni);
           ps.setString(2,nombre);
        res = ps.executeUpdate();
          ps.close();
          if(res == 1) {
              msg = "Datos actualizados correctamente";
          }else {
              msg = "Error al actualizar";
          }
                         
       }catch(Exception e){
           
       }
       
       return msg;
    }

    @Override
    public Persona eliminarPersona(int id) {
       String sql = "delete from personas where id="+id;
         Persona p = new Persona();
       try{
           con= conex.getConnection();
           ps = con.prepareStatement(sql);
           ps.execute();
           ps.close();
           
       }catch(Exception e){
           
       }
       
       return p;
    }
    
}
