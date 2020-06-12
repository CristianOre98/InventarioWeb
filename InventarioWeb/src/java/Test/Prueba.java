
package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.util.List;
        

public class Prueba {
    public static void main(String[] args) {
        Prueba evaluar = new Prueba();
        evaluar.listarCategorias();
    }

    private void listarCategorias() {
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        List<Categoria> listar = categoria.listar();
        System.out.println("LISTADO DE CATEGORIAS");
        for (Categoria categoriaListar : listar) {
            System.out.println("ID: " + categoriaListar.getId_categoria()+
                               " NOMBRE: "+ categoriaListar.getNom_categoria()+
                               " ESTADO: "+ categoriaListar.getEstado_categoria());
        }
    }
}
