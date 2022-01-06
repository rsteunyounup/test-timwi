# Application Spotify

## Créer la base de donnée PostgreSQL
CREATE DATABASE spotify;

## Modifier le fichier application.properties et mettre à jour le username le password

## Build maven 
mvn install -DskipTests

## Build npm
npm install

## A la racine du projet, lancer le microservice springboot
mvn spring-boot:run

## Dans le package 'webapp', lancer le client angular
ng serve
