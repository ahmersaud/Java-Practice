package loginPkg;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp {

	private JFrame frmSignup;
	private JTextField textField;
	private JTextField txtPassword;
	
	
	
	public void runSignUp(boolean a) 
	{
		try 
		{
			SignUp window = new SignUp();
			window.frmSignup.setVisible(a);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public SignUp() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmSignup = new JFrame();
		frmSignup.setTitle("SignUp");
		frmSignup.setBounds(100, 100, 450, 300);
		frmSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignup.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(161, 71, 149, 20);
		frmSignup.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setBounds(72, 71, 65, 14);
		frmSignup.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(72, 105, 65, 14);
		frmSignup.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(161, 102, 149, 20);
		frmSignup.getContentPane().add(txtPassword);
		
		JButton btnSignUp = new JButton("SignUp");
		
		
		btnSignUp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				
			signUpFunc();
			frmSignup.setVisible(false);
			SigIn user = new SigIn();
			user.runLogIn(true);	
								
			}
		});
		btnSignUp.setBounds(186, 152, 89, 23);
		frmSignup.getContentPane().add(btnSignUp);
		
		
	}


public void signUpFunc()
{
	DBConnect A = new DBConnect();
	boolean let = A.InsertData(textField.getText() , txtPassword.getText());
	System.out.println(let);
	System.out.println();
	
}

}




