# Project Stack:
Java 13, Gradle 6.0.1, Spring (Spring Boot, Spring Data), Hibernate, and MySQL.

## Overview:
A RESTful web service that is consumed by my [Auto Service Tracker client application](https://github.com/achang209/auto-service-tracker-client/blob/master/README.md). 
This application pairing allows users to keep track of their car's maintenance history. This project was inspired after numerous
visits to disparate car shops and not being able to recall when or who last serviced a particular part of my car.

## Current Features:
Users can save and edit their `Invoice` details, search their invoices by various properties (i.e. `Vendor` or `Repair`),
and upload/download a PDF of their original invoice.

## Next Steps:
I would like to add custom exception handling so the error messaging is consumer friendly and implement some sort of authentication/authorization mechanism (probably Spring Security) to allow my application to be used by multiple users. After that, I think it would be nice to containerize my project and all of it's dependencies to allow for easy portability across different machines. 
