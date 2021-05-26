package org.tnmk.practicespringgracefulshutdown.pro00webserver.sample_rest_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class AsyncProcessService {
  private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @Async
  public void runLongProcessAsync() throws InterruptedException {
    logger.info("Starting an async long-run request ...");
    Thread.sleep(25000);
    logger.info("Finish the async long-run request within time out limit!!!");
  }
}
