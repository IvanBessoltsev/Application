create table if not exists city
(
    id   serial primary key,
    name varchar(64)
);

create table if not exists department
(
    id   serial primary key,
    name varchar(64)
);

create table if not exists user_local
(
    id                 serial primary key,
    login              varchar(64) unique not null,
    first_name         varchar(40)        not null,
    last_name          varchar(40)        not null,
    middle_name        varchar(40)        not null,
    date_of_birth      date               not null,
    date_of_employment date               not null,
    date_of_dismissal  date,
    department_id      int references department(id),
    is_active          boolean default true
);

create table if not exists contact
(
    id           serial primary key,
    phone_number varchar(20),
    email        varchar(20),
    city_id      int references city (id),
    user_id      int references user_local (id)
);

create table if not exists family_member
(
    id                   serial primary key,
    name                 varchar(20) not null,
    date_of_birth        date        not null,
    relation             varchar(10) not null,
    user_id              int references user_local (id)
);

create table if not exists photo
(
    id        serial primary key,
    file_name varchar(100) not null,
    user_id   int references user_local(id)
);

