package com.example.sanchezvictor_u2.Model;

public class Explorador {
    private String nombre;
    private String descripcion;
    private String descripcionres;
    private int    imagenId;
    private String planeta;

    public Explorador(String nombre, String descripcion, int imagenId, String planeta, String descripcionres) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
        this.planeta = planeta;
        this.descripcionres = descripcionres;
    }






    public String getNombre() {return nombre;}
    public String getDescripcion() {return descripcion;}
    public int getImagenId() {return imagenId;}
    public String getPlaneta() {return planeta;}
    public String getDescripcionres() {return descripcionres;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public void setImagenId(int imagenId) {this.imagenId = imagenId;}
    public void setPlaneta(String planeta) {this.planeta = planeta;}
    public void setDescripcionres(String descripcionres) {this.descripcionres = descripcionres;}
}
