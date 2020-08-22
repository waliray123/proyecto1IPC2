
package GUIStart;

import ConnectionDB.ControlDB;
import ConnectionDB.connectionToDB;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            connectionToDB connect = new connectionToDB();
            Connection connection = connect.getConnection();
            ControlDB control = new ControlDB(connection);
            
            boolean isEmpty = control.verifyEmptyDB();                                                
            
            if (isEmpty) {
                FirstEnterFrame firstEnter = new FirstEnterFrame(control);
                firstEnter.setVisible(true);
            }else{
                fChooseDateStore chooseDate = new fChooseDateStore(control);
                chooseDate.setVisible(true);
            }                    
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR, " + e.getMessage(), "X", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
}
