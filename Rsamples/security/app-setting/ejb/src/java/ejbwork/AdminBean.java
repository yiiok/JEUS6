package ejbwork;

import javax.naming.NameNotFoundException;

public class AdminBean implements Admin{
	
	public String message() throws NameNotFoundException{
		return "Only administrators can call this method"; 
	}
	
}
