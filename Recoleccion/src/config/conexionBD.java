
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author jeanc
 */
public class conexionBD {
   
        Connection conecta = null;
     
        
        String user = "root";
        String pass = "";
        String bd = "base_datos";
        String host = "localhost";
        String puerto = "3306";
        
        
        String cadena = "jdbc:mysql://"+host+":"+puerto+"/"+bd;
     
       
        @SuppressWarnings("UseSpecificCatch")
       public Connection estableConexion(){
           
           try {
               
               
               Class.forName("com.mysql.cj.jdbc.Driver");
               conecta = DriverManager.getConnection(cadena,user,pass);
               //JOptionPane.showMessageDialog(null, "Conexion exitosa");
               
           } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error" + e.toString());
           }
           return conecta;
       } 

    public void insertarRegistro(JTextField txtCuenta, JTextField txtNombre, JTextField txtAdp, JTextField txtService, JTextField txtPantalla, JTextField txtTeclado, JTextField txtMouse, JTextField txtHeandsets, JTextField txtCableRed, JTextField txtCableVideo, JTextField txtCableRed0, JTextField txtTeclado0, JTextField txtMouse0, JTextField txtCuenta0, JTextField txtService0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       
    
}
