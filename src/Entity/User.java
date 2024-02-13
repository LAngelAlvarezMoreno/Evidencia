package Entity;

public class User extends BaseEntity {
	private String UserName;
	public String getUserName()
	{
		return UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	
	private String Password;
	public String getPassowrd() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	
	private UserProfile Profile;
	public UserProfile getUserProfile() {
		return Profile;
	}
	public void setUserProfile(UserProfile userprofile) {
		Profile = userprofile;
	}
	
	public User(String id, String fullname,String username, String password, UserProfile profile) {
		this.setID(id);
		this.setFullName(fullname);
		this.UserName = username;
		this.Password = password;
		this.Profile = profile;
	}
	
	public User() {
		
	}
	
	@Override
	public String toString() {
		return this.getID()+":"+this.getFullName()+":"+this.UserName+":"+this.Password+":"+this.Profile.getName()+":"+this.Profile.getProfileId();
	}
}
