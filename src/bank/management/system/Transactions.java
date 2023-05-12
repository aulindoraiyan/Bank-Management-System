
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, ministatement, fastcash, balanceenquiry, pinchange, exit;
    String pinnumber;
       Transactions(String pinnumber){
       this.pinnumber = pinnumber;
           
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,680);
    add(image);
    
    JLabel text = new JLabel("Please select your Transaction");
    text.setBounds(230, 175, 700, 35);
    text.setForeground(Color.white);
    text.setFont(new Font("System", Font.BOLD, 16));
    image.add(text);//text.add er karone, image er upor text ta thakbe. or else 
    //frame er upor thakto jeta image diye dhaka pore jaito.
    
     deposit = new JButton("Deposit");
    deposit.setBounds(170, 305, 150, 30);
    deposit.addActionListener(this);
    image.add(deposit);
    
    withdrawl = new JButton("Cash Withdrawl");
    withdrawl.setBounds(355, 305, 150, 30);
    withdrawl.addActionListener(this);
    image.add(withdrawl);
    
    fastcash = new JButton("Fast Cash");
    fastcash.setBounds(170, 340, 150, 30);
    fastcash.addActionListener(this);
    image.add(fastcash);
    
    ministatement = new JButton("Statement");
    ministatement.setBounds(355, 340, 150, 30);
    ministatement.addActionListener(this);
    image.add(ministatement);
    
    pinchange = new JButton("Pin Change");
    pinchange.setBounds(170, 375, 150, 30);
    pinchange.addActionListener((ActionListener) this);
    image.add(pinchange);
    
    balanceenquiry = new JButton("Balance Enquiry");
    balanceenquiry.setBounds(355, 375, 150, 30);
    balanceenquiry.addActionListener(this);
    image.add(balanceenquiry);
    
    exit = new JButton("Exit");
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
            System.exit(0);//frame bondho hoye jabe
        } else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        
    }
       
    
   
    public static void main(String args[]) {
            new Transactions("");
    }
}
