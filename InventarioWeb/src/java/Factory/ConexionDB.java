
package Factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class ConexionDB {
    protected String[] parametros;
    protected Connection conexion;
    
    abstract Connection open();
    
    public ResultSet consultaSQL(String consulta){
       Statement st;
       ResultSet rs = null;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(consulta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    
    public boolean ejecutarSQL(String consulta){
        Statement st;
        boolean guardar = true;
        try {
            st = conexion.createStatement();
            st.executeUpdate(consulta);
        } catch (Exception ex) {
            guardar = false;
            ex.printStackTrace();
        }
        return guardar;
    }
    
    public boolean cerrarConexion(){
        boolean ok = true;
        try {
            conexion.close();
        } catch (Exception ex) {
            ok = false;
            ex.printStackTrace();
        }
        return ok;
    }
}


