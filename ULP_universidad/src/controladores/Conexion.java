package controladores;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private String url;
    private String user;
    private String password;
    
    private Connection conexion;
    
    public Conexion(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Conexion() {
    }
    
    
    public Connection bucarConexion() {
        //si es la primera vez, hay que establecerla
        if (conexion == null) { 
            
            try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return conexion; //retorna la conexión establecida
        
    }
    
}
