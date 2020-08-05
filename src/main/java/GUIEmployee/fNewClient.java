/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIEmployee;

import java.awt.Color;

/**
 *
 * @author user-ubunto
 */
public class fNewClient extends javax.swing.JFrame {

    /**
     * Creates new form fNewClient
     */
    public fNewClient() {
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

        LabelName = new javax.swing.JLabel();
        TextFieldName = new javax.swing.JTextField();
        LabelDPI = new javax.swing.JLabel();
        TextFieldDpi = new javax.swing.JTextField();
        LabelPhone = new javax.swing.JLabel();
        TextFieldPhone = new javax.swing.JTextField();
        LabelCredit = new javax.swing.JLabel();
        TextFieldCredit = new javax.swing.JTextField();
        LabelNIT = new javax.swing.JLabel();
        TextFieldNit = new javax.swing.JTextField();
        LabelEMail = new javax.swing.JLabel();
        TextFieldEMail = new javax.swing.JTextField();
        LabelDiretion = new javax.swing.JLabel();
        TextFieldAddress = new javax.swing.JTextField();
        ButtonSaveClient = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelName.setText("Nombre del cliente*");

        LabelDPI.setText("DPI");

        TextFieldDpi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldDpiKeyTyped(evt);
            }
        });

        LabelPhone.setText("Telefono*");

        TextFieldPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldPhoneKeyTyped(evt);
            }
        });

        LabelCredit.setText("Credito de Compra");

        TextFieldCredit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldCreditKeyTyped(evt);
            }
        });

        LabelNIT.setText("NIT*");

        LabelEMail.setText("Correo Electronico");

        LabelDiretion.setText("Direccion");

        ButtonSaveClient.setText("Guardar Cliente");
        ButtonSaveClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TextFieldCredit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(LabelName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabelDPI, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabelPhone, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TextFieldName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TextFieldDpi, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TextFieldPhone, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(LabelCredit))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelDiretion)
                    .addComponent(LabelEMail)
                    .addComponent(LabelNIT)
                    .addComponent(TextFieldNit)
                    .addComponent(TextFieldEMail)
                    .addComponent(TextFieldAddress)
                    .addComponent(ButtonSaveClient, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelNIT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelDPI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldDpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelEMail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelPhone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelDiretion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelCredit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonSaveClient, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldDpiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldDpiKeyTyped
        validateOnlyNumbers(evt);
    }//GEN-LAST:event_TextFieldDpiKeyTyped

    private void TextFieldPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldPhoneKeyTyped
        validateOnlyNumbers(evt);
    }//GEN-LAST:event_TextFieldPhoneKeyTyped

    private void TextFieldCreditKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldCreditKeyTyped
        validateOnlyNumbers(evt);
    }//GEN-LAST:event_TextFieldCreditKeyTyped

    private void ButtonSaveClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSaveClientActionPerformed
        if (this.reviewRequiredFields() == true ) {
            
        }
    }//GEN-LAST:event_ButtonSaveClientActionPerformed

    private boolean reviewRequiredFields(){
        this.setColorsLabels();
        boolean isReady = true;
        if (this.TextFieldName.getText().isEmpty() == true) {
            isReady= false;
            this.LabelName.setForeground(Color.red);            
        }
        if (this.TextFieldPhone.getText().isEmpty() == true) {
            isReady= false;
            this.LabelPhone.setForeground(Color.red);
        }
        if (this.TextFieldNit.getText().isEmpty() == true) {
            isReady= false;
            this.LabelNIT.setForeground(Color.red);
        }       
        return isReady;
    }
    
    private void setColorsLabels(){        
        this.LabelName.setForeground(Color.black);
        this.LabelPhone.setForeground(Color.black);
        this.LabelNIT.setForeground(Color.black);        
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
    private javax.swing.JButton ButtonSaveClient;
    private javax.swing.JLabel LabelCredit;
    private javax.swing.JLabel LabelDPI;
    private javax.swing.JLabel LabelDiretion;
    private javax.swing.JLabel LabelEMail;
    private javax.swing.JLabel LabelNIT;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelPhone;
    private javax.swing.JTextField TextFieldAddress;
    private javax.swing.JTextField TextFieldCredit;
    private javax.swing.JTextField TextFieldDpi;
    private javax.swing.JTextField TextFieldEMail;
    private javax.swing.JTextField TextFieldName;
    private javax.swing.JTextField TextFieldNit;
    private javax.swing.JTextField TextFieldPhone;
    // End of variables declaration//GEN-END:variables
}
