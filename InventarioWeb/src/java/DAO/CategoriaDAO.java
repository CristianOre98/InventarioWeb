
package DAO;

import Model.Categoria;
import java.util.List;

public interface CategoriaDAO {
    /*Definir los metodos, como la clase en inteface los metodos no se implementan
    aqui, metodos son de tipo abstractos*/
    
    public List<Categoria> listar();
    public List<Categoria> Listar2();
    public Categoria editarCat(int id_cat_edit);
    public boolean guardarCat(Categoria categoria);
    public boolean borrarCat(int id_cat_borrar);
    
    
}
