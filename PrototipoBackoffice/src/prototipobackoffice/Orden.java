/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipobackoffice;

import java.util.*;
/**
 *
 * @author alvaro.montero
 */
public class Orden {

    String BIC_Entidad;
    String Ref_Orden;
    String Contrapartida;
    String BIC_Contrapartida;
    String Sentido;
    double Importe;
    String Divisa;
    Date Fecha_Valor;
    String Corresponsal_Propio;
    String Cuenta_Corresponsal_Propio;
    String Corresponsal_Ajeno;
    String Cuenta_Corresponsal_Ajeno;
    String Tipo_Mensaje;

    public Orden(String BIC_Entidad, String Ref_Orden, String Contrapartida, String BIC_Contrapartida, String Sentido, double Importe, String Divisa, Date Fecha_Valor, String Corresponsal_Propio, String Cuenta_Corresponsal_Propio, String Corresponsal_Ajeno, String Cuenta_Corresponsal_Ajeno, String Tipo_Mensaje) {
        this.BIC_Entidad = BIC_Entidad;
        this.Ref_Orden = Ref_Orden;
        this.Contrapartida = Contrapartida;
        this.BIC_Contrapartida = BIC_Contrapartida;
        this.Sentido = Sentido;
        this.Importe = Importe;
        this.Divisa = Divisa;
        this.Fecha_Valor = Fecha_Valor;
        this.Corresponsal_Propio = Corresponsal_Propio;
        this.Cuenta_Corresponsal_Propio = Cuenta_Corresponsal_Propio;
        this.Corresponsal_Ajeno = Corresponsal_Ajeno;
        this.Cuenta_Corresponsal_Ajeno = Cuenta_Corresponsal_Ajeno;
        this.Tipo_Mensaje = Tipo_Mensaje;
    }

    public Orden() {
    }

    public String getBIC_Entidad() {
        return BIC_Entidad;
    }

    public String getRef_Orden() {
        return Ref_Orden;
    }

    public String getContrapartida() {
        return Contrapartida;
    }

    public String getBIC_Contrapartida() {
        return BIC_Contrapartida;
    }

    public String getSentido() {
        return Sentido;
    }

    public double getImporte() {
        return Importe;
    }

    public String getDivisa() {
        return Divisa;
    }

    public Date getFecha_Valor() {
        return Fecha_Valor;
    }

    public String getCorresponsal_Propio() {
        return Corresponsal_Propio;
    }

    public String getCuenta_Corresponsal_Propio() {
        return Cuenta_Corresponsal_Propio;
    }

    public String getCorresponsal_Ajeno() {
        return Corresponsal_Ajeno;
    }

    public String getCuenta_Corresponsal_Ajeno() {
        return Cuenta_Corresponsal_Ajeno;
    }

    public String getTipo_Mensaje() {
        return Tipo_Mensaje;
    }

    public void setBIC_Entidad(String BIC_Entidad) {
        this.BIC_Entidad = BIC_Entidad;
    }

    public void setRef_Orden(String Ref_Orden) {
        this.Ref_Orden = Ref_Orden;
    }

    public void setContrapartida(String Contrapartida) {
        this.Contrapartida = Contrapartida;
    }

    public void setBIC_Contrapartida(String BIC_Contrapartida) {
        this.BIC_Contrapartida = BIC_Contrapartida;
    }

    public void setSentido(String Sentido) {
        this.Sentido = Sentido;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }

    public void setDivisa(String Divisa) {
        this.Divisa = Divisa;
    }

    public void setFecha_Valor(Date Fecha_Valor) {
        this.Fecha_Valor = Fecha_Valor;
    }

    public void setCorresponsal_Propio(String Corresponsal_Propio) {
        this.Corresponsal_Propio = Corresponsal_Propio;
    }

    public void setCuenta_Corresponsal_Propio(String Cuenta_Corresponsal_Propio) {
        this.Cuenta_Corresponsal_Propio = Cuenta_Corresponsal_Propio;
    }

    public void setCorresponsal_Ajeno(String Corresponsal_Ajeno) {
        this.Corresponsal_Ajeno = Corresponsal_Ajeno;
    }

    public void setCuenta_Corresponsal_Ajeno(String Cuenta_Corresponsal_Ajeno) {
        this.Cuenta_Corresponsal_Ajeno = Cuenta_Corresponsal_Ajeno;
    }

    public void setTipo_Mensaje(String Tipo_Mensaje) {
        this.Tipo_Mensaje = Tipo_Mensaje;
    }
    
    
    
    
}
