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
public class Estudiante {
    private String nombre;
    private String carnet;
    private String email;
    
    public Estudiante(String nombre, String carne, String mail){
        this.nombre = nombre;
        carnet = carne;
        email = mail;   
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Estudiante: \n" + "Name:" + nombre + ", Carnet: " + carnet + ", E-mail: " + email + "\n";
    }
    
}
