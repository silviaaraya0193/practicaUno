/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Estudiante;
import Modelo.ManejadorRegistros;
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
    private ManejadorRegistros manejo;
    
    public Controlador_Estudiantes(ManipulaEstudiantes manipulaEstudiante) {
        this.manipulaEstudiante = manipulaEstudiante;
        array = new ArrayList();
        manejo = new ManejadorRegistros();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        int codigo = this.manipulaEstudiante.get_CodigoPorFuente(e.getSource());
        switch(codigo){
            case AGREGAR:if(manipulaEstudiante.txtLlenos()){
                if(manejo.verificarEstudiante(manipulaEstudiante.getTxtCarnet())){
                manejo.addEstudiante(manipulaEstudiante.getEstudiante());
                    //System.out.println("agregados: \n"+listaEstudiantes());
                JOptionPane.showMessageDialog(null,"Estudiante Registrado");
                manipulaEstudiante.limpiarCampos();
            } else{
                JOptionPane.showMessageDialog(null,"Error, Estudiante ya Existente");
                manipulaEstudiante.limpiarCampos();
            }
            }
            break;
            case ELIMINAR: if(manipulaEstudiante.txtCarnet()){
               // System.out.println("entra a eliminar carnet lleno");//entra hasta aqui
                if(manejo.verificarEstudiante(manipulaEstudiante.getTxtCarnet())){
                JOptionPane.showMessageDialog(null,"Error, Estudiante No Existente");
                manipulaEstudiante.limpiarCampos();
                //}
            } else {
                manejo.deleteEstudiante(manipulaEstudiante.getTxtCarnet());
                JOptionPane.showMessageDialog(null,"Estudiante Eliminado");
                //System.out.println("lista luego de eliminar: \n"+listaEstudiantes());
                manipulaEstudiante.limpiarCampos();
            }
            }
            break;
            case BUSCAR: if(manipulaEstudiante.txtCarnet()){
                if(manejo.verificarEstudiante(manipulaEstudiante.getTxtCarnet())){
                JOptionPane.showMessageDialog(null,"Estudiante No Existente");
                manipulaEstudiante.limpiarCampos();
             }else{ 
                JOptionPane.showMessageDialog(null,manejo.buscarEstudiante(manipulaEstudiante.getTxtCarnet()));
                //JOptionPane.showMessageDialog(null,listaEstudiantes());
                manipulaEstudiante.limpiarCampos();
            } 
            }
            break;
            case EDITAR: if(manipulaEstudiante.txtCarnet()){
                if(manejo.verificarEstudiante(manipulaEstudiante.getTxtCarnet())){
                JOptionPane.showMessageDialog(null,"Estudiante No Existente");
                manipulaEstudiante.limpiarCampos();
            } else if(manipulaEstudiante.txtCarnet()){
                manejo.editarNombre(JOptionPane.showInputDialog("Digite el nuevo nombre del estudiante: "));
                JOptionPane.showMessageDialog(null,"Nombre Modificado Exitosamente");
                    //System.out.println("lista nombre modificado: "+listaEstudiantes());
                manipulaEstudiante.limpiarCampos();
            }
            }
            break;
            }
    }
    
//    //metodo para agregar estudiantes
//    public void addEstudiante(Estudiante estudiante){
//        array.add(estudiante);
//    }
//    
//    //metodo para eliminar estudiante
//    public void deleteEstudiante(String carnet){
//        for(int i=0; i< array.size(); i++){
//            if(buscarEstudiante(carnet)!= null){
//                array.remove(buscarEstudiante(carnet));
//            }
//        }
//    }
//    
//    //metodo para buscar estudiante
//    public Estudiante buscarEstudiante(String carnet){
//        for(int i=0; i<array.size(); i++){
//            if(array.get(i).getCarnet().equalsIgnoreCase(carnet)){
//                return array.get(i);//el carnet si existe
//            } 
//        }
//        return null;
//    }
//    
//    //metodo para editar estudiante
//    public void editarNombre(String nombreNuevo){
//        for(int i =0; i < array.size(); i++){
//            if(array.get(i).getCarnet().equalsIgnoreCase(manipulaEstudiante.getTxtCarnet())){
//            array.get(i).setNombre(nombreNuevo);
//            }
//        }
//    }
//    
//    //metodo para mostrar lista de estudiante
//    public String listaEstudiantes(){
//        String hilera = "";
//        for(int i =0; i< array.size(); i++){
//            hilera += array.get(i).toString();
//        }
//        return hilera;
//    }
//    
//    public boolean verificarEstudiante(String numero){
//        for (int i =0; i< array.size(); i++) {
//            if(array.get(i).getCarnet().equalsIgnoreCase(numero)){
//                return false;//el carnet es igual
//            }//fin del if
//        }//fin del for
//        return true;//el carnet es diferente
//    }//fin del metodo que verifica si existe el estudiante ya registrado
//    
//   //metodo para consultar estudiante por carnet
//    public String consultarCarnet(String carnet){
//        String estudiante="";
//        for(int i =0; i< array.size(); i++){
//            if(array.get(i).getCarnet().equalsIgnoreCase(carnet)){
//                estudiante = array.get(i).toString();
//            }
//        }
//        return estudiante;
//    }
}
