package com.eyric.app.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestTsak {
//    @Scheduled(cron="0/1 * *  * * ? ")   //每1秒执行一次
    public void testTask(){
        Long now = new Date().getTime();
        System.out.println(now);
    }
}
