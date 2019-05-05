/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Clase que se puede conectar a la base de datos
 * postgres
 * @author los lanzas
 */
public class Conexion_Postgres extends Conexion {
    private String opcones ;
    private static String JDBC = "jdbc:postgresql://";
    private static String DRIVER = "org.postgresql.Driver";
    private static String HOST = "localhost:5432";
    public Conexion_Postgres(String database, String username, String password) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(JDBC, DRIVER, HOST, database, username, password);
        this.opcones = "charSet=LATIN1";
        
    }
    
    public Conexion_Postgres() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{
        this("fruticula", "postgres", "1234");
    }
    /**
     * Inicializa la base de datos 
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    @Override
    public void init() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        s_conexion = jdbc + host + "/"+database;
        Class.forName(driver).newInstance();
        conexion = DriverManager.getConnection(jdbc+host+"/"+database+"?"+opcones,username,password);
        dbmd = conexion.getMetaData();
        statement =  conexion.createStatement();
    }
    
    
}
