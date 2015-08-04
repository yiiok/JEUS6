package sample.scheduler;

import java.lang.*;
import java.rmi.*;
import java.net.*;
import javax.ejb.*;
import javax.naming.*;
import javax.rmi.PortableRemoteObject;
import java.util.*;

public class EJBScheduleClient {
    private void run() {
        try {
            InitialContext ctx = new InitialContext();
            Object ref = ctx.lookup("ScheduleApp");
            EJBScheduleHome scheduleHome =
                (EJBScheduleHome)PortableRemoteObject.narrow(
                        ref, EJBScheduleHome.class);

            EJBSchedule schedule = scheduleHome.create();

            if (schedule != null) {
                schedule.trigger();

                int msec = 5000;
                System.out.println("Sleeping " + msec + "ms ... "
                        + ": Please check the log on JEUS");
                Thread.sleep(msec);
            } else {
                System.out.println("Remote stub injection failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        EJBScheduleClient client = new EJBScheduleClient();
        client.run();
    }
}
