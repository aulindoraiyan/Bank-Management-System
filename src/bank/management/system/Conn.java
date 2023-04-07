
package bank.management.system;

import java.sql.*;


/**
 *  JDBC Connectivity has 5 steps. 
 * 1. register the driver 2. Create Connection
 * 3. Create Statement 4. Execute Query(this is in the signupOne)
 * 5. Close Connection
 * @author DELL
 */

public class Conn {
    Connection c;
    Statement s;

    public Conn(){
        
        try{
           
            
            
            //Now create connection:
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "mR786sr1957@");
            //the only reason local host works because its running in this computer. in any other instances use ip address or url
            // Now create Statement
            s = c.createStatement();
            
        }catch(Exception e) {
            System.out.println(e);
        }
    }
   
}
