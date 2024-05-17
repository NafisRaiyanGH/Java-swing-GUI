package classes;
import Interface.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class AddStudentCost extends JFrame implements ActionListener,Icalculate{
    
private Container c;
private  Color c1=new Color(211,211,211);
private Font font = new Font("cambria", Font.BOLD,15);
private Font fontt = new Font("cambria", Font.PLAIN ,35);
private JTable table;
private JComboBox price,selectcourse,qty;
private DefaultTableModel model;
private JLabel l1,l2,l3,titleLabel,idlabel,cnamelabel,datelable,paylabel;
private JTextField idtext,cnametext,datetext,paytext;
private JButton addButton,exitButton,payButton,paidButton;
private JScrollPane scroll;
private String[] course={"eee","cse"};
private String []quantity={"1","2"};
private String [] Price={"3300","4400"};
private String [] cols={"ID","Student Name ","Date","course","Quantity","Course Cost","Total"};
private JTextField id,cname,mobile,date,total;
private String [] rows=new String[7];
	
	
	 AddStudentCost()
	 {
		initComponents() ;
               
                this.setVisible(true);
              this.setLocationRelativeTo(null);
		 
	 }
	
	public void initComponents()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(50,50,900,700);
		this.setTitle("Cost Dashboard : Student Management System");
		
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(c1);
                
                 titleLabel = new JLabel("Cost Dashboard");
        titleLabel.setFont(fontt );
        titleLabel.setBounds(2,-50,400,150);
        c.add(titleLabel);
		
		selectcourse=new JComboBox(course);
		selectcourse.setBounds(150,250,170,30);
		
		c.add(selectcourse);
		
		qty=new JComboBox(quantity);
		qty.setBounds(400,300,150,30);
                c.add(qty);
                
                price=new JComboBox(Price );
		 price.setBounds(150,300,170,30);
		c.add( price);
                
               l3=new JLabel("Cost Per Course : ");
		l3.setBounds(40,300,150,30);
		l3.setFont(font);
		c.add(l3);
		
		l1=new JLabel("Select course : ");
		l1.setBounds(40,250,150,30);
		l1.setFont(font);
		c.add(l1);
		
		l2=new JLabel("Quantity");
		l2.setBounds(330,300,150,30);
		l2.setFont(font);
		c.add(l2);
		
		addButton=new JButton("Add Course");
		addButton.setBounds(600,300,150,30);
		c.add(addButton);
                
                payButton=new JButton("Calculate Cost");
		payButton.setBounds(550,210,150,30);
		c.add(payButton);
                
                 paidButton=new JButton("Paid");
                 paidButton.setFont(font);
		paidButton.setBounds(570,250,100,30);
		c.add(paidButton);
                
                paylabel = new JLabel("Total Amount ");
         paylabel .setBounds(550,100,200,50);
        paylabel .setFont(font);
        c.add( paylabel );
        
        
        paytext = new JTextField();
       paytext.setBounds(550,150,150,50);
        paytext.setFont(font);
        c.add(paytext);
                
         idlabel = new JLabel("ID : ");
         idlabel .setBounds(40,130,100,30);
        idlabel .setFont(font);
        c.add( idlabel );
        
        
        idtext = new JTextField();
       idtext.setBounds(100,130,230,30);
        idtext.setFont(font);
        c.add(idtext);
        
        cnamelabel = new JLabel("Student Name : ");
        cnamelabel .setBounds(40,180,130,30);
       cnamelabel .setFont(font);
        c.add( cnamelabel );
        
        
        cnametext = new JTextField();
        cnametext.setBounds(180,180,150,30);
        cnametext.setFont(font);
        c.add(cnametext);
        
       datelable = new JLabel("Date : ");
        datelable .setBounds(40,80,130,30);
       datelable.setFont(font);
        c.add( datelable );
        
        
        datetext = new JTextField();
        datetext.setBounds(100,80,230,30);
        datetext.setFont(font);
        c.add(datetext);
		
		exitButton=new JButton("Exit");
		exitButton.setBounds(610,620,150,30);
                exitButton.setFont(font);
		c.add(exitButton);
                
                table =new JTable();
                model=new DefaultTableModel();
                model.setColumnIdentifiers(cols);
                table.setModel(model);
                table.setFont(font);
                table.setSelectionBackground(Color.lightGray);
                table.setBackground(Color.WHITE);
                table.setRowHeight(40);
                scroll=new JScrollPane(table);
                scroll.setBounds(40, 340, 800, 265);
                c.add(scroll);
                addButton.addActionListener(this);
                payButton.addActionListener(this);
                paidButton.addActionListener(this);
                exitButton.addActionListener(this);
                
		
		
		
		
	}
   public void getSum() 
   {
       int sum=0;
       for(int i=0;i<table.getRowCount();i++)
       {
        sum=sum+Integer.parseInt(table.getValueAt(i, 6).toString());
       }
       paytext.setText(Integer.toString(sum)+" "+"TK");
       
   }
           


    @Override
   
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==addButton)
       { 
      /*    
      String selectmedi=selectcourse.getSelectedItem().toString();
         String selectqt=qty.getSelectedItem().toString();
          String Selectprice= price.getSelectedItem().toString();
          int QTY=Integer.parseInt(selectqt);
          int unitprice=Integer.parseInt(Selectprice);
       int bill=unitprice*QTY;
         String Bill= String.valueOf(bill);

          
      rows[0] = idtext.getText();
      rows[1] = cnametext.getText();
      rows[2] = datetext.getText();
              
      rows[3] = selectmedi;
      rows[4]=selectqt;
      rows[5]= Selectprice;
      rows[6]=Bill;
      
      
       model.addRow(rows);
        
        */   
         getBill() ; 
       }
       else if(e.getSource()==payButton)
       {
           getSum() ;
             
       }
       else if(e.getSource()==paidButton)
       {
         JOptionPane.showConfirmDialog(null, "Are You Collect Bill From Student ? ", "Confrim", JOptionPane.YES_NO_OPTION);
         JOptionPane.showMessageDialog(null, "Success");
       }
     
       else if(e.getSource()==exitButton)
       {
        this.setVisible(false);
        new Dashboard(); 
       }
           
       
        
    }

    @Override
    public void getBill() {
           
      String selectmedi=selectcourse.getSelectedItem().toString();
         String selectqt=qty.getSelectedItem().toString();
          String Selectprice= price.getSelectedItem().toString();
          int QTY=Integer.parseInt(selectqt);
          int unitprice=Integer.parseInt(Selectprice);
       int bill=unitprice*QTY;
         String Bill= String.valueOf(bill);

          
      rows[0] = idtext.getText();
      rows[1] = cnametext.getText();
      rows[2] = datetext.getText();
              
      rows[3] = selectmedi;
      rows[4]=selectqt;
      rows[5]= Selectprice;
      rows[6]=Bill;
      
      
       model.addRow(rows);
    }
	
	
	
	
}