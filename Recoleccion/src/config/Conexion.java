
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author jeanc
 */
public class Conexion {
   
        Connection conecta;
     
        
        String user = "root";
        String pass = "";
        String bd = "recoleccion";
        String host = "localhost";
        String puerto = "3306";
        
        
        String cadena = "jdbc:mysql://"+host+":"+puerto+"/"+bd;
     
       
        @SuppressWarnings("UseSpecificCatch")
       public Connection EstableConexion(){
           
           try {
               
               
               Class.forName("com.mysql.cj.jdbc.Driver");
               conecta = DriverManager.getConnection(cadena,user,pass);
               //JOptionPane.showMessageDialog(null, "Conexion exitosa");
               
           } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error" + e.toString());
           }
           return conecta;
       } 

  
       
    
}
