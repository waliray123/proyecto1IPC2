/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import java.util.ArrayList;

/**
 *
 * @author user-ubunto
 */
public class ControlCodes {
    private ArrayList<String> codes = new ArrayList<String>();        
    
    public void addCode(String code){
        this.codes.add(code);
    }
    
    public void deleteCode(String codeDelete){
        this.codes.remove(codeDelete);
    }
    
    public boolean verifyExistenceCode(String newCode){
        boolean exists = false;
        for (String codeInList : this.codes) {
            if (codeInList.equals(newCode)) {
                exists = true;
            }
        }        
        return exists;
    }
    
    
}
