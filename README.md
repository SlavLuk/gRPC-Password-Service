## gRPC-Password-Service
 Part 1

# How to run jar file:

Place a jar file into bin java directory (C:\Program Files\Java\jdk1.8.0_77\bin)

Type command :java -jar GRPCserver.jar

To stop server : Ctrl+C

To test server : useful sofware BloomRPC,just add proto file 

### Update : 
Fixed onCompleted() method call form UserPasswordServiceImpl.java in validate method from hanging.

## UserAPI dropwizard Part 2

# How to run jar file:

Place UserApiServer.jar file and userApiConfig.yml into bin java directory (C:\Program Files\Java\jdk1.8.0_77\bin)

Type command :java -jar UserApiServer.jar server userApiConfig.yml

To stop server : Ctrl+C

To test Api use Postman.

### Swagger uri https://app.swaggerhub.com/apis/SlavLuk/UserAPI/1.0.0