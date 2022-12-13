# README
SYSMEX pseudo client to send a dummy message to the SYSMEX service (SYS).

## Build
To build the client enter the following command:

	mvn install
	
You get the running binaries (JAR) in the target directory.

## BASE SETUP
Copy the JAR to a selectable directory

## Start
To send a dummy message to the SYSMEX service (SYS) hit the follwing command:

	java -jar PATH_TO_JAR IP_TO_SYS PORT PATIENT_ID
