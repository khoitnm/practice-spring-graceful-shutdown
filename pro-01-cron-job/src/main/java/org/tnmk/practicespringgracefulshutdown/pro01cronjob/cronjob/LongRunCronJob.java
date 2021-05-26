package org.tnmk.practicespringgracefulshutdown.pro01cronjob.cronjob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class LongRunCronJob {
  private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private static int cronJobIndex = 0;

  @Scheduled(fixedDelay = 2000)
  public void longRunProcess() throws InterruptedException {
    logger.info("Starting a long-run cronjob {}...", ++cronJobIndex);
    Thread.sleep(10000);
    logger.info("Finish the long-run cronjob {} within time out limit!!!", cronJobIndex);
  }
}
