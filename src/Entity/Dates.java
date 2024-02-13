package Entity;

public class Dates {
	
	private int ID;
	public void setID(int id) {
		ID = id;
	}
	public int getID() {
		return ID;
	}
	
	private String DateSelected;
	public void setDate(String dateselected){
		DateSelected = dateselected;
	}
	public String getDate() {
		return DateSelected;
	}
	
	private String AppointmentTime;
	public void setTimeSpam(String appointmentTime) {
		AppointmentTime = appointmentTime;
	}
	public String getAppointmentTime() {
		return AppointmentTime;
	}
	
	private Patient PatientData;
	public void setPatientData(Entity.Patient patient) {
		PatientData = patient;
	}
	public Entity.Patient getPatientData(){
		return PatientData;
	}	 
	
	private Entity.Doctor Doctor;
	public void setDoctor(Doctor doctor) {
		Doctor = doctor;
	}
	public Entity.Doctor getDoctor(){
		return Doctor;
	}
	
	public Dates() {
		
	}
	
	public Dates(int id, String dateselected, String appointmenttime, Patient patientdata, Doctor doctor) {
		this.ID = id;
		this.DateSelected = dateselected;
		this.AppointmentTime = appointmenttime;
		this.PatientData = patientdata;
		this.Doctor = doctor;
	}
	

	@Override
	public String toString() {
		return  this.ID + ":" + this.DateSelected + ":" + this.AppointmentTime + ":" + this.PatientData.toString() + ":" + this.Doctor.toString();
		//return this.ID+":"+this.DateSelected + ":" + this.AppointmentTime + ":" + this.PatientData.getFullName() + ":" + this.PatientData.getAge() + ":" + this.PatientData.getGender() + ":" + this.Doctor.toString();
	}
	
	
}
