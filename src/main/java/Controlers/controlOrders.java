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

    public controlOrders(Date dateActual, ControlDB control1) {
        this.ordersReady = "";
        this.dateActual = dateActual;
        this.control = control1;        
    }
    
    public void setOrders(){
        this.orders = control.setOrders();
        reviewAllOrders();
    }
    
    private void reviewAllOrders(){
        boolean thereAreOrders = false;
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).isDelivered() == false) {
                Date dateReceipt = this.orders.get(i).getDateReceipt();
                int isReady = this.dateActual.compareTo(dateReceipt);
                if (isReady == 1) {
                    this.ordersReady +=" "+ this.orders.get(i).getCode();
                    thereAreOrders = true;
                }else if(isReady == 0){
                    this.ordersReady +=" "+ this.orders.get(i).getCode();
                    thereAreOrders = true;
                }
            }            
        }
        if (thereAreOrders == true) {
            showOrders();
        }
    }
    
    private void showOrders(){
        JOptionPane.showMessageDialog(null,"Hay ordenes por recoger con codigo:" + this.ordersReady);
    }
    
}
