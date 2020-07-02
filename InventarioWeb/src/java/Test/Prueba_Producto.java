
package Test;
import Model.Producto;
import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import java.util.List;


public class Prueba_Producto {
    
      
    public static void main(String[] args) {
        Prueba_Producto evaluar = new Prueba_Producto();
       evaluar.listarProductos();
        //evaluar.editarProducto();
        evaluar.guardaProducto();
         evaluar.listarProductos();
        //evaluar.eliminarCategoria();
    }

    private void listarProductos() {
       ProductoDAO producto = new ProductoDAOImplementar(); //To change body of generated methods, choose Tools | Templates.
       List<Producto> listar = producto.listar();
        System.out.println("LISTADO DE PRODUCTO");
        for ( Producto categoriaListar : listar) {
            System.out.println(" ID: "+ categoriaListar.getId_producto()+
                 " NOMBRE: " + categoriaListar.getNom_producto()+
                " Descripcion: "+ categoriaListar.getDes_producto()+
                " ESTADO: " + categoriaListar.getEstado()+
                " STOCK: "+ categoriaListar.getStock()+
                " PRECIO: "+ categoriaListar.getPrecio()+
                " CATEGORIA: "+ categoriaListar.getCategoria_id()+
                " FECHA ENTRADA: "+ categoriaListar.getFecha_entrada());
        }
    }
private void guardaProducto() {
       ProductoDAO producto = new ProductoDAOImplementar(); //To change body of generated methods, choose Tools | Templates. 
       Producto guarda = new Producto();
      // guarda_pro.setId_producto(21);
       guarda.setNom_producto("pabaszjbkcbj");
       guarda.setDes_producto("svuohuj");
       guarda.setPrecio((float) 25.36);
       guarda.setPrecio((float) 500.25);
       guarda.setUnidadMedida("fefgdrgf");
       guarda.setEstado(1);
       guarda.setCategoria_id(22);
       guarda.setFecha_entrada("2020-09-29 18:26.0");
       producto.guardarPro(guarda);
    }  
public void editarProducto(){
        ProductoDAO producto = new ProductoDAOImplementar();
        Producto cat_edit = producto.editarPro(1);
        System.out.println("CATEGORIA A MODIFICAR");
        System.out.println("ID: "+ cat_edit.getId_producto()+
                 " NOMBRE: " + cat_edit.getNom_producto()+
                "Descripcion: "+ cat_edit.getDes_producto()+
                " ESTADO: " + cat_edit.getEstado()+
                "STOCK: "+ cat_edit.getStock()+
                "PRECIO: "+ cat_edit.getPrecio()+
                "CATEGORIA: "+ cat_edit.getCategoria_id()+
                "FECHA ENTRADA: "+ cat_edit.getFecha_entrada());
    }

    }
 

