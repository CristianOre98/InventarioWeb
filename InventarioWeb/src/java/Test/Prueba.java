
package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.util.List;
        

public class Prueba {
    public static void main(String[] args) {
        Prueba evaluar = new Prueba();
       // evaluar.guardarCategoria(); //Método guardar
        evaluar.listarCategorias();//Método listar
        evaluar.eliminarCategoria();
        evaluar.listarCategorias();//Consultar si ha sido eliminada
       // evaluar.editarCategoria();
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

    private void editarCategoria() {
       CategoriaDAO categoria = new CategoriaDAOImplementar();
       Categoria cat_edit = categoria.editarCat(1);//Se pasa el valor id_categoria = 1
        System.out.println("CATEGORIA A MODIFICAR");
        System.out.println("ID: " + cat_edit.getId_categoria()+
                           " NOMBRE: " + cat_edit.getNom_categoria()+
                           " ESTADO: " + cat_edit.getEstado_categoria());
    }

    private void guardarCategoria() {
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        Categoria guardar_cat = new Categoria();
        guardar_cat.setNom_categoria("Bebidas Naturales");//nueva categoria a guardar
        guardar_cat.setId_categoria(5);//Modificar la categoria registrada anteriormente
        guardar_cat.setEstado_categoria(1); //Estado 1
        categoria.guardarCat(guardar_cat);
    }   

    private void eliminarCategoria() {
    CategoriaDAO categoria = new CategoriaDAOImplementar();
    categoria.borrarCat(2);
    }
}
