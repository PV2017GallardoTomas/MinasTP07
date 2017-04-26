/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean.form;

import aplicacion.modelo.dominio.JuegoAhorcado;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Flia. Gallardo
 */
@ManagedBean
@SessionScoped
public class JuegoFormBean implements Serializable {
private boolean componenteDeshabilitado;
private JuegoAhorcado juegoAhorcado;
private String palabraIngresada;
private char letraIngresada;

    /**
     * Creates a new instance of JuegoFormBean
     */
    public JuegoFormBean() {
        juegoAhorcado = new JuegoAhorcado();
        componenteDeshabilitado = false;
    }
public void empezarJuego(){
        getJuegoAhorcado().empezarJuego(getPalabraIngresada());
        setComponenteDeshabilitado(true);
        
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Juego Iniciado","Que tenga suerte"));
    
}
public void controlarLetra(){
    boolean esLetraEncontrada=getJuegoAhorcado().buscarLetra(getLetraIngresada());
    if (esLetraEncontrada==true){
        if (getJuegoAhorcado().juegoGanado()==true){
            FacesContext context=FacesContext.getCurrentInstance();
            setComponenteDeshabilitado(false);
            setPalabraIngresada(new String());
            setJuegoAhorcado(new JuegoAhorcado());
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"WINNER!","Usted gano el juego"));
                       
                    }
    }else{
        if (getJuegoAhorcado().juegoGanado()==true){
            FacesContext context=FacesContext.getCurrentInstance();
            setComponenteDeshabilitado(false);
            setPalabraIngresada(new String());
            setJuegoAhorcado(new JuegoAhorcado());
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"GAME OVER!","Usted perdio el juego")); 
    }

    }
}
    /**
     * @return the juegoAhorcado
     */
    public JuegoAhorcado getJuegoAhorcado() {
        return juegoAhorcado;

    }
    /**
     * @param juegoAhorcado the juegoAhorcado to set
     */
    public void setJuegoAhorcado(JuegoAhorcado juegoAhorcado) {
        this.juegoAhorcado = juegoAhorcado;
    }

    /**
     * @return the palabraIngresada
     */
    public String getPalabraIngresada() {
        return palabraIngresada;
    }

    /**
     * @param palabraIngresada the palabraIngresada to set
     */
    public void setPalabraIngresada(String palabraIngresada) {
        this.palabraIngresada = palabraIngresada;
    }

    /**
     * @return the letraIngresada
     */
    public char getLetraIngresada() {
        return letraIngresada;
    }

    /**
     * @param letraIngresada the letraIngresada to set
     */
    public void setLetraIngresada(char letraIngresada) {
        this.letraIngresada = letraIngresada;
    }

    /**
     * @return the componenteDeshabilitado
     */
    public boolean isComponenteDeshabilitado() {
        return componenteDeshabilitado;
    }

    /**
     * @param componenteDeshabilitado the componenteDeshabilitado to set
     */
    public void setComponenteDeshabilitado(boolean componenteDeshabilitado) {
        this.componenteDeshabilitado = componenteDeshabilitado;
    }

   
    
}
