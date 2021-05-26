# Build project
```
mvn clean install -DskipTests
```

# Test graceful shutdown within timeout limit
The timeout limit is configured in `application.yml`.


__1) Start application:__ <br/>
Open the terminal:
```
java -jar ./target/pro-01-cron-job-0.0.1-SNAPSHOT.jar 
```

__2) Stop server in when the scheduled job is still being processed__ </br>
Press `Ctrl-C` to stop it. 
>
> At this moment, this POC doesn't work!!!
>
Then we'll see these log messages in the console (it shouldn't be like that, we should see some messages like `graceful shutdown...`):
```
[26/05/2021 15:04:34] [INFO] [scheduling-1] [LongRunCronJob.longRunProcess]  - Starting a long-run cronjob 2...
[26/05/2021 15:04:35] [ERROR] [scheduling-1] [TaskUtils$LoggingErrorHandler.handleError]  - Unexpected error occurred in scheduled task
java.lang.InterruptedException: sleep interrupted
        at java.base/java.lang.Thread.sleep(Native Method)
        at org.tnmk.practicespringgracefulshutdown.pro01cronjob.cronjob.LongRunCronJob.longRunProcess(LongRunCronJob.java:19)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:566)
        at org.springframework.scheduling.support.ScheduledMethodRunnable.run(ScheduledMethodRunnable.java:84)
        at org.springframework.scheduling.support.DelegatingErrorHandlingRunnable.run(DelegatingErrorHandlingRunnable.java:54)
        at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
        at java.base/java.util.concurrent.FutureTask.runAndReset(FutureTask.java:305)
        at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:305)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
        at java.base/java.lang.Thread.run(Thread.java:834) 
```
