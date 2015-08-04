package ejbwork;

import javax.ejb.Remote;
import javax.naming.NameNotFoundException;

@Remote
public interface Secret{
	public String message() throws NameNotFoundException;
	public String excludedMSG() throws NameNotFoundException;
}
