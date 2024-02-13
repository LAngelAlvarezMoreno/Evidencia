package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Infraestructure.UserFunctions;
import Infraestructure.Views.CitaNueva;
import Infraestructure.Views.NewDoctor;
import Infraestructure.Views.SearchDate;
import Infraestructure.Views.SearchPatient;

import java.awt.Panel;
import java.awt.Color;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JOptionPane;
import java.awt.Button;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private String CurrentUserProfile = new String();
	
	UserFunctions userFunctions = new UserFunctions();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
					frame.setLocationRelativeTo(frame);															
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public MainPage() {
		userFunctions.UsersLoginLoad();
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Bitacora de Citas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1132, 795);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		
		Object objAction;
	

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		Panel panelDetail = new Panel();
		Panel passwordPanel = new Panel();
		Panel UserDataPanel = new Panel();
		JLabel lblUser = new JLabel("New label");
		DefaultListModel<String> modelList = new DefaultListModel<>();
		Panel initialPanel = new Panel();
		initialPanel.setBackground(new Color(34, 139, 34));
		initialPanel.setBounds(0, 0, 259, 751);
		contentPane.add(initialPanel);
		initialPanel.setLayout(null);
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBounds(0, 0, 858, 103);
		panelDetail.add(optionsPanel);
		optionsPanel.setLayout(null);
		optionsPanel.setVisible(false);
		
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUser.setForeground(Color.WHITE);
		JLabel lblProfile = new JLabel("New label");
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		panel.setBounds(187, 35, 0, 0);
		initialPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblOptionSelected = new JLabel("");
		lblOptionSelected.setVisible(false);
		lblOptionSelected.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblOptionSelected.setHorizontalTextPosition(SwingConstants.CENTER);
		lblOptionSelected.setHorizontalAlignment(SwingConstants.CENTER);
		lblOptionSelected.setBounds(225, 104, 623, 50);
		panelDetail.add(lblOptionSelected);
		
		Panel actionsPanel = new Panel();
		actionsPanel.setVisible(false);
		actionsPanel.setName("");
		actionsPanel.setBounds(0, 104, 224, 647);
		panelDetail.add(actionsPanel);
		actionsPanel.setLayout(null);
		
		Button btnNew = new Button("NUEVO");
		btnNew.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
			
			String optionSelected = lblOptionSelected.getText();

			switch(optionSelected) {
			case "PACIENTES": 							
				
		        
				break;
				
			case "CITAS": 
				
			     setEnabled(false);			        
		         CitaNueva dialog = new CitaNueva();
		         dialog.pack();
		         dialog.setTitle("CITA NUEVA");
				 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				 dialog.setModal(true);
				 dialog.setBounds(100, 100, 450, 300);
				 ///dialog.setSize(100, 100, 450, 300); 
			     dialog.setLocationRelativeTo(null); 
			     dialog.setVisible(true);				      				     
		         setEnabled(true);
		         break;
				
			case "DOCTORES": 		
			     setEnabled(false);			        
		         Infraestructure.Views.NewDoctor doctorDialog = new  Infraestructure.Views.NewDoctor();
		         doctorDialog.pack();
		         doctorDialog.setTitle("NUEVO REGISTRO DE DOCTOR");
		         doctorDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		         doctorDialog.setModal(true);
		         doctorDialog.setBounds(100, 100, 533, 512);
		         doctorDialog.setLocationRelativeTo(null); 
		         doctorDialog.setVisible(true);				      				     
		         setEnabled(true);
				break;				
			}
				
			}
		});
		btnNew.setVisible(false);
		btnNew.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnNew.setName("");
		btnNew.setBounds(10, 202, 211, 69);
		actionsPanel.add(btnNew);
		
		Button btnUpdate = new Button("MODIFICAR");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String optionSelected = lblOptionSelected.getText();
				switch(optionSelected) {
				case "PACIENTES": 							
			         
			        
					break;
					
				case "CITAS": 
					
				
					
					break;
					
				case "DOCTORES": 
					
					break;				
				}
			}
		});
		btnUpdate.setVisible(false);
		btnUpdate.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnUpdate.setName("");
		btnUpdate.setBounds(10, 290, 211, 69);
		actionsPanel.add(btnUpdate);
		
		Button btnDelete = new Button("ELIMINAR");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String optionSelected = lblOptionSelected.getText();
				switch(optionSelected) {
				case "PACIENTES": 							
			         
			        
					break;
					
				case "CITAS": 
					
				
					
					break;
					
				case "DOCTORES": 
					break;				
				}
			}
		});
		btnDelete.setVisible(false);
		btnDelete.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnDelete.setName("");
		btnDelete.setBounds(10, 381, 211, 69);
		actionsPanel.add(btnDelete);
		
		Button btnSearch = new Button("BUSCAR");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {									

				String optionSelected = lblOptionSelected.getText();
				switch(optionSelected) {
				case "PACIENTES": 							
			         setEnabled(false);			        
			         SearchPatient dialog = new SearchPatient();
			         dialog.pack();
			         dialog.setTitle("BUSCAR PACIENTE");
					 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					 dialog.setModal(true);
					 dialog.setSize(panelDetail.getSize()); 
				     dialog.setLocationRelativeTo(null); 
				     dialog.setVisible(true);				      				     
			         setEnabled(true);
			        
					break;
					
				case "CITAS": 
					
					 setEnabled(false);			        
			         SearchDate datesDialog = new SearchDate();
			         
			         datesDialog.pack();
			         datesDialog.setTitle("BUSCAR CITAS");
			         datesDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			         datesDialog.setModal(true);
			         datesDialog.setBounds(100, 100, 494, 445); 
					 datesDialog.setLocationRelativeTo(null); 
				     datesDialog.setVisible(true);				      				     
			         setEnabled(true);
					
					break;
					
				case "DOCTORES": 
					break;				
				}				
			}
		});
		btnSearch.setVisible(false);
		btnSearch.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnSearch.setName("");
		btnSearch.setBounds(10, 113, 211, 69);
		actionsPanel.add(btnSearch);	
		
		JButton btnDoctores = new JButton("DOCTORES");
		btnDoctores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblOptionSelected.setText(btnDoctores.getText());
				actionsPanel.setVisible(true);
				
				switch(CurrentUserProfile){
				case "01ADMINISTRATOR":								
				btnSearch.setVisible(true);
				btnUpdate.setVisible(true);
				btnDelete.setVisible(true);
				btnNew.setVisible(true);
				
					break;
				case "02DOCTOR":
					btnSearch.setVisible(true);
					btnUpdate.setVisible(true);
					btnDelete.setVisible(true);
					btnNew.setVisible(true);
					break;
				case "03PATIENT":
					btnSearch.setVisible(true);				
					break;				
		}			
			}
		});
		btnDoctores.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDoctores.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnDoctores.setVisible(false);
		btnDoctores.setBounds(587, 11, 261, 81);
		optionsPanel.add(btnDoctores);
		
		JButton btnPacientes = new JButton("PACIENTES");
		btnPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblOptionSelected.setText(btnPacientes.getText());
				actionsPanel.setVisible(true);
				
				switch(CurrentUserProfile){
						case "01ADMINISTRATOR":								
						btnSearch.setVisible(true);
						btnUpdate.setVisible(true);
						btnDelete.setVisible(true);
						btnNew.setVisible(true);
						
							break;
						case "02DOCTOR":
							btnSearch.setVisible(true);
							btnUpdate.setVisible(true);
							btnDelete.setVisible(true);
							btnNew.setVisible(true);
							break;
						case "03PATIENT":
							btnSearch.setVisible(true);				
							break;				
				}			
			}
		});
		btnPacientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPacientes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPacientes.setVisible(false);
		btnPacientes.setBounds(300, 11, 261, 81);
		optionsPanel.add(btnPacientes);
		
		JButton btnCitas = new JButton("CITAS");
		btnCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				lblOptionSelected.setText(btnCitas.getText());
				actionsPanel.setVisible(true);
				
				switch(CurrentUserProfile){
							case "01ADMINISTRATOR":								
							btnSearch.setVisible(true);
							btnUpdate.setVisible(true);
							btnDelete.setVisible(true);
							btnNew.setVisible(true);
							
								break;
							case "02DOCTOR":
								btnSearch.setVisible(true);
								btnUpdate.setVisible(true);
								btnDelete.setVisible(true);
								btnNew.setVisible(true);
								break;
							case "03PATIENT":
								btnSearch.setVisible(true);				
								break;				
					}												
			}
		});
		btnCitas.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCitas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCitas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCitas.setVisible(false);
		btnCitas.setBounds(10, 11, 261, 81);
		optionsPanel.add(btnCitas);
		//fin botonera
		
		JButton btnSalir = new JButton("CERRAR SESION");
		btnSalir.setIconTextGap(16);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		ImageIcon iconLogout = new ImageIcon(this.getClass().getResource("/LogOut-03-WF.ico"));
		btnSalir.setIcon(iconLogout);
		btnSalir.setVisible(false);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
				UserDataPanel.setVisible(false);
				passwordPanel.setVisible(true);
				btnSalir.setVisible(false);
				txtPassword.setText(new String());
				txtUserName.setText(new String());
	
				btnCitas.setVisible(false);
				btnPacientes.setVisible(false);
				btnDoctores.setVisible(false);
				optionsPanel.setVisible(false);
				lblOptionSelected.setVisible(false);
				actionsPanel.setVisible(false);
				lblOptionSelected.setText(new String());
				
				btnSearch.setVisible(false);
				btnUpdate.setVisible(false);
				btnDelete.setVisible(false);
				btnNew.setVisible(false);

				//lblImage.setVisible(true);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(255, 0, 0));
		btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSalir.setBounds(0, 716, 259, 35);
		initialPanel.add(btnSalir);
		
		
		passwordPanel.setBounds(0, 240, 259, 470);
		initialPanel.add(passwordPanel);
		passwordPanel.setLayout(null);
		
		JLabel lbl1 = new JLabel("Usuario");
		lbl1.setBounds(15, 11, 87, 32);
		passwordPanel.add(lbl1);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		txtUserName = new JTextField();
		txtUserName.setBounds(15, 48, 234, 33);
		passwordPanel.add(txtUserName);
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtUserName.setColumns(10);
		
		JLabel lbl2 = new JLabel("Contraseña");
		lbl2.setBounds(15, 92, 159, 32);
		passwordPanel.add(lbl2);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(15, 135, 234, 33);
		passwordPanel.add(txtPassword);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnLogin = new JButton("INICIAR");
		btnLogin.setBounds(10, 190, 239, 33);		
		passwordPanel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				userFunctions.UsersLoginLoad();
				var currentUser = userFunctions.GetUserloginByUserName(txtUserName.getText());				
				if(currentUser != null) {	
					String pass = new String(txtPassword.getPassword());
					
					if(currentUser.getPassowrd().equals(pass)){
						
						UserDataPanel.setVisible(true);
						passwordPanel.setVisible(false);
						btnSalir.setVisible(true);
						//lblImage.setVisible(false);
						
						lblUser.setText(currentUser.getFullName());
						lblProfile.setText(currentUser.getUserProfile().getName());			
						
						optionsPanel.setVisible(true);						
						lblOptionSelected.setVisible(true);
						
						CurrentUserProfile = currentUser.getUserProfile().getProfileId();
						
						switch(CurrentUserProfile){
							case "01ADMINISTRATOR":								
								btnCitas.setVisible(true);
								btnPacientes.setVisible(true);
								btnDoctores.setVisible(true);
								break;
							case "02DOCTOR":
								btnCitas.setVisible(true);
								btnPacientes.setVisible(true);
								break;
							case "03PATIENT":
								btnCitas.setVisible(true);
								break;
							default:
								JOptionPane.showMessageDialog(null, "No hay opciones disponibles.", "WARNING", JOptionPane.WARNING_MESSAGE);
								break;
						}
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "WARNING", JOptionPane.WARNING_MESSAGE);
					}						
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Usuario no encontrado.", "WARNING", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setToolTipText("iniciar sesión");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setAlignmentX(0.5f);
		
		
		UserDataPanel.setVisible(false);
		UserDataPanel.setBounds(0, 0, 259, 234);
		initialPanel.add(UserDataPanel);
		UserDataPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel.setBounds(10, 11, 239, 46);
		UserDataPanel.add(lblNewLabel);
		
		
		lblUser.setBounds(10, 93, 239, 37);
		UserDataPanel.add(lblUser);
		
		
		lblProfile.setBounds(10, 166, 239, 37);
		UserDataPanel.add(lblProfile);
		
		JLabel lblNewLabel_1 = new JLabel("perfil");
		lblNewLabel_1.setBounds(10, 151, 239, 14);
		UserDataPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("nombre");
		lblNewLabel_1_1.setBounds(10, 79, 239, 14);
		UserDataPanel.add(lblNewLabel_1_1);
		ImageIcon ico = new ImageIcon(this.getClass().getResource("/image.png"));
		
		
		panelDetail.setForeground(new Color(0, 0, 0));
		panelDetail.setBackground(new Color(30, 144, 255));
		panelDetail.setBounds(258, 0, 858, 751);
		contentPane.add(panelDetail);
		panelDetail.setLayout(null);
		
		
		/*Panel panel_1 = new Panel();
		panel_1.setBounds(225, 109, 633, 642);
		panelDetail.add(panel_1);*/
		
			
	}
}
