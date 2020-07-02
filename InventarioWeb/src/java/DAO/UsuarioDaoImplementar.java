package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Categoria;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDaoImplementar implements UsuarioDAO{
    
    ConexionDB conn;  //Crear el objeto tipo conexión.

    public UsuarioDaoImplementar() {
        //Definir a la base de datos que se conectará por defecto.
        //this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
    }

    @Override
    public ArrayList<Usuario> startSesion(String user, String clave) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_usuario WHERE BINARY correo = '").append(user);
        miSQL.append("' and clave = md5('").append(clave);
        miSQL.append("');");  
        System.out.println(miSQL);
        //ArrayList<Usuario> user = new ArrayList(); // crear el array de almacenamiento en cada fial los registros encontrados
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try{
        //Se crea el objeto ResultSet implementando el método (consultaSQL) creado para la consulta.
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                Usuario usuario = new Usuario();
                //Asignar cada campo consultado al atributo en la clase.
                usuario.setId(resultadoSQL.getInt("id"));
                usuario.setNombre(resultadoSQL.getString("nombre"));
                usuario.setApellido(resultadoSQL.getString("apellido"));
                usuario.setCorreo(resultadoSQL.getString("correo"));
                usuario.setUsuario(resultadoSQL.getString("usuario"));
                usuario.setClave(resultadoSQL.getString("clave"));
                usuario.setTipo(resultadoSQL.getInt("tipo"));
                usuario.setEstado(resultadoSQL.getInt("estado"));
                usuario.setPregunta(resultadoSQL.getString("pregunta"));
                usuario.setRespuesta(resultadoSQL.getString("respuesta"));
                usuario.setFecharegistro(resultadoSQL.getString("fecha_registro"));
                lista.add(usuario); //Agregar al array cada registro encontrado.
                
                /*lista.add(new Usuario(usuario.setId(resultadoSQL.getInt("id")),
                        usuario.setNombre(resultadoSQL.getString("nombre")),
                        usuario.setApellido(resultadoSQL.getString("apellido")),
                        usuario.setCorreo(resultadoSQL.getString("correo")),
                        usuario.setUsuario(resultadoSQL.getString("usuario")),
                        usuario.setClave(resultadoSQL.getString("clave")),
                        usuario.setTipo(resultadoSQL.getInt("tipo")),
                        usuario.setEstado(resultadoSQL.getInt("estado")),
                        usuario.setPregunta(resultadoSQL.getString("pregunta")),
                        usuario.setRespuesta(resultadoSQL.getString("respuesta")),
                        usuario.setFecharegistro(resultadoSQL.getString("fecha_registro"))));*/       
            }
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
        
        return lista;
    }
    
    
    
    //Método creado para probar de inmediato el método startSesion()
    public static void main(String[] args){
        //UsuarioDaoImplementar p = new UsuarioDaoImplementar();  
        UsuarioDAO p = new UsuarioDaoImplementar();
        //p.sesion("chovi", "123");
        ArrayList<Usuario> user = new ArrayList();
        user = p.startSesion("jose@gmail.com", "12345");
        //Para obtener el tamaño de un arraylist. El tamaño esta dado en base
        //a la cantidad de filas o registros existentes en la BD.
        int size = user.size();
        //Buble for para recorrer un arrylist.
          for (int i = 0; i < user.size(); i++) {
              System.out.println(user.get(i).getUsuario() + "\t" + user.get(i).getClave() + "\t" + user.get(i).getCorreo() + "\t" + user.get(0).getNombre() + "\t" + 
                      user.get(0).getTipo());
              System.out.println("El valor máximo de i es: " + i);
            } 
      }

    @Override
    public List<Usuario> listar() {
         this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
      StringBuilder miSQL = new StringBuilder();
      miSQL.append("SELECT id, nombre, apellido, correo, usuario, clave, "
              + "tipo, estado, pregunta, respuesta, fecha_registro FROM tb_usuario");
     List<Usuario> lista = new ArrayList<Usuario>();
        try {
            //Se crea el objeto ResultSet implementando el metodo (consultaSQL) creado para la consulta
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                Usuario usuario = new Usuario();
               usuario.setId(resultadoSQL.getInt("id"));
                usuario.setNombre(resultadoSQL.getString("nombre"));
                usuario.setApellido(resultadoSQL.getString("apellido"));
                usuario.setCorreo(resultadoSQL.getString("correo"));
                usuario.setUsuario(resultadoSQL.getString("usuario"));
                usuario.setClave(resultadoSQL.getString("clave"));
                usuario.setTipo(resultadoSQL.getInt("tipo"));
                usuario.setEstado(resultadoSQL.getInt("estado"));
                usuario.setPregunta(resultadoSQL.getString("pregunta"));
                usuario.setRespuesta(resultadoSQL.getString("respuesta"));
                usuario.setFecharegistro(resultadoSQL.getString("fecha_registro"));
                lista.add(usuario); //Agregar al array cada registro encontrado.
            }
        } catch (Exception ex) {
            
        }finally{
            this.conn.cerrarConexion(); //para cerrar la conexion a bd
        }
        return lista;
    }

    @Override
    public Usuario editarUsu(int id_usu_edit) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        
        Usuario usuario = new Usuario();
        StringBuilder miSQL = new StringBuilder();
        //Agregar la consulta SQL.
        miSQL.append("SELECT * FROM tb_usuario WHERE id = ").append(id_usu_edit);
        //Realizar la consulta.
        try{
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
               usuario.setId(resultadoSQL.getInt("id"));
                usuario.setNombre(resultadoSQL.getString("nombre"));
                usuario.setApellido(resultadoSQL.getString("apellido"));
                usuario.setCorreo(resultadoSQL.getString("correo"));
                usuario.setUsuario(resultadoSQL.getString("usuario"));
                usuario.setClave(resultadoSQL.getString("clave"));
                usuario.setTipo(resultadoSQL.getInt("tipo"));
                usuario.setEstado(resultadoSQL.getInt("estado"));
                usuario.setPregunta(resultadoSQL.getString("pregunta"));
                usuario.setRespuesta(resultadoSQL.getString("respuesta"));
               // usuario.setFecharegistro(resultadoSQL.getString("fecha_registro"));
            }
        }catch(Exception e){
        }finally{
            this.conn.cerrarConexion();
        }
        
        return usuario;
    }

    @Override
    public boolean guardarUsu(Usuario usuario) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean guardar = false;
        
        try{
            System.out.println("Usuario "+ usuario.getId());
            if(usuario.getId() == 0){
               StringBuilder miSQL = new StringBuilder();

                //Agregar consulta SQL; el id_categoria es autoincrementable.
                miSQL.append("INSERT INTO tb_usuario(nombre, apellido, correo, usuario, clave, tipo, estado,"
                        + " pregunta, respuesta) VALUES ");
                miSQL.append("('"+usuario.getNombre()+ "', ");
                miSQL.append("'"+usuario.getApellido()+"', '");
                miSQL.append(usuario.getCorreo()+"', '");
                miSQL.append(usuario.getUsuario()+"', '");
                miSQL.append(usuario.getClave()+"', ");
                miSQL.append(usuario.getTipo()+", ");
                miSQL.append(usuario.getEstado()+", '");
                miSQL.append(usuario.getPregunta()+"', '");
                miSQL.append(usuario.getRespuesta()+"');");
                //Invocar método para ejecutar la consulta.
        
                this.conn.ejecutarSQL(miSQL.toString());
                System.out.println("Registro Guardado...");
            }else if(usuario.getId()>0){                            //Comprobación para actualizar...
                System.out.println("Entramos...");
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("UPDATE tb_usuario SET ");
                miSQL.append(" nombre =  '").append(usuario.getNombre());
                miSQL.append("', apellido =  '").append(usuario.getApellido());
                miSQL.append("', correo =  '").append(usuario.getCorreo());
                miSQL.append("', usuario =  '").append(usuario.getUsuario());
                miSQL.append("', clave =  '").append(usuario.getClave());
                miSQL.append("', tipo =  '").append(usuario.getTipo());
                miSQL.append("', estado =  '").append(usuario.getEstado());
                miSQL.append("', pregunta =  '").append(usuario.getPregunta());
                miSQL.append("', respuesta =  '").append(usuario.getRespuesta());
                miSQL.append("' WHERE id =  '").append(usuario.getId()).append("';");
//                
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
    public boolean borrarUsu(int id_usu_borrar) {
         this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean borrar = false;           //Bandera de resultados
        try{
            StringBuilder miSQL = new StringBuilder();
            miSQL.append("DELETE FROM tb_usuario WHERE id = ").append(id_usu_borrar);
            this.conn.ejecutarSQL(miSQL.toString());
            borrar = true;
        }catch(Exception e){
            
        }finally{
            this.conn.cerrarConexion();  //Cerrar la conexión.
        }
        return borrar;
    }
    
    
}
