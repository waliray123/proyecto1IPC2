/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;

import ObjectsDB.Client;
import ObjectsDB.Employee;
import ObjectsDB.Order;
import ObjectsDB.Product;
import ObjectsDB.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author user-ubunto
 */
public class ControlDB {
    private Connection connection;
    private PreparedStatement ps; //for operations
    private ResultSet rs;//for getting data
    
    public ControlDB(Connection connection) {
        this.connection = connection;
    }       
    
    public boolean verifyEmptyDB(){
        boolean isEmpty = true;

        String query = "SELECT * FROM STORE";                
        try (PreparedStatement preSt = connection.prepareStatement(query);
                ResultSet result = preSt.executeQuery()) {            
            
            if (result.next())
                isEmpty = false;
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
                
        return isEmpty;
    }
    
    public void insertClient(String NIT, String name, String phone, String DPI, 
            String credit, String email, String address){
        try {
            ps = connection.prepareStatement("INSERT INTO CLIENT VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, NIT);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, DPI);
            ps.setString(5, credit);
            ps.setString(6, email);
            ps.setString(7, address);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void insertEmployee(String code, String name, String phone, String NIT, 
            String DPI, String email, String address){
        try {
            ps = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, code);
            ps.setString(2, name);            
            ps.setString(3, phone);
            ps.setString(4, NIT);
            ps.setString(5, DPI);
            ps.setString(6, email);
            ps.setString(7, address);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void insertStore(String code,String name, String address, String phone1,
            String phone2, String email, String shedule){        
        try {
            ps = connection.prepareStatement("INSERT INTO STORE VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, code);
            ps.setString(2, name);
            ps.setString(3, address);
            ps.setString(4, phone1);
            ps.setString(5, phone2);
            ps.setString(6, email);
            ps.setString(7, shedule);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void insertShippingTime(String codeStoreOut,String codeStoreEnter, int daysTime){        
        try {
            ps = connection.prepareStatement("INSERT INTO SHIPPINGTIME (STORE_code_out,STORE_code_enter, days_Time) VALUES (?,?,?)");
            ps.setString(1, codeStoreOut);
            ps.setString(2, codeStoreEnter);            
            ps.setInt(3, daysTime);            
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void insertProduct(String code,String name, String maker, double price, String description, int guarantee){        
        try {
            ps = connection.prepareStatement("INSERT INTO PRODUCT VALUES (?,?,?,?,?,?)");
            ps.setString(1, code);
            ps.setString(2, name);
            ps.setString(3, maker);
            ps.setDouble(4, price);
            ps.setString(5, description);
            ps.setInt(6, guarantee);            
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void insertRelationStoreProduct(String codeStore,String codeProduct, int quantity){        
        try {
            ps = connection.prepareStatement("INSERT INTO STORE_PRODUCT (STORE_code ,PRODUCT_code , quantity) VALUES (?,?,?)");
            ps.setString(1, codeStore);
            ps.setString(2, codeProduct);
            ps.setInt(3, quantity);      
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void insertOrder(String code, String dateOrder, double total , double advance, String clientNit, int codeShippingTime ,String storeEnter, String storeOut, boolean delivered){        
        try {
            ps = connection.prepareStatement("INSERT INTO ORDER_CLIENT VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, code);
            ps.setString(2, dateOrder);
            ps.setDouble(3, total);
            ps.setDouble(4, advance);                                              
            ps.setString(5, clientNit);
            ps.setInt(6, codeShippingTime);
            ps.setString(7, storeEnter);
            ps.setString(8, storeOut);
            ps.setBoolean(9, delivered); 
                       
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void quitQuantityProduct(String codeStoreOut, String codeProduct, int quantityToQuit){
        int quantity = takeQuantityProduct(codeStoreOut,codeProduct)-quantityToQuit;
        
        try {
            ps = connection.prepareStatement("UPDATE STORE_PRODUCT SET quantity = ? WHERE STORE_code = ? AND PRODUCT_code = ?");
            ps.setInt(1, quantity);
            ps.setString(2, codeStoreOut);
            ps.setString(3, codeProduct);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public int takeQuantityProduct(String codeStore, String codeProduct){
        int quantity = 0;
        String query = "SELECT quantity FROM STORE_PRODUCT WHERE STORE_code = ? AND PRODUCT_code = ?"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {
            preSt.setString(1, codeStore);
            preSt.setString(2, codeProduct);
            
            ResultSet result = preSt.executeQuery();                        
            
            
            if (result.next())
                quantity = result.getInt(1);
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return quantity;
    }
    
    public void insertOrderProduct(int quantity ,String orderCode, String productCode){        
        try {
            ps = connection.prepareStatement("INSERT INTO ORDER_PRODUCT VALUES (?,?,?)");
            ps.setInt(1, quantity);
            ps.setString(2, orderCode);
            ps.setString(3, productCode);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }        
    }
    
    public void addTotalOrder(String codeOrder, double totalToAdd){
        double total = takeTotalOrder(codeOrder) + totalToAdd;
        
        try {
            ps = connection.prepareStatement("UPDATE ORDER_CLIENT SET total = ? WHERE code = ?");
            ps.setDouble(1, total);
            ps.setString(2, codeOrder);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public double takeTotalOrder(String codeOrder){
        double total = 0;
        String query = "SELECT total FROM ORDER_CLIENT WHERE code = ?"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {
            preSt.setString(1, codeOrder);
            
            ResultSet result = preSt.executeQuery();                        
            
            
            if (result.next())
                total = Double.parseDouble(result.getString(1));
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return total;
    }
    
    public int existRelationShippingTime(String storeCodeOut, String storeCodeEnter){
        int codeShipping = 0;
        
        String query = "SELECT * FROM SHIPPINGTIME WHERE STORE_code_out = ? AND STORE_code_enter = ? OR STORE_code_out = ? AND STORE_code_enter = ?"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {
            preSt.setString(1, storeCodeOut);
            preSt.setString(2, storeCodeEnter);
            preSt.setString(3, storeCodeEnter);
            preSt.setString(4, storeCodeOut);
            
            ResultSet result = preSt.executeQuery();                        
            
            
            if (result.next())
                codeShipping = Integer.parseInt(result.getString(1));
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return codeShipping;
    }
    
    public boolean existRelationStoreCode(String codeStore , String codeProduct){
        boolean existRelation = false;
        String query = "SELECT * FROM STORE_PRODUCT WHERE STORE_code = ? AND PRODUCT_code = ?;"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {            
            preSt.setString(1, codeStore);
            preSt.setString(2, codeProduct);
            
            ResultSet result = preSt.executeQuery();            
            if (result.next())
                existRelation = true;
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return existRelation;
    }
    
    public void setCodeStoreCombobox(JComboBox comboBox){
        String query = "SELECT * FROM STORE"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {            
            
            ResultSet result = preSt.executeQuery();            
            while(result.next())
                comboBox.addItem(result.getString(1));
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }                
    }
    
    public boolean existCodeOrder(String codeOrder){
        boolean existRelation = false;
        String query = "SELECT * FROM ORDER_CLIENT WHERE code = ? "; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {            
            preSt.setString(1, codeOrder);
            
            ResultSet result = preSt.executeQuery();            
            if (result.next())
                existRelation = true;
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return existRelation;
    }
    
    public Order searchAndSetByCodeOrder(String codeOrder){
        Order order = new Order();
        String query = "SELECT * FROM ORDER_CLIENT WHERE code = ? "; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {            
            preSt.setString(1, codeOrder);
            
            ResultSet result = preSt.executeQuery();            
            if (result.next()){
                order.setCode(result.getString(1));                
                order.setTotal(Double.parseDouble(result.getString(3)));
                order.setAdvance(Double.parseDouble(result.getString(4)));                
                order.setClientNIT(result.getString(5));
                order.setShippingTime(searchDaysShipping(result.getString(6)));
                order.setDateStr(result.getString(2));
                order.setCodeOrderOut(result.getString(7));
                order.setCodeOrderEnter(result.getString(8));
                order.setDelivered(Boolean.getBoolean(result.getString(9)));
            }    
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return order;
    }
    
    public int searchDaysShipping(String shippingCode){
        int days = 0;
        String query = "SELECT * FROM SHIPPINGTIME WHERE code = ? "; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {            
            preSt.setString(1, shippingCode);
            
            ResultSet result = preSt.executeQuery();            
            if (result.next())
                days = result.getInt(4);
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return days;
    }
    
    public ArrayList<Product> setProductsByOrder(String orderCode){
        ArrayList<Product> products = new ArrayList<Product>();
        
        String query = "SELECT * FROM PRODUCT AS SP INNER JOIN ORDER_PRODUCT AS OP ON OP.PRODUCT_code = SP.code AND OP.ORDER_CLIENT_code = ?"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {            
            preSt.setString(1, orderCode);
            
            ResultSet result = preSt.executeQuery();            
            while(result.next()){
                Product product = new Product();
                product.setCode(result.getString(1));
                product.setName(result.getString(2));
                product.setMaker(result.getString(3));
                product.setPrice(Double.parseDouble(result.getString(4)));
                product.setDescription(result.getString(5));
                product.setGuarantee(Integer.parseInt(result.getString(6)));
                product.setQuantity(Integer.parseInt(result.getString(7)));
                products.add(product);
            }
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return products;
    }
    
    public ArrayList<Product> setProductsByStore(String codeStore){
        ArrayList<Product> products = new ArrayList<Product>();
        
        String query = "SELECT * FROM PRODUCT AS P INNER JOIN STORE_PRODUCT AS SP ON SP.PRODUCT_code = P.code AND SP.STORE_code = ?"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {            
            preSt.setString(1, codeStore);
            
            ResultSet result = preSt.executeQuery();            
            while(result.next()){
                Product product = new Product();
                product.setCode(result.getString(1));
                product.setName(result.getString(2));
                product.setMaker(result.getString(3));
                product.setPrice(Double.parseDouble(result.getString(4)));
                product.setDescription(result.getString(5));
                product.setGuarantee(Integer.parseInt(result.getString(6)));
                product.setQuantity(Integer.parseInt(result.getString(9)));
                products.add(product);
            }
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return products;
    }
    
    public ArrayList<Store> setStores(){
        ArrayList<Store> stores = new ArrayList<Store>();
        
        String query = "SELECT * FROM STORE"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {            
            
            ResultSet result = preSt.executeQuery();            
            while(result.next()){
                Store store = new Store();
                store.setCode(result.getString(1));
                store.setName(result.getString(2));
                store.setAddress(result.getString(3));
                store.setPhone1(result.getString(4));
                if (result.getString(5) == null)
                    store.setPhone2("");
                else
                    store.setPhone2(result.getString(5));
                if(result.getString(6) == null)
                    store.setEmail("");
                else
                    store.setEmail(result.getString(6));
                if(result.getString(7) == null)
                    store.setShedule("");
                else
                    store.setShedule(result.getString(7));
                
                stores.add(store);
            }
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return stores;
    }
    
    public void updateStore(String code,String name, String address, String phone1,
            String phone2, String email, String shedule){
        try {
            ps = connection.prepareStatement("UPDATE STORE SET name = ?,address = ?, phone1 = ?, phone2 = ?, email = ?, shedule = ? WHERE code = ?;");
            ps.setString(7, code);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone1);
            ps.setString(4, phone2);
            ps.setString(5, email);
            ps.setString(6, shedule);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ArrayList<Employee> setEmployee(){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        
        String query = "SELECT * FROM EMPLOYEE"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {            
            
            ResultSet result = preSt.executeQuery();            
            while(result.next()){
                Employee employee = new Employee();
                employee.setCode(Integer.parseInt(result.getString(1)));
                employee.setName(result.getString(2));
                
                employee.setPhone(result.getString(3));
                employee.setDPI(result.getString(5));
                
                if (result.getString(4) == null)
                    employee.setNIT("");
                else
                    employee.setNIT(result.getString(4));
                if(result.getString(6) == null)
                    employee.setEmail("");
                else
                    employee.setEmail(result.getString(6));
                if(result.getString(7) == null)
                    employee.setAddress("");
                else
                    employee.setAddress(result.getString(7));
                
                employees.add(employee);
            }
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return employees;
    }        
    
    public void updateEmployee(String code, String name, String phone, String NIT, 
            String DPI, String email, String address){
        try {
            ps = connection.prepareStatement("UPDATE EMPLOYEE SET name = ?,address = ?,phone = ?, NIT = ?, DPI = ?, email = ? WHERE code = ?");
            ps.setString(7, code);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.setString(4, NIT);
            ps.setString(5, DPI);
            ps.setString(6, email);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ArrayList<Client> setClients(){
        ArrayList<Client> clients = new ArrayList<Client>();
        
        String query = "SELECT * FROM CLIENT"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {            
            
            ResultSet result = preSt.executeQuery();            
            while(result.next()){
                Client client = new Client();
                client.setNIT(result.getString(1));
                client.setName(result.getString(2));                
                client.setPhone(result.getString(3));                
                
                
                if (result.getString(4) == null)
                    client.setDPI("");
                else
                    client.setDPI(result.getString(4));
                
                if(result.getString(5) == null)
                    client.setCredit(0);
                else
                    client.setCredit(Double.parseDouble(result.getString(5)));
                
                if(result.getString(6) == null)
                    client.setEmail("");
                else
                    client.setEmail(result.getString(6));
                
                if(result.getString(7) == null)
                    client.setAddress("");
                else
                    client.setAddress(result.getString(7));
                
                clients.add(client);
            }
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return clients;
    }
    
    public void updateClient(String NIT, String name, String phone, String DPI, 
            String credit, String email, String address){
        try {
            ps = connection.prepareStatement("UPDATE CLIENT SET name = ?,phone = ?,DPI = ?, credit = ?, email = ?, address = ? WHERE NIT = ?");
            ps.setString(7, NIT);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, DPI);
            ps.setString(4, credit);
            ps.setString(5, email);
            ps.setString(6, address);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void updateProduct(String code,String name, String maker, double price, String description, int guarantee){
        try {
            ps = connection.prepareStatement("UPDATE PRODUCT SET name = ?,maker = ?,price = ?, description = ?, guarantee = ? WHERE code = ?");
            ps.setString(6, code);
            ps.setString(1, name);
            ps.setString(2, maker);
            ps.setDouble(3, price);
            ps.setString(4, description);
            ps.setInt(5, guarantee);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void updateRelationStoreProduct(String codeStore,String codeProduct, int quantity){
        try {
            ps = connection.prepareStatement("UPDATE STORE_PRODUCT SET quantity = ? WHERE STORE_code = ? AND PRODUCT_code = ?");
            ps.setInt(1, quantity);
            ps.setString(2, codeStore);
            ps.setString(3, codeProduct);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void updateShippingTime(String codeStore1,String codeStore2, int days){
        try {
            ps = connection.prepareStatement("UPDATE SHIPPINGTIME SET days_Time = ? WHERE (STORE_code_out = ? AND STORE_code_enter = ?) OR (STORE_code_out = ? AND STORE_code_enter = ?)");
            ps.setInt(1, days);
            ps.setString(2, codeStore1);
            ps.setString(3, codeStore2);
            ps.setString(4, codeStore2);
            ps.setString(5, codeStore1);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void insertSell(String date ,String clientNIT, double total){        
        try {
            ps = connection.prepareStatement("INSERT INTO SALE (dateSale,CLIENT_NIT,total) VALUES (?,?,?)");
            ps.setString(1, date);
            ps.setString(2, clientNIT);
            ps.setDouble(3, total);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }        
    
    public void insertSellProduct(String productCode){
        int codeSale = takeLastSell();
        try {
            ps = connection.prepareStatement("INSERT INTO SALE_PRODUCT (SALE_code,PRODUCT_code) VALUES (?,?)");
            ps.setInt(1, codeSale);
            ps.setString(2, productCode);            
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
    }
    
    public int takeLastSell(){
        int codeSale = 0;
        String query = "SELECT * FROM SALE"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {                        
            
            ResultSet result = preSt.executeQuery();            
            if (result.last())
                codeSale=result.getInt(1);
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return codeSale;
    }
    
    public void quitCreditClient(String codeClient, double quantityToQuit){
        double credit = takeCreditClient(codeClient)-quantityToQuit;
        
        try {
            ps = connection.prepareStatement("UPDATE CLIENT SET credit = ? WHERE NIT = ? ");
            ps.setDouble(1, credit);
            ps.setString(2, codeClient);
            
            ps.executeUpdate();//action done
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public double takeCreditClient(String codeClient){
        double credit = 0;
        String query = "SELECT credit FROM CLIENT WHERE NIT = ?"; 
        
        try (PreparedStatement preSt = connection.prepareStatement(query);) {
            preSt.setString(1, codeClient);
            
            ResultSet result = preSt.executeQuery();                        
            
            
            if (result.next())
                credit = result.getDouble(1);
                
            result.close();
            preSt.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return credit;
    }
}
