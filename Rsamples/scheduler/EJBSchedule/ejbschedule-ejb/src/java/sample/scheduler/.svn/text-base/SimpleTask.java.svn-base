package sample.scheduler;

import jeus.schedule.*;

import java.util.Date;

public class SimpleTask implements ScheduleListener {
    private String name;
    private int count;

    // no-arg constructor is required if classname is used for task registration
    public SimpleTask() {
    }

    public SimpleTask(String name) {
        this.name = name;
    }

    public void onTime() {
        count++;
        System.out.println("##### " + name + " is waked on " + new Date());
    }
}
