//Misael Mejia Guerrero 2021-0331//

package Connection;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    String basedatos = "login/register";
    String User = "root";
    String Password = "12345";
    String Url = "jdbc:mysql://localhost:3306/";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection Conect;
    
    public Connection getConexion() {
        
        try {
            Class.forName(driver);
            Conect = DriverManager.getConnection(Url + basedatos,User,Password);
            System.out.println("Se conecto a " + basedatos);
            
        } catch (ClassNotFoundException ex) {
            System.out.println("No se conecto a " + basedatos);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Conect;
        
    }
    
}
