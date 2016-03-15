/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Vista.ManipulaEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Silvia Araya J
 */
public class Controlador_VentanaPrincipal implements ActionListener{
    
    private ManipulaEstudiantes manipuladorEstudiantes;
    
    public Controlador_VentanaPrincipal(){
        this.manipuladorEstudiantes = new ManipulaEstudiantes();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Salir")){
            System.exit(0);
        }
        if(e.getActionCommand().equalsIgnoreCase("Manipula Estudiantes")){
            manipuladorEstudiantes.setVisible(true);
        }
    }
    
}
