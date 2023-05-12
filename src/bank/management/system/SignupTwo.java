
package bank.management.system;




import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*; // because we are using the active listener interface. 
// etar karon jokhon next chaap dibe, amra shob value jeno database e nite pari. basically 
// kono action jeno hoi. 



public class SignupTwo extends JFrame implements ActionListener {
    
    
    
    JButton next;
   
    JComboBox religion, income, education, occupation, seniorCitizen;
        String formno;// this is how we connect the first form with the secoond one


   SignupTwo(String formno) {
       
       setLayout(null);
       this.formno = formno;
       
       
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
       JLabel religionL = new JLabel("Religion: ");
       religionL.setFont(new Font("Railway", Font.BOLD, 15));
       religionL.setBounds(100, 190, 100, 30);
       add(religionL);
       
       String valReligion[] = {"Muslim", "Christian", "Hindu", "Jew", "Other" };
        religion = new JComboBox(valReligion);
       religion.setBounds(300, 190, 400, 30);
       religion.setBackground(Color.WHITE);
       add(religion);
       /**
        * so ekhane set bounds emon hobe. look at the uporer section2. okhane
        * 2nd and 4th no. set bounds hoilo 140 + 30 = 170; and jeta add hobe otar 
        * sathe + 20 add hobe. so 170 + 20 = 190
        */
       
       
      
       JLabel incomeL = new JLabel("Annual Income: ");
       incomeL.setFont(new Font("Railway", Font.BOLD, 15));
       incomeL.setBounds(100, 240, 200, 30);
       add(incomeL);
       
       String incomeCategory[] = {"null", "< 50,000$", "< 1,00,000$" , "> 1,00,000$"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
       add(income);
       
       
       
       
       JLabel EducationL = new JLabel("Highest Degree / Education: ");
       EducationL.setFont(new Font("Railway", Font.BOLD, 13));
       EducationL.setBounds(100, 290, 200, 30);
       add(EducationL);
       
       String educationOption[] = {"High School", "Bachelors", "Masters", "Phd"};
       
        education = new JComboBox(educationOption); 
        education.setBounds(300, 290, 400, 30);
       education.setBackground(Color.white);
      
       add(education);
       
       
     
       
        JLabel email = new JLabel("Occupation: ");
       email.setFont(new Font("Railway", Font.BOLD, 15));
       email.setBounds(100, 340, 200, 30);
       add(email);
       
       String OccupationOption[] = {"Salaried", "Self-Employed", "Business", "Student", "Others"};
        occupation = new JComboBox(OccupationOption);
          occupation.setFont(new Font("Railway", Font.BOLD, 15));
       occupation.setBounds(300, 340, 400, 30);
       add(occupation);
  
       
       JLabel seniorCitizenL = new JLabel("Senior Citizen: ");
       seniorCitizenL.setFont(new Font("Railway", Font.BOLD, 15));
       seniorCitizenL.setBounds(100, 390, 200, 30);
       add(seniorCitizenL);
       
       String seniorCitizenOption[] = { "Yes", "No" };
       
        seniorCitizen = new JComboBox(seniorCitizenOption);
       seniorCitizen.setFont(new Font("Railway", Font.BOLD, 15));
       seniorCitizen.setBounds(300, 390, 400, 30);
       add(seniorCitizen);
       
       
       
       
     
   
       
        next = new JButton("Next");
       next.setBackground(Color.black);
       next.setForeground(Color.white);
       next.setFont(new Font("Railway", Font.BOLD, 14));
       next.setBounds(620, 550, 80, 30);
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
//      String formno =  "" + random;// int. ekhane shob String value dite hobe tai empty 
      // string er sathe int concat (+) kore dilei ota STring hoye jabe. 
      String sReligion = (String)religion.getSelectedItem();  //casting it as String cus religioncombobox.getelected item object return kortesilo. 
      
      String sIncome = (String) income.getSelectedItem();
      String sEducation = (String) education.getSelectedItem();
      String sOccupation = (String) occupation.getSelectedItem();
      String sSeniorCitizen = (String) seniorCitizen.getSelectedItem();
      
      
      
  
     
      
      /**
       * now amra database e akta hit marbo. Because database 
       * akta external entity and akta run time error ashar chances ase. 
       * so we will also print the error. 
       */
      
      try{
          
              Conn c = new Conn();
              String query = "insert into signuptwo values('" + formno + "', '" + sReligion + "', '" + sIncome + "', '" + sEducation + "', '" + sOccupation + "', '" + sSeniorCitizen + "')";  
              
              c.s.executeUpdate(query); // as a result my quesry will run in mysql
               
              //signup3 object
              setVisible(false);
              new SignupThree(formno).setVisible(true);
              
          
      }catch(Exception e){
          System.out.println(e);
      }
      
      }
    public static void main(String args[]) {
        new SignupTwo("");
        
    
}
   
   }
