/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import ConnectionDB.ControlDB;
import ObjectsDB.Order;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author user-ubunto
 */
public class controlOrders {
    private Date dateActual;
    private ArrayList<Order> orders;
    private String ordersReady;
    private ControlDB control;
    private String codeStore;

    public controlOrders(Date dateActual, ControlDB control1,String codeStore) {
        this.ordersReady = "";
        this.dateActual = dateActual;
        this.control = control1;   
        this.codeStore = codeStore;
    }
    
    public void setOrders(){
        this.orders = control.setOrders();
        reviewAllOrders();
    }
    
    private void reviewAllOrders(){
        boolean thereAreOrders = false;
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).isDelivered() == false && this.orders.get(i).getCodeOrderEnter().equals(this.codeStore) && this.orders.get(i).isRegisteredOrder()==false) {
                Date dateReceipt = this.orders.get(i).getDateReceipt();
                int isReady = this.dateActual.compareTo(dateReceipt);
                if (isReady == 1) {
                    this.ordersReady +=" "+ this.orders.get(i).getCode();
                    thereAreOrders = true;
                    registerOrder(this.orders.get(i).getCode(), this.orders.get(i).isDelayedOrder());
                }else if(isReady == 0){
                    if (this.orders.get(i).isDelayedOrder() == false) {
                        this.ordersReady +=" "+ this.orders.get(i).getCode();
                        thereAreOrders = true;
                        registerOrder(this.orders.get(i).getCode(), this.orders.get(i).isDelayedOrder());
                    } 
                }
            }            
        }
        if (thereAreOrders == true) {
            showOrders();
        }
    }
    
    private void showOrders(){
        JOptionPane.showMessageDialog(null,"Se registraron las Ordenes con pedido:" + this.ordersReady);
    }
    
    private void registerOrder(String codeOrder, boolean delayed){
        this.control.updateOrderByCode(codeOrder, false, true, delayed);
    }
    
}
