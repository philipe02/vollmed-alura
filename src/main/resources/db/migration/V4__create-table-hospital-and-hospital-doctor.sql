create table if not exists hospital (
    id bigint auto_increment,
    name varchar(100) not null,
    cnpj varchar(100) not null unique,
    street varchar(100) not null,
    number varchar(100),
    complement varchar(100),
    neighborhood varchar(100) not null,
    city varchar(100) not null,
    state varchar(100) not null,
    zipcode varchar(100) not null,
    primary key (id)
);

create table if not exists hospital_doctor (
    id bigint auto_increment,
    hospital_id bigint,
    doctor_id bigint,
    primary key (id),
    foreign key (hospital_id) references hospital(id),
    foreign key (doctor_id) references doctor(id)
);