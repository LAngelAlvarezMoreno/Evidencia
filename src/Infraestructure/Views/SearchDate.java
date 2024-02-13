package Infraestructure.Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.TextArea;

public class SearchDate extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	Infraestructure.DatesFunctions dateFunctions = new Infraestructure.DatesFunctions(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchDate dialog = new SearchDate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchDate() {
		setResizable(false);
		dateFunctions.LoadDates();
		setBounds(100, 100, 494, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("CITAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 458, 27);
		contentPanel.add(lblNewLabel);
		
		TextArea area = new TextArea();
		area.setBounds(10, 82, 458, 327);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				area.setText(new String());
				ArrayList<Entity.Dates> dates =	dateFunctions.GetDatesList();
				if(dates.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay citas para mostrar", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
					return;
				}					
				
				for(Entity.Dates date : dates) {
					String text = ">>> Datos Cita: " + date.getID() + " - " + date.getDate() + " - " + date.getAppointmentTime().replace("-", ":") + " Horas" + " \n Datos Paciente: " + date.getPatientData().getID() + " - " + date.getPatientData().getFullName() + " - " + date.getPatientData().getAge()+" años" + " \n Datos Doctor:" + date.getDoctor().getFullName() + " - " + date.getDoctor().getSpeciality() + "\n\n";			
					area.append(text);									
				}
			}
		});
		btnBuscar.setBounds(10, 49, 458, 27);
		contentPanel.add(btnBuscar);
		
		
		contentPanel.add(area);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setVisible(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
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
