package Entity;

public class Doctor extends BaseEntity {

	private String Speciality;
	public void setSpeciality(String speciality) {
		Speciality = speciality;
	}
	public String getSpeciality() {
		return Speciality;
	}
	
	private User UserLogin;
	public void setUserLogin(User userlogin) {
		UserLogin = userlogin;
	}
	public User getUserLogin() {
		return UserLogin;
	}
	
	public Doctor(String id, String fullname, String speciality, User userlogin) {
		this.setID(id);
		this.setFullName(fullname);
		this.Speciality = speciality;
		this.UserLogin = userlogin;
	}

	public Doctor(){}
	
	@Override
	public String toString() {
		return this.getID()+":"+this.getFullName()+":"+this.Speciality+":" + UserLogin.toString();
	}
	
	
}
