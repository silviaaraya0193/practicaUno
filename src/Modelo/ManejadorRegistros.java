/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Vista.ManipulaEstudiantes;
import Vista.VentanaCurso;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Silvia Araya J
 */
public class ManejadorRegistros {
    private ManipulaEstudiantes manipulaEstudiante;
    private ArrayList<Estudiante> array;
    private Estudiante estudiante;
    private VentanaCurso ventana;
    private ArrayList<Curso> arrayCursos;
    private int numEstudiantes;
    
    public ManejadorRegistros() {
        this.manipulaEstudiante = manipulaEstudiante;
        array = new ArrayList<Estudiante>();
        arrayCursos = new ArrayList<Curso>();
        estudiante = new Estudiante();
        numEstudiantes = 0;
        this.ventana = ventana;
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
    //metodos de los cursos, registro, eliminar, modificar, consultar, asignar estudiante a un curso.
    //metodos de las validaciones con las expresiones regulares y el try catch
    //metodo para validar que el curso no haya sido ya registrado
    public boolean verificarCurso(String sigla){
        for(int i=0; i<arrayCursos.size(); i++){
            if(arrayCursos.get(i).getSigla().equalsIgnoreCase(sigla)){
                return false;//el curso ya existe
            }
        }
        return true;//el curso no existe registrado
    }
    public void agregarCursos(Curso curso){
        arrayCursos.add(curso);
    }
    
    //metodo para eliminar curso
    public void eliminarCurso(String sigla){
        for(int i=0;i<arrayCursos.size();i++){
            if(arrayCursos.get(i).getSigla().equalsIgnoreCase(sigla)){
                arrayCursos.remove(buscarCurso(sigla));
            }
        }
    }
    //metodo para buscar curso
    public Curso buscarCurso(String sigla){
        for(int i=0; i<arrayCursos.size(); i++){
            if(arrayCursos.get(i).getSigla().equalsIgnoreCase(sigla)){
                return arrayCursos.get(i);//el curso si existe
            } 
        }
        return null;
    }
    //metodo para modificar un curso
    public void modificarCurso(String sigla, String nombre){
        for(int i=0;i<arrayCursos.size(); i++){
                arrayCursos.get(i).setSigla(sigla);
                arrayCursos.get(i).setNombre(nombre);
        }
    }
    //metodo para la consulta de un curso
    public String consultarCurso(){
        String datos="";
       // if(verificarCurso(ventana.getTxt_Sigla())){
            for(int i=0;i<arrayCursos.size();i++){
                datos = arrayCursos.get(i).toString();
           // }
        }
        return datos;
    }
    public Curso asignarCurso(Curso e){
        if(numEstudiantes < 25){
            for(int i =0; i<arrayCursos.size();i++){
                arrayCursos.get(i).setCurso(e);
                numEstudiantes++;
            }
    } return null;
    }
}
