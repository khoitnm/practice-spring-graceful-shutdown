# Build project
```
mvn clean install -DskipTests
```

# Test graceful shutdown within timeout limit
The timeout limit is configured in `application.yml`.


__1) Start application:__ <br/>
Open the terminal:
```
java -jar ./target/pro-00-web-server-0.0.1-SNAPSHOT.jar 
```

__2) Trigger a request__ <br/>
Then on the browser, trigger the long run request: http://localhost:8080/long-run-request/within-timeout-limit

__3) Stop server in when the request is still being processed__ </br>
When the request is still processing, press `Ctrl-C` to stop it. 
Then we'll see these log messages in the console:
```
[26/05/2021 13:09:03] [INFO] [http-nio-8080-exec-1] [LongRunController.startLongRunRequest_withinTimeoutLimit]  - Starting a long-run request...
[26/05/2021 13:09:06] [INFO] [SpringContextShutdownHook] [GracefulShutdown.shutDownGracefully]  - Commencing graceful shutdown. Waiting for active requests to complete
[26/05/2021 13:09:28] [INFO] [http-nio-8080-exec-1] [LongRunController.startLongRunRequest_withinTimeoutLimit]  - Finish the long-run request within time out limit!!!
[26/05/2021 13:09:28] [INFO] [tomcat-shutdown] [GracefulShutdown.doShutdown]  - Graceful shutdown complete
[26/05/2021 13:09:28] [INFO] [SpringContextShutdownHook] [ExecutorConfigurationSupport.shutdown]  - Shutting down ExecutorService 'applicationTaskExecutor' 
```

Note:
We have to use `java -jar` to start the application. If we use `mvn spring-boot:run`, it won't really shutdown gracefully!

# Test graceful shutdown when the request exceeds timeout limit
Similar to the previous step, but this time, after starting the application, we'll trigger another request (by using Browser) which takes longer 
time to complete: http://localhost:8080/long-run-request/exceed-timeout-limit

Then, when stopping server in the middle, we'll see these log messages in the console:
```
[26/05/2021 13:17:36] [INFO] [http-nio-8080-exec-1] [LongRunController.startLongRunRequest_Exceed]  - Starting a long-run request...
[26/05/2021 13:17:39] [INFO] [SpringContextShutdownHook] [GracefulShutdown.shutDownGracefully]  - Commencing graceful shutdown. Waiting for active requests to complete
[26/05/2021 13:18:09] [INFO] [SpringContextShutdownHook] [DefaultLifecycleProcessor$LifecycleGroup.stop]  - Failed to shut down 1 bean with phase value 2147483647 within timeout of 300
00ms: [webServerGracefulShutdown]
[26/05/2021 13:18:09] [INFO] [tomcat-shutdown] [GracefulShutdown.doShutdown]  - Graceful shutdown aborted with one or more requests still active
[26/05/2021 13:18:11] [INFO] [SpringContextShutdownHook] [ExecutorConfigurationSupport.shutdown]  - Shutting down ExecutorService 'applicationTaskExecutor' 
```

# Test graceful shutdown with async process
Similar to the previous testing, this time, we'll trigger this request (by using Browser):
http://localhost:8080/long-run-request/async

Then again, go to the terminal, press `Ctrl-C` to stop it.
