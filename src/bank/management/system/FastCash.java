
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, ministatement, fastcash, balanceenquiry, pinchange, exit;
    String pinnumber;
       FastCash(String pinnumber){
       this.pinnumber = pinnumber;
           
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,680);
    add(image);
    
    JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
    text.setBounds(225, 190, 700, 35);
    text.setForeground(Color.white);
    text.setFont(new Font("System", Font.BOLD, 16));
    image.add(text);//text.add er karone, image er upor text ta thakbe. or else 
    //frame er upor thakto jeta image diye dhaka pore jaito.
    
     deposit = new JButton("$ 20");
    deposit.setBounds(170, 305, 150, 30);
    deposit.addActionListener(this);
    image.add(deposit);
    
    withdrawl = new JButton("$ 50");
    withdrawl.setBounds(355, 305, 150, 30);
    withdrawl.addActionListener(this);
    image.add(withdrawl);
    
    fastcash = new JButton("$ 100");
    fastcash.setBounds(170, 340, 150, 30);
    fastcash.addActionListener(this);
    image.add(fastcash);
    
    ministatement = new JButton("$200");
    ministatement.setBounds(355, 340, 150, 30);
    ministatement.addActionListener(this);
    image.add(ministatement);
    
    pinchange = new JButton("$ 500");
    pinchange.setBounds(170, 375, 150, 30);
    pinchange.addActionListener((ActionListener) this);
    image.add(pinchange);
    
    balanceenquiry = new JButton("$ 1000");
    balanceenquiry.setBounds(355, 375, 150, 30);
    balanceenquiry.addActionListener(this);
    image.add(balanceenquiry);
    
    exit = new JButton("Back");
    exit.setBounds(355, 410, 150, 30);
    exit.addActionListener(this);
     image.add(exit);
       
       setSize(900,900);
       setLocation(300, 0);
//      setUndecorated( true);
       setVisible(true);// set visible shobar niche thakbe
       
       
       } 
       
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(2); //ekhane sub string use kortesi because we dont wantthe $ and the space after dollar
            Conn c = new Conn();
            try{
                
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "$ " + amount + " Debited Successfully");
                
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
            
        }
        
    }
       
    
   
    public static void main(String args[]) {
            new FastCash("");
    }
}

