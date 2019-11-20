create table users
(
    id         bigint auto_increment primary key,
    created    datetime,
    updated    datetime,
    name       varchar(255),
    surname    varchar(255),
    patronymic varchar(255),
    email      varchar(255),
    phone      varchar(255)
);

create sequence hibernate_sequence;
