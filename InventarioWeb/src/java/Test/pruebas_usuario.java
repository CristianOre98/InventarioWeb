
package Test;
import java.util.List;
import DAO.UsuarioDAO;
import DAO.UsuarioDaoImplementar;
import Model.Usuario;

public class pruebas_usuario {
    
    public static void main(String[] args) {
        pruebas_usuario evaluar = new pruebas_usuario();
        
        evaluar.editarProducto();
        evaluar.guardaU();
         evaluar.listarProductos();
    }
    
     private void listarProductos() {
       UsuarioDAO usuario = new UsuarioDaoImplementar(); //To change body of generated methods, choose Tools | Templates.
       List<Usuario> listar = usuario.listar();
        System.out.println("LISTADO DE PRODUCTO");
        for ( Usuario usuarioListar : listar) {
            System.out.println(" ID: "+ usuarioListar.getId()+
                 " NOMBRE: " + usuarioListar.getNombre()+
                " apellido: "+ usuarioListar.getApellido()+
                " correo: " + usuarioListar.getCorreo()+
                " usuario: "+ usuarioListar.getUsuario()+
                " clave: "+ usuarioListar.getClave()+
                " estado: "+ usuarioListar.getEstado()+
                " tipo: "+ usuarioListar.getTipo()+
                " pregunta: "+ usuarioListar.getPregunta()+
                " respuesta: "+ usuarioListar.getRespuesta());
        }
     }
    
    
    private void guardaU() {
       UsuarioDAO producto = new UsuarioDaoImplementar(); //To change body of generated methods, choose Tools | Templates. 
       Usuario guarda = new Usuario();
      guarda.setId(3);
       guarda.setNombre("pabaszjbkcbj");
       guarda.setApellido("svuohuj");
       guarda.setCorreo("@@@@@");
       guarda.setUsuario("12adjjkfxc");
       guarda.setClave("123");
       guarda.setEstado(1);
       guarda.setTipo(2);
       guarda.setPregunta("tu mascota");
       guarda.setRespuesta("michi");
       producto.guardarUsu(guarda);
    }  
public void editarProducto(){
        UsuarioDAO usuario = new UsuarioDaoImplementar();
        Usuario cat_edit = usuario.editarUsu(1);
        System.out.println("CATEGORIA A MODIFICAR");
        System.out.println("ID: "+ cat_edit.getId()+
                 " NOMBRE: " + cat_edit.getNombre()+
                "apellido: "+ cat_edit.getApellido()+
                "correo: "+ cat_edit.getCorreo()+
                "usuario: "+ cat_edit.getUsuario()+
                "clave: "+ cat_edit.getClave()+
                " ESTADO: " + cat_edit.getEstado()+
                "tipo: "+ cat_edit.getTipo()+
                "pregunta: "+ cat_edit.getPregunta()+
                "respuesta: "+ cat_edit.getRespuesta());
                
    }

}