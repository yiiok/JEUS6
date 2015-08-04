package sample.scheduler;

import jeus.schedule.*;

import java.rmi.RemoteException;
import javax.ejb.*;

public class EJBScheduleEJB implements SessionBean {
    private SimpleTask task;
    private ScheduleController taskHandler;
    private boolean isStarted;

    public EJBScheduleEJB() {
    }

    public void ejbCreate() {
        task = new SimpleTask("ScheduleAppTask");
        isStarted = false;
    }

    public void trigger() throws RemoteException {
        if (!isStarted) {
            Scheduler scheduler =
                SchedulerFactory.getDefaultScheduler();
            taskHandler = scheduler.registerSchedule(
                    task, 2000, 2000, null, Scheduler.UNLIMITED, false);

            isStarted = true;
        }
    }

    public void ejbRemove() throws RemoteException {
        if (isStarted)
            taskHandler.cancel();
    }

    public void setSessionContext(SessionContext sc) {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }
}
