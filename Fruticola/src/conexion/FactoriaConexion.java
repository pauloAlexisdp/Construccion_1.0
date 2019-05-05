/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 * Permite generar una instancia para el servicio de base de datos
 * @author len_win
 */
public class FactoriaConexion {
    //puntero que hereda conexion
    private Conexion cdb;
    
    private static FactoriaConexion instancia;
    
    public FactoriaConexion(){
        
    }
    
    public static FactoriaConexion getInstancia(){
        if(instancia==null){
            instancia = new FactoriaConexion();
        }
        return instancia;
    }
    
    public Conexion getConexiondb() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        if(cdb == null){
            String nombreClase = "conexion.Conexion_Postgres";
            
            cdb = (Conexion) Class.forName(nombreClase).newInstance();
        }
        return cdb;
    }
}
