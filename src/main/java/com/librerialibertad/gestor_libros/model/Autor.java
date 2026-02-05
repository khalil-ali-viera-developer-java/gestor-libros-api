package com.librerialibertad.gestor_libros.model;

import java.time.LocalDate;

public class Autor {

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String pais;

    // CONSTRUCTOR POR DEFECTO;
    public Autor(){
    }

    // CONSTRUCTOR CON PARAMETROS;
    public Autor(String nombre, String apellido, LocalDate fechaNacimiento, String pais){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
    }

    // NOMBRE;
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    // APELLIDO;
    public String getApellido(){
        return this.apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    // FECHA DE NACIMIENTO;
    public LocalDate getFechaNacimiento(){
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    // PAIS;
    public String getPais(){
        return this.pais;
    }

    public void setPais(String pais){
        this.pais = pais;
    }


}
