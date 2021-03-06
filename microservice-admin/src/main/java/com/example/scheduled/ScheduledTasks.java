package com.example.scheduled;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 */
@Component
@Configuration
@EnableScheduling
public class ScheduledTasks {
    @Scheduled(fixedRate = 1000 * 30)
    public void reportCurrentTime() {
        System.out.println ("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date()));
    }

    /**
     * 每分钟执行一次
     */
    @Scheduled(cron = "0 */1 *  * * *")
    public void reportCurrentByCron() {
        System.out.println ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date ()));
    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }
}
