/*    Jonathan Slimovitch
      CS 110: Intermediate Programming
      Assignment #10
      
      GUI Implementation
*/

import java.awt.*;         //Needed for Swing classes
import javax.swing.*;      //Needed for Color class
import java.awt.event.*;   //Needed for event listening
import javax.swing.JOptionPane; //Needed for JOptionPane

public class WarGUI extends JFrame
{
   
   public JPanel panelCenter, panel1, panel2, panel3, panelWest, panelEast, panel4, panel5, panel6, panel7;
   public JLabel pic1, pic2;
   private ImageIcon ufront, cfront, back;
   public String runner="n";
   public JTextField myRunner;
   
   private JButton button, button1;
   private final int WINDOW_WIDTH=900;
   private final int WINDOW_HEIGHT=300;
   
   /**
      Constructor sets up frame size, layout, border, and colors. It also creates panel1-panel7, as 
      well as panelCENTER, panelWEST, and panelEast.
   */
   
   public WarGUI()
   {
      //Set window title
      setTitle("Card Game: WAR");
                    
      //Set size of window
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      //Set window layout
      setLayout(new BorderLayout());
      
      //Create panelCenter
      panelCenter=new JPanel(new GridLayout(1,2));
      add(panelCenter, BorderLayout.CENTER);
      
      //Create panelWest
      panelWest=new JPanel(new GridLayout(2,1));
      panelWest.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Actions: "),BorderFactory.createLineBorder(Color.BLACK,2)));
      add(panelWest,BorderLayout.WEST);
      
      //Create panelEast
      panelEast=new JPanel(new GridLayout(2,1));
      panelEast.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Player Totals: "),BorderFactory.createLineBorder(Color.BLACK,2)));
      panelEast.revalidate();
      add(panelEast,BorderLayout.EAST);
      
      //Create panel1
      panel1=new JPanel();
      JLabel messageLabel=new JLabel("User");
      //Add the label components to the panel
      panel1.add(messageLabel);
      //Specify what happens when close button is clicked
      panel1.setBackground(Color.ORANGE);      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Set picture icons
      ufront=new ImageIcon("back.jpg");
      back=new ImageIcon("back.jpg");
      pic1=new JLabel(back);
      //Add panel1 to panelCenter
      panelCenter.add(panel1);
      //Display the window
      setVisible(true);
      
      //Create panel2
      panel2=new JPanel();
      JLabel messageLabel2=new JLabel("Computer");
      //Add the label components to the panel
      panel2.add(messageLabel2);
      panel2.setBackground(Color.GREEN);
      //Specify what happens when close button is clicked
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Set picture icons
      pic2=new JLabel(back);
      //Add panel2 to panelCenter
      panelCenter.add(panel2);
      //Display the window
      setVisible(true);
      
      //Create panel3
      panel3=new JPanel();
      JLabel messageLabel3=new JLabel("User Total");
      //Add the label components to the panel
      panel3.add(messageLabel3);
      panel3.setBackground(Color.CYAN);
      //Specify what happens when close button is clicked
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Add panel3 to panelEast
      panelEast.add(panel3);
      //Display the window
      setVisible(true);
      
      //Create panel4
      panel4=new JPanel();
      JLabel messageLabel5=new JLabel("Computer Total");
      //Add the label components to the panel
      panel4.add(messageLabel5);
      panel4.setBackground(Color.CYAN);
      //Specify what happens when close button is clicked
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Add panel4 to panelEast
      panelEast.add(panel4);
      //Display the window
      setVisible(true);

      //Create panel5
      panel5=new JPanel();
      JLabel messageLabel6=new JLabel("Click Flip to Play!");
      //Add the label components to the panel
      panel5.add(messageLabel6);
      //Specify what happens when close button is clicked
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      panel5.setBackground(Color.CYAN);
      //Add panel5 to frame
      add(panel5, BorderLayout.SOUTH);
      //Display the window
      setVisible(true);

      //Create panel6
      panel6=new JPanel();
      //Create button
      button=new JButton("Flip");
      button.addActionListener(new ButtonListener());
      panel6.add(button);
      panel6.setBackground(Color.CYAN);
      //Add panel6 to panelWest
      panelWest.add(panel6);
      
      //Create panel7
      panel7=new JPanel();
      //Create button
      // button1=new JButton("Draw next card: ");
//       button1.addActionListener(new ButtonListener1());
//       panel7.add(button1);
//       //Add panel7 to panelWest
//       JTextField myRunner=new JTextField();
//       myRunner.setBounds(70,70,120,20);
//       panel7.add(myRunner);
      panel7.setBackground(Color.CYAN);
      
      panelWest.add(panel7);
      

             
   }
   
