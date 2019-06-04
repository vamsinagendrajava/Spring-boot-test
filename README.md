# spring-boot-test

Commands for Setting up api-backend
------------------------------------
1) Change directory to springboot-test
2) Run this command
    mvn clean package
3) Then this command
    docker build -t spring-boot-anagram-test .
4) And, finally
    docker run -d spring-boot-anagram-test
5) Command in step #4, returns container id. Run this command
	docker container inspect <container id>
6) Look for "IPAddress" which is "bridge" which is under "Networks"
Thats the ipaddress of the container. This ipaddress has to be passed as input to api-client for connectivity

Commands for setting up api-client
-----------------------------------
1) change directory to testclient
2) Run the command
	mvn clean package
3) java -Dspring-boot-app-host-ip=<ipaddress of api-container> -jar target/test-client-1.0-SNAPSHOT-shaded.jar
