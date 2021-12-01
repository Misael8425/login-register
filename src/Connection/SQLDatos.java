//Misael Mejia Guerrero 2021-0331//

package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLDatos extends Conexion {
    
    public boolean Registro(Datos usr){
        
        PreparedStatement ps = null;
        Connection Conect = getConexion();
        
        String sql = "INSERT INTO usuarios (Nombre_de_usuario, Nombre, Apellido, Número_de_teléfono, Correo_electrónico, Contraseña)VALUES(?,?,?,?,?,?)";
        
        try {
            ps = Conect.prepareStatement(sql);
            ps.setString(1,usr.getNombre_de_usuario());
            ps.setString(2,usr.getNombre());
            ps.setString(3,usr.getApellido());
            ps.setString(4,usr.getNúmero_de_teléfono());
            ps.setString(5,usr.getCorreo_electrónico());
            ps.setString(6,usr.getContraseña());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean Login(Datos usr){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection Conect = getConexion();
        
        String sql = "Select Nombre_de_usuario, Nombre, Contraseña FROM usuarios WHERE Nombre_de_usuario = ?";
        
        try {
            ps = Conect.prepareStatement(sql);
            ps.setString(1,usr.getNombre_de_usuario());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
                if(usr.getContraseña().equals(rs.getString(3))) {
                    
                    usr.setNombre_de_usuario(rs.getString(1));
                    usr.setNombre(rs.getString(2));
                    return true;
                    
                } else {
                    
                    return false;
                    
                }
                
            }
            
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public int Existe(String Nombre_de_usuario){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection Conect = getConexion();
        
        String sql = "Select count(Nombre_de_usuario) FROM usuarios WHERE Nombre_de_usuario = ?";
        
        try {
            ps = Conect.prepareStatement(sql);
            ps.setString(1,Nombre_de_usuario);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1);
            }
            
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLDatos.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
    
    public boolean Email(String correo) {

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+´)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);
        return mather.find();

    }
}
