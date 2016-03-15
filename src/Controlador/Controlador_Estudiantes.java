/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Estudiante;
import Vista.ManipulaEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Silvia Araya J
 */
public class Controlador_Estudiantes implements ActionListener{
    
    public static final int CARNET = 1;
    public static final int NOMBRE = 2;
    public static final int CORREO = 3;
    public static final int AGREGAR = 4;
    public static final int BUSCAR = 5;
    public static final int EDITAR = 6;
    public static final int ELIMINAR = 7;
    private ManipulaEstudiantes manipulaEstudiante;
    private ArrayList<Estudiante> array;
    
    public Controlador_Estudiantes(ManipulaEstudiantes manipulaEstudiante) {
        this.manipulaEstudiante = manipulaEstudiante;
        array = new ArrayList();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        int codigo = this.manipulaEstudiante.get_CodigoPorFuente(e.getSource());
        switch(codigo){
            case AGREGAR: if(verificarEstudiante(manipulaEstudiante.getTxtCarnet())){
                addEstudiante(manipulaEstudiante.getEstudiante());
                JOptionPane.showMessageDialog(null,"Estudiante Registrado");
            } else{
                JOptionPane.showMessageDialog(null,"Error, Estudiante ya Existente");
            }
            break;
            case ELIMINAR: if(verificarEstudiante(manipulaEstudiante.getTxtCarnet())){
                JOptionPane.showMessageDialog(null,"Error, Estudiante No Existente");
            } else{
                deleteEstudiante(manipulaEstudiante.getTxtCarnet());
                JOptionPane.showMessageDialog(null,"Estudiante Eliminado");
            }
            break;
            case BUSCAR: if(verificarEstudiante(manipulaEstudiante.getTxtCarnet())){
                JOptionPane.showMessageDialog(null,"Estudiante No Existente");
            } else{
                JOptionPane.showMessageDialog(null,buscarEstudiante(manipulaEstudiante.getTxtCarnet()));
                JOptionPane.showMessageDialog(null,listaEstudiantes());
            }
            break;
            case EDITAR: if(verificarEstudiante(manipulaEstudiante.getTxtCarnet())){
                JOptionPane.showMessageDialog(null,"Estudiante No Existente");
            } else{
                editarNombre(JOptionPane.showInputDialog("Digite el nuevo nombre del estudiante: "));
                JOptionPane.showMessageDialog(null,"Nombre Modificado Exitosamente");
            }
            break;
            }
    }
    
    //metodo para agregar estudiantes
    public void addEstudiante(Estudiante estudiante){
        array.add(estudiante);
    }
    
    //metodo para eliminar estudiante
    public void deleteEstudiante(String carnet){
        for(int i=0; i< array.size(); i++){
            if(buscarEstudiante(carnet)!= null){
                array.remove(buscarEstudiante(carnet));
            }
        }
    }
    
    //metodo para buscar estudiante
    public Estudiante buscarEstudiante(String carnet){
        for(int i=0; i<array.size(); i++){
            if(array.get(i).getCarnet().equalsIgnoreCase(carnet)){
                return array.get(i);//el carnet si existe
            } 
        }
        return null;
    }
    
    //metodo para editar estudiante
    public void editarNombre(String nombreNuevo){
        for(int i =0; i < array.size(); i++){
            array.get(i).setNombre(nombreNuevo);
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
    
   
}
