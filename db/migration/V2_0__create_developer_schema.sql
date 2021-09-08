create table if not exists `developer` (
    `id`         			BIGINT(10) NOT NULL AUTO_INCREMENT,
    `developerFirstName`    	    varchar(20),
    `developerLastName`   	 		varchar(20),
    primary key (id)
);
