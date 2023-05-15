package com.backend.crud.dto;

public class ExperienciaDto {

    private String urlimagen;
    private String titulo;
    private String fecha;
    private String descripcion;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String urlimagen, String titulo, String fecha, String descripcion) {
        this.urlimagen = urlimagen;
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getUrlimagen() {
        return urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
