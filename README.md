# Back-end task
[![Travis](https://travis-ci.org/kmusienko/backend-task.svg?branch=master)](https://travis-ci.org/kmusienko/backend-task)

This is a simple REST service.

## Development

### How to run the project locally
#### Pre-requisites
1. Install ```java```
1. Install ```maven```
1. Install ```mysql-server```
1. Configure your db:
   1. Run [init.sql](https://github.com/kmusienko/backend-task/blob/master/src/main/resources/init.sql)
   
#### Build and run the project
1. Build the project with maven: ```mvn clean install```
1. Run the jar from target: ```java -jar target/demo-0.0.1-SNAPSHOT.jar```
1. Application is accessible at http://localhost:8080/

### Remark
If you are sending some regular expression through url, click on 'Encode URL' before sending a request.
In order to have ability to encode url, use [Advanced REST client](https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo)
