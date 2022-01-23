drop table if exists games;

create table games
(
    id                integer primary key,
    title             varchar(100),
    thumbnail         varchar(100),
    game_url          varchar(250),
    genre             varchar(100),
    platform          varchar(50),
    publisher         varchar(50),
    developer         varchar(100),
    release_date      date
);