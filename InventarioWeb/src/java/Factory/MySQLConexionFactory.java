
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;


public final class MySQLConexionFactory extends ConexionDB {

    public MySQLConexionFactory(String[] criterio) {
    this.parametros = criterio;
    this.open();
    }

   

    
    @Override
   public Connection open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //En this.parametros[] iran los datos de los nombre de la bd, usuario y clave
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+this.parametros[0],this.parametros[1],this.parametros[2]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.conexion;
    }
    
}
