package com.pcs.consultarrucdniperu.entidades.migoapi;


import com.google.gson.annotations.SerializedName;

public class MigoApiResult {
    @SerializedName("success")
    private String success;
    @SerializedName("ruc")
    private String ruc;
    @SerializedName("nombre_o_razon_social")
    private String nombre_o_razon_social;
    @SerializedName("estado_del_contribuyente")
    private String estado_del_contribuyente;
    @SerializedName("condicion_de_domicilio")
    private String condicion_de_domicilio;
    @SerializedName("ubigeo")
    private String ubigeo;
    @SerializedName("tipo_de_via")
    private String tipo_de_via;
    @SerializedName("nombre_de_via")
    private String nombre_de_via;
    @SerializedName("codigo_de_zona")
    private String codigo_de_zona;
    @SerializedName("tipo_de_zona")
    private String tipo_de_zona;
    @SerializedName("numero")
    private String numero;
    @SerializedName("interior")
    private String interior;
    @SerializedName("lote")
    private String lote;
    @SerializedName("dpto")
    private String dpto;
    @SerializedName("manzana")
    private String manzana;
    @SerializedName("kilometro")
    private String kilometro;
    @SerializedName("distrito")
    private String distrito;
    @SerializedName("provincia")
    private String provincia;
    @SerializedName("departamento")
    private String departamento;
    @SerializedName("direccion")
    private String direccion;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre_o_razon_social() {
        return nombre_o_razon_social;
    }

    public void setNombre_o_razon_social(String nombre_o_razon_social) {
        this.nombre_o_razon_social = nombre_o_razon_social;
    }

    public String getEstado_del_contribuyente() {
        return estado_del_contribuyente;
    }

    public void setEstado_del_contribuyente(String estado_del_contribuyente) {
        this.estado_del_contribuyente = estado_del_contribuyente;
    }

    public String getCondicion_de_domicilio() {
        return condicion_de_domicilio;
    }

    public void setCondicion_de_domicilio(String condicion_de_domicilio) {
        this.condicion_de_domicilio = condicion_de_domicilio;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getTipo_de_via() {
        return tipo_de_via;
    }

    public void setTipo_de_via(String tipo_de_via) {
        this.tipo_de_via = tipo_de_via;
    }

    public String getNombre_de_via() {
        return nombre_de_via;
    }

    public void setNombre_de_via(String nombre_de_via) {
        this.nombre_de_via = nombre_de_via;
    }

    public String getCodigo_de_zona() {
        return codigo_de_zona;
    }

    public void setCodigo_de_zona(String codigo_de_zona) {
        this.codigo_de_zona = codigo_de_zona;
    }

    public String getTipo_de_zona() {
        return tipo_de_zona;
    }

    public void setTipo_de_zona(String tipo_de_zona) {
        this.tipo_de_zona = tipo_de_zona;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public String getKilometro() {
        return kilometro;
    }

    public void setKilometro(String kilometro) {
        this.kilometro = kilometro;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
