/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author len_win
 */
public class Cuenta {
    private String nombre;
    private String password;
    private String tipo;
    
    public Cuenta(String nombre, String password, String tipo){
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
    }
    public Cuenta(){}

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String toString(){
        return "Cuenta usuario= "+this.nombre+" psw="+this.password+" tipo="+this.tipo;
    }
    
}
