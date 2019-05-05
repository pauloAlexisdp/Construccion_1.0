/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;


import java.sql.*;

/**
 * clase que permite la conexion con la base de datos
 * @author los_LANZAS
 */
public class Conexion {
    Connection conexion = null;
    Statement statement = null;
    DatabaseMetaData dbmd;
    String s_conexion = null;
    ResultSet resultado = null;
    String un_sql  = null;
    
    protected String jdbc;
    protected String driver;
    protected String host;
    protected String database;
    protected String username;
    protected String password;
    
    public Conexion(String jdbc, String driver, String host, String database,String username,String password) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{
        this.jdbc = jdbc;
        this.driver = driver;
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        init();
    }
    /**
     * inicializa la conexion con la base de datos
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public void init() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        s_conexion = this.jdbc + this.host + "/"+this.database;
        Class.forName(this.driver).newInstance();
        conexion = DriverManager.getConnection(this.jdbc + this.host + "/"+this.database, this.username,this.password);
        dbmd = conexion.getMetaData();
        statement = (Statement) conexion.createStatement();
    }
    
    public String getDriver(){
        return this.driver;
    }
    
}
