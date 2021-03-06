/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIStart;

import ConnectionDB.ControlDB;
import Controlers.controlOrders;
import GUIEmployee.fEmployee;
import ObjectsDB.Employee;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author user-ubunto
 */
public class fChooseDateStore extends javax.swing.JFrame {
    private ControlDB control;
    private boolean isFirstEntry;
    /**
     * Creates new form fChooseDate
     */
    public fChooseDateStore(ControlDB control1, Date dateUse, String codeStoreUse) {
        initComponents();        
        this.control = control1;                
        this.control.setCodeStoreCombobox(this.jComboBox1);
        if (dateUse == null){
            setFirstDateStore();
            this.isFirstEntry = true;
        }else{
            setDate(dateUse);
            setStore(codeStoreUse);
            this.isFirstEntry = false;
        }        
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Que fecha desea ingresar");
        jLabel1.setToolTipText("");

        jLabel2.setText("Que tienda desea ingresar");

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String codeStoreActual = String.valueOf(this.jComboBox1.getSelectedItem());
        Date dateActual = this.jDateChooser1.getDate();
        if (this.isFirstEntry == true) {
            StartFrame startFrame = new StartFrame(control, dateActual, codeStoreActual);
            startFrame.setVisible(true);
        }else{
            controlOrders controlOrder = new controlOrders(dateActual,this.control,codeStoreActual);
            controlOrder.setOrders();
            fEmployee frameEmployee = new fEmployee(this.control,codeStoreActual, dateActual);
            frameEmployee.setVisible(true);
        }
        this.dispose();        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void setFirstDateStore(){
        try{            
            String firstDate = "2020-01-01";
            java.util.Date dateParse= new SimpleDateFormat("yyyy-MM-dd").parse(firstDate);
            this.jDateChooser1.setDate(dateParse);
        }catch(Exception e){
            System.out.println("error al cargar la fecha");
        }
    }
    public void setDate(Date dateActual){
        try{
            this.jDateChooser1.setDate(dateActual);
        }catch(Exception e){
            System.out.println("error al cargar la fecha");
        }
    }
    
    public void setStore(String codeStore){
        this.jComboBox1.setSelectedItem(codeStore);
    }        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
