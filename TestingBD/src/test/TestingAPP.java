package test;

import connection.Connector;

/**
 *
 * @author Luis Cruz
 */
public class TestingAPP {
    
    public static void main(String[] args) {
        
        Connector conexion = new Connector();
        
        conexion.conectar();
        conexion.desconectar();
        
    }
    
}
