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
    private String bic_entidad;
    private String bic_corresponsal_propio;
    private String MUR;

    private String campo21, campo32A, campo53A, campo57A, campo23B, campo23E, campo50A,
                      campo2, campo59A, campo71A, campo56D, campo72, campo25, sentido;

    public Mensaje(String bic_entidad, String MUR) {
        this.bic_entidad = bic_entidad;
        this.MUR = MUR;
    }

    
    
    
    
    public String getMUR() {
        return MUR;
    }

    public void setMUR(String MUR) {
        this.MUR = MUR;
    }

    public String getBic_entidad() {
        return bic_entidad;
    }

    public void setBic_entidad(String bic_entidad) {
        this.bic_entidad = bic_entidad;
    }

    public String getBic_corresponsal_propio() {
        return bic_corresponsal_propio;
    }

    public void setBic_corresponsal_propio(String bic_corresponsal_propio) {
        this.bic_corresponsal_propio = bic_corresponsal_propio;
    }

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

    public String getCampo21() {
        return campo21;
    }

    public void setCampo21(String campo21) {
        this.campo21 = campo21;
    }

    public String getCampo32A() {
        return campo32A;
    }

    public void setCampo32A(String campo32A) {
        this.campo32A = campo32A;
    }

    public String getCampo53A() {
        return campo53A;
    }

    public void setCampo53A(String campo53A) {
        this.campo53A = campo53A;
    }

    public String getCampo57A() {
        return campo57A;
    }

    public void setCampo57A(String campo57A) {
        this.campo57A = campo57A;
    }

    public String getCampo23B() {
        return campo23B;
    }

    public void setCampo23B(String campo23B) {
        this.campo23B = campo23B;
    }

    public String getCampo23E() {
        return campo23E;
    }

    public void setCampo23E(String campo23E) {
        this.campo23E = campo23E;
    }

    public String getCampo50A() {
        return campo50A;
    }

    public void setCampo50A(String campo50A) {
        this.campo50A = campo50A;
    }

    public String getCampo59A() {
        return campo59A;
    }

    public void setCampo59A(String campo59A) {
        this.campo59A = campo59A;
    }

    public String getCampo71A() {
        return campo71A;
    }

    public void setCampo71A(String campo71A) {
        this.campo71A = campo71A;
    }

    public String getCampo56D() {
        return campo56D;
    }

    public void setCampo56D(String campo56D) {
        this.campo56D = campo56D;
    }

    public String getCampo72() {
        return campo72;
    }

    public void setCampo72(String campo72) {
        this.campo72 = campo72;
    }

    public String getCampo25() {
        return campo25;
    }

    public void setCampo25(String campo25) {
        this.campo25 = campo25;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

}
