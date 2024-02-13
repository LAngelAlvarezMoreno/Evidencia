package Infraestructure.Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DeleteDate extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdDate;
	Infraestructure.DatesFunctions dateFunctions = new Infraestructure.DatesFunctions();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteDate dialog = new DeleteDate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeleteDate() {
		JTextArea txtAreaDate = new JTextArea();
		txtAreaDate.setBounds(10, 11, 453, 297);
		contentPanel.add(txtAreaDate);
		
		dateFunctions.LoadDates();
		txtAreaDate.setText(new String());
		ArrayList<Entity.Dates> dates =	dateFunctions.GetDatesList();	
		
		for(Entity.Dates date : dates) {
			String text = ">>> Datos Cita: " + date.getID() + " - " + date.getDate() + " - " + date.getAppointmentTime().replace("-", ":") + " Horas"+ " \n Datos Paciente: " + date.getPatientData().getID() + " - " + date.getPatientData().getFullName() + " - " + date.getPatientData().getAge()+" años"  + "\n\n";			
			txtAreaDate.append(text);									
		}
		setBounds(100, 100, 489, 428);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
	
		
		JLabel lblNewLabel = new JLabel("ID de Cita");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(138, 319, 100, 26);
		contentPanel.add(lblNewLabel);
		
		txtIdDate = new JTextField();
		txtIdDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtIdDate.setBounds(240, 318, 100, 25);
		contentPanel.add(txtIdDate);
		txtIdDate.setColumns(10);
		
		JButton btnDeleteDate = new JButton("ELIMINAR");
		btnDeleteDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(txtIdDate.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ingresa el id de la CITA", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				int id = Integer.parseInt(txtIdDate.getText().trim());
				boolean delete = dateFunctions.DeleteDateAndSave(id);
				if(delete) {
					JOptionPane.showMessageDialog(null, "CITA Eliminada correctamente.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
		
			}
		});
		btnDeleteDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteDate.setBounds(350, 321, 113, 23);
		contentPanel.add(btnDeleteDate);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setVisible(false);
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
