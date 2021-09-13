create table if not exists team (
    idTeam              		SERIAL PRIMARY KEY,
    teamName    	    	varchar(20) not null,
    status              	varchar(10) not null
);