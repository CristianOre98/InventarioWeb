package DAO;

import Model.Usuario;
import java.util.ArrayList;
import java.util.List;

public interface UsuarioDAO {
    
    //Definir los métodos, como la clase en interface. Los métodos no se implementan 
    //aqui, los métodos son de tipo abstractos.
    public ArrayList<Usuario> startSesion(String user, String clave);
    public List<Usuario> listar();
    public Usuario editarUsu(int id_usu_edit);
    public boolean guardarUsu(Usuario usuario);
   
    public boolean borrarUsu(int id_usu_borrar);
}
