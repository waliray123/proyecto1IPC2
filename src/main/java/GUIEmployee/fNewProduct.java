/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIEmployee;

import ConnectionDB.ControlDB;
import ObjectsDB.Product;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author user-ubunto
 */
public class fNewProduct extends javax.swing.JFrame {

    private String IDProduct;
    private DefaultTableModel dtmProduct;
    private TableRowSorter tableRowSorter;
    private ArrayList<Product> products;
    private ControlDB control;
    private String codeStore;
    
    /**
     * Creates new form fNewProduct
     */
    public fNewProduct(ControlDB control1, String codeStore) {
        initComponents();
        this.IDProduct = "";
        this.codeStore = codeStore;
        this.control = control1;
        this.dtmProduct = (DefaultTableModel) this.TableProduct.getModel();
        this.products = this.control.setProductsByStore(this.codeStore);
        setProductsTable();
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
        LabelMaker = new javax.swing.JLabel();
        TextFieldMaker = new javax.swing.JTextField();
        LabelCode = new javax.swing.JLabel();
        TextFieldCode = new javax.swing.JTextField();
        LabelQuantity = new javax.swing.JLabel();
        TextFieldQuantity = new javax.swing.JTextField();
        LabelPrice = new javax.swing.JLabel();
        TextFieldPrice = new javax.swing.JTextField();
        LabelName5 = new javax.swing.JLabel();
        TextFieldGuaranty = new javax.swing.JTextField();
        LabelName6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaDescription = new javax.swing.JTextArea();
        jButtonSaveProduct = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableProduct = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextFieldFilter = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LabelName.setText("Nombre del Producto*");

        LabelMaker.setText("Fabricante*");

        LabelCode.setText("Codigo*");

        LabelQuantity.setText("Cantidad*");

        TextFieldQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldQuantityKeyTyped(evt);
            }
        });

        LabelPrice.setText("Precio*");

        TextFieldPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldPriceKeyTyped(evt);
            }
        });

        LabelName5.setText("Garantia (Meses)");

        TextFieldGuaranty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldGuarantyKeyTyped(evt);
            }
        });

        LabelName6.setText("Descripcion de Producto");

        TextAreaDescription.setColumns(20);
        TextAreaDescription.setRows(5);
        jScrollPane1.setViewportView(TextAreaDescription);

        jButtonSaveProduct.setText("Guardar Producto en esta Tienda");
        jButtonSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveProductActionPerformed(evt);
            }
        });

        jLabel1.setText("*Campos Obligatorios");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TableProduct.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        TableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Fabricante", "Existencia", "Precio", "Garantia", "Tienda", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableProduct);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel3.setText("Producto en todas las tiendas");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel2.setText("Filtrar");

        TextFieldFilter.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        TextFieldFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldFilterKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextFieldFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LabelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextFieldName))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LabelMaker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextFieldMaker, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LabelCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LabelQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelName6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LabelName5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextFieldGuaranty, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LabelPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonSaveProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelPrice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelMaker)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldMaker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelName5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldGuaranty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelCode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LabelQuantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelName6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jButtonSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveProductActionPerformed
        if (this.reviewRequiredFields() == true) {
            String code = this.TextFieldCode.getText();
            String name = this.TextFieldName.getText();
            String maker = this.TextFieldMaker.getText();
            int quantity = Integer.parseInt(this.TextFieldQuantity.getText());
            double price = Double.parseDouble(this.TextFieldPrice.getText());
            int guarantee = 0;
            if (this.TextFieldGuaranty.getText().equals("") == false)
                guarantee = Integer.parseInt(this.TextFieldGuaranty.getText());
                        
            String Description = "";
            if (this.TextAreaDescription.getText().equals("") == false)
                Description = this.TextAreaDescription.getText();
            
            if (this.IDProduct.equalsIgnoreCase("")) {
                System.out.println("Guardar Producto");
                this.control.insertProduct(code, name, maker, price, Description, guarantee);
                this.control.insertRelationStoreProduct(codeStore, code, quantity);
            }else{
                this.control.updateProduct(this.IDProduct, name, maker, price, Description, guarantee);
                this.control.updateRelationStoreProduct(this.codeStore, this.IDProduct, quantity);
                System.out.println("Editar Producto");                
            }
            this.products = this.control.setProductsByStore(this.codeStore);
            setProductsTable();
            cleanTextBox();
        }
    }//GEN-LAST:event_jButtonSaveProductActionPerformed

    private void TextFieldPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldPriceKeyTyped
        validateOnlyNumbers(evt);
    }//GEN-LAST:event_TextFieldPriceKeyTyped

    private void TextFieldQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldQuantityKeyTyped
        validateOnlyNumbers(evt);
    }//GEN-LAST:event_TextFieldQuantityKeyTyped

    private void TextFieldGuarantyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldGuarantyKeyTyped
        validateOnlyNumbers(evt);
    }//GEN-LAST:event_TextFieldGuarantyKeyTyped

    private void TableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductMouseClicked
        int select = this.TableProduct.rowAtPoint(evt.getPoint());
        this.TextFieldCode.setText(String.valueOf(this.TableProduct.getValueAt(select,0)));
        this.TextFieldName.setText(String.valueOf(this.TableProduct.getValueAt(select,1)));
        this.TextFieldMaker.setText(String.valueOf(this.TableProduct.getValueAt(select,2)));
        this.TextFieldQuantity.setText(String.valueOf(this.TableProduct.getValueAt(select,3)));
        this.TextFieldPrice.setText(String.valueOf(this.TableProduct.getValueAt(select,4)));
        this.TextFieldGuaranty.setText(String.valueOf(this.TableProduct.getValueAt(select,5)));
        this.TextAreaDescription.setText(String.valueOf(this.TableProduct.getValueAt(select,7)));        
        this.IDProduct = this.TextFieldCode.getText();        
    }//GEN-LAST:event_TableProductMouseClicked

    private void TextFieldFilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldFilterKeyTyped

        /*This is the filter of the rows of the table that
        *contains the products, you can filter the column 0, 1 and 2
        */
        this.TextFieldFilter.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+TextFieldFilter.getText(), 0,1,2));
            }
        });

        tableRowSorter = new TableRowSorter(dtmProduct);
        this.TableProduct.setRowSorter(tableRowSorter);

    }//GEN-LAST:event_TextFieldFilterKeyTyped
    
    private boolean reviewRequiredFields(){
        this.setColorsLabels();
        boolean isReady = true;
        if (this.TextFieldName.getText().isEmpty() == true) {
            isReady= false;
            this.LabelName.setForeground(Color.red);            
        }
        if (this.TextFieldCode.getText().isEmpty() == true) {
            isReady= false;
            this.LabelCode.setForeground(Color.red);
        }
        if (this.TextFieldMaker.getText().isEmpty() == true) {
            isReady= false;
            this.LabelMaker.setForeground(Color.red);
        }
        if (this.TextFieldQuantity.getText().isEmpty() == true) {
            isReady= false;
            this.LabelQuantity.setForeground(Color.red);
        }
        if (this.TextFieldPrice.getText().isEmpty() == true) {
            isReady= false;
            this.LabelPrice.setForeground(Color.red);
        }
        return isReady;
    }        
    
    private void setColorsLabels(){
        this.LabelCode.setForeground(Color.black);
        this.LabelName.setForeground(Color.black);
        this.LabelQuantity.setForeground(Color.black);
        this.LabelMaker.setForeground(Color.black);
        this.LabelPrice.setForeground(Color.black);
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

    public void cleanTextBox(){
        this.TextAreaDescription.setText("");
        this.TextFieldCode.setText("");
        this.TextFieldName.setText("");
        this.TextFieldMaker.setText("");
        this.TextFieldQuantity.setText("");
        this.TextFieldGuaranty.setText("");
        this.TextFieldPrice.setText("");
        this.IDProduct = "";
    }
    
    public void setProductsTable(){
        cleanTable();
        String code = "";
        String name = "";
        String maker = "";
        int quantity = 0;
        double price = 0;
        int guarantee = 0;
        String Store = "";
        String Description = "";
        
        int sizeProducts = this.products.size();
        for (int i = 0; i < sizeProducts; i++) {
            code = this.products.get(i).getCode();
            name = this.products.get(i).getName();
            maker = this.products.get(i).getMaker();
            quantity = this.products.get(i).getQuantity();
            price = this.products.get(i).getPrice();
            guarantee = this.products.get(i).getGuarantee();
            Store = this.codeStore;
            Description = this.products.get(i).getDescription();
                       
            this.dtmProduct.addRow(new Object[]{code, name, maker,quantity,price,guarantee,Store,Description});
        }                
        
        this.TableProduct.setModel(dtmProduct);
    }
    
    public void cleanTable(){
        int filas=this.TableProduct.getRowCount();
        for (int i = 0;filas>i; i++) {
            this.dtmProduct.removeRow(0);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCode;
    private javax.swing.JLabel LabelMaker;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelName5;
    private javax.swing.JLabel LabelName6;
    private javax.swing.JLabel LabelPrice;
    private javax.swing.JLabel LabelQuantity;
    private javax.swing.JTable TableProduct;
    private javax.swing.JTextArea TextAreaDescription;
    private javax.swing.JTextField TextFieldCode;
    private javax.swing.JTextField TextFieldFilter;
    private javax.swing.JTextField TextFieldGuaranty;
    private javax.swing.JTextField TextFieldMaker;
    private javax.swing.JTextField TextFieldName;
    private javax.swing.JTextField TextFieldPrice;
    private javax.swing.JTextField TextFieldQuantity;
    private javax.swing.JButton jButtonSaveProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
