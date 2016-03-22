/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Vista.ManipulaEstudiantes;
import Vista.VentanaConsulta;
import Vista.VentanaReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Silvia Araya J
 */
public class Controlador_VentanaPrincipal implements ActionListener{
    
    private ManipulaEstudiantes manipuladorEstudiantes;
    private VentanaReportes ventanaReportes;
    private VentanaConsulta ventanaConsulta;
    
    public Controlador_VentanaPrincipal(){
        this.manipuladorEstudiantes = new ManipulaEstudiantes();
        this.ventanaReportes = new VentanaReportes();
        this.ventanaConsulta = new VentanaConsulta();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Salir")){
            System.exit(0);
        }
        if(e.getActionCommand().equalsIgnoreCase("Manipula Estudiantes")){
            manipuladorEstudiantes.setVisible(true);
        }
        if(e.getActionCommand().equalsIgnoreCase("Consulta Estudiantes")){
            ventanaConsulta.setVisible(true);
        }
        if(e.getActionCommand().equalsIgnoreCase("Reporte Estudiantes")){
            ventanaReportes.setVisible(true);
        }
    }
    
}