   /**
      Flips User Picture (from back to front or vice versa)
      @param myString String address of Card
   */
   
   public void FlipPanelUser(String myString)
   {      
      pic1.setIcon(null);                  
      
      ufront=new ImageIcon(myString+".jpg");
      back=new ImageIcon("back.jpg");
      pic1=new JLabel(back);
      pic1.setIcon(back);
      panel1.add(pic1);
   }
   
   /**
      Flips Computer Picture (from back to front or vice versa)
      @param myString String address of Card
   */
   
   public void FlipPanelComputer(String myString)
   {      
      pic2.setIcon(null);
      cfront=new ImageIcon(myString+".jpg");
      back=new ImageIcon("back.jpg");
      pic2=new JLabel(back);
      pic2.setIcon(back);
      panel2.add(pic2);
      panel2.revalidate();
   }
   
   /**
      ButtonListener implementsActionListener. If clicked, it causes pic1 and pic2 to flip
   */
    
   class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent u)
      {
         if (pic1.getIcon()!= ufront&& pic2.getIcon()!=cfront)
         {
            pic1.setIcon(ufront);
            pic2.setIcon(cfront);
         }
         else
         {
            pic1.setIcon(back);
            pic2.setIcon(back);
         }
         
      }
   }
   
   /**
      Returns runner, indicating whether or not another card will be dealt
      @return The value of the runner
   */
   
   // public String getRunner()
//    {
//       return runner;
//    }

   /**
      ButtonListener1 implements ActionListener. If clicked, it sets String Runner = "y"
   */
   
   // class ButtonListener1 implements ActionListener
//    {
//       public void actionPerformed(ActionEvent d)
//       {
//          //runner=JOptionPane.showInputDialog("Do you want to run again? (enter y/n)");
//       }
//    }
//    
   /**
      Method updates panel3 to include the total number of cards in User's Hand
      @param num The number of cards in User's Hand
   */
   
   public void userTotal(int num)
   {
      
      panel3.removeAll();
      JLabel messageLabel4=new JLabel("\nCards in User's Hand: "+num);
      panel3.add(messageLabel4);
   
        
      //Specify what happens when close button is clicked
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      panelEast.add(panel3);
   
   }
   
   /**
      Method updates panel4 to include the total number of cards in Computer's Hand
      @param num The number of cards in Computer's Hand
   */
   
   public void computerTotal(int num)
   {
      
      panel4.removeAll();
      JLabel messageLabel5=new JLabel("Cards in Computer's Hand: "+num);
      panel4.add(messageLabel5);
      panelEast.add(panel4);
   }
   
   /**
      Method declares whether User1 or User2 won
      @param compareValue The compareValue field from War class (1 if User 1 won, 2 if User 2 won, 3 if tie)
      @param roundNum The round number   
   */
   
   public void bottom(int compareValue,int roundNum)
   {
      String s="";
      panel5.removeAll();
      if(compareValue==1)
      {
         s="User won!";
      }
      else if (compareValue==2)
      {
         s="Computer won!";
      }
      
             
      
      JLabel messageLabel6=new JLabel(s+"                     \n Round Number:"+roundNum);
      panel5.add(messageLabel6);
      add(panel5, BorderLayout.SOUTH);
   }
  
}
      
   

