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
    
    long id_orden;
    String BIC_Entidad;
    String Ref_Orden;
    String Contrapartida;
    String BIC_Contrapartida;
    String Sentido;
    double Importe;
    String Divisa;
    Date Fecha_Valor;
    Date Fecha_Entrada;
    Date Fecha_Liquidacion;
    String Corresponsal_Propio;
    String Cuenta_Corresponsal_Propio;
    String Corresponsal_Ajeno;
    String Cuenta_Corresponsal_Ajeno;
    String Tipo_Mensaje;
    
    
    String Tipo_Orden;
    int Mensajes_emitidos;
    int Mensajes_recibidos;
    
    
    public Orden() {
    }

    public Orden(long id_orden, String BIC_Entidad, String Ref_Orden, String Contrapartida, String BIC_Contrapartida, String Sentido, double Importe, String Divisa, Date Fecha_Valor, Date Fecha_Entrada, Date Fecha_Liquidacion, String Corresponsal_Propio, String Cuenta_Corresponsal_Propio, String Corresponsal_Ajeno, String Cuenta_Corresponsal_Ajeno, String Tipo_Mensaje) {
        this.id_orden = id_orden;
        this.BIC_Entidad = BIC_Entidad;
        this.Ref_Orden = Ref_Orden;
        this.Contrapartida = Contrapartida;
        this.BIC_Contrapartida = BIC_Contrapartida;
        this.Sentido = Sentido;
        this.Importe = Importe;
        this.Divisa = Divisa;
        this.Fecha_Valor = Fecha_Valor;
        this.Fecha_Entrada = Fecha_Entrada;
        this.Fecha_Liquidacion = Fecha_Liquidacion;
        this.Corresponsal_Propio = Corresponsal_Propio;
        this.Cuenta_Corresponsal_Propio = Cuenta_Corresponsal_Propio;
        this.Corresponsal_Ajeno = Corresponsal_Ajeno;
        this.Cuenta_Corresponsal_Ajeno = Cuenta_Corresponsal_Ajeno;
        this.Tipo_Mensaje = Tipo_Mensaje;
    }

    

    public String getBIC_Entidad() {
        return BIC_Entidad;
    }

    public void setBIC_Entidad(String BIC_Entidad) {
        this.BIC_Entidad = BIC_Entidad;
    }

    public String getRef_Orden() {
        return Ref_Orden;
    }

    public void setRef_Orden(String Ref_Orden) {
        this.Ref_Orden = Ref_Orden;
    }

    public String getContrapartida() {
        return Contrapartida;
    }

    public void setContrapartida(String Contrapartida) {
        this.Contrapartida = Contrapartida;
    }

    public String getBIC_Contrapartida() {
        return BIC_Contrapartida;
    }

    public void setBIC_Contrapartida(String BIC_Contrapartida) {
        this.BIC_Contrapartida = BIC_Contrapartida;
    }

    public String getSentido() {
        return Sentido;
    }

    public void setSentido(String Sentido) {
        this.Sentido = Sentido;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    public String getDivisa() {
        return Divisa;
    }

    public void setDivisa(String Divisa) {
        this.Divisa = Divisa;
    }

    public Date getFecha_Valor() {
        return Fecha_Valor;
    }

    public void setFecha_Valor(Date Fecha_Valor) {
        this.Fecha_Valor = Fecha_Valor;
    }

    public Date getFecha_Entrada() {
        return Fecha_Entrada;
    }

    public void setFecha_Entrada(Date Fecha_Entrada) {
        this.Fecha_Entrada = Fecha_Entrada;
    }

    public Date getFecha_Liquidacion() {
        return Fecha_Liquidacion;
    }

    public void setFecha_Liquidacion(Date Fecha_Liquidacion) {
        this.Fecha_Liquidacion = Fecha_Liquidacion;
    }
    
    public String getCorresponsal_Propio() {
        return Corresponsal_Propio;
    }

    public void setCorresponsal_Propio(String Corresponsal_Propio) {
        this.Corresponsal_Propio = Corresponsal_Propio;
    }

    public String getCuenta_Corresponsal_Propio() {
        return Cuenta_Corresponsal_Propio;
    }

    public void setCuenta_Corresponsal_Propio(String Cuenta_Corresponsal_Propio) {
        this.Cuenta_Corresponsal_Propio = Cuenta_Corresponsal_Propio;
    }

    public String getCorresponsal_Ajeno() {
        return Corresponsal_Ajeno;
    }

    public void setCorresponsal_Ajeno(String Corresponsal_Ajeno) {
        this.Corresponsal_Ajeno = Corresponsal_Ajeno;
    }

    public String getCuenta_Corresponsal_Ajeno() {
        return Cuenta_Corresponsal_Ajeno;
    }

    public void setCuenta_Corresponsal_Ajeno(String Cuenta_Corresponsal_Ajeno) {
        this.Cuenta_Corresponsal_Ajeno = Cuenta_Corresponsal_Ajeno;
    }

    public String getTipo_Mensaje() {
        return Tipo_Mensaje;
    }

    public void setTipo_Mensaje(String Tipo_Mensaje) {
        this.Tipo_Mensaje = Tipo_Mensaje;
    }

    public long getId_orden() {
        return id_orden;
    }

    public void setId_orden(long id_orden) {
        this.id_orden = id_orden;
    }

    public String getTipo_Orden() {
        return Tipo_Orden;
    }

    public void setTipo_Orden(String Tipo_Orden) {
        this.Tipo_Orden = Tipo_Orden;
    }

    

    
    
    @Override
    public String toString() {
        return "Orden{" + "BIC_Entidad=" + BIC_Entidad + ", Ref_Orden=" + Ref_Orden + ", Contrapartida=" + Contrapartida + ", BIC_Contrapartida=" + BIC_Contrapartida + ", Sentido=" + Sentido + ", Importe=" + Importe + ", Divisa=" + Divisa + ", Fecha_Valor=" + Fecha_Valor + ", Corresponsal_Propio=" + Corresponsal_Propio + ", Cuenta_Corresponsal_Propio=" + Cuenta_Corresponsal_Propio + ", Corresponsal_Ajeno=" + Corresponsal_Ajeno + ", Cuenta_Corresponsal_Ajeno=" + Cuenta_Corresponsal_Ajeno + ", Tipo_Mensaje=" + Tipo_Mensaje + '}';
    }

    
    
    
    
}
