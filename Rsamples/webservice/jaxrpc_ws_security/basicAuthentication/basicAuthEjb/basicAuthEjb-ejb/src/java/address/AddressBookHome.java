package address;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface AddressBookHome extends EJBHome {

    AddressBook create() throws RemoteException, CreateException;
}
