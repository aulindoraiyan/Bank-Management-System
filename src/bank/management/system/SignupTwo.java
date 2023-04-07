
package bank.management.system;




import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*; // because we are using the active listener interface. 
// etar karon jokhon next chaap dibe, amra shob value jeno database e nite pari. basically 
// kono action jeno hoi. 



public class SignupTwo extends JFrame implements ActionListener {
    
    int random;
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, 
            addressTextField, cityTextField, stateTextField, countryTextField;
    
    JButton next;
    JRadioButton male, female, others, single, married;
    

   SignupTwo() {
       
       setLayout(null);
       
      setTitle("NEW ACCOUNT APPLICATION FORM ~ PAGE 2");
       
       // uporer section : 
//       JLabel additionalDetails = new JLabel("");
//       additionalDetails.setFont(new Font ("Railway", Font.BOLD, 28 ));
//       additionalDetails.setBounds(140, 20, 600, 40);
//       add(additionalDetails);
       
       JLabel additionalDetails = new JLabel ("Page 2: Additional Details");
       additionalDetails.setFont(new Font("Railway", Font.BOLD, 18));
       additionalDetails.setBounds(290, 80, 400, 30);
       add(additionalDetails);
       
       // Uporer section 2: 
       JLabel religion = new JLabel("Religion: ");
       religion.setFont(new Font("Railway", Font.BOLD, 15));
       religion.setBounds(100, 140, 100, 30);
       add(religion);
       
       String valReligion[] = {"Muslim", "Christian", "Hindu", "Jew", "Other" };
       JComboBox religionComboBox = new JComboBox(valReligion);
       religionComboBox.setBounds(300, 140, 400, 30);
       religionComboBox.setBackground(Color.WHITE);
       add(religionComboBox);
       /**
        * so ekhane set bounds emon hobe. look at the uporer section2. okhane
        * 2nd and 4th no. set bounds hoilo 140 + 30 = 170; and jeta add hobe otar 
        * sathe + 20 add hobe. so 170 + 20 = 190
        */
       
       
      
       JLabel income = new JLabel("Annual Income: ");
       income.setFont(new Font("Railway", Font.BOLD, 15));
       income.setBounds(100, 240, 200, 30);
       add(income);
       
       String incomeCategory[] = {"null", "< 50,000$", "< 1,00,000$" , "> 1,00,000$"};
       JComboBox incomeComboBox = new JComboBox(incomeCategory);
        incomeComboBox.setBounds(300, 240, 400, 30);
        incomeComboBox.setBackground(Color.WHITE);
       add(incomeComboBox);
       
       
       
       
       JLabel Education = new JLabel("Highest Degree / Education: ");
       Education.setFont(new Font("Railway", Font.BOLD, 13));
       Education.setBounds(100, 290, 200, 30);
       add(Education);
       
       String educationOption[] = {"High School", "Bachelors", "Masters", "Phd"};
       
       JComboBox educationComboBox = new JComboBox(educationOption); 
        educationComboBox.setBounds(300, 290, 120, 30);
       educationComboBox.setBackground(Color.white);
      
       add(educationComboBox);
       
       
     
       
        JLabel email = new JLabel("Qualification: ");
       email.setFont(new Font("Railway", Font.BOLD, 15));
       email.setBounds(100, 340, 200, 30);
       add(email);
       
        emailTextField = new JTextField();
       emailTextField.setFont(new Font("Railway", Font.BOLD, 14));
       emailTextField.setBounds(300, 340, 400, 30);
       add(emailTextField);
       
       JLabel maritalStatus = new JLabel("Occupation: ");
       maritalStatus.setFont(new Font("Railway", Font.BOLD, 15));
       maritalStatus.setBounds(100, 390, 200, 30);
       add(maritalStatus);
       
        single = new JRadioButton("Single");
       single.setBounds(300, 390, 80, 30);
       single.setBackground(Color.white);
       add(single);
       
        married = new JRadioButton("Married");
       married.setBounds(450, 390, 80, 30);
       married.setBackground(Color.white);
       add(married);
       
       ButtonGroup marriageGroup = new ButtonGroup();
       marriageGroup.add(single);
       marriageGroup.add(married);
       
       
       JLabel address = new JLabel("Address: ");
       address.setFont(new Font("Railway", Font.BOLD, 15));
       address.setBounds(100, 440, 200, 30);
       add(address);
       
        addressTextField = new JTextField();
       addressTextField.setFont(new Font("Railway", Font.BOLD, 14));
       addressTextField.setBounds(300, 440, 400, 30);
       add(addressTextField);
       
        JLabel city = new JLabel("City: ");
       city.setFont(new Font("Railway", Font.BOLD, 15));
       city.setBounds(100, 500, 200, 30);
       add(city);
       
        cityTextField = new JTextField();
       cityTextField.setFont(new Font("Railway", Font.BOLD, 14));
       cityTextField.setBounds(300, 500, 400, 30);
       add(cityTextField);
       
       JLabel state = new JLabel("Senior Citizen: ");
       state.setFont(new Font("Railway", Font.BOLD, 15));
       state.setBounds(100, 550, 200, 30);
       add(state);
       
          stateTextField = new JTextField();
       stateTextField.setFont(new Font("Railway", Font.BOLD, 14));
       stateTextField.setBounds(300, 550, 400, 30);
       add(stateTextField);
       
       
     
       JLabel country = new JLabel("Existing Account: ");
       country.setFont(new Font("Railway", Font.BOLD, 15));
       country.setBounds(100, 600, 200, 30);
       add(country);
       
          countryTextField = new JTextField();
       countryTextField.setFont(new Font("Railway", Font.BOLD, 14));
       countryTextField.setBounds(300, 600, 400, 30);
       add(countryTextField);
       
        next = new JButton("Next");
       next.setBackground(Color.black);
       next.setForeground(Color.white);
       next.setFont(new Font("Railway", Font.BOLD, 14));
       next.setBounds(620, 660, 80, 30);
       next.addActionListener(this); /** adding this because we need an action 
        * when next button is clicked. 
        * **/
       
         
       add(next);
       
       
       
       getContentPane().setBackground(Color.WHITE);// frame er color change korlo
       /**
        * below is the code jeta frame banabe. make sure to
        * import import javax.swing.*;
import java.awt.*; as necessary. 
        */
       setSize(850, 800);
       setLocation(350, 10);
       setVisible(true);
       
   }
   
