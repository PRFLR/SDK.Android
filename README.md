PRFLR Android SDK
=================

###How-to

1. Download and add the library.
2. In AndroidManifest.xml add the following to application section:
    ```xml

    <meta-data android:name="org.prflr.apikey" android:value="your_api_key"/>
    ```
3. Run somethere in startup:
    ```java

    PRFLR.init(context)
    ```

4. Add timers wherever you need them:
    ```java
    
    // Starts timer with name "timerName".
    PRFLR.begin(timerName);
    
    // Here we're doing something, which we want to measure
    
    // Stops and sends timer with additional info.
    PRFLR.end(timerName, info);
    ```
