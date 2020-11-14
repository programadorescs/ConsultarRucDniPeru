package com.pcs.consultarrucdniperu.entidades.apiperudev;

import com.google.gson.annotations.SerializedName;


public class ApiPeruDevData_Ruc {
    @SerializedName("success")
    private String success;
    @SerializedName("data")
    private ApiPeruDev_Ruc data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ApiPeruDev_Ruc getData() {
        return data;
    }

    public void setData(ApiPeruDev_Ruc data) {
        this.data = data;
    }

    public static class ApiPeruDev_Ruc {
        @SerializedName("")
        private String ruc;
        @SerializedName("")
        private String nombre_o_razon_social;
        @SerializedName("")
        private String nombre_comercial;
        @SerializedName("")
        private String estado;
        @SerializedName("")
        private String condicion;
        @SerializedName("")
        private String direccion;
        @SerializedName("")
        private String direccion_completa;

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

        public String getNombre_comercial() {
            return nombre_comercial;
        }

        public void setNombre_comercial(String nombre_comercial) {
            this.nombre_comercial = nombre_comercial;
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

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getDireccion_completa() {
            return direccion_completa;
        }

        public void setDireccion_completa(String direccion_completa) {
            this.direccion_completa = direccion_completa;
        }
    }
}
