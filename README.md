# Spring Boot Jython

A simple Java Spring Boot application with Jython integration. 

## Installation

```
git clone git@github.com:amemifra/Spring-Jython.git
```
Your system must have install
* Java
* Maven
* VS Code
* Java Extention Pack - VS Code Extention
* Rest Client Extention - VS Code Extention

## Examples
Before start:
Open VS Code press f5 to autoattach the java debugger and start the Spring Boot Application.
### Launch a script
Open test.http and send the request
```
GET http://localhost:8080/api/hello-world
```
This will log "hello world!" in the debug console.

### Launch a method in a Python Class
Open test.http and send the request
```
GET http://localhost:8080/api/class?n=20&d=2
```
This will back 10 (20/2) as result of the web request sent