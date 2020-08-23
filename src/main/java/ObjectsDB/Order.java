/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectsDB;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author user-ubunto
 */
public class Order {
    private String code;
    private Date dateOrder;
    private double total;
    private double advance;
    private String ClientNIT;
    private int ShippingTime;
    private Date dateReceipt;
    private String codeOrderOut;
    private String codeOrderEnter;
    private boolean delivered;

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }   
    
    public String getCodeOrderOut() {
        return codeOrderOut;
    }

    public void setCodeOrderOut(String codeOrderOut) {
        this.codeOrderOut = codeOrderOut;
    }

    public String getCodeOrderEnter() {
        return codeOrderEnter;
    }

    public void setCodeOrderEnter(String codeOrderEnter) {
        this.codeOrderEnter = codeOrderEnter;
    }        
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDateStr(String dateStr) {
        try{
            java.util.Date dateParse= new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            this.dateOrder = dateParse;
            setDateReciept();
        }catch(Exception e){
            System.out.println("error al cargar la fecha");
        }
        
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public String getClientNIT() {
        return ClientNIT;
    }

    public void setClientNIT(String ClientNIT) {
        this.ClientNIT = ClientNIT;
    }

    public int getShippingTime() {
        return ShippingTime;
    }

    public void setShippingTime(int ShippingTime) {
        this.ShippingTime = ShippingTime;
    }
    
    public void setDateReciept(){        
        Calendar calendar = Calendar.getInstance();	
        calendar.setTime(this.dateOrder); // Configuramos la fecha que se recibe	
        calendar.add(Calendar.DAY_OF_YEAR, this.ShippingTime);
        
        String dateReciptStr = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" + (calendar.get(Calendar.DAY_OF_MONTH));
        
        try{            
            java.util.Date dateParse= new SimpleDateFormat("yyyy-MM-dd").parse(dateReciptStr);
            this.dateReceipt = dateParse;
        }catch(Exception e){
            System.out.println("error al cargar la fecha");
        }                 
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public Date getDateReceipt() {
        return dateReceipt;
    }
    
}
