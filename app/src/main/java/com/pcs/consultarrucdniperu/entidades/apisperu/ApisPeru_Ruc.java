package com.pcs.consultarrucdniperu.entidades.apisperu;

import com.google.gson.annotations.SerializedName;

public class ApisPeru_Ruc {
    @SerializedName("ruc")
    private String ruc;
    @SerializedName("razonSocial")
    private String razonSocial;
    @SerializedName("nombreComercial")
    private String nombreComercial;
    @SerializedName("direccion")
    private String direccion;
    @SerializedName("estado")
    private String estado;
    @SerializedName("condicion")
    private String condicion;
    @SerializedName("departamento")
    private String departamento;
    @SerializedName("provincia")
    private String provincia;
    @SerializedName("distrito")
    private String distrito;
    @SerializedName("profesion")
    private String profesion;

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDireccionCompleta() {
        return direccion  + " " + departamento + " " + provincia + " " + distrito;
     }
}
