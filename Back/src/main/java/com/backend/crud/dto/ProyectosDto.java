package com.backend.crud.dto;
public class ProyectosDto {
    private String urlimagen;
    private String nombre;
    private String descripcion;
    private String urlproyecto;

    public ProyectosDto() {
    }

    public ProyectosDto(String urlimagen, String nombre, String descripcion, String urlproyecto) {
        this.urlimagen = urlimagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlproyecto = urlproyecto;
    }

    public String getUrlimagen() { return urlimagen; }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlproyecto() { return urlproyecto; }

    public void setUrlproyecto(String urlproyecto) {
        this.urlproyecto = urlproyecto;
    }

}

