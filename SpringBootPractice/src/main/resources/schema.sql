create table IF NOT EXISTS productItem
(
    id integer not null auto_increment,
    name varchar(255) not null,
    price double not null,
    quantity integer not null,
    primary key(id)
);
