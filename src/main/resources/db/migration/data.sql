drop table if exists football_clubs CASCADE;

drop table if exists owners CASCADE;

drop table if exists players CASCADE;

create table football_clubs
(
    id     integer generated by default as identity,
    budget integer,
    league varchar(255),
    title  varchar(255),
    primary key (id)
);
create table owners
(
    id          integer generated by default as identity,
    age         tinyint,
    first_name  varchar(255),
    last_name   varchar(255),
    nationality varchar(255),
    fc_id       integer,
    primary key (id)
);
create table players
(
    id         integer generated by default as identity,
    age        tinyint,
    first_name varchar(255),
    last_name  varchar(255),
    level      tinyint,
    fc_id      integer,
    primary key (id)
);
alter table football_clubs
    add unique (title);
alter table owners
    add foreign key (fc_id) references football_clubs;
alter table players
    add foreign key (fc_id) references football_clubs;