   /**
    * adding nicher method to overwrite the function.
    * Next e chaap dile ki ki hobe otar jonno method. 
    * jei values gula amra database e dhukaite chai, oi values gula nicher method
    * e likhte hobe. Shob gula ke STring e convert korte hobe cus database e 
    * only STring value dhukabo. 
    * @param ae 
    */
   public void actionPerformed(ActionEvent ae){
      String formno =  "" + random;// int. ekhane shob String value dite hobe tai empty 
      // string er sathe int concat (+) kore dilei ota STring hoye jabe. 
      String name = nameTextField.getText();
      String fname = fnameTextField.getText();
      String dob = dobTextField.getText();
      String gender = null; /**
       * isSeleted use kore dekhte parbo amader kon Radio Button selected hoise. 
       * 
       */
      if(male.isSelected()){
          gender = "Male";
      }
      else if(female.isSelected()){
          gender = "Female";
      }
      else if (others.isSelected()){
          gender = "others";
      }
      String email = emailTextField.getText();
      
      String maritalStatus = null; 
      if(single.isSelected()){
      maritalStatus = "Single" ;
      }
      else if (married.isSelected()){
              maritalStatus = "Married";
              }
      
      String address = addressTextField.getText();
      String city = cityTextField.getText();
      String state = stateTextField.getText();
      String country = countryTextField.getText();
     
      
      /**
       * now amra database e akta hit marbo. Because database 
       * akta external entity and akta run time error ashar chances ase. 
       * so we will also print the error. 
       */
      
      try{
          if(name.equals("")){
              JOptionPane.showMessageDialog(null, "Name is required");
          }else{
              Conn c = new Conn();
              String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + maritalStatus + "', '" + address + "', '" + city + "', '" + state + "', '" + country + "')"; 
              
              c.s.executeUpdate(query); // as a result my quesry will run in mysql
                      
          }
      }catch(Exception e){
          System.out.println(e);
      }
      
      }
    public static void main(String args[]) {
        new SignupTwo();
        
    
}
   
   }
