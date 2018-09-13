package com.zl.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/3
 * @description:
 **/

public class HelloJob implements BaseJob {


    public HelloJob() {
    }

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("hello" + simpleDateFormat.format(new Date()));

    }
}
