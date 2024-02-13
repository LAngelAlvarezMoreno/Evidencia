package Entity;

public class Patient extends BaseEntity {

	private String Gender;
	private int Age;
	private User PatientLogin;
	
	public void setGender(String gender) {
		this.Gender = gender; 
	}
	public String getGender() {
		return Gender;
	}
	
	public void setAge(int age) {
		this.Age = age;
	}
	public int getAge(){
		return Age;
	}
		
	public void setUserLogin(User patientlogin) {
		PatientLogin = patientlogin;
	}
	public User getPatientLogin() {
		return PatientLogin;
	}
	
	public Patient() {
		
	}
	
	public Patient(String id, String fullname, String gender, int age, User patientlogin) {
		this.setID(id);
		this.setFullName(fullname);
		this.Gender = gender;
		this.Age = age;
		this.PatientLogin = patientlogin;
	}
	
	@Override
	public String toString() {
		return this.getID() + ":" + this.getFullName() + ":" + this.Gender + ":" + this.Age + ":" + this.PatientLogin.toString();
	}
	
}
