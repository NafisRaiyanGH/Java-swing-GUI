package classes;
import java.awt.Color;
 import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class StudentReport extends JFrame{

    private  Container c;
    private JLabel label,label1;
    private JTable table; 
    private JScrollPane scroll;
    private JPanel panel;
    private Font font;
    private JButton button;
    
    private String []cols = {"ID","Student Name","Cost","School","Grade"};
    private String [][]rows ={
                                {"2001","hanif","456","tgbhs","A"},
                                {"2002","rafik","8900","tgbhs","C"},
                                {"2003","bablu","5600","tgbhs ","D"},
                               
                              
                                
    };
    StudentReport()
    {
        
       this.initcomponents(); 
           this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
     this. setVisible(true);
     this.setLocationRelativeTo(null);
        
    }
    
    
 
  public void  initcomponents(){
      
    this.panel = new JPanel(null);
    panel.setBounds(100, 100, 750, 450);
    panel.setBackground(Color.LIGHT_GRAY);
      font=new Font("Arial",Font.BOLD,20);
      
  c = this.getContentPane();
      c.setLayout(null);
      c.setBackground(Color.LIGHT_GRAY);
      label=new JLabel(" All Student Report");
      label.setBounds(100, 50, 400, 500);
        this.setBounds(100,100,900,550);
      this.setTitle("StudentReport : Student Management System");
      label.setBounds(250,20,200,50);
       this.add(label);
       label.setFont(font);
         table = new JTable(rows,cols);
         scroll = new JScrollPane(table);
          scroll.setBounds(50,80,800,350);
             c.add(scroll); 
             table.setSelectionBackground(Color.green);
             this.button = new JButton("Close");
            
              this.button.setBounds(630, 350, 100, 30);
     button.setFont(font);
    this.panel.add(this.button);
   
     
    this.add(this.panel);
       
    
     this.add(this.panel);
     this.button.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              setVisible(false);
          new Dashboard();
      
          }
    
    
    });
  
}

   
    }

    
      
    


