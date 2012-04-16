/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ubuntu
 */
public class Producto {
    
    String upc;
    int existencias;
    String nombre;
    float precio;
    float costo;
    
    
    public Producto(String upc,
            int existencias,
            String nombre, 
            float precio, 
            float costo){
        this.upc = upc;
        this.existencias = existencias;
        this.nombre = nombre;
        this.precio = precio;
        this.costo = costo;
    }
    
    public Producto(Connection conn, String upc)
    throws SQLException
    {
        String select = "select * from Inventario where upc = ?; ";
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(select);
        ps.setString(1, upc);
        
        ResultSet rs = ps.executeQuery();
        
        rs.first();
        
        this.upc = upc;
        this.existencias = rs.getInt("existencias");
        this.nombre = rs.getString("nombre");
        this.precio = rs.getFloat("precio");
        this.costo = rs.getFloat("costo");
        
    }
       
    public void agregar(Connection conn)
    throws SQLException{
        
        String agregar = "insert into Inventario values (?,?,?,?,?)";
        
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(agregar);
        ps.setString(1, upc);
        ps.setInt(2,existencias);
        ps.setString(3,nombre);
        ps.setFloat(4,precio);
        ps.setFloat(5,costo);
        
        ps.execute();
        
    }
    
    public void modifacar(Connection conn)
    throws SQLException{
        
        String modificar = "update Inventario set "
                + "existencias = ?, nombre = ?, precio = ?, costo = ? "
                + "where upc = ?";
        
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(modificar);
        ps.setString(5, upc);
        ps.setInt(1,existencias);
        ps.setString(2,nombre);
        ps.setFloat(3,precio);
        ps.setFloat(4,costo);
        
        ps.executeUpdate();
    }
    
    
    
    public String getUpc(){
        return upc;
    }
    
    public int getExistencias(){
        return existencias;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public float getCosto(){
        return costo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Object[] getArray(){
        Object[] s = new Object[5];
        
        s[0] = upc;
        s[1] = (Integer)existencias;
        s[2] = nombre;
        s[3] = (Float)precio;
        s[4] = (Float)costo;  
        
        return s;
    }
    
    public Object[] getArrayVender(){
        Object[] s = new Object[4];
        
        s[0] = upc;
        s[1] = nombre;
        s[2] = (Integer)1;
        s[3] = (Float)precio;
        
        return s;
    }
    
}
