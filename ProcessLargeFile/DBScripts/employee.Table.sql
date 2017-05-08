
USE world;
DROP TABLE IF EXISTS employee;
CREATE TABLE IF NOT EXISTS employee
     (
       id            	INT      NOT NULL AUTO_INCREMENT , 
       firstname      	VARCHAR(30)      NULL             , 
	   lastname       	VARCHAR(30)      NULL             , 
       gender	    	CHAR(1)          NULL             , 
       PRIMARY KEY (id) 
     ) ;

