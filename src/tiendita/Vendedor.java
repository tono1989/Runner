/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ubuntu
 */
public class Vendedor {
    
    String nombre;
    //Poner un enum
    int privilegios = 0;
    
    public Vendedor(String nombre){
        this.nombre = nombre;
    }
    
    public void realizaVenta(Vector listaDeProductos, Connection conn)
    throws TienditaException{
        //Buscar una mejor estructura de datos para vector.
        if (conn == null) 
            throw new TienditaException("Error. No hay conexion con la base de datos.");
        
        String update = "update Inventario set existencias = existencias - ? where upc = ?";
        Vector v;
        String upc;
        int cantidad;
        try{
            PreparedStatement ps = 
                    (PreparedStatement) conn.prepareStatement(update);
            
            for (int i = 0; i< listaDeProductos.size(); i++){
                v = (Vector) listaDeProductos.get(i);
                upc = (String) v.get(0);
                cantidad =  (Integer) v.get(2);
                
                ps.setInt(1,cantidad);
                ps.setString(2,upc);
                
                ps.addBatch();
            }
            
            ps.executeBatch();
            
            
        }catch(SQLException e){
            throw new TienditaException("Error. " + e.getMessage());
        }
    }
}
