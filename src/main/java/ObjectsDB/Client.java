/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectsDB;

/**
 *
 * @author user-ubunto
 */
public class Client {
    private String NIT;
    private String name;
    private String phone;
    private String DPI;
    private double credit;
    private String email;
    private String address;

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNIT() {
        return NIT;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDPI() {
        return DPI;
    }

    public double getCredit() {
        return credit;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
    
    
    
}
