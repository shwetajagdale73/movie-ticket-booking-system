import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JavaCurd {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCurd window = new JavaCurd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaCurd() {
		initialize();
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JTable table_1;
	private JTextField txtsub;
	private JTextField txtpay;
	private JTextField txtbalance;
	private JTable table_2;
	 
	public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root","");
	        }
	        catch (ClassNotFoundException ex)
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	 
	    }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1229, 781);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 126, 439, 432);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JCheckBox chk1 = new JCheckBox("ODC");
		chk1.setBounds(28, 80, 93, 21);
		chk1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(chk1);
		
		JCheckBox chk2 = new JCheckBox("Balcony");
		chk2.setBounds(28, 166, 93, 21);
		chk2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(chk2);
		
		JCheckBox chk3 = new JCheckBox("Box");
		chk3.setBounds(28, 244, 93, 21);
		chk3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(chk3);
		
		JCheckBox chk4 = new JCheckBox("Super balcony");
		chk4.setBounds(28, 326, 142, 21);
		chk4.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(chk4);
		
		JSpinner txtodc = new JSpinner();
		txtodc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtodc.setBounds(199, 81, 77, 20);
		panel.add(txtodc);
		
		JSpinner txtbalcony = new JSpinner();
		txtbalcony.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtbalcony.setBounds(199, 167, 77, 20);
		panel.add(txtbalcony);
		
		JSpinner txtbox = new JSpinner();
		txtbox.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtbox.setBounds(199, 245, 77, 20);
		panel.add(txtbox);
		
		JSpinner txtsbal = new JSpinner();
		txtsbal.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtsbal.setBounds(199, 327, 77, 20);
		panel.add(txtsbal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1215, 77);
		panel_1.setBackground(Color.BLUE);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Movie Ticket Booking");
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel.setBackground(new Color(0, 255, 255));
		
		table = new JTable();
		table.setBounds(649, 213, 1, 1);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(611, 213, -33069, -32978);
		frame.getContentPane().add(table_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(77, 578, 135, 41);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Print Invoice");
		btnNewButton_1.setBounds(227, 578, 152, 41);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("SubTotal");
		lblNewLabel_1.setBounds(553, 592, 80, 13);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Pay");
		lblNewLabel_3.setBounds(839, 585, 60, 27);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_3);
		
		txtsub = new JTextField();
		txtsub.setBounds(668, 584, 135, 30);
		txtsub.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(txtsub);
		txtsub.setColumns(10);
		
		txtpay = new JTextField();
		txtpay.setBounds(924, 584, 157, 30);
		txtpay.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(txtpay);
		txtpay.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Balance");
		lblNewLabel_2.setBounds(553, 644, 80, 13);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel_2);
		
		txtbalance = new JTextField();
		txtbalance.setBounds(668, 634, 135, 25);
		txtbalance.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(txtbalance);
		txtbalance.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(553, 126, 590, 432);
		frame.getContentPane().add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		table_2.setForeground(new Color(0, 0, 0));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SeatType", "Price", "Qty", "Total"
			}
		));
	}
}
