/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita;

import com.mysql.jdbc.Connection;

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
}
