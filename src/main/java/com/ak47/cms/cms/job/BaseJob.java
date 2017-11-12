package com.ak47.cms.cms.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface BaseJob {
    Logger logger = LoggerFactory.getLogger(BaseJob.class);
    void job();
}
