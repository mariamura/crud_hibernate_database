create table if not exists developer (
    idDeveloper	            		        SERIAL PRIMARY KEY,
    developerFirstName    	    	varchar(20) not null,
    developerLastName              	varchar(10) not null
);


