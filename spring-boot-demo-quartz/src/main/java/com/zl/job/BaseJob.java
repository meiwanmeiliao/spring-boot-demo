package com.zl.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/3
 * @description:
 **/
public interface BaseJob extends Job {

    public void execute(JobExecutionContext context) throws JobExecutionException;
}
