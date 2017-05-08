
USE world;

CREATE TABLE IF NOT EXISTS salary
     (
       id            	INT      	NOT NULL AUTO_INCREMENT , 
       salary      		DOUBLE      NULL             , 
       employee_id	    INT        NOT NULL         , 
       PRIMARY KEY (id) 
     ) ;

