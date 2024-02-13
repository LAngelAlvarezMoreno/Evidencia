package Infraestructure;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Entity.User;


public class UserFunctions {

	private ArrayList<User> UsersLogin = new ArrayList<>();
	
	public UserFunctions() {
		 
	}
	
	public void Save(User newuser) {
		
		
		
	}	
	
	public ArrayList<User> GetAllUsersLogin(){
		return UsersLogin;
	}

	private boolean compare(String userLogin, String userList)
	{
		if (userList.toUpperCase().equals(userLogin.toUpperCase())) 
		{
			return true;
		}
		return false;
	}
	
	public User GetUserloginByUserName(String username){
		User result = null;
	
		
			for(User usr : UsersLogin) {
			
				boolean compare = compare(username,  usr.getUserName());
				if (compare) {
					result = usr;
					break;
				}
			}			
		
		
		return result;
	}
	
	
	
	 public boolean UsersLoginLoad(){		 
		 try {
			 UsersLogin = new ArrayList<>();
			 File fileLogin = new File("logins.txt").getAbsoluteFile();
			 if(fileLogin.exists()) {
				 String line;
				
				try (BufferedReader br = new BufferedReader(new FileReader(fileLogin))) {
					while((line = br.readLine()) != null) {
						 if(!line.isEmpty()) {
							 var data = line.split(":");
							 if(data.length == 6) {
									Entity.User user = new Entity.User();
									
									user.setID(data[0]);
									user.setFullName(data[1]);
									user.setUserName(data[2]);
									user.setPassword(data[3]);
									user.setUserProfile(new Entity.UserProfile(data[5], data[4]));
									
									UsersLogin.add(user);
							 }
							 
						 }
					 }
				}
			 } 
			 		 			 				
			 
						 	
				Entity.User user_ = new Entity.User("1", "AMINISTRADOR DE DATOS", "admin", "123", new Entity.UserProfile("01ADMINISTRATOR", "ADMINISTRADOR") );													
				UsersLogin.add(user_);
				
						
			 
			 
		 }catch(Exception ex) {
			 System.out.println(ex.getMessage());
			 return false;
		 }
		 
		 return true;
		 
	 }
}
