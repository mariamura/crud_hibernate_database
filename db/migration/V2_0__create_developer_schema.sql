create table if not exists `developer` (
    `idDeveloper`         			int(10) NOT NULL AUTO_INCREMENT,
    `developerFisrtName`    	    varchar(20),
    `developerLastName`   	 		varchar(20),
    `idTeam`						int(10) NOT NULL,
    primary key (idDeveloper)
);
