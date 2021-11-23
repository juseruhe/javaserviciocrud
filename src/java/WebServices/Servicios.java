
package WebServices;

import dao.pagina.crud.desarrollo.dao.PersonaDAO;
import dao.pagina.crud.desarrollo.models.Persona;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "Servicios")
public class Servicios {

    PersonaDAO dao = new PersonaDAO();
  
    @WebMethod(operationName = "mostrarPersonas")
    public List<Persona> mostrarPersonas(){
        List datos = dao.mostrarPersonas();
        return datos;
    }
    
       @WebMethod(operationName = "insertarPersona")
    public String insertarPersona(@WebParam(name="dni") String dni,@WebParam(name="nombre") String nombre){
        String datos = dao.insertarPersona(dni, nombre);
        return datos;
    }
    
       @WebMethod(operationName = "mostrarPersona")
    public Persona mostrarPersona(@WebParam(name="id") int id){
        Persona persona = dao.mostrarPersona(id);
        return persona;
    }
    
      @WebMethod(operationName = "actualizarPersona")
    public String actualizarPersona(@WebParam(name="id") int id,@WebParam(name="dni") String dni,@WebParam(name="nombre") String nombre){
        String datos = dao.actualizarPersona(id, dni, nombre);
        return datos;
    }
    
        @WebMethod(operationName = "eliminarPersona")
    public Persona eliminarPersona(@WebParam(name="id") int id){
       Persona p = dao.eliminarPersona(id);
       return p;
    }
}
   

}