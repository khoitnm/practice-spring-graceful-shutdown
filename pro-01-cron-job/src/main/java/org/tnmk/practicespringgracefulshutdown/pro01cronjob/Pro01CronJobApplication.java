package org.tnmk.practicespringgracefulshutdown.pro01cronjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Pro01CronJobApplication {
  public static void main(String[] args) {
    SpringApplication.run(Pro01CronJobApplication.class, args);
  }
}
