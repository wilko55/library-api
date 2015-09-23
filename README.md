### This *should* get the app up and running:
---
 1. [Install Gradle](https://docs.gradle.org/current/userguide/installation.html) to compile and run the app
 2. Set up a database - [currently configured for MySQL](http://dev.mysql.com/doc/refman/5.6/en/installing.html) - see below for how to get set up on Ubuntu
 3. Can use the eg_db.sql file to get the basic database structure and a couple of dummy entries.
 4. In the terminal, run ./gradlew build
 5. Then ./gradlew run

SQL - for linux (ubuntu 14.04)

1. ``sudo apt-get install mysql-server``
2. enter password
log into server shell
3. ``mysql -u root -p``

create database

> ``create database bookshelf;``

use script to generate tables by pasting in eg_db.sql into the shell

create new user
> ``create user 'admin'@'localhost' identified by 'password';``
> ``grant all privileges on *.* to 'admin'@'localhost' with grant option;``

Until swagger gets involved, view all books at [localhost:8080/books](http://localhost:8080/books) and an individual book like [localhost:8080/books/1](http://localhost:8080/books/1)
