package com.pcs.consultarrucdniperu.entidades.apiperudev;


import com.google.gson.annotations.SerializedName;

public class ApiPeruDevData_Dni {

    @SerializedName("success")
    private String success;
    @SerializedName("data")
    private ApiPeruDev_Dni data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ApiPeruDev_Dni getData() {
        return data;
    }

    public void setData(ApiPeruDev_Dni data) {
        this.data = data;
    }

    public static class ApiPeruDev_Dni {
        @SerializedName("numero")
        private String numero;
        @SerializedName("nombre_completo")
        private String nombre_completo;
        @SerializedName("nombres")
        private String nombres;
        @SerializedName("apellido_paterno")
        private String apellido_paterno;
        @SerializedName("apellido_materno")
        private String apellido_materno;
        @SerializedName("codigo_verificacion")
        private String codigo_verificacion;
        @SerializedName("fecha_nacimiento")
        private String fecha_nacimiento;
        @SerializedName("sexo")
        private String sexo;

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public String getNombre_completo() {
            return nombre_completo;
        }

        public void setNombre_completo(String nombre_completo) {
            this.nombre_completo = nombre_completo;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getApellido_paterno() {
            return apellido_paterno;
        }

        public void setApellido_paterno(String apellido_paterno) {
            this.apellido_paterno = apellido_paterno;
        }

        public String getApellido_materno() {
            return apellido_materno;
        }

        public void setApellido_materno(String apellido_materno) {
            this.apellido_materno = apellido_materno;
        }

        public String getCodigo_verificacion() {
            return codigo_verificacion;
        }

        public void setCodigo_verificacion(String codigo_verificacion) {
            this.codigo_verificacion = codigo_verificacion;
        }

        public String getFecha_nacimiento() {
            return fecha_nacimiento;
        }

        public void setFecha_nacimiento(String fecha_nacimiento) {
            this.fecha_nacimiento = fecha_nacimiento;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }
    }
}
