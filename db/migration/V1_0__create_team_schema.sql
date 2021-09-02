create table if not exists `team` (
    `teamId` 	            int(10) NOT NULL AUTO_INCREMENT,
    `teamName`    	    	varchar(20),
    `status`              	varchar(10),
    primary key (teamId)
);
