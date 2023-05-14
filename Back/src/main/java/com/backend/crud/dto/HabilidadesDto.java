package com.backend.crud.dto;

public class HabilidadesDto {
    private String urlimagen;
    private String nombre;
    private String descripcion;
    private float porcentaje;

    public HabilidadesDto() {
    }

    public HabilidadesDto(String urlimagen, String nombre, String descripcion, float porcentaje) {
        this.urlimagen = urlimagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
    }

    public String getUrlimagen() { return urlimagen; }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) { this.porcentaje = porcentaje; }
}

