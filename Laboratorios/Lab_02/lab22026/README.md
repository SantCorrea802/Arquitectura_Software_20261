# LAB22026

[![CI/CD Pipeline](https://github.com/SantCorrea802/Arquitectura_Software_20261/actions/workflows/build.yml/badge.svg)](https://github.com/SantCorrea802/Arquitectura_Software_20261/actions/workflows/build.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=SantCorrea802_Arquitectura_Software_20261&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=SantCorrea802_Arquitectura_Software_20261)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=SantCorrea802_Arquitectura_Software_20261&metric=bugs)](https://sonarcloud.io/summary/new_code?id=SantCorrea802_Arquitectura_Software_20261)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=SantCorrea802_Arquitectura_Software_20261&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=SantCorrea802_Arquitectura_Software_20261)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=SantCorrea802_Arquitectura_Software_20261&metric=coverage)](https://sonarcloud.io/summary/new_code?id=SantCorrea802_Arquitectura_Software_20261)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=SantCorrea802_Arquitectura_Software_20261&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=SantCorrea802_Arquitectura_Software_20261)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=SantCorrea802_Arquitectura_Software_20261&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=SantCorrea802_Arquitectura_Software_20261)



Implementation of a Simple App with the next operations:

* Get random nations
* Get random currencies
* Get random airplanes
* Get application version
* health check

Including integration with GitHub Actions, Sonarqube (SonarCloud), Coveralls and Snyk

### Folders Structure

In the folder `src` is located the main code of the app

In the folder `test` is located the unit tests

### How to install it

Execute:

```shell
$ mvnw spring-boot:run
```
to download the node dependencies

### How to test it

Execute:

```shell
$ mvnw clean install
```

### How to get coverage test

Execute:

```shell
$ mvwn -B package -DskipTests --file pom.xml
```