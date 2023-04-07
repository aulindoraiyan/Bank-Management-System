
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear;
    JTextField cardTextField ;
    JPasswordField pinTextField; 
    
    Login(){
    
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null); // Since I used Null. it will not make any template
        // so I have to make the custom template on my own. use label.setBounds to create the template
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Onward", Font.BOLD, 38));
        add(text);
        
        JLabel funnyText = new JLabel("Give me an internship");
        funnyText.setBounds(600, 35, 150, 40);
        funnyText.setFont(new Font("Serif", Font.ITALIC   , 14));
        add(funnyText);
        
        
        JLabel cardno = new JLabel("Card No: ");
        cardno.setBounds(120, 150, 150, 40);
        cardno.setFont(new Font("Railway", Font.BOLD, 20));
        add(cardno);
        
         cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        cardTextField.setFont(new Font ("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN: ");
        pin .setBounds(125, 220, 150, 40);
        pin .setFont(new Font("Railway", Font.BOLD, 20));
        add(pin );
        
         pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 150, 30);
        pinTextField.setFont(new Font ("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
         signup = new JButton("SIGNUP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        
        add(signup);
        
        
        
        getContentPane().setBackground(Color.CYAN);
    
    setSize(800, 480);
    setVisible(true);
    setLocation(350, 200);
}
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText(" ");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login){
            
        }
        else if(ae.getSource() == signup){
        
        }
    }

    public static void main(String args[]){
         new Login();
    }
    
    
}
