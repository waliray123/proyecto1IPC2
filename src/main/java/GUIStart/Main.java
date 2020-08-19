
package GUIStart;

import ConnectionDB.connectionToDB;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connectionToDB connect = new connectionToDB();
        connect.getConnection();
        
        FirstEnterFrame firstEnter = new FirstEnterFrame();
        firstEnter.setVisible(true);        
        //StartFrame startFrame = new StartFrame();
        //startFrame.setVisible(true);
    }
    
}
