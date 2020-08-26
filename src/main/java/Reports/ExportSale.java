/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import ObjectsDB.Sale;
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
public class ExportSale {
    private ArrayList<Sale> sales;

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
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
        pw.println("<h1>"+title+"</h1>");
    }
    
    private void finelHTML(PrintWriter pw){
        pw.println("</table>");
        pw.println("</body>");
        pw.println("</html>");               
    }
    
    private void titleTable(PrintWriter pw){
        pw.println("<tr>");
        pw.println("<td><strong>"+ "Codigo de Cliente" +"</strong></td>");            
        pw.println("<td><strong>"+ "Fecha de Venta" +"</strong></td>");            
        pw.println("<td><strong>"+ "Total" +"</strong></td>");            
        pw.println("<td><strong>"+ "Codigo Venta" +"</strong></td>");           
        pw.println("</tr>");
    }
    
    private void insertTable(PrintWriter pw){
        for (int i = 0; i < this.sales.size(); i++) {            
            pw.println("<tr>");
            pw.println("<td>"+ this.sales.get(i).getClientNIT() +"</td>");            
            pw.println("<td>"+ this.sales.get(i).getDateSale() +"</td>");                                    
            pw.println("<td>"+ String.valueOf(this.sales.get(i).getTotal()) +"</td>");
            pw.println("<td>"+ this.sales.get(i).getCode() +"</td>");
            pw.println("</tr>");
        }
    } 
    
    public void exportReport(String title){
        String path = takePath();
        System.out.println(path);
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
