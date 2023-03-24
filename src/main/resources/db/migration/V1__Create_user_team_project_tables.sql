CREATE TABLE IF NOT EXISTS users
(
    id           bigint primary key unique not null ,
    username     varchar(100) not null,
    phone_number varchar(50)  not null,
    team_id bigint,
    foreign key (team_id) references users (id)
);

CREATE TABLE IF NOT EXISTS team
(
    id   bigint primary key unique not null ,
    team_name varchar(50) not null,
    team_description varchar(1024) not null,
    logo bytea,
    creation_date date,
    total_number_of_members int not null
);

CREATE TABLE IF NOT EXISTS project
(
    id bigint primary key unique not null ,
    project_name varchar(100) not null ,
    project_description varchar(1024),
    logo bytea,
    start_date date not null ,
    end_date date not null
);