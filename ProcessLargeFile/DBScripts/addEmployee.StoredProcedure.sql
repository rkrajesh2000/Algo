USE world;

DROP PROCEDURE IF EXISTS `addEmployee` ;

DELIMITER //
CREATE PROCEDURE addEmployee
     (
        IN  p_firstname      	VARCHAR(30), 
        IN  p_lastname       	VARCHAR(30), 
        IN  p_gender	    	CHAR(1),
        IN  p_salary      		DOUBLE 
     )
BEGIN 
	DECLARE emp_id INT;
    
    INSERT INTO employee
         (
           firstname, 
           lastname, 
           gender                    
         )
    VALUES 
         ( 
           p_firstname, 
           p_lastname, 
           p_gender                    
         ) ;
         
       SET emp_id =  LAST_INSERT_ID();
       
    INSERT INTO salary
         (
           salary, 
           employee_id             
         )
    VALUES 
         ( 
           p_salary, 
           emp_id              
         ) ;
         
END; //

 DELIMITER ;