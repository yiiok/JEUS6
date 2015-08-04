package ejbwork;

import javax.naming.NameNotFoundException;

public class SecretBean implements Secret{
	
	public String message() throws NameNotFoundException{
		return "This message is transported from another ejb";
	}
	
	public String excludedMSG()throws NameNotFoundException{
		return "Excluded permission is default mode of this message";
	}

}
