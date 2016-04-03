/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Silvia Araya J
 */
public class Curso {
    private String nombre;
    private String sigla;
    private int creditos;
    private int numEstudiantes;
    private Estudiante estudiante;
    private Curso curso;
    
    public Curso(String nombre, String sigla, int creditos) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.creditos = creditos;
        estudiante = new Estudiante();
    }

    public Curso() {
    }
    public Curso(String nombre, String sigla) {
        this.nombre = nombre;
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getNumEstudiantes() {
        return numEstudiantes;
    }

    public void setNumEstudiantes(int numEstudiantes) {
        this.numEstudiantes = numEstudiantes;
    }
    
    @Override
    public String toString() {
        return "Curso:\n" + "Nombre:" + nombre + "\nSigla:" + sigla + "\nCreditos:" + creditos + "\n";
    }
    public Curso getCurso(){
        return curso;
    }
    public void setCurso(Curso curso){
        this.curso = curso;
    }
}
