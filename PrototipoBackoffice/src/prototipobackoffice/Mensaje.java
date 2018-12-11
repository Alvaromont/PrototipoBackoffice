/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;

/**
 *
 * @author jorge.barjola
 */
public class Mensaje {

    private String tipoMensaje;
    private String estadoCruce;
    private String ref_OrdenAsociado;
    private String trn;
    private int recibido_enviado;   // 0 para recibido y 1 para enviado
    private Orden orden;
    private int id_mensaje;

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
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

    public String getRef_OrdenAsociado() {
        return ref_OrdenAsociado;
    }

    public void setRef_OrdenAsociado(String ref_OrdenAsociado) {
        this.ref_OrdenAsociado = ref_OrdenAsociado;
    }

    public String getTrn() {
        return trn;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }

    public int getRecibido_enviado() {
        return recibido_enviado;
    }

    public void setRecibido_enviado(int recibido_enviado) {
        this.recibido_enviado = recibido_enviado;
    }

}
