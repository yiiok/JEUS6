package ejbwork;

import java.io.IOException;

import javax.ejb.Remote;
import javax.naming.NamingException;
import javax.naming.NameNotFoundException;

@Remote
public interface PublicCall{
	public String message() throws NameNotFoundException;
	public String callsecret()throws NamingException, IOException;
}
