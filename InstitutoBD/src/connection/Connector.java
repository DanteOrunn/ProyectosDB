package connection;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Cruz
 * @version 1.0.0
 */
public class Connector {
    
    private String dbName;
    private String url;
    private String user;
    private String password;
    private String driver;
    private Connection connect;
    
    public Connector(){
        this.dbName = "testing";
        this.url = "jdbc:mysql://localhost:3306/";
        this.user = "DevAccessRoot";
        this.password = "Lol_Cow69";
        this.driver = "com.mysql.cj.jdbc.Driver";
    }
    
    public Connector(String dbName){
        this.dbName = dbName;
        this.url = "jdbc:mysql://localhost:3306/";
        this.user = "DevAccessRoot";
        this.password = "Lol_Cow69";
        this.driver = "com.mysql.cj.jdbc.Driver";
    }
    
    public Connector(String dbName, String url, String user, String password, String driver){
        this.dbName = dbName;
        this.url = url;
        this.user = user;
        this.password = password;
        this.driver = driver;
    }
    
    public Connector(String dbName, String ipDirecction, String port, String user, String password, String driver){
        this.dbName = dbName;
        this.url = "jdbc:mysql://" + ipDirecction + ":" + port;
        this.user = user;
        this.password = password;
        this.driver = driver;
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url + dbName, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "La conexion a la base de datos " + dbName + " fallo");
            JOptionPane.showMessageDialog(null, "|ERROR|:" + e.getMessage());
        }
        
        return connect;
    }
    
    public void desconectar(){
        try {
            connect.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la desconexion a la base de datos");
        }
    }
    
}
