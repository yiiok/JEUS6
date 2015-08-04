package sample.scheduler;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface EJBScheduleHome extends EJBHome {
    EJBSchedule create() throws RemoteException, CreateException;
}
