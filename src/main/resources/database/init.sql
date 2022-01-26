drop table if exists games;

create table games
(
    id                integer primary key auto_increment,
    title             varchar(100),
    thumbnail         varchar(100),
    game_url          varchar(250),
    genre             varchar(100),
    platform          varchar(100),
    publisher         varchar(100),
    developer         varchar(100),
    release_date      date
);