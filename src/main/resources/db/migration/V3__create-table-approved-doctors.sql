create table if not exists approved_doctors (
    id bigint auto_increment,
    doctor_id bigint,
    registration_date date,
    expiration_date date,
    primary key (id),
    foreign key (doctor_id) references doctor(id)
);