package Infraestructure.Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entity.Doctor;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.SwingConstants;

public class CitaNueva extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtAge;
	private JTextField txtFullname;
	Infraestructure.DoctorFunctions doctFunctions = new Infraestructure.DoctorFunctions();
	Infraestructure.DatesFunctions dateFunctions = new Infraestructure.DatesFunctions();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CitaNueva dialog = new CitaNueva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);														
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CitaNueva() {
		dateFunctions.LoadDates();
		setBounds(100, 100, 450, 304);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Fecha");
			lblNewLabel.setBounds(10, 11, 135, 22);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(10, 80, 135, 22);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblGenero);
		
		txtAge = new JTextField();
		txtAge.setBounds(155, 114, 269, 23);
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAge.setColumns(10);
		contentPanel.add(txtAge);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 114, 135, 22);
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblEdad);
		
		txtFullname = new JTextField();
		txtFullname.setBounds(155, 148, 269, 23);
		txtFullname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFullname.setColumns(10);
		contentPanel.add(txtFullname);
		
		JLabel lblPatientID = new JLabel("Nombre completo");
		lblPatientID.setBounds(10, 148, 135, 22);
		lblPatientID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblPatientID);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(10, 182, 135, 22);
		lblDoctor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblDoctor);
		
		
		JComboBox<String> cbGender = new JComboBox<>();
		cbGender.addItem("Hombre");
		cbGender.addItem("Mujer");
		cbGender.setBounds(155, 84, 269, 22);
		cbGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		contentPanel.add(cbGender);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(10, 45, 135, 22);
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(lblHora);
		
		
		
		DefaultComboBoxModel<String> HH = new DefaultComboBoxModel<>();
		for(int h = 0; h<=23;h++) {
			HH.addElement(""+h);
		}
		
		JComboBox cbHora = new JComboBox(HH);
		cbHora.setBounds(155, 47, 64, 22);
		cbHora.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPanel.add(cbHora);
		
		
		
		DefaultComboBoxModel<String> mm = new DefaultComboBoxModel<>();
		for(int m = 0; m < 60; m+=5 ) {
			mm.addElement(""+m);
		}
		
		JComboBox cbMinutos = new JComboBox(mm);
		cbMinutos.setBounds(248, 47, 64, 22);
		cbMinutos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPanel.add(cbMinutos);
		
		JLabel lblMinutos = new JLabel(":");
		lblMinutos.setBounds(217, 45, 32, 24);
		lblMinutos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMinutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPanel.add(lblMinutos);
		
		
		JComboBox cbDia = new JComboBox();
		for(int dia = 1; dia <= 31; dia++) {
			cbDia.addItem(dia);
		}
		
		cbDia.setBounds(155, 13, 64, 22);
		cbDia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPanel.add(cbDia);
		
		JComboBox cbMes = new JComboBox();
		for(int mes = 1; mes <= 12; mes++) {
			cbMes.addItem(mes);
		}
		
		cbMes.setBounds(248, 13, 64, 22);
		cbMes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPanel.add(cbMes);
		
		
		JComboBox cbAño = new JComboBox();
		int añoActual = Calendar.getInstance().get(Calendar.YEAR);
		for(int año = añoActual; año<= 2100; año++) {
			cbAño.addItem(año);
		}
		
		cbAño.setBounds(343, 13, 81, 22);
		cbAño.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPanel.add(cbAño);
		
		JLabel lblMinutos_1 = new JLabel("-");
		lblMinutos_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMinutos_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutos_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMinutos_1.setBounds(217, 11, 32, 24);
		contentPanel.add(lblMinutos_1);
		
		JLabel lblMinutos_2 = new JLabel("-");
		lblMinutos_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMinutos_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutos_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMinutos_2.setBounds(311, 11, 32, 24);
		contentPanel.add(lblMinutos_2);
		
		doctFunctions.loadDoctors();
		JComboBox<Entity.Doctor> cbDoctors = new JComboBox();
		cbDoctors.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		var doctors =  doctFunctions.GetDoctors();
		
		for(Entity.Doctor doctor : doctors) {
			cbDoctors.addItem(doctor);
		}
		
		
		
		
		cbDoctors.setBounds(155, 184, 269, 22);
		contentPanel.add(cbDoctors);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						///validar fecha, hora y doctor 
						
						if(txtAge.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Ingresa tu edad.", "WARNING", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						if(txtFullname.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Ingresa tu nombre.", "WARNING", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						
						
						String selectedDate = cbDia.getSelectedItem().toString() + "/" + cbMes.getSelectedItem().toString() + "/" + cbAño.getSelectedItem().toString();			
						String appointmenttimeSelected = cbHora.getSelectedItem()+"-"+cbMinutos.getSelectedItem();
						
						Entity.Dates date = new Entity.Dates();
						
						date.setID(dateFunctions.GenerateID());
						date.setDate(selectedDate);
						date.setTimeSpam(appointmenttimeSelected);						
						Entity.Patient patient = new Entity.Patient();
						String id = (""+dateFunctions.GenerateID()).trim();
						patient.setID(id);
						patient.setFullName(txtFullname.getText().trim());
						patient.setAge(Integer.parseInt(txtAge.getText()));
						patient.setGender(cbGender.getSelectedItem().toString());	
						patient.setUserLogin(new Entity.User(id,
														txtFullname.getText().trim(),
														id,
														"123",
														new Entity.UserProfile("03PATIENT", "PACIENTE")));
						date.setPatientData(patient);																		
						date.setDoctor((Doctor) cbDoctors.getSelectedItem());
						
						dateFunctions.setDate(date);
						boolean save = dateFunctions.Save(date);
						if(save) {
							JOptionPane.showMessageDialog(null, "Cita creada correctamente", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
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
