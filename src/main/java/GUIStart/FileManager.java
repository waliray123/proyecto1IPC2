/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIStart;

import ConnectionDB.ControlDB;
import ConnectionDB.connectionToDB;
import Controlers.ControlCodes;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user-ubunto
 */
public class FileManager {
    
    private final int LENGTHNAME = 20;
    private final int LENGTHPHONENUMBER = 8;
    private final int LENGTHSTORE = 5;
    private final int LENGTHTIMESTORE = 4;    
    private final int LENGTHPRODUCT = 7;
    private final int LENGTHEMPLOYEE = 5;
    private final int LENGTHCLIENT = 5;
    private final int LENGTHORDER = 10;
    
    
    private String[] components;
    private int countLine;
    private DefaultTableModel tableModel;
    private ControlCodes controlCodesClient = new ControlCodes();
    private ControlCodes controlCodesEmployee = new ControlCodes();
    private ControlCodes controlCodesProduct = new ControlCodes();
    private ControlCodes controlCodesStore = new ControlCodes();
    private ControlCodes controlCodesOrder = new ControlCodes();
    private ControlDB control;
    
    public void loadControlData(String path , DefaultTableModel tableModel, ControlDB control1){
        this.countLine = 1;
        this.tableModel = tableModel;
        try {            
            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            
            this.control = control1;
            
            
            while((line=br.readLine())!=null){
                System.out.println(line);
                verifyTable(line);
                this.countLine++;
            }
            System.out.println("termino");            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public void verifyTable(String line){
        this.components = line.split(",");
                
        String firstLine = this.components[0];
        if (firstLine.equals("TIENDA"))
            verifyStore();
        else if (firstLine.equals("TIEMPO"))
            verifyTime();
        else if (firstLine.equals("PRODUCTO"))
            verifyProduct();
        else if (firstLine.equals("EMPLEADO"))
            verifyEmployee();
        else if (firstLine.equals("CLIENTE"))
            verifyClient();
        else if (firstLine.equals("PEDIDO"))
            verifyOrder();
        else
            this.tableModel.addRow(new Object[]{this.countLine, "No existe esa Estructura"});
    }
    
    public void verifyStore(){
        if (this.components.length == this.LENGTHSTORE) {            
            if (verifyName(this.components[1])) {
                if (verifyPhoneNumber(this.components[4])) {
                    if (this.controlCodesStore.verifyExistenceCode(this.components[3]) == false) {
                        insertStore();
                    }else
                        this.tableModel.addRow(new Object[]{this.countLine, "Codigo ya Existe"});
                }
            }           
        }else if (this.components.length < this.LENGTHSTORE)
            addRowMissingData();
        else if (this.components.length > this.LENGTHSTORE)
            addRowExtraData();
                
    }
    
    public void verifyTime(){
        if (this.components.length == this.LENGTHTIMESTORE) {            
            if (this.controlCodesStore.verifyExistenceCode(this.components[1]) &&
                    this.controlCodesStore.verifyExistenceCode(this.components[2])) {
                insertTime();
            }            
        }else if (this.components.length < this.LENGTHTIMESTORE)
            addRowMissingData();
        else if (this.components.length > this.LENGTHTIMESTORE)
            addRowExtraData();
    }
    
    public void verifyProduct(){
        if (this.components.length == this.LENGTHPRODUCT) {            
            if (verifyName(this.components[1])) {
                if (this.controlCodesStore.verifyExistenceCode(this.components[6])) {
                    if (this.controlCodesProduct.verifyExistenceCode(this.components[3])) {
                        if (this.control.existRelationStoreCode(this.components[6] , this.components[3])) {
                            this.tableModel.addRow(new Object[]{this.countLine, "El producto ya existe en esa tienda"});
                        }else{
                            insertRelationStoreProduct();
                        }
                    }else{
                        insertProduct();// en la tienda y la relacion
                    }
                }                               
            }            
        }else if (this.components.length < this.LENGTHPRODUCT)
            addRowMissingData();
        else if (this.components.length > this.LENGTHPRODUCT)
            addRowExtraData();
    }
    
    public void verifyEmployee(){
        if (this.components.length == this.LENGTHEMPLOYEE) {            
            if (verifyName(this.components[1])) {
                if (verifyPhoneNumber(this.components[3])) {
                    if(this.controlCodesEmployee.verifyExistenceCode(this.components[2]) == false){
                        insertEmployee();
                    }else
                        this.tableModel.addRow(new Object[]{this.countLine, "Codigo ya Existe"});
                }                
            }            
        }else if (this.components.length < this.LENGTHEMPLOYEE)
            addRowMissingData();
        else if (this.components.length > this.LENGTHEMPLOYEE)
            addRowExtraData();
    }
    
    public void verifyClient(){
        if (this.components.length == this.LENGTHCLIENT) {            
            if (verifyName(this.components[1])) {
                if (verifyPhoneNumber(this.components[3])) {
                    if(this.controlCodesClient.verifyExistenceCode(this.components[2]) == false){
                        insertClient();
                    }else
                        this.tableModel.addRow(new Object[]{this.countLine, "Codigo ya Existe"});
                }                
            }            
        }else if (this.components.length < this.LENGTHCLIENT)
            addRowMissingData();
        else if (this.components.length > this.LENGTHCLIENT)
            addRowExtraData();
    }
    
    public void verifyOrder(){
        if (this.components.length == this.LENGTHORDER) {            
            if (this.controlCodesStore.verifyExistenceCode(this.components[2]) && 
                    this.controlCodesStore.verifyExistenceCode(this.components[3])) {
                    if(this.controlCodesClient.verifyExistenceCode(this.components[5])&&
                            this.controlCodesProduct.verifyExistenceCode(this.components[6])){
                        if (this.controlCodesOrder.verifyExistenceCode(this.components[1])) {
                            //existe orden
                            insertOrderProduct();
                            addTotalOrder();
                        }else
                            insertOrder();
                    }else
                        this.tableModel.addRow(new Object[]{this.countLine, "El codigo no existe"});         
            }else
                this.tableModel.addRow(new Object[]{this.countLine, "El codigo de tienda"});  
        }else if (this.components.length < this.LENGTHORDER)
            addRowMissingData();
        else if (this.components.length > this.LENGTHORDER)
            addRowExtraData();        
    }
    
    public void insertStore(){
        this.controlCodesStore.addCode(this.components[3]);
        //Insertar en base de datos
        this.control.insertStore(this.components[3], this.components[1],this.components[2],this.components[4], null, null,null);
    }
    
    public void insertTime(){        
        //Insertar en base de datos
        this.control.insertShippingTime(this.components[1], this.components[2],Integer.parseInt(this.components[3]));
    }
    
    public void insertProduct(){
        this.controlCodesProduct.addCode(this.components[3]);
        this.control.insertProduct(this.components[3],this.components[1], this.components[2], Double.parseDouble(this.components[5]), null, 0);
        insertRelationStoreProduct();
        //Insertar en base de datos
    }
    
    public void insertRelationStoreProduct(){
        //Inserta en la base de datos la relacion producto tienda
        this.control.insertRelationStoreProduct(this.components[6],this.components[3], Integer.parseInt(this.components[4]));
    }
    
    public void insertEmployee(){
        this.controlCodesEmployee.addCode(this.components[2]);
        //Insertar en base de datos
        this.control.insertEmployee(this.components[2], this.components[1],this.components[3],null,this.components[4], null,null);
    }
    
    public void insertClient(){
        this.controlCodesClient.addCode(this.components[2]);
        //Insertar en base de datos
        this.control.insertClient(this.components[2], this.components[1],this.components[3],null, this.components[4], null,null);
    }
    
    public void insertOrder(){
        int codeShipping = 0;
        codeShipping = this.control.existRelationShippingTime(this.components[2], this.components[3]);
        if (codeShipping != 0) {
            this.controlCodesOrder.addCode(this.components[1]);
            this.control.insertOrder(this.components[1], this.components[4], Double.parseDouble(this.components[8]) , Double.parseDouble(this.components[9]), this.components[5], codeShipping);
            insertOrderProduct();            
        }else
            this.tableModel.addRow(new Object[]{this.countLine, "No hay tiempo de Pedido"});
    }
    
    public void insertOrderProduct(){
        this.control.insertOrderProduct(Integer.parseInt(this.components[7]), this.components[1], this.components[6]);        
    }
    
    public void addTotalOrder(){
        this.control.addTotalOrder(this.components[1], Double.parseDouble(this.components[8]));
    }
    
    public boolean verifyName(String name){
        boolean lengthCorrect = false;        
        if (name.length() < this.LENGTHNAME)
            lengthCorrect = true;
        if(lengthCorrect == false)
            this.tableModel.addRow(new Object[]{this.countLine, "El nombre es muy largo"});        
        return lengthCorrect;
    }
    
    public boolean verifyPhoneNumber(String phone){
        boolean lengthCorrect = false;
        if (phone.length() == this.LENGTHPHONENUMBER)
            lengthCorrect = true;
        if(lengthCorrect == false)
            this.tableModel.addRow(new Object[]{this.countLine, "Numero de Telefono Incorrecto"});
        return lengthCorrect;
    }
            
    public void addRowExtraData(){
        this.tableModel.addRow(new Object[]{this.countLine, "Datos Extra"});
    }
    
    public void addRowMissingData(){
        this.tableModel.addRow(new Object[]{this.countLine, "Faltan datos"});
    }
}
