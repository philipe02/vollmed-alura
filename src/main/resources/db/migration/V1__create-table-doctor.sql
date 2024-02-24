create table doctor(
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(100) not null unique,
    specialty varchar(100) not null,
    phone varchar(100) not null,
    street varchar(100) not null,
    number varchar(100) not null,
    complement varchar(100) not null,
    neighborhood varchar(100) not null,
    city varchar(100) not null,
    state varchar(100) not null,
    zipcode varchar(100) not null,

    primary key (id)
);