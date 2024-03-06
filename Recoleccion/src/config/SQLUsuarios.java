package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLUsuarios extends Conexion {

//  Ingresa los datos de los usrios en la abase de datos
    public boolean registrar (Usuarios usr) {

        PreparedStatement ps = null;
        Connection con = EstableConexion();

        String sql = "INSERT INTO usuarios (usuario, password, nombre) VALUES (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getPassword());
            ps.setString(3, usr.getNombre());
            ps.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SQLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    
//    Verifica que si el usurio esxisten en la base de datos y lo seleciona 
    public boolean login (Usuarios usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = EstableConexion();

        String sql = "SELECT u.id, u.usuario, u.password, u.nombre, u.idTipo, t.nombre FROM usuarios AS u INNER JOIN tipousurio AS t ON u.idTipo = t.id WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());

            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getPassword().equals(rs.getString(3))) {
                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setIdTipo(5);
                    usr.setTipoNombre(rs.getString(6));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(SQLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
