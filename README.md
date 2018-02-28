# Claim Management REST endpoint with MSF4J 

## How to get the things running...

To run, please follow the instructions given below:
 First, WSO2 Identity Server's OSGi runtime, you need to have msf4j - servlet bridge in your osgi runtime.
 You can find it from [here](https://github.com/ruwanta/msf4j-tomcat-bridge/)
 Build that msf4J -Servlet bride and then add the OSGi bundle found in the /target to the dropins directory 
 of your Identity Server.

Next, build the Claim Management REST Endpoint (i.e. this project) and then you will get the claim management service
 as an OSGi bundle. Use the below maven command for that purpose
```
mvn clean install
```

As per the current source code, you can access the rest endpoints as given below.

Attributes Api (This is related to the CRUD of Local Claims)
```
http://localhost:9763/api/identity/claim/mgt/v1.0/attributes
```

Dialects Api (This is related to the CRUD of Dialects and External Claims)
```
http://localhost:9763/api/identity/claim/mgt/v1.0/dialects
```