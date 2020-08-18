/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIStart;

import Controlers.ControlCodes;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    
    public void loadControlData(String path , DefaultTableModel tableModel){
        this.countLine = 1;
        this.tableModel = tableModel;
        try {            
            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            
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
                insertProduct();
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
    }
    
    public void insertTime(){        
        //Insertar en base de datos
    }
    
    public void insertProduct(){
        this.controlCodesProduct.addCode(this.components[3]);
        //Insertar en base de datos
    }
    
    public void insertEmployee(){
        this.controlCodesEmployee.addCode(this.components[2]);
        //Insertar en base de datos
    }
    
    public void insertClient(){
        this.controlCodesClient.addCode(this.components[2]);
        //Insertar en base de datos
    }
    
    public void insertOrder(){        
        //Insertar en base de datos
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
