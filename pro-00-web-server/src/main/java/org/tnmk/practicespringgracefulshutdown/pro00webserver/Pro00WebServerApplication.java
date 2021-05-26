package org.tnmk.practicespringgracefulshutdown.pro00webserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.invoke.MethodHandles;

@EnableAsync
@SpringBootApplication
public class Pro00WebServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(Pro00WebServerApplication.class, args);
  }
}
