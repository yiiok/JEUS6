package ejbwork;

import javax.ejb.Remote;
import javax.naming.NameNotFoundException;

@Remote
public interface Admin{
	public String message() throws NameNotFoundException;
}
