/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;


import Modelo.Curso;
import Modelo.ManejadorRegistros;
import Vista.VentanaCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Silvia Araya J
 */
public class Controlador_Cursos implements ActionListener{
    private VentanaCurso ventanaCurso;
    private ManejadorRegistros manejoCurso;
    public static final int CREDITOS = 1;
    public static final int NOMBRE = 2;
    public static final int SIGLA = 3;
    public static final int AGREGAR = 4;
    public static final int MODIFICAR = 5;
    public static final int CONSULTAR = 6;
    public static final int ELIMINAR = 7;
    public static final int ASIGNAR = 8;
    public Controlador_Cursos(VentanaCurso ventanaCurso){
        this.ventanaCurso = ventanaCurso;
        manejoCurso = new ManejadorRegistros();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int codigo = this.ventanaCurso.get_CodigoPorFuente(e.getSource());
        switch(codigo){
            case AGREGAR: if(ventanaCurso.txtLlenos()){
                if(manejoCurso.verificarCurso(ventanaCurso.getTxt_Sigla())){
                    manejoCurso.agregarCursos(ventanaCurso.getCurso());
                    JOptionPane.showMessageDialog(null, "Curso Registrado Exitosamente");
                    ventanaCurso.limpiarCampos();
                } else{
                    JOptionPane.showMessageDialog(null, "Error, Curso Existente");
                    ventanaCurso.limpiarCampos();
                }
            }
                break;
            case ELIMINAR: if(ventanaCurso.txtSigla()){
                if(manejoCurso.verificarCurso(ventanaCurso.getTxt_Sigla())){
                JOptionPane.showMessageDialog(null, "Error, el curso no existe");
                ventanaCurso.limpiarCampos();
            } else{
                manejoCurso.eliminarCurso(ventanaCurso.getTxt_Sigla());
                JOptionPane.showMessageDialog(null, "Curso eliminado Exitosamente");
               
                ventanaCurso.limpiarCampos();
            }
            }
                break;
            case MODIFICAR: if(ventanaCurso.txtSigla()){
                if(manejoCurso.verificarCurso(ventanaCurso.getTxt_Sigla())){
                    JOptionPane.showMessageDialog(null, "Error, el curso no existe");
                    ventanaCurso.limpiarCampos();
                } else{
                    if(ventanaCurso.txtSigla()){
                   // JOptionPane.showInputDialog("Digite la sigla del curso que desea modificar");
                    JOptionPane.showMessageDialog(null,manejoCurso.buscarCurso(ventanaCurso.getTxt_Sigla()));
                    manejoCurso.modificarCurso(JOptionPane.showInputDialog("Digite la nueva sigla del curso"),JOptionPane.showInputDialog("Digite el nuevo nombre del curso"));
                    JOptionPane.showMessageDialog(null, "Datos modificados existosamente");
                    ventanaCurso.limpiarCampos();
                }
                }
            }
                break;
            case ASIGNAR:String curso="";
            String nombre = "";
            curso = JOptionPane.showInputDialog("Digite la sigla del curso que sea matricular");
            nombre = JOptionPane.showInputDialog("Digite el nombre del estudiante");
                      if(manejoCurso.verificarCurso(curso)){
                          JOptionPane.showMessageDialog(null,"Error, curso no exitente, o ya esta lleno");
                          ventanaCurso.limpiarCampos();
                      } else{
                           manejoCurso.asignarCurso(new Curso(curso, nombre));
                          JOptionPane.showMessageDialog(null,"Curso asignado");
                          
                      }
                break;
            case CONSULTAR:
            if(manejoCurso.verificarCurso(ventanaCurso.getTxt_Sigla())){
                 JOptionPane.showMessageDialog(null,"Error, el curso solicitado no existe");
                ventanaCurso.limpiarCampos();
            } else{
                 JOptionPane.showMessageDialog(null,manejoCurso.consultarCurso());
                 ventanaCurso.limpiarCampos();
            }
                break;
                
        }
        }
    
}
