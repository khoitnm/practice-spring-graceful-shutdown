package org.tnmk.practicespringgracefulshutdown.pro00webserver.sample_rest_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

@RestController
public class LongRunController {
  private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @GetMapping("/long-run-request")
  public void startLongRunRequest() throws InterruptedException {
    logger.info("Starting a long-run request...");
    Thread.sleep(60000);
    logger.info("Finish the long-run request!!!");
  }
}
