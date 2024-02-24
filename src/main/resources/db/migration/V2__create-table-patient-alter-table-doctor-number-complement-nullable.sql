create table patient(
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    phone varchar(100) not null,
    cpf varchar(100) not null unique,
    street varchar(100) not null,
    number varchar(100),
    complement varchar(100),
    neighborhood varchar(100) not null,
    city varchar(100) not null,
    state varchar(100) not null,
    zipcode varchar(100) not null,
    primary key (id)
);

alter table doctor
modify column number varchar(100) null,
modify column complement varchar(100) null;
