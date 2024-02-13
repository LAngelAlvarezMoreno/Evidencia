package Infraestructure;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Entity.UserProfile;

public class DoctorFunctions {
	
	private ArrayList<Entity.Doctor> doctors = new ArrayList<>();
	
	public ArrayList<Entity.Doctor> GetDoctors(){
		return doctors;
	}
	
	public boolean ExistDoctor(String id) {
		for(Entity.Doctor doc : doctors) {
			if(doc.getID().trim().equals(id.trim())) {
				return true;
			}
		}
		return false;
	}
	
	public int GenerateID() {
		int id = new Random().nextInt(900000) + 100000;
		boolean exist = ExistDoctor(""+id);
		if(exist) {
			GenerateID();
		}
		
		return id;
	}
	
	public void SetDoctor(Entity.Doctor doctor) {
		doctors.add(doctor);
	}
	
	public boolean Save(Entity.Doctor doctor) {
		boolean result = false;
		try {
			File file = new File("Doctors.txt").getAbsoluteFile();
			if(!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(doctor.toString());
			bw.newLine();
			bw.close();
			result = true;
			
		}catch(Exception ex) {
			return false;
		}
		
		return result;
	}
	
	public boolean SaveOnLogin(Entity.User user) {
		boolean result = false;
		try {
			File file = new File("logins.txt").getAbsoluteFile();
			if(!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
				
			bw.write(user.toString());
			bw.newLine();
			bw.close();
			result = true;
			
			
		}catch(Exception ex) {
			return false;
		}
		
		return result;
	}
	
	public void loadDoctors() {
		try {
			File fileDoctor = new File("Doctors.txt").getAbsoluteFile();
			if(fileDoctor.exists()) {						
			String line;
			 BufferedReader bufferReader = new BufferedReader(new FileReader(fileDoctor));
             while ((line = bufferReader.readLine()) != null) {
                 if (!line.isEmpty()) {
                     var items = line.split(":");
                  
                     if (items.length == 7) {
						Entity.Doctor doctor = new Entity.Doctor();
                    	 
                    	 doctor.setID(items[0]);
                    	 doctor.setFullName(items[1]);
                    	 doctor.setSpeciality(items[2]);
                    	 doctor.setUserLogin(new Entity.User(items[0], items[1],items[3], items[4], new Entity.UserProfile(items[6], items[5])));                    	                                       	 
                    	 
                        doctors.add(doctor);                    	 
                     }
                 }
             }
             bufferReader.close();
			}
			else
			{
				doctors = new ArrayList<>();
			}
			
		}catch(Exception ex) {
			
		}
	}

}
