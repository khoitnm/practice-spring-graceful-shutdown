package org.tnmk.practicespringgracefulshutdown.pro00webserver.sample_rest_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

@RestController
public class LongRunController {
  private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  /**
   * The timeout limit is configured in `application.yml`: timeout-per-shutdown-phase
   * @throws InterruptedException
   */
  @GetMapping("/long-run-request/within-timeout-limit")
  public void startLongRunRequest_withinTimeoutLimit() throws InterruptedException {
    logger.info("Starting a long-run request...");
    Thread.sleep(25000);
    logger.info("Finish the long-run request within time out limit!!!");
  }

  @GetMapping("/long-run-request/exceed-timeout-limit")
  public void startLongRunRequest_Exceed() throws InterruptedException {
    logger.info("Starting a long-run request...");
    Thread.sleep(80000);
    logger.info("I don't expect to see this message in the log console because "
        + "the request exceeds the timeout limit and it will be stopped in the middle.");
  }
}
