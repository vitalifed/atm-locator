ATM Locator - HTTP REST API for searching ING bank ATM
=========================================

ATM Locator is an internet portal that acts as an interface to actual locations of ATM belonging to ING bank.
The ATM Loactor exposes: 
* REST API interface for accessing locations of ATM
* Simplified interface for searching and observing ATM near specified location


## How to build and deploy application

The easiest way to build and run the **server** is to use the maven:

    $ mvn install 
    
The command should build war **atm-locator.war** in target folder  

### Deployment 

In Tomcat env. it is enough to copy and paste **war** to **webapps** folder into Tomcat. 
When you start Tomcat, the **war** will be automatically deployed with context root atm-locator

### Technology stack

* JDK 1.8
* Spring 4.3.8
* Spring Security 4.3.2
* Servlet 3.0
* JQuery 1.12.4
* Maven 3.0

## Use cases

| Use case                                     | REST API                                     | Expected result                                                                                                                                                                                | Description                                                                                                                                                                      |
|----------------------------------------------|----------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1. Get all ATM location in raw format        | /atm/{bank}/raw                              | [{"address": {"street": "Heerenweg","housenumber": "199","postalcode": "1851 KP","city": "HEILOO","geoLocation": {"lat": "52.60022","lng": "4.703054"}},"distance": 0,"type": "ING"}]          | The REST API dispatches a request to https://www.ing.nl/api/locator/atms/ and response the result in the same format as it was obtained                                          |
| 2. Search ATM by city                        | /atm/{bank}/raw?city=Rijswijk                | [{"address": {"street": "Kerklaan","housenumber": "74","postalcode": "2282 CL","city": "RIJSWIJK","geoLocation": {"lat": "52.054291","lng": "4.33541"}},"distance": 0,"type": "ALBERT_HEIJN"}, | The REST API dispatches a request to https://www.ing.nl/api/locator/atms/ and the response will be filtered by city and send to requester in the same format as it was obtained. |
| 3. Get all ATM location in simplified format | /atm/{bank}/search                           | {"data": [["Heerenweg","199","1851 KP","HEILOO"],["Irislaan","83","2343 CH","OEGSTGEEST"], ...                                                                                                 | The REST API dispatches a request to https://www.ing.nl/api/locator/atms/ and response the result in the simplified format                                                       |
| 4. Search ATM by city                        | /atm/{bank}/search?city=Rijswijk             | {"data": [["Kerklaan","74","2282 CL","RIJSWIJK"],["Bogaardplein","22","2284 DM","RIJSWIJK"],                                                                                                   | The REST API dispatches a request to https://www.ing.nl/api/locator/atms/ and the response will be filtered by city and send to requester in the simplified format .             |

## Secutity 
There are two groups of users: ADMIN and USER

ADMIN:
   * user:     admin
   * password: admin
   
USER: 
   * user:     petra
   * password: petra
   
Accounts from the group USER has no rights to perform any requests.

### Usage
If the application was deployed successfully, give a try and open http://localhost:8080/atm-locator/ 
On login page enter your user and password: (admin, admin)

## Swagger

Where to find specification
src/main/webapp/specs
http://localhost:8080/atm-locator/specs/swagger.json

## Swagger UI
http://localhost:8080/atm-locator/swagger-ui/




   


