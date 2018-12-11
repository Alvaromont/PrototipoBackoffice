/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;

import java.util.Date;

/**
 *
 * @author alvaro.montero
 */
public class Orden {

    String Tipo_Orden;
    String ref_Orden;
    String contrapartida;
    String sentido;
    double importe;
    String divisa;
    Date fecha_Entrada;
    Date fecha_Valor;
    Date fecha_Liquidacion;
    Date fecha_liberacion;
    String estado = "No liberada";
    String corresponsal_Propio;
    String cuenta_Corresponsal_Propio;
    int id_orden;
    String bic_Entidad;
    String bic_Contrapartida;
    String corresponsal_Ajeno;
    String cuenta_Corresponsal_Ajeno;
    String tipo_Mensaje;

    int Mensajes_emitidos;
    int Mensajes_recibidos;

    public Orden() {
    }

    public Orden(String Tipo_Orden, String ref_Orden, String contrapartida, String sentido, double importe, String divisa, Date fecha_Entrada, Date fecha_Valor, Date fecha_Liquidacion, Date fecha_liberacion, String corresponsal_Propio, String cuenta_Corresponsal_Propio, int id_orden, String bic_Entidad, String bic_Contrapartida, String corresponsal_Ajeno, String cuenta_Corresponsal_Ajeno, String tipo_Mensaje) {
        this.Tipo_Orden = Tipo_Orden;
        this.ref_Orden = ref_Orden;
        this.contrapartida = contrapartida;
        this.sentido = sentido;
        this.importe = importe;
        this.divisa = divisa;
        this.fecha_Entrada = fecha_Entrada;
        this.fecha_Valor = fecha_Valor;
        this.fecha_Liquidacion = fecha_Liquidacion;
        this.fecha_liberacion = fecha_liberacion;
        this.corresponsal_Propio = corresponsal_Propio;
        this.cuenta_Corresponsal_Propio = cuenta_Corresponsal_Propio;
        this.id_orden = id_orden;
        this.bic_Entidad = bic_Entidad;
        this.bic_Contrapartida = bic_Contrapartida;
        this.corresponsal_Ajeno = corresponsal_Ajeno;
        this.cuenta_Corresponsal_Ajeno = cuenta_Corresponsal_Ajeno;
        this.tipo_Mensaje = tipo_Mensaje;
        this.Mensajes_emitidos = Mensajes_emitidos;
        this.Mensajes_recibidos = Mensajes_recibidos;
    }

