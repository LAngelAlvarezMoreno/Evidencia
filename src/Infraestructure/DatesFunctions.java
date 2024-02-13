package Infraestructure;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import Entity.User;

public class DatesFunctions {

	ArrayList<Entity.Dates> DateList = new ArrayList<>();
	

	
	public int GenerateID() {
		int id = new Random().nextInt(900000) + 100000;
		boolean exist = ExistDate(id);
		if(exist) {
			GenerateID();
		}
		
		return id;
	}
	
	public boolean ExistDate(int id) {
		for(Entity.Dates _date : DateList) {
			if(_date.getID() == id) {
				return true;
			}
		}
		return false;
	}
	
	public void setDate(Entity.Dates date) {
		if(!DateList.isEmpty()) {
			DateList.add(date);
		}
		else {
			DateList = new ArrayList<Entity.Dates>();
			DateList.add(date);
		}
	
	}
	
	public ArrayList<Entity.Dates> GetDatesList(){
		return DateList;
	}
	
	public void LoadDates() {
		try {
			File file = new File("Dates.txt").getAbsoluteFile();
			if(file.exists()) {						
			String line;
			 BufferedReader br = new BufferedReader(new FileReader(file));
             while ((line = br.readLine()) != null) {
                 if (!line.isEmpty()) {
                     var items = line.split(":");
                  
                     if (items.length >= 13) {
						Entity.Dates _date = new Entity.Dates();
                                	     
						_date.setID(Integer.parseInt(items[0]));
						_date.setDate(items[1]);
						_date.setTimeSpam(items[2]);
						
						Entity.Patient patientData = new Entity.Patient();
						patientData.setID(items[3]);
						patientData.setFullName(items[4]);
						patientData.setGender(items[5]);
						patientData.setAge(Integer.parseInt(items[6]));		
						patientData.setUserLogin(new Entity.User(items[7],
																 items[8],
																 items[9],
																 items[10],
																 new Entity.UserProfile(items[12], items[11])));
						_date.setPatientData(patientData);	
						
						Entity.Doctor doctor = new Entity.Doctor();
						doctor.setID(items[13]);
						doctor.setFullName(items[14]);
						doctor.setSpeciality(items[15]);
						doctor.setUserLogin(new Entity.User(items[16],
															items[17],
															items[18],
															items[19],
															new Entity.UserProfile(items[21],items[20])));
					
						
						
						
						_date.setDoctor(doctor); 
                        DateList.add(_date);                    	 
                     }
                 }
             }
             br.close();
			}
			else
			{
				DateList = new ArrayList<>();
			}
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public boolean Save(Entity.Dates date) {
		boolean result = false;
		try {
			File file = new File("Dates.txt").getAbsoluteFile();
			if(!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(date.toString());
			bw.newLine();
			bw.close();
			result = true;
			
		}catch(Exception ex) {
			return false;
		}
		
		return result;
	}
	
	public boolean DeleteDateAndSave(int idDate) {
		 boolean result = false;
	        try {
	        			
	           DateList.removeIf(_date -> (_date.getID() == idDate));	        
	        	
	            File file = new File("Dates.txt").getAbsoluteFile();
	            if (!file.exists()) {
	                file.createNewFile();
	            }

	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	                for (Entity.Dates item : DateList) {	                		                	
	                    writer.write(item.toString());
	                    writer.newLine();
	                }
	                writer.close();
	                result = true;
	            } catch (IOException ex) {
	                ex.printStackTrace();
	                result = false;
	            }
	        }catch (IOException exception){
	            System.out.println(exception.getMessage());
	            result = false;
	        }
	        return  result;
	}
}
