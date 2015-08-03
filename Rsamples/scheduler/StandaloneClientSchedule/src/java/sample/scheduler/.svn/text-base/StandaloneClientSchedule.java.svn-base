package sample.scheduler;

import jeus.schedule.client.*;
import jeus.schedule.*;
import java.util.*;
import jeus.util.*;

public class StandaloneClientSchedule implements ScheduleListener {
    public StandaloneClientSchedule() {
    }

    public void onTime() {
        System.out.println("#### Scheduler on the Client VM waked up at "
                + new Date() + " ####");
    }

    public static void main(String args[]) {
        try {
            Scheduler scheduler = SchedulerFactory.getDefaultScheduler();
            Date firstTime = new Date(System.currentTimeMillis() + 1000);
            Date endTime = new Date(firstTime.getTime() + 8000);
            ScheduleController schController = scheduler.registerSchedule(
                        new StandaloneClientSchedule(), firstTime, 1000,
                        endTime, Scheduler.UNLIMITED, false);

            int msec = 10000;
            System.out.println("Sleeping " + msec + "ms ...");
            Thread.sleep(msec);

            schController.cancel();
        } catch (Exception re) {
            re.printStackTrace();
        }
    }
}
