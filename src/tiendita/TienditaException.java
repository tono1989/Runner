/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita;

import javax.swing.JTextArea;

/**
 *
 * @author ubuntu
 */
public class TienditaException extends Exception {

    public TienditaException(String string) {
        super(string);
    }
    
    public static void reportaError(String s,JTextArea textArea){
        textArea.setText("Error. " + s);
    }
}
