Spring Boot – Scheduling

Spring Boot provides the ability to schedule tasks for execution at a given time period with the help of @Scheduled annotation. 
This article provides a step by step guideline on how we can schedule tasks to run in a spring boot application

Specifying @EnableScheduling annotation in the Spring Boot application class.

// Java Program to Illustrate Specifying
// @EnableScheduling annotation

package com.Scheduler;

// Importing required classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// Annotation
@SpringBootApplication
@EnableScheduling

// Class
public class SchedulerApplication {

    // Main driver method
    public static void main(String[] args)
    {
        SpringApplication.run(SchedulerApplication.class,
                              args);
    }
}

@EnableScheduling annotation facilitates Spring Boot with scheduled task execution capability.

Step 3: Creating a @Component class Scheduler which defines the method scheduleTask() for scheduling a task using the @Scheduled annotation.

The method scheduleTask() in Scheduler class simply prints the date and time at which the task is running.

Scheduling tasks using a cron expression

// Java Program to Illustrate Scheduling Task
// using a cron expression

package com.Scheduler;

// Importing required classes
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// Annotation
@Component
// Class
public class Scheduler {

    // Method
    // To trigger the scheduler every one minute
    // between 19:00 PM to 19:59 PM
    @Scheduled(cron = "0 * 19 * * ?")
    public void scheduleTask()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
            "dd-MM-yyyy HH:mm:ss.SSS");

        String strDate = dateFormat.format(new Date());

        System.out.println(
            "Cron job Scheduler: Job running at - "
            + strDate);
    }
}