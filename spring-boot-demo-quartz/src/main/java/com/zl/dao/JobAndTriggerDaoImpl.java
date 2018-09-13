package com.zl.dao;

import com.zl.entity.JobAndTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/3
 * @description:
 **/
@Repository
public class JobAndTriggerDaoImpl implements JobAndTriggerDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<JobAndTrigger> getJobAndTriggerDetails() {
        String sql = "SELECT " +
                "qrtz_job_details.JOB_NAME, " +
                "qrtz_job_details.JOB_GROUP, " +
                "qrtz_job_details.JOB_CLASS_NAME, " +
                "qrtz_triggers.TRIGGER_NAME, " +
                "qrtz_triggers.TRIGGER_GROUP, " +
                "qrtz_cron_triggers.CRON_EXPRESSION, " +
                "qrtz_cron_triggers.TIME_ZONE_ID " +
                "FROM " +
                "qrtz_job_details " +
                "JOIN qrtz_triggers " +
                "JOIN qrtz_cron_triggers ON qrtz_job_details.JOB_NAME = qrtz_triggers.JOB_NAME " +
                "AND qrtz_triggers.TRIGGER_NAME = qrtz_cron_triggers.TRIGGER_NAME " +
                "AND qrtz_triggers.TRIGGER_GROUP = qrtz_cron_triggers.TRIGGER_GROUP ";
        return entityManager.createNativeQuery(sql).getResultList();
    }
}
