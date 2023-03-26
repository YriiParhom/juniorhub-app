CREATE TABLE IF NOT EXISTS users
(
    id           bigint primary key generated always as identity (increment 1 minvalue 1 maxvalue 1000000000),
    username     varchar(100) not null,
    phone_number varchar(50)  not null,
    team_id      bigint,
    foreign key (team_id) references users (id)
);

CREATE TABLE IF NOT EXISTS team
(
    id                      bigint primary key generated always as identity (increment 1 minvalue 1 maxvalue 1000000000),
    team_name               varchar(250)  not null,
    team_description        varchar(1024),
    logo                    bytea,
    creation_date           date          not null,
    total_number_of_members int           not null,
    project_id              bigint,
    foreign key (project_id) references team (id)
);

CREATE TABLE IF NOT EXISTS project
(
    id                  bigint primary key generated always as identity (increment 1 minvalue 1 maxvalue 1000000000),
    project_name        varchar(250) not null,
    project_description varchar(1024),
    logo                bytea,
    start_date          date         not null,
    end_date            date         not null
);