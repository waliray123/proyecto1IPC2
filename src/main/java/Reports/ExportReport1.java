/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import ObjectsDB.Order;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author user-ubunto
 */
public class ExportReport1{
    private ArrayList<Order> orders;

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }        
    
    public String takePath(){
        String path = "";
        JFileChooser fileChooser = new JFileChooser();
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("report.html", "html"));
                fileChooser.setAcceptAllFileFilterUsed(false);
                int seleccion = fileChooser.showSaveDialog(null);
                if (seleccion == APPROVE_OPTION) {
                    path = (fileChooser.getSelectedFile().getPath()+".html");
                }
        return path;
    }        
    
    private void headHTML(PrintWriter pw, String title){
        pw.println("<html>");
        pw.println("<head><title>Reporte</title></head>");
        pw.println("<body>");
        pw.println("<table>");
        pw.println("<h1>"+ title +"</h1>");
    }
    
    private void finelHTML(PrintWriter pw){
        pw.println("</table>");
        pw.println("</body>");
        pw.println("</html>");               
    }
    
    private void titleTable(PrintWriter pw){
        pw.println("<tr>");
        pw.println("<td><strong>"+ "Codigo" +"</strong></td>");            
        pw.println("<td><strong>"+ "Fecha de Orden" +"</strong></td>");            
        pw.println("<td><strong>"+ "Fecha de Entrega" +"</strong></td>");            
        pw.println("<td><strong>"+ "Total" +"</strong></td>");            
        pw.println("<td><strong>"+ "Adelanto" +"</strong></td>");            
        pw.println("<td><strong>"+ "Codigo Cliente" +"</strong></td>");            
        pw.println("</tr>");
    }
    
    private void insertTable(PrintWriter pw){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateOrder ="";
        String dateReceipt ="";
        for (int i = 0; i < this.orders.size(); i++) {            
            dateOrder = sdf.format(this.orders.get(i).getDateOrder());
            dateReceipt = sdf.format(this.orders.get(i).getDateReceipt());
            pw.println("<tr>");
            pw.println("<td>"+ this.orders.get(i).getCode() +"</td>");            
            pw.println("<td>"+ dateOrder +"</td>");            
            pw.println("<td>"+ dateReceipt +"</td>");            
            pw.println("<td>"+ String.valueOf(this.orders.get(i).getTotal()) +"</td>");            
            pw.println("<td>"+ String.valueOf(this.orders.get(i).getAdvance()) +"</td>");            
            pw.println("<td>"+ this.orders.get(i).getClientNIT() +"</td>");            
            pw.println("</tr>");
        }
    } 
    
    public void exportReport(String title){
        String path = takePath();
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(path);
            pw = new PrintWriter(fichero);

            headHTML(pw,title);
            titleTable(pw);
            insertTable(pw);
            finelHTML(pw);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    
    
}
