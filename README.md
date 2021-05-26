The main purpose of this practice is to see whether we can gracefully shutdown an application when there are some running processes.

To test all of those example, please do not use IDE to start the application: https://github.com/spring-projects/spring-boot/issues/22959
We need to use command lines in terminal to start application:
    - `java -jar xxx.jar`
    - Using `mvn spring-boot:run` also doesn't work, please don't use it.