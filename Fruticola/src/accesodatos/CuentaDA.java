/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import conexion.*;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Cuenta;

/**
 *
 * @author len_win
 */
public class CuentaDA {
    private Cuenta cuenta;
    
    public CuentaDA(Cuenta cuenta){
        this.cuenta = cuenta;
    }
    
    public void guardar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Conexion cdb = FactoriaConexion.getInstancia().getConexiondb();
        cdb.un_sql = "select nombre cuenta where nombre = "+cuenta.getNombre();
        cdb.resultado = cdb.statement.executeQuery(cdb.un_sql);
        if(cdb.resultado!=null){
            
        }else{
            cdb.un_sql = "Insert into cuenta values ('"+cuenta.getNombre()+"','"+cuenta.getPassword()+"','"+cuenta.getTipo()+"'";
            cdb.statement.executeUpdate(cdb.un_sql);
        }
    
    }
    
    public ArrayList cargar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        ArrayList r = null;
        Cuenta c;
        Conexion cdb = FactoriaConexion.getInstancia().getConexiondb();
        cdb.un_sql = "select * from cuenta";
        cdb.resultado = cdb.statement.executeQuery(cdb.un_sql);
        if(cdb.resultado!=null){
            r = new ArrayList();
            while(cdb.resultado.next()){
                c = new Cuenta();
                c.setNombre(cdb.resultado.getString("nombre"));
                c.setPassword(cdb.resultado.getString("password"));
                c.setTipo(cdb.resultado.getString("tipo"));
                r.add(c);
            }
        }else{
            System.out.println("error");
        }
      return r;
    }
}
