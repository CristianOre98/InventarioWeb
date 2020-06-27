
package DAO;


import Factory.ConexionBD;
import Factory.FactoryConexionBD;
import Model.Producto;
import Model.Categoria;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAOImplementar implements ProductoDAO{

    ConexionBD conn;

    public ProductoDAOImplementar() {
        
    }

    public List<Producto> listar() {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
      StringBuilder miSQL = new StringBuilder();
      miSQL.append("SELECT p.id_producto, p.nom_producto, p.des_producto, p.stock, p.precio, p.unidad_de_medida, p.estado_producto, "
              + "p.categoria, p.fecha_entrada FROM tb_producto p INNER JOIN tb_categoria c on p.categoria = c.id_categoria");
     List<Producto> lista = new ArrayList<Producto>();
        try {
            //Se crea el objeto ResultSet implementando el metodo (consultaSQL) creado para la consulta
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                Producto producto = new Producto();
                Categoria cat = new Categoria();
                producto.setId_producto(resultadoSQL.getInt("p.id_producto"));
                producto.setNom_producto(resultadoSQL.getString("p.nom_producto"));
                producto.setDes_producto(resultadoSQL.getString("p.des_producto"));
                producto.setStock(resultadoSQL.getFloat("p.stock"));
                producto.setPrecio(resultadoSQL.getFloat("p.precio"));
                producto.setUnidadMedida(resultadoSQL.getString("p.unidad_de_medida"));
                producto.setEstado(resultadoSQL.getInt("p.estado_producto"));

                producto.setCategoria_id(resultadoSQL.getInt("p.categoria"));
                producto.setFecha_entrada(resultadoSQL.getString("p.fecha_entrada"));
                lista.add(producto); //agregando al array cada registro encontrado
            }
        } catch (Exception ex) {
            
        }finally{
            this.conn.cerrarConexion(); //para cerrar la conexion a bd
        }
        return lista;
        }

    @Override
    public List<Producto> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto editarPro(int id_pro_edit) {
       this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
        Categoria catego = new Categoria();
        Producto producto = new Producto();
        StringBuilder miSQL = new StringBuilder();
        //Agregar la consulta SQL.
        miSQL.append("SELECT * FROM tb_producto WHERE id_producto = ").append(id_pro_edit);
        //Realizar la consulta.
        try{
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
               producto.setId_producto(resultadoSQL.getInt("id_producto"));
                producto.setNom_producto(resultadoSQL.getString("nom_producto"));
                producto.setStock(resultadoSQL.getFloat("stock"));
                producto.setPrecio(resultadoSQL.getFloat("precio"));
                producto.setUnidadMedida(resultadoSQL.getString("unidad_de_medida"));
                producto.setEstado(resultadoSQL.getInt("estado_producto"));
                producto.setCategoria_id(resultadoSQL.getInt("categoria"));
                producto.setFecha_entrada("fecha_entrada");
            }
        }catch(Exception e){
        }finally{
            this.conn.cerrarConexion();
        }
        
        return producto;
    }

    @Override
    public boolean guardarPro(Producto producto) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
        boolean guardar = false;
        try{
            if(producto.getId_producto() == 0){
                StringBuilder miSQL = new StringBuilder();
                //Agregar consulta SQL; el id_categoria es autoincrementable.
                miSQL.append("INSERT INTO tb_producto(nom_producto, des_producto, stock, precio, unidad_de_medida, "
                        + "categoria, fecha_entrada) VALUES ('");
                miSQL.append(producto.getNom_producto()+ "', '").append(producto.getDes_producto()+"', ");
                miSQL.append(producto.getStock()+", ").append(producto.getPrecio()+", '");
                miSQL.append(producto.getUnidadMedida()+"', ").append(producto.getCategoria_id()+", ");
                miSQL.append(producto.getFecha_entrada());
                miSQL.append(");");
                //Invocar método para ejecutar la consulta.
                this.conn.ejecutarSQL(miSQL.toString());
                System.out.println("Registro Guardado...");
            }else if(producto.getId_producto() >0){                            //Comprobación para actualizar...
                System.out.println("Entramos...");
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("UPDATE tb_producto SET id_producto = ").append(producto.getId_producto());
                miSQL.append(", nom_producto =  '").append(producto.getNom_producto());
                miSQL.append("', des_producto =  '").append(producto.getDes_producto());
                miSQL.append("', stock =  ").append(producto.getStock());
                miSQL.append(", precio =  ").append(producto.getPrecio());
                miSQL.append(", unidad_de_medida =  '").append(producto.getUnidadMedida());
                miSQL.append("', categoria =  ").append(producto.getCategoria());
                miSQL.append(", fecha_entrada = '").append(producto.getFecha_entrada()).append("';");
                //Invocar método para ejecutar la consulta.
                this.conn.ejecutarSQL(miSQL.toString());
                System.out.println("Registro modificado correctamente!");
            }
            
          //return guardar;
        }catch(Exception e){
            
        }finally{
            this.conn.cerrarConexion();
        }
        return guardar;
    }

    @Override
    public boolean borrarPro(int id_pro_borrar) {
         this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
        boolean borrar = false;           //Bandera de resultados
        try{
            StringBuilder miSQL = new StringBuilder();
            miSQL.append("DELETE FROM tb_producto WHERE id_producto = ").append(id_pro_borrar);
            this.conn.ejecutarSQL(miSQL.toString());
            borrar = true;
        }catch(Exception e){
            
        }finally{
            this.conn.cerrarConexion();  //Cerrar la conexión.
        }
        return borrar;
    }

   
    
   
    
}
