/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIEmployee;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author user-ubunto
 */
public class fNewStore extends javax.swing.JFrame {

    /**
     * Creates new form fNewStore
     */
    public fNewStore() {
        initComponents();
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
        ButtonSave = new javax.swing.JButton();
        LabelStore = new javax.swing.JLabel();
        TextFieldName = new javax.swing.JTextField();
        LabelAddress = new javax.swing.JLabel();
        TextFieldAddress = new javax.swing.JTextField();
        LabelCode = new javax.swing.JLabel();
        TextFieldCode = new javax.swing.JTextField();
        LabelEMail = new javax.swing.JLabel();
        TextFieldEMail = new javax.swing.JTextField();
        LabelPhone1 = new javax.swing.JLabel();
        TextFieldPhone1 = new javax.swing.JTextField();
        LabelPhone2 = new javax.swing.JLabel();
        TextFieldPhone2 = new javax.swing.JTextField();
        LabelShedule = new javax.swing.JLabel();
        TextFieldShedule = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nueva Tienda");

        ButtonSave.setText("Guardar Tienda");
        ButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveActionPerformed(evt);
            }
        });

        LabelStore.setText("Nombre de la Tienda*");
        LabelStore.setOpaque(true);

        LabelAddress.setText("Direccion*");
        LabelAddress.setOpaque(true);

        LabelCode.setText("Codigo*");
        LabelCode.setOpaque(true);

        LabelEMail.setText("E-Mail");
        LabelEMail.setOpaque(true);

        LabelPhone1.setText("Telefono 1*");
        LabelPhone1.setOpaque(true);

        TextFieldPhone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldPhone1KeyTyped(evt);
            }
        });

        LabelPhone2.setText("Telefono 2");
        LabelPhone2.setOpaque(true);

        TextFieldPhone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldPhone2KeyTyped(evt);
            }
        });

        LabelShedule.setText("Horario");
        LabelShedule.setOpaque(true);

        jLabel9.setText("* Campos Obligatorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFieldName)
                            .addComponent(LabelStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelEMail)
                            .addComponent(LabelCode)
                            .addComponent(LabelAddress)
                            .addComponent(TextFieldAddress)
                            .addComponent(TextFieldCode)
                            .addComponent(TextFieldEMail))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ButtonSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(TextFieldShedule, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFieldPhone2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelPhone1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFieldPhone1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap(22, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelPhone2)
                                    .addComponent(LabelShedule))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelStore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(LabelPhone1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelPhone2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelShedule)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldShedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelEMail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSaveActionPerformed
        if (this.reviewRequiredFields() == true) {
            //guardar en base de datos
        }            
    }//GEN-LAST:event_ButtonSaveActionPerformed

    private void TextFieldPhone1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldPhone1KeyTyped
        validateOnlyNumbers(evt);
    }//GEN-LAST:event_TextFieldPhone1KeyTyped

    private void TextFieldPhone2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldPhone2KeyTyped
        validateOnlyNumbers(evt);
    }//GEN-LAST:event_TextFieldPhone2KeyTyped
      
    private boolean reviewRequiredFields(){
        this.setColorsLabels();
        boolean isReady = true;
        if (this.TextFieldName.getText().isEmpty() == true) {
            isReady= false;
            this.LabelStore.setForeground(Color.red);            
        }
        if (this.TextFieldCode.getText().isEmpty() == true) {
            isReady= false;
            this.LabelCode.setForeground(Color.red);
        }
        if (this.TextFieldAddress.getText().isEmpty() == true) {
            isReady= false;
            this.LabelAddress.setForeground(Color.red);
        }
        if (this.TextFieldPhone1.getText().isEmpty() == true) {
            isReady= false;
            this.LabelPhone1.setForeground(Color.red);
        }
        return isReady;
    }        
    
    private void setColorsLabels(){
        this.LabelCode.setForeground(Color.black);
        this.LabelStore.setForeground(Color.black);
        this.LabelPhone1.setForeground(Color.black);
        this.LabelAddress.setForeground(Color.black);
    }
    
    /**
     * This method is used by textfields so that the user does 
     * not enter any character that is not a digit.
     *
     * @param evt
    */
    public void validateOnlyNumbers(java.awt.event.KeyEvent evt){
        char validate = evt.getKeyChar();
        if (Character.isDigit(validate) == false) {
            evt.consume();
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSave;
    private javax.swing.JLabel LabelAddress;
    private javax.swing.JLabel LabelCode;
    private javax.swing.JLabel LabelEMail;
    private javax.swing.JLabel LabelPhone1;
    private javax.swing.JLabel LabelPhone2;
    private javax.swing.JLabel LabelShedule;
    private javax.swing.JLabel LabelStore;
    private javax.swing.JTextField TextFieldAddress;
    private javax.swing.JTextField TextFieldCode;
    private javax.swing.JTextField TextFieldEMail;
    private javax.swing.JTextField TextFieldName;
    private javax.swing.JTextField TextFieldPhone1;
    private javax.swing.JTextField TextFieldPhone2;
    private javax.swing.JTextField TextFieldShedule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}