    Orden(String bic_Entidad, String tipo_Orden, String ref_Orden, String contrapartida, String sentido, double importe, String divisa, Date fecha_Entrada, Date fecha_Valor, Date fecha_Liquidacion, Date fecha_liberacion, String corresponsal_Propio, String cuenta_Corresponsal_Propio, String bic_Contrapartida, String corresponsal_Ajeno, String cuenta_Corresponsal_Ajeno, String tipo_Mensaje) {
        this.ref_Orden = ref_Orden;
        this.bic_Entidad = bic_Entidad;
        this.contrapartida = contrapartida;
        this.sentido = sentido;
        this.importe = importe;
        this.divisa = divisa;
        this.fecha_Entrada = fecha_Entrada;
        this.fecha_Valor = fecha_Valor;
        this.fecha_Liquidacion = fecha_Liquidacion;
        this.fecha_liberacion = fecha_liberacion;
        this.corresponsal_Propio = corresponsal_Propio;
        this.cuenta_Corresponsal_Propio = cuenta_Corresponsal_Propio;
        this.bic_Contrapartida = bic_Contrapartida;
        this.corresponsal_Ajeno = corresponsal_Ajeno;
        this.cuenta_Corresponsal_Ajeno = cuenta_Corresponsal_Ajeno;
        this.tipo_Mensaje = tipo_Mensaje;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public String getBic_Entidad() {
        return bic_Entidad;
    }

    public void setBic_Entidad(String bic_Entidad) {
        this.bic_Entidad = bic_Entidad;
    }

    public String getRef_Orden() {
        return ref_Orden;
    }

    public void setRef_Orden(String ref_Orden) {
        this.ref_Orden = ref_Orden;
    }

    public String getContrapartida() {
        return contrapartida;
    }

    public void setContrapartida(String contrapartida) {
        this.contrapartida = contrapartida;
    }

    public String getBic_Contrapartida() {
        return bic_Contrapartida;
    }

    public void setBic_Contrapartida(String bic_Contrapartida) {
        this.bic_Contrapartida = bic_Contrapartida;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
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

    public Date getFecha_Valor() {
        return fecha_Valor;
    }

    public void setFecha_Valor(Date fecha_Valor) {
        this.fecha_Valor = fecha_Valor;
    }

    public Date getFecha_Entrada() {
        return fecha_Entrada;
    }

    public void setFecha_Entrada(Date fecha_Entrada) {
        this.fecha_Entrada = fecha_Entrada;
    }

    public Date getFecha_Liquidacion() {
        return fecha_Liquidacion;
    }

    public void setFecha_Liquidacion(Date fecha_Liquidacion) {
        this.fecha_Liquidacion = fecha_Liquidacion;
    }

    public Date getFecha_liberacion() {
        return fecha_liberacion;
    }

    public void setFecha_liberacion(Date fecha_liberacion) {
        this.fecha_liberacion = fecha_liberacion;
    }

    public String getCorresponsal_Propio() {
        return corresponsal_Propio;
    }

    public void setCorresponsal_Propio(String corresponsal_Propio) {
        this.corresponsal_Propio = corresponsal_Propio;
    }

    public String getCuenta_Corresponsal_Propio() {
        return cuenta_Corresponsal_Propio;
    }

    public void setCuenta_Corresponsal_Propio(String cuenta_Corresponsal_Propio) {
        this.cuenta_Corresponsal_Propio = cuenta_Corresponsal_Propio;
    }

    public String getCorresponsal_Ajeno() {
        return corresponsal_Ajeno;
    }

    public void setCorresponsal_Ajeno(String corresponsal_Ajeno) {
        this.corresponsal_Ajeno = corresponsal_Ajeno;
    }

    public String getCuenta_Corresponsal_Ajeno() {
        return cuenta_Corresponsal_Ajeno;
    }

    public void setCuenta_Corresponsal_Ajeno(String cuenta_Corresponsal_Ajeno) {
        this.cuenta_Corresponsal_Ajeno = cuenta_Corresponsal_Ajeno;
    }

    public String getTipo_Mensaje() {
        return tipo_Mensaje;
    }

    public void setTipo_Mensaje(String tipo_Mensaje) {
        this.tipo_Mensaje = tipo_Mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_Orden() {
        return Tipo_Orden;
    }

    public void setTipo_Orden(String Tipo_Orden) {
        this.Tipo_Orden = Tipo_Orden;
    }

    public int getMensajes_emitidos() {
        return Mensajes_emitidos;
    }

    public void setMensajes_emitidos(int Mensajes_emitidos) {
        this.Mensajes_emitidos = Mensajes_emitidos;
    }

    public int getMensajes_recibidos() {
        return Mensajes_recibidos;
    }

    public void setMensajes_recibidos(int Mensajes_recibidos) {
        this.Mensajes_recibidos = Mensajes_recibidos;
    }

    @Override
    public String toString() {
        return "Orden{" + "id_orden=" + id_orden + ", bic_Entidad=" + bic_Entidad + ", ref_Orden=" + ref_Orden + ", contrapartida=" + contrapartida + ", bic_Contrapartida=" + bic_Contrapartida + ", sentido=" + sentido + ", importe=" + importe + ", divisa=" + divisa + ", fecha_Valor=" + fecha_Valor + ", fecha_Entrada=" + fecha_Entrada + ", fecha_Liquidacion=" + fecha_Liquidacion + ", fecha_liberacion=" + fecha_liberacion + ", corresponsal_Propio=" + corresponsal_Propio + ", cuenta_Corresponsal_Propio=" + cuenta_Corresponsal_Propio + ", corresponsal_Ajeno=" + corresponsal_Ajeno + ", cuenta_Corresponsal_Ajeno=" + cuenta_Corresponsal_Ajeno + ", tipo_Mensaje=" + tipo_Mensaje + ", estado=" + estado + ", Tipo_Orden=" + Tipo_Orden + ", Mensajes_emitidos=" + Mensajes_emitidos + ", Mensajes_recibidos=" + Mensajes_recibidos + '}';
    }

}
