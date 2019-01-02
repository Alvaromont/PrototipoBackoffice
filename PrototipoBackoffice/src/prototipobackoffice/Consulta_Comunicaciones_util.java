/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;

import java.util.Date;

/**
 *
 * @author jorge.barjola
 */
public class Consulta_Comunicaciones_util {

    private String tipoMensaje;
    private String estadoCruce;
    private String refOrden;
    private String contrapartida;
    private String trn;
    private double importe;
    private String divisa;
    private Date fechaValor;
    private String corresponsalPropio;

    public Consulta_Comunicaciones_util(String tipoMensaje, String estadoCruce, String refOrden, String contrapartida, String trn, double importe, String divisa, Date fechaValor, String corresponsalPropio) {
        this.tipoMensaje = tipoMensaje;
        this.estadoCruce = estadoCruce;
        this.refOrden = refOrden;
        this.contrapartida = contrapartida;
        this.trn = trn;
        this.importe = importe;
        this.divisa = divisa;
        this.fechaValor = fechaValor;
        this.corresponsalPropio = corresponsalPropio;
    }

    
    
    
    
    
    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getEstadoCruce() {
        return estadoCruce;
    }

    public void setEstadoCruce(String estadoCruce) {
        this.estadoCruce = estadoCruce;
    }

    public String getRefOrden() {
        return refOrden;
    }

    public void setRefOrden(String refOrden) {
        this.refOrden = refOrden;
    }

    public String getContrapartida() {
        return contrapartida;
    }

    public void setContrapartida(String contrapartida) {
        this.contrapartida = contrapartida;
    }

    public String getTrn() {
        return trn;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public Date getFechaValor() {
        return fechaValor;
    }

    public void setFechaValor(Date fechaValor) {
        this.fechaValor = fechaValor;
    }

    public String getCorresponsalPropio() {
        return corresponsalPropio;
    }

    public void setCorresponsalPropio(String corresponsalPropio) {
        this.corresponsalPropio = corresponsalPropio;
    }
    
    
    
    

}
