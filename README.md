# OrderMission
workflow for a order mission into a shcool

installation

1-import project to eclipse.
	- go to eclipse
	- file > import > existing project from workspace
	- click next next...
	-the project is imported with success
2- configuration:
	- install wamp
	- run wamp
	- create a database named mission
	- go to application.properties and update it to reflect your configuration
	- go to the class com.order.mission.AppInitializer.java and uncommnet all the code if you want the application add some info to be used by default
	- go to eclipse and add tomcat server 9
	- add the application to tomcat
	- start tomacat
	- go to http://localhost:8080/mission/login
	- login used admin
	