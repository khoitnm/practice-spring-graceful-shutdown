package org.tnmk.practicespringgracefulshutdown.pro01cronjob.cronjob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.lang.invoke.MethodHandles;

@Configuration
public class GracefulShutdownConfig {
  private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @Bean
  public TaskScheduler taskScheduler() {
    logger.info("Start configuring taskScheduler...");
    ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler() {
      private static final long serialVersionUID = -1L;
      private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

      @Override
      public void destroy() {
        logger.info("Start destroying scheduler...");
        this.getScheduledThreadPoolExecutor().setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        super.destroy();
        logger.info("Finish destroying scheduler!");
      }
    };
    scheduler.setWaitForTasksToCompleteOnShutdown(true);
    scheduler.setAwaitTerminationSeconds(60);
    logger.info("Finish configuring taskScheduler!");
    return scheduler;
  }
}
