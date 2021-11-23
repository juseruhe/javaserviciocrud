
package dao.pagina.crud.desarrollo.interfaces;

import dao.pagina.crud.desarrollo.models.Persona;
import java.util.List;


public interface CRUD {
    public List mostrarPersonas();
    public Persona mostrarPersona(int id);
    public String  insertarPersona(String dni, String nombre);
    public String  actualizarPersona(int id,String dni,String nombre);
    public Persona eliminarPersona(int id);
}
