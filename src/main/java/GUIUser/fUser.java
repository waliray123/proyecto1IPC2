/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIUser;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author user-ubunto
 */
public class fUser extends javax.swing.JFrame {

    private TableRowSorter tableRowSorterClient;
    private DefaultTableModel dtmClient;
    private String IDClient;
    
    
    /**
     * Creates new form FrameEmployee
     */
    public fUser() {
        initComponents();
        
        dtmClient = (DefaultTableModel) this.TableClient.getModel();
        this.IDClient = "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableClient = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        TextFieldClientName = new javax.swing.JTextField();
        TextFieldFilterClient = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel6.setText("Cliente");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel9.setText("Filtrar");

        TableClient.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        TableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Juan", "11111", "0101", "800"},
                {"MAria", "22222", "9817", "0"},
                {"Pedro", "3333", "7871", "1000"}
            },
            new String [] {
                "Nombre", "NIT", "DPI", "Credito"
            }
        ));
        TableClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableClientMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableClient);

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel12.setText("Nombre del Cliente");

        TextFieldClientName.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        TextFieldFilterClient.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        TextFieldFilterClient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldFilterClientKeyTyped(evt);
            }
        });

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(199, 199, 199)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextFieldFilterClient))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(TextFieldClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(TextFieldFilterClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(5, 5, 5)
                .addComponent(TextFieldClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableClientMouseClicked
        int select = this.TableClient.rowAtPoint(evt.getPoint());
        this.TextFieldClientName.setText(String.valueOf(this.TableClient.getValueAt(select,0)));
        this.IDClient = String.valueOf(this.TableClient.getValueAt(select,1));
    }//GEN-LAST:event_TableClientMouseClicked

    private void TextFieldFilterClientKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldFilterClientKeyTyped
        /*This is the filter of the rows of the table that
        *contains the Client, you can filter the column 0and 1
        */
        this.TextFieldFilterClient.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                tableRowSorterClient.setRowFilter(RowFilter.regexFilter("(?i)"+TextFieldFilterClient.getText(), 0,1));
            }
        });

        tableRowSorterClient = new TableRowSorter(dtmClient);
        this.TableClient.setRowSorter(tableRowSorterClient);
    }//GEN-LAST:event_TextFieldFilterClientKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.IDClient.equals("")) {
            System.out.println("tiene que ingresar un cliente");
        }else{
            fClient fclient = new fClient(this.IDClient);
            fclient.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableClient;
    private javax.swing.JTextField TextFieldClientName;
    private javax.swing.JTextField TextFieldFilterClient;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
