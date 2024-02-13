package Entity;

public class UserProfile {

	private String ProfileId;
	private String Name;
	
	public UserProfile(String profileId, String name) {
		this.ProfileId = profileId;
		this.Name = name;
	}
	
	public UserProfile() {
		
	}
	
	public String getName() {
		return Name;
	}
	
	public String getProfileId() {
		return ProfileId;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public void setProfileId(String profileId) {
		this.ProfileId =  profileId;
	}
	
	
}
