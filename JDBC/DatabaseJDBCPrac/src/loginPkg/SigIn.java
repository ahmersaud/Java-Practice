package loginPkg;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SigIn {

	private JFrame frmLogin;
	private JTextField textFieldUserName;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
			public void runLogIn(boolean b) 
			{
				try 
				{
					SigIn window = new SigIn();
					window.frmLogin.setVisible(b);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
						
			}
			
	/**
	 * Create the application.
	 */
	public SigIn() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmLogin = new JFrame();
		frmLogin.setTitle("LogIn");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			
			{
				signup();
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignup.setBounds(213, 156, 89, 23);
		frmLogin.getContentPane().add(btnSignup);
		
		JLabel LblUsername = new JLabel("Username");
		LblUsername.setBounds(26, 65, 58, 14);
		frmLogin.getContentPane().add(LblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(26, 105, 58, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(111, 62, 221, 20);
		frmLogin.getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(111, 102, 221, 20);
		frmLogin.getContentPane().add(textFieldPassword);
		
        JButton btnLogIn = new JButton("LogIn");
		
		
		btnLogIn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				DBConnect B = new DBConnect();
		boolean c = B.LogInData(textFieldUserName.getText().trim(),textFieldPassword.getText().trim());
				
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogIn.setBounds(94, 156, 89, 23);
		frmLogin.getContentPane().add(btnLogIn);
	}
	
 public void signup()
 {
	 this.frmLogin.setVisible(false);
	 SignUp usern = new SignUp();
	 usern.runSignUp(true);
	 
 }
}



