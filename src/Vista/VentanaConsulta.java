/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

/**
 *
 * @author Silvia Araya J
 */
public class VentanaConsulta extends javax.swing.JFrame {

    /**
     * Creates new form VentanaConsulta
     */
    public VentanaConsulta() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbl_indicacion = new javax.swing.JLabel();
        txt_consulta = new javax.swing.JTextField();
        btn_consultarCarnet = new javax.swing.JButton();
        btn_ConsultaTodo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Consulta De Estudiantes");

        lbl_indicacion.setText("Digite el numero de carnet que desea consultar:");

        txt_consulta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btn_consultarCarnet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_consultarCarnet.setText("Consultar Por Carnet");
        btn_consultarCarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarCarnetActionPerformed(evt);
            }
        });

        btn_ConsultaTodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ConsultaTodo.setText("Consultar Todos Estudiantes");
        btn_ConsultaTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultaTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_indicacion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(txt_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btn_consultarCarnet))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btn_ConsultaTodo)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(lbl_indicacion)
                .addGap(18, 18, 18)
                .addComponent(txt_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_consultarCarnet)
                .addGap(37, 37, 37)
                .addComponent(btn_ConsultaTodo)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_consultarCarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarCarnetActionPerformed
       if(evt.getSource() == btn_consultarCarnet){
           VentanaConsultaCarnet carnet = new VentanaConsultaCarnet();
           this.setVisible(false);
           carnet.setVisible(true);
       }
    }//GEN-LAST:event_btn_consultarCarnetActionPerformed

    private void btn_ConsultaTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultaTodoActionPerformed
       if(evt.getSource() == btn_ConsultaTodo){
           VentanaConsultaTodo carnet = new VentanaConsultaTodo();
           this.setVisible(false);
           carnet.setVisible(true);
       }
    }//GEN-LAST:event_btn_ConsultaTodoActionPerformed
    public String getTxtCarnet(){
        String numero = txt_consulta.getText();
        return numero;
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsultaTodo;
    private javax.swing.JButton btn_consultarCarnet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_indicacion;
    private javax.swing.JTextField txt_consulta;
    // End of variables declaration//GEN-END:variables
}
