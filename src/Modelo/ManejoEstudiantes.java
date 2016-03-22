/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Vista.ManipulaEstudiantes;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Silvia Araya J
 */
public class ManejoEstudiantes {
    private ManipulaEstudiantes manipulaEstudiante;
    private ArrayList<Estudiante> array;
    private Estudiante estudiante;
    
    public ManejoEstudiantes(ManipulaEstudiantes manipulaEstudiante) {
        this.manipulaEstudiante = manipulaEstudiante;
        array = new ArrayList();
        estudiante = new Estudiante();
    }
    
    //metodo para agregar estudiantes
    public void addEstudiante(Estudiante estudiante){
        try{
            verificarNombre(estudiante);
            verificarCarnet(estudiante);
            verificarCorreo(estudiante);
             array.add(estudiante);
        }catch(MyException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    //metodo para eliminar estudiante
    public void deleteEstudiante(String carnet){
        try{
            verificarCarnet(estudiante);
        for(int i=0; i< array.size(); i++){
            if(buscarEstudiante(carnet)!= null){
                array.remove(buscarEstudiante(carnet));
            }
        }
        }catch(MyException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    //metodo para buscar estudiante
    public Estudiante buscarEstudiante(String carnet){
        try{
            validarCarnet(carnet);
        for(int i=0; i<array.size(); i++){
            if(array.get(i).getCarnet().equalsIgnoreCase(carnet)){
                return array.get(i);//el carnet si existe
            } 
        }
        }catch(MyException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    //metodo para editar estudiante
    public void editarNombre(String nombreNuevo){
        try{
            validarNombre(nombreNuevo);
        for(int i =0; i < array.size(); i++){
            if(array.get(i).getCarnet().equalsIgnoreCase(manipulaEstudiante.getTxtCarnet())){
            array.get(i).setNombre(nombreNuevo);
            }
        }
        }catch(MyException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    //metodo para mostrar lista de estudiante
    public String listaEstudiantes(){
        String hilera = "";
        for(int i =0; i< array.size(); i++){
            hilera += array.get(i).toString();
        }
        return hilera;
    }
    
    public boolean verificarEstudiante(String numero){
        for (int i =0; i< array.size(); i++) {
            if(array.get(i).getCarnet().equalsIgnoreCase(numero)){
                return false;//el carnet es igual
            }//fin del if
        }//fin del for
        return true;//el carnet es diferente
    }//fin del metodo que verifica si existe el estudiante ya registrado
    
   //metodo para consultar estudiante por carnet
    public String consultarCarnet(String carnet){
        String estudiante="";
        try{
            validarCarnet(carnet);
        for(int i =0; i< array.size(); i++){
            if(array.get(i).getCarnet().equalsIgnoreCase(carnet)){
                estudiante = array.get(i).toString();
            }
        }
        }catch(MyException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return estudiante;
    }
    
    //metodo para el reporte de estudiantes
    public String[][] reportes(){
        String datos[][] = new String[array.size()][3];
        for(int i=0; i<array.size();i++){
            datos[i][0] = array.get(i).getNombre();
            datos[i][1] = array.get(i).getCarnet();
            datos[i][2] = array.get(i).getEmail();
            System.out.println("datos"+datos);
        }
        return datos;
        
    }
    
    //metodo para verificar el nombre
    public void verificarNombre(Estudiante nombre) throws MyException{
        Pattern pat = Pattern.compile("[A-Za-z]");
        Matcher mat = pat.matcher(nombre.getNombre());
        if(mat.find()){
           nombre.setNombre(nombre.getNombre());
        } else{
            throw new MyException("Error en el nombre");
        }
    }
    
    //metodo para verificar el carnet
    public void verificarCarnet(Estudiante carnet) throws MyException{
        Pattern pat = Pattern.compile("[^\\d]+[0-9]{5,6}");
        Matcher mat = pat.matcher(carnet.getCarnet());
        if(mat.find()){
            carnet.setCarnet(carnet.getCarnet());
        }else{
            throw new MyException("Error en el carnet");
        }
    }
    
    //metodo para verificar el correo
    public void verificarCorreo(Estudiante correo) throws MyException{
        Pattern pat = Pattern.compile("^[\\\\w-]+(\\\\.[\\\\w-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(correo.getEmail());
        if(mat.find()){
            correo.setEmail(correo.getEmail());
        }else{
            throw new MyException("Error en el correo");
        }
    }
    //metodo para verificar el carnet
    public void validarCarnet(String carnet) throws MyException{
        Pattern pat = Pattern.compile("[^\\d]+[0-9]{5,6}");
        Matcher mat = pat.matcher(carnet);
        if(mat.find()){
            System.out.println("Valido");
        }else{
            throw new MyException("Error en el carnet");
        }
    }
    
    //metodo para validar el cambio de nombre
    public void validarNombre(String nombre) throws MyException{
        Pattern pat = Pattern.compile("[A-Za-z]");
        Matcher mat = pat.matcher(nombre);
        if(mat.find()){
            System.out.println("Valido");
        }else{
            throw new MyException("Error en el nombre");
        }
    }
}
