package com.backend.crud.dto;

public class EducacionDto {

    private String urlimagen;
    private String titulo;
    private String fecha;
    private String institucion;
    private String descripcion;

    public EducacionDto() {
    }

    public EducacionDto(String urlimagen, String titulo, String fecha, String institucion, String descripcion) {
        this.urlimagen = urlimagen;
        this.titulo = titulo;
        this.fecha = fecha;
        this.institucion = institucion;
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


    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}