import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LC {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField RegtxtUser;
	private JTextField txtPass;
	private JTextField Regtxtpass;

	
	
	

	private JButton btnUpdate;
	private JTextField txtId;
	private JButton btnDelete;
	public static Connection con;
	
	public int user;
	public int Per;
	public String UserName;
	int clothesid;
	int Qtysale;
	int QtyReresiduum;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LC window = new LC();
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void CheckLogin() 
	{
		String User=txtUser.getText();
		String pass=txtPass.getText();
		
		ResultSet dt = null;
		try {
			con=DBcon.connect();
			dt = DBcon.MSelect(User, pass);
			
			while (dt.next()) {  
	        	 user=dt.getInt(1);
	        	 Per=dt.getInt(2);
	        	 UserName=dt.getString(3);
	        	 frame.setVisible(true);
					
					
					
	        	
	        }  
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	

	
	
	private JComboBox<String> comboBoxName;
	private JTextField txtSearch;
	private JTable table;
	private JTextField txtNo;
	private JTextField txtName;
	private JTextField txtprice;
	private JTextField txtqty;
	private JTextField txtEmloyee;
	private JTextField txtdate;
	private JTextField txtQtysale;
	private JTextField txtPriceTotal;

	
//	public void myJComboBox() {
//	    try {   //6
//	    	
//	    	con=DBcon.connect();
//	    	
//		    String sql = "select * from Permision";
//		    
//	        PreparedStatement pst  = con.prepareStatement(sql);  
//	        System.out.println("sdsdsdsd");
//	        ResultSet rs = pst.executeQuery();
//	        System.out.println(rs.next());
//	        while (rs.next()) {  
//	        	comboBoxName.addItem(rs.getString("PermisionName"));
//	        
//	        }  
//	      
//	     
//	} catch (SQLException e1) {  
//	    System.out.println(e1.getMessage());  
//	}
//	}
//	
	

	/**
	 * Create the application.
	 */
	public LC() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 585, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		JPanel panLogin = new JPanel();
		frame.getContentPane().add(panLogin, "name_772072286471253");
		panLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(83, 86, 67, 14);
		panLogin.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(83, 151, 67, 14);
		panLogin.add(lblNewLabel_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(199, 83, 96, 20);
		panLogin.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(199, 148, 96, 20);
		panLogin.add(txtPass);
		JPanel panSelaing = new JPanel();
		frame.getContentPane().add(panSelaing, "name_846315517879263");
		panSelaing.setLayout(null);
		JButton BtnLogin = new JButton("Login");
		JPanel panelItem = new JPanel();
		panelItem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelItem.setBounds(10, 51, 524, 313);
		panSelaing.add(panelItem);
		panelItem.setLayout(null);
		
		BtnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CheckLogin();
				  
				if(user!=0)
				{
				
				panSelaing.setVisible(true);
				panLogin.setVisible(false);
				
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Incorrect");
				}
				
			}

			/**
			 * 
			 */
			
		});
		BtnLogin.setBounds(199, 234, 89, 23);
		panLogin.add(BtnLogin);
		
		JPanel panRegister = new JPanel();
		frame.getContentPane().add(panRegister, "name_772072286471253");
		panRegister.setLayout(null);
		
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				//BtnLogin.addActionListener(null);
				CheckLogin();
				System.out.println(Per);
				if(Per==1)
				
				{
				panRegister.setVisible(true);
				panLogin.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Access Deney");
				}
				
			}
		});
		btnRegister.setBounds(328, 234, 89, 23);
		panLogin.add(btnRegister);
		
		
		
		JLabel lblNewLabel1 = new JLabel("UserName");
		lblNewLabel1.setBounds(83, 86, 67, 14);
		panRegister.add(lblNewLabel1);
		
		JLabel lblNewLabel_12 = new JLabel("Password");
		lblNewLabel_12.setBounds(83, 151, 67, 14);
		panRegister.add(lblNewLabel_12);
		
		RegtxtUser = new JTextField();
		RegtxtUser.setBounds(199, 83, 96, 20);
		panRegister.add(RegtxtUser);
		RegtxtUser.setColumns(10);
		
		Regtxtpass = new JTextField();
		Regtxtpass.setColumns(10);
		Regtxtpass.setBounds(199, 148, 96, 20);
		panRegister.add(Regtxtpass);
		
		JButton BtnLogin112 = new JButton("Login");
		panRegister.setBounds(199, 234, 89, 23);
		panRegister.add(BtnLogin112);
		
		JLabel lblPermission = new JLabel("Permission");
		lblPermission.setBounds(83, 218, 67, 14);
		panRegister.add(lblPermission);
		
		JComboBox<?> comboBoxPer = new JComboBox<Object>();
		comboBoxPer.setModel(new DefaultComboBoxModel(new String[] {"User", "Admin"}));
		comboBoxPer.setBounds(221, 214, 179, 22);
		panRegister.add(comboBoxPer);
		
		
		
	
		
		
		
		
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String RUser=RegtxtUser.getText();
				String Rpass=Regtxtpass.getText();
				int Permission = 0;
				String Rper=(String) comboBoxPer.getSelectedItem();
				if(Rper=="User")
				{
					 Permission =2;
					
					
				}
				if(Rper=="Admin")
				{
					 Permission =1;
				}
				
				try {
					con=DBcon.connect();
					 DBcon.InsertUser(RUser, Rpass,Permission);
					
					
			        	JOptionPane.showMessageDialog(null,"SuccefullInsertUser");
			        }  
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(156, 286, 89, 23);
		panRegister.add(btnNewButton);
		
		JButton btnBackToLogin = new JButton("back");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panRegister.setVisible(false);
				panLogin.setVisible(true);
			}
		});
		btnBackToLogin.setBounds(297, 286, 89, 23);
		panRegister.add(btnBackToLogin);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("\u0627\u062F\u062E\u0644 \u0631\u0645\u0632 \u0627\u0644\u0645\u0627\u062F\u0629");
		lblNewLabel_2.setBounds(430, 26, 110, 14);
		panSelaing.add(lblNewLabel_2);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(293, 23, 127, 20);
		panSelaing.add(txtSearch);
		txtSearch.setColumns(10);
		JButton BtnSeasrch = new JButton("\u0628\u062D\u062B");
		BtnSeasrch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int search=Integer.parseInt(txtSearch.getText());
				//JOptionPane.showMessageDialog(null,search);
				
				ResultSet dtTable = null;
				try {
					con=DBcon.connect();
					dtTable = DBcon.MSelect(search);
					//table_1.setModel(DbUtils.resultSetToTableModel(dtTable));
					while (dtTable.next()) {  
						JOptionPane.showMessageDialog(null,"table Succefull");
						
						      
						 clothesid=(dtTable.getInt(1));
                             txtNo.setText(dtTable.getString(2));
                             txtqty.setText(dtTable.getString(3));
                             
                             txtName.setText(dtTable.getString(4));
                             
                             txtprice.setText(dtTable.getString(5));
                            
                            txtEmloyee.setText(UserName);
                             
                             
                            LocalDate date = LocalDate.now();
                            //date.atStartOfDay();
//                            String str=new SimpleDateFormat("yyy-MM-dd").format(date.getMonthValue());
                            String str=new SimpleDateFormat("yyy-MM-dd").format(date.getDayOfMonth());
                            txtdate.setText(str);
                            
                           
						
						
						
						
						
						
						//JOptionPane.showMessageDialog(null,dtTable.);
					//	table_1.setModel(DbUtils.resultSetToTableModel(dtTable));
			        
			        }  
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
			}
		});
		BtnSeasrch.setBounds(129, 22, 89, 23);
		panSelaing.add(BtnSeasrch);
		
		
		JLabel lblNewLabel_3 = new JLabel("\u0631\u0645\u0632 \u0627\u0644\u0645\u0627\u062F\u0629");
		lblNewLabel_3.setBounds(428, 106, 48, 14);
		panelItem.add(lblNewLabel_3);
		
		JLabel label = new JLabel("\u0627\u0633\u0645 \u0627\u0644\u0645\u0627\u062F\u0629");
		label.setBounds(428, 131, 72, 14);
		panelItem.add(label);
		
		JLabel label_1 = new JLabel("\u0627\u0644\u0633\u0639\u0631");
		label_1.setBounds(438, 156, 72, 14);
		panelItem.add(label_1);
		
		JLabel lblNewLabel_4 = new JLabel("\u0627\u0644\u0643\u0645\u064A\u0629");
		lblNewLabel_4.setBounds(428, 181, 48, 14);
		panelItem.add(lblNewLabel_4);
		
		JLabel label_2 = new JLabel("\u0627\u0633\u0645 \u0627\u0644\u0645\u0648\u0638\u0641");
		label_2.setBounds(428, 207, 72, 14);
		panelItem.add(label_2);
		
		JLabel label_3 = new JLabel("\u0627\u0644\u0648\u0642\u062A \u0648\u0627\u0644\u062A\u0627\u0631\u064A\u062E");
		label_3.setBounds(428, 238, 82, 14);
		panelItem.add(label_3);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(502, 89, -433, -51);
		panelItem.add(table);
		
		txtNo = new JTextField();
		txtNo.setEditable(false);
		txtNo.setColumns(10);
		txtNo.setBounds(264, 103, 96, 20);
		panelItem.add(txtNo);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(264, 128, 96, 20);
		panelItem.add(txtName);
		
		txtprice = new JTextField();
		txtprice.setEditable(false);
		txtprice.setColumns(10);
		txtprice.setBounds(264, 153, 96, 20);
		panelItem.add(txtprice);
		
		txtqty = new JTextField();
		txtqty.setEditable(false);
		txtqty.setColumns(10);
		txtqty.setBounds(264, 178, 96, 20);
		panelItem.add(txtqty);
		
		txtEmloyee = new JTextField();
		txtEmloyee.setEditable(false);
		txtEmloyee.setColumns(10);
		txtEmloyee.setBounds(264, 204, 96, 20);
		panelItem.add(txtEmloyee);
		
		txtdate = new JTextField();
		txtdate.setEditable(false);
		txtdate.setColumns(50);
		txtdate.setBounds(200, 235, 160, 20);
		panelItem.add(txtdate);
		
		txtQtysale = new JTextField();
		txtQtysale.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
				int price =Integer.parseInt(txtprice.getText());
				int Qty =Integer.parseInt(txtqty.getText());
				
				
				if(txtQtysale.getText().equals(""))
				{
					 return ; 
				}
				 Qtysale =Integer.parseInt(txtQtysale.getText());
				if(Qty>=Qtysale) {
					QtyReresiduum=Qty-Qtysale;
				
				int result=price * Qtysale;
				txtPriceTotal.setText(result+"");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"error");
				}
			}
		});
		txtQtysale.setColumns(10);
		txtQtysale.setBounds(264, 21, 96, 20);
		panelItem.add(txtQtysale);
		
		JLabel label_4 = new JLabel("\u0627\u062F\u062E\u0644 \u0627\u0644\u0643\u0645\u064A\u0629 \u0627\u0644\u0645\u0628\u0627\u0639\u0629");
		label_4.setBounds(370, 24, 106, 14);
		panelItem.add(label_4);
		
		JLabel label_5 = new JLabel("\u0627\u0644\u0633\u0639\u0631 \u0627\u0644\u0627\u062C\u0645\u0627\u0644\u064A");
		label_5.setBounds(179, 24, 72, 14);
		panelItem.add(label_5);
		
		txtPriceTotal = new JTextField();
		txtPriceTotal.setEditable(false);
		txtPriceTotal.setColumns(10);
		txtPriceTotal.setBounds(10, 21, 139, 20);
		panelItem.add(txtPriceTotal);
		
		JButton BtnSave = new JButton("\u062D\u0641\u0638");
		BtnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//
				try {
					con=DBcon.connect();
				int qty=Integer.parseInt(txtQtysale.getText());
			
				JOptionPane.showMessageDialog(null,qty);
					 DBcon.InsertSale(user, clothesid,qty,txtdate.getText());
      				 DBcon.Updatesale(clothesid,QtyReresiduum);
					 
                      JOptionPane.showMessageDialog(null,"SuccefullSaling");
			        }  
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//JOptionPane.showMessageDialog(null,e1.printStackTrace());
				}
				
				
				
			}
		});
		BtnSave.setBounds(162, 58, 89, 23);
		panelItem.add(BtnSave);
		
		
		
		
		
		
		
		
		
		
		
		
		//myJComboBox();
		
	}
}
