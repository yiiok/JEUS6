package ejbwork;

import java.io.IOException;

import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

public class PublicCallBean implements PublicCall{
	
	public String message() throws NameNotFoundException{
		return "This message is generated from public ejb";
	}	
	
	public String callsecret() throws NamingException, IOException{
		int base_port = Integer.parseInt(System.getProperty("jeus.baseport", "21000"));
		String msg = null;
		Secret sec = (Secret) Calljeus.connect("secret", base_port);
		msg = sec.message();
		return msg;		
	}	
}
