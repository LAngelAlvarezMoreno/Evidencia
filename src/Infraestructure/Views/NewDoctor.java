package Infraestructure.Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Doctor;
import Entity.User;
import Entity.UserProfile;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class NewDoctor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFullname;
	private JTextField txtSpeciality;
	private JTextField txtUsername;
	private JTextField txtPassword;
	Infraestructure.DoctorFunctions docFunctions = new Infraestructure.DoctorFunctions();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewDoctor dialog = new NewDoctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewDoctor() {
		docFunctions.loadDoctors();
		setBounds(100, 100, 533, 512);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblFullname = new JLabel("Nombre completo");
			lblFullname.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblFullname.setBounds(10, 28, 160, 31);
			contentPanel.add(lblFullname);
		}
		
		txtFullname = new JTextField();
		txtFullname.setBounds(180, 28, 327, 31);
		contentPanel.add(txtFullname);
		txtFullname.setColumns(10);
		
		JLabel lblSpeciality = new JLabel("Especialidad");
		lblSpeciality.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpeciality.setBounds(10, 70, 160, 31);
		contentPanel.add(lblSpeciality);
		
		txtSpeciality = new JTextField();
		txtSpeciality.setColumns(10);
		txtSpeciality.setBounds(180, 70, 327, 31);
		contentPanel.add(txtSpeciality);
		
		JLabel lblUsername = new JLabel("Usuario");
		lblUsername.setToolTipText("usuario para ingreso del sistema");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(10, 112, 160, 31);
		contentPanel.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(180, 112, 327, 31);
		contentPanel.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(10, 154, 160, 31);
		contentPanel.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(180, 154, 327, 31);
		contentPanel.add(txtPassword);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						
						
						if(txtFullname.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "INGRESA TU NOMBRE.", "WARNING", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						
						if(txtSpeciality.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "INGRESA LA ESPECIALIDAD", "WARNING", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						if(txtUsername.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "INGRESA TU USUARIO", "WARNING", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						if(txtPassword.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "INGRESA UNA CONTRASEÑA", "WARNING", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						Doctor doctor = new Doctor();
						
						int id = docFunctions.GenerateID();
						doctor.setID((""+id).trim());
						doctor.setFullName(txtFullname.getText().toString().trim());
                    	doctor.setSpeciality(txtSpeciality.getText().toString().trim());                    	 
                    	
                    	User userlogin = new User();
                    	userlogin.setID((""+id).trim());
                    	userlogin.setFullName(txtFullname.getText().toString().trim());
                    	userlogin.setUserName(txtUsername.getText().toString().trim());
                    	userlogin.setPassword(txtPassword.getText().toString().trim());                    	                                 
                    	userlogin.setUserProfile(new UserProfile("02DOCTOR","DOCTOR"));
                    	
                    	doctor.setUserLogin(userlogin);
                    	                    	
                    	docFunctions.SetDoctor(doctor);                   				
						boolean save = docFunctions.Save(doctor);			
						if(save) {
							
							docFunctions.SaveOnLogin(userlogin);
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
