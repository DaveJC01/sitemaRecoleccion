/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;


import java.sql.*;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author jeanc
 */
public class consulta {
    
    String cuenta;
    String nombre;
    String adp;
    String serviceTag;
    String pantalla;
    String teclado;
    String mouse;
    String headsets;
    String cableRed;
    String caleVideo;
    String cablePower;
    String cargador;
    String token;
    String costo;
    String observacion;

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAdp() {
        return adp;
    }

    public void setAdp(String adp) {
        this.adp = adp;
    }

    public String getServiceTag() {
        return serviceTag;
    }

    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public String getTeclado() {
        return teclado;
    }

    public void setTeclado(String teclado) {
        this.teclado = teclado;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }
      public String getHeadsets() {
        return headsets;
    }

    public void setHeadsets(String headsets) {
        this.headsets = headsets;
    }

    public String getCableRed() {
        return cableRed;
    }

    public void setCableRed(String cableRed) {
        this.cableRed = cableRed;
    }

    public String getCaleVideo() {
        return caleVideo;
    }

    public void setCaleVideo(String caleVideo) {
        this.caleVideo = caleVideo;
    }

    public String getCablePower() {
        return cablePower;
    }

    public void setCablePower(String cablePower) {
        this.cablePower = cablePower;
    }

    public String getCargador() {
        return cargador;
    }

    public void setCargador(String cargador) {
        this.cargador = cargador;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    //Limpiar las celdas despues de guardar los datos 
    public void limpiar( 
            JTextField txtCuenta,
            JTextField txtNombre,
            JTextField txtAdp,
            JTextField txtService,
            JTextField txtPantalla,
            JTextField txtTeclado,
            JTextField txtMouse,
            JTextField txtHeadsets,
            JTextField txtCableRed,
            JTextField txtCableVideo,
            JTextField txtCablePower,
            JTextField txtCableCargador,
            JTextField txtToken,
            JTextField txtCosto,
            JTextField txtObservacion){
        
       
                txtCuenta.setText("");
                txtNombre.setText("");
                txtAdp.setText("");
                txtService.setText("");
                txtPantalla.setText("");
                txtTeclado.setText("");
                txtMouse.setText("");
                txtHeadsets.setText("");
                txtCableRed.setText("");
                txtCableVideo.setText("");
                txtCablePower.setText("");
                txtCableCargador.setText("");
                txtToken.setText("");
                txtCosto.setText("");
                txtObservacion.setText("");
    }
    
    
    
    
    public void insertarRegistro(
            JTextField txtCuenta,
            JTextField txtNombre,
            JTextField txtAdp,
            JTextField txtService,
            JTextField txtPantalla,
            JTextField txtTeclado,
            JTextField txtMouse,
            JTextField txtHeadsets,
            JTextField txtCableRed,
            JTextField txtCableVideo,
            JTextField txtCablePower,
            JTextField txtCableCargador,
            JTextField txtToken,
            JTextField txtCosto,
            JTextField txtObservacion) {
        
        setCuenta(txtCuenta.getText());
        setNombre(txtNombre.getText());
        setAdp(txtAdp.getText());
        setServiceTag(txtService.getText());
        setPantalla(txtPantalla.getText());
        setTeclado(txtTeclado.getText());
        setMouse(txtMouse.getText());
        setHeadsets(txtHeadsets.getText());
        setCableRed(txtCableRed.getText());
        setCaleVideo(txtCableVideo.getText());
        setCablePower(txtCablePower.getText());
        setCargador(txtCableCargador.getText());
        setToken(txtToken.getText());
        setCosto(txtCosto.getText());
        setObservacion(txtObservacion.getText());
        
        
        
         
       conexionBD objetoConexion = new conexionBD();
       
       
       
       
       String consultar =("INSERT INTO `recoleccion`( `cuenta`, `nombre`, `adp`, `servicetag`, `pantalla`, `teclado`, `mouse`, `headsets`, `cableRed`, `cableVideo`, `cablePower`, `cargador`, `token`, `costo`, `observacion`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
    
       
        try {
            
            CallableStatement cs = objetoConexion.estableConexion().prepareCall(consultar);
            
            cs.setString(1, getCuenta());
            cs.setString(2, getNombre());
            cs.setString(3, getAdp());
            cs.setString(4, getServiceTag());
            cs.setString(5, getPantalla());
            cs.setString(6, getTeclado());
            cs.setString(7, getMouse());
            cs.setString(8, getHeadsets());
            cs.setString(9, getCableRed());
            cs.setString(10, getCaleVideo());
            cs.setString(11, getCablePower());
            cs.setString(12, getCargador());
            cs.setString(13, getToken());
            cs.setString(14, getCosto());
            cs.setString(15, getObservacion());
                                        
            int res =   cs.executeUpdate();
            
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Datos Registrados exitosamente");
                
                limpiar(txtCuenta, txtNombre, txtAdp, txtService, txtPantalla, txtTeclado, txtMouse, txtHeadsets, txtCableRed, txtCableVideo, txtCablePower, txtCableCargador, txtToken, txtCosto, txtObservacion);
                
                              
            }
              
                      
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Datos no Registrados"+e.toString());
        }
}
    
   
}
