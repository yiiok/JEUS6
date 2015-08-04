package sample.scheduler;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface EJBSchedule extends EJBObject {
    public void trigger() throws RemoteException;
}
