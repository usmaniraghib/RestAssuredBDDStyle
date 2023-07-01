REST-ASSURED:-
It is an API/ Library through which we can automate only RestAPI.
https://rest-assured.io/

Pre-requisites:-
Java-9
Eclipse
Maven
Testng


POM Dependency :-
rest-assured
json-path
json
gson
testng
scribejava-apis
json-schema-validator
xml-schema-validator

HTTP Request :-
get
post
put
delete
head
trace
option
patch

Testing url :-
https://reqres.in/

Gerkin-Keywords:-

given() -> CONTENT TYPE, SET COOKIES, ADD AUTHENTICATION, ADD PARAM, SET HEADER INFORMATION AND ETC... 
		
when() -> GET, POST, PUT, DELETE...

then() -> VALIDATE STATUS CODE, EXTRACT RESPONSE, EXTRACT HEADERS COOKIES AND RESPONSE BODY....

Static Import Jars:-
https://github.com/rest-assured/rest-assured/wiki/GettingStarted#static-imports

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

Get Request :-
--GET ALL USERS
https://reqres.in/api/users?page=2
--Response Code - 200

Get Request :-
--GET USER
https://reqres.in/api/users/2
--Response Code - 200

Post Request :-
SUBMIT USER
https://reqres.in/api/users

{
    "name": "raghib",
    "job": "Tester"
}

--Response Code - 201

Put Request :-
UPDATE USER
https://reqres.in/api/users/2

{
    "name": "raghib",
    "job": "Tester"
}

--Response Code - 200

Delete Request :-
DELETE USER
https://reqres.in/api/users/userid

--Response Code - 204

