package org.tnmk.practicespringgracefulshutdown.pro00webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Pro00WebServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(Pro00WebServerApplication.class, args);
  }
}
