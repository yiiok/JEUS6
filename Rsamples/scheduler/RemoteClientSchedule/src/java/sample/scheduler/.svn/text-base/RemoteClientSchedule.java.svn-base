package sample.scheduler;

import jeus.schedule.*;
import java.util.*;
import java.rmi.*;
import javax.naming.*;
import jeus.util.*;

public class RemoteClientSchedule implements ScheduleListener {
    private int next;

    public RemoteClientSchedule() {
    }

    public void onTime() {
        System.out.println("#### Remote Client Scheduler onTime() called : "
                + new Date() + " ####");
    }

    public static void main(String args[]) {
        try {
            InitialContext ic = new InitialContext();
            Scheduler scheduler =
                (Scheduler)ic.lookup(Scheduler.NODE_SCHEDULER_NAME);
            Date firstTime = new Date();
            Date endTime = new Date(firstTime.getTime()+20000);
            ScheduleController schController = scheduler.registerSchedule(
                    "sample.scheduler.RemoteClientSchedule",
                    firstTime, 1000, endTime, 10, true);

            int msec = 12000;
            System.out.println("Sleeping " + msec + "ms ..."
                    + ": Please check the log on JEUS");
            Thread.sleep(msec);

            // Cancel this schedule gracefully.
            schController.cancel();

            // If you want to cancel all registered schedules, 
            // please call Scheduler::cancel().
            //scheduler.cancel();
        } catch (JeusSchedulerException jse) {
            jse.printStackTrace();
        } catch (RemoteException re) {
            re.printStackTrace();
        } catch (NamingException ne) {
            ne.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
