package org.tnmk.practicespringgracefulshutdown.pro00webserver.sample_rest_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

@RestController
public class AsyncProcessController {
  private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private final AsyncProcessService asyncProcessService;

  public AsyncProcessController(AsyncProcessService asyncProcessService) {
    this.asyncProcessService = asyncProcessService;
  }

  @GetMapping("/long-run-request/async")
  public void startLongRunRequest_withinTimeoutLimit() throws InterruptedException {
    logger.info("Trigger an async request...");
    asyncProcessService.runLongProcessAsync();
    Thread.sleep(10000);
    logger.info("Finished triggering the async request, and it is processing in another thread...");
  }

}
