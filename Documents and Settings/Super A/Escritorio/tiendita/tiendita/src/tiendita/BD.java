/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author ubuntu
 */
public class BD {
    
    public static Connection conectar(String usuario, String contraseña)
    throws TienditaException{
        Properties connectionProps = new Properties();
        connectionProps.put("user", usuario);
        connectionProps.put("password", contraseña);
        
        try{
        return (Connection) DriverManager.
            getConnection("jdbc:mysql://localhost:3306/tienda_vaca", connectionProps);
        
        
        }catch(SQLException e){
            throw new TienditaException("No se pudo establecer coneccion con "+
                    "la base de datos. "+ e.getMessage());
        }
    }
    
    public static void desconectar(Connection con){
        try{
            if (con != null){
                con.close();
            }
        }catch(SQLException e){
            
        }
    }
    
    public static void reportarError(String error){
        
    }
}